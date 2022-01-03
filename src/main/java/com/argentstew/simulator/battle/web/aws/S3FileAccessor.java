package com.argentstew.simulator.battle.web.aws;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.IOUtils;
import com.argentstew.simulator.battle.web.aws.exception.S3FileException;
import com.argentstew.simulator.battle.web.file.FileAccessor;
import com.argentstew.simulator.battle.web.model.BlogDTO;
import com.argentstew.simulator.battle.web.model.ImageDTO;
import com.argentstew.simulator.battle.web.model.ImageType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * com.argentstew.simulator.battle.web.aws
 * 12/21/2021
 *
 * @author argen
 */
@Component
@Profile("prod")
public class S3FileAccessor implements FileAccessor {

    private static final String META_ENTRY_TITLE = "Entry-Title";
    private static final String META_ENTRY_DATE = "Entry-Date";
    private static final String ENTRY_TYPE = ".html";

    private final AmazonS3ClientBuilder s3ClientBuilder;

    @Autowired
    public S3FileAccessor(@Qualifier("s3ClientBuilder") AmazonS3ClientBuilder s3ClientBuilder) {
        this.s3ClientBuilder = s3ClientBuilder;
    }

    @Override
    public ImageDTO getImage(String bucket, String key) {
        validateBucket(bucket);
        validateKey(key);

        AmazonS3 client = getS3Client();
        try {
            for (String extension : ImageType.getAllExtensions()) {
                String fullKey = key + "." + extension;
                if (client.doesObjectExist(bucket, fullKey)) {
                    try (S3Object s3Object = client.getObject(bucket, fullKey)) {
                        return ImageDTO.builder().name(key).extension(extension)
                                .bytes(IOUtils.toByteArray(s3Object.getObjectContent())).build();
                    } catch (IOException e) {
                        throw new S3FileException("Could not read from S3");
                    } catch (AmazonServiceException e) {
                        throw new S3FileException(String.format("Error from S3 for %s (%s - %s)", fullKey,
                                e.getErrorCode(), e.getErrorMessage()));
                    }
                }
            }
        } finally {
            client.shutdown();
        }

        throw new S3FileException("Could not fetch from S3: File does not exist");
    }

    @Override
    public List<BlogDTO> getAllBlogTitles(String bucket) {
        validateBucket(bucket);

        AmazonS3 client = getS3Client();
        try {
            ObjectListing result = client.listObjects(bucket);
            return result.getObjectSummaries().stream()
                    .filter(summary -> summary.getKey().endsWith(ENTRY_TYPE)).parallel()
                    .map(summary -> {
                        Map<String, String> metadata = client.getObjectMetadata(bucket, summary.getKey())
                                .getUserMetadata();
                        return BlogDTO.builder()
                                .number(Integer.parseInt(Pattern.compile("entry(\\d+)\\.html")
                                        .matcher(summary.getKey()).group(0)))
                                .title(metadata.get(META_ENTRY_TITLE))
                                .timestamp(LocalDateTime.parse(metadata.get(META_ENTRY_DATE)))
                                .build();
                    })
                    .sorted(Comparator.comparingInt(BlogDTO::getNumber))
                    .collect(Collectors.toList());
        } finally {
            client.shutdown();
        }
    }

    @Override
    public BlogDTO getBlogEntry(String bucket, int entryNumber) {
        validateBucket(bucket);
        if (entryNumber <= 0) {
            throw new S3FileException("Could not fetch from S3: Blog entry number invalid");
        }

        AmazonS3 client = getS3Client();
        try {
            S3Object object = client.getObject(bucket, String.format("entry%d.html", entryNumber));
            String entryHtml = IOUtils.toString(object.getObjectContent());
            return BlogDTO.builder().number(entryNumber)
                    .timestamp(LocalDateTime.parse(object.getObjectMetadata().getUserMetadata().get(META_ENTRY_DATE)))
                    .title(object.getObjectMetadata().getUserMetadata().get(META_ENTRY_TITLE))
                    .html(entryHtml)
                    .build();
        } catch (IOException e) {
            throw new S3FileException("Could not fetch from S3: File could not be read");
        } finally {
            client.shutdown();
        }
    }

    private void validateBucket(String bucket) {
        if (StringUtils.isBlank(bucket)) {
            throw new S3FileException("Could not fetch from S3: Bucket not specified");
        }
    }

    private void validateKey(String key) {
        if (StringUtils.isBlank(key)) {
            throw new S3FileException("Could not fetch from S3: Key not specified");
        }
    }

    private AmazonS3 getS3Client() {
        try {
            return s3ClientBuilder.build();
        } catch (Exception e) {
            throw new S3FileException("Failed to create client");
        }
    }
}
