package com.argentstew.simulator.battle.web.aws;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.IOUtils;
import com.argentstew.simulator.battle.web.aws.exception.S3FileException;
import com.argentstew.simulator.battle.web.file.FileAccessor;
import com.argentstew.simulator.battle.web.model.ImageDTO;
import com.argentstew.simulator.battle.web.model.ImageType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * com.argentstew.simulator.battle.web.aws
 * 12/21/2021
 *
 * @author argen
 */
@Component
@Profile("prod")
public class S3FileAccessor implements FileAccessor {

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
    public String getBlogEntry(String bucket, int entryNumber) {
        validateBucket(bucket);
        if (entryNumber <= 0) {
            throw new S3FileException("Could not fetch from S3: Blog entry number invalid");
        }

        AmazonS3 client = getS3Client();
        try {
            return client.getObjectAsString(bucket, String.format("entry%d.html", entryNumber));
        } catch (AmazonServiceException e) {
            throw new S3FileException(String.format("Error from S3 for %s (%s - %s)", bucket,
                    e.getErrorCode(), e.getErrorMessage()));
        } finally {
            client.shutdown();
        }
    }

    @Override
    public String getLogFile(String bucket, String id) {
        validateBucket(bucket);
        validateKey(id);

        AmazonS3 client = getS3Client();
        try {
            return client.getObjectAsString(bucket, id + ".txt");
        } catch (AmazonServiceException e) {
            throw new S3FileException(String.format("Error from S3 for %s (%s - %s)", bucket,
                    e.getErrorCode(), e.getErrorMessage()));
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
