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
        if (StringUtils.isBlank(bucket)) {
            throw new S3FileException("Could not fetch from S3: Bucket not specified");
        }

        if (StringUtils.isBlank(key)) {
            throw new S3FileException("Could not fetch from S3: Name not specified");
        }

        AmazonS3 client;
        try {
            client = s3ClientBuilder.build();
        } catch (Exception e) {
            throw new S3FileException("Failed to create client");
        }

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
}
