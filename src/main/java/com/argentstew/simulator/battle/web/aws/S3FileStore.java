package com.argentstew.simulator.battle.web.aws;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.argentstew.simulator.battle.web.aws.exception.S3FileException;
import com.argentstew.simulator.battle.web.file.FileStore;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * com.argentstew.simulator.battle.web.aws
 * 6/4/2022
 *
 * @author argen
 */
@Component
@Profile("prod")
public class S3FileStore implements FileStore {

    private final AmazonS3ClientBuilder s3ClientBuilder;

    @Autowired
    public S3FileStore(@Qualifier("s3ClientBuilder") AmazonS3ClientBuilder s3ClientBuilder) {
        this.s3ClientBuilder = s3ClientBuilder;
    }

    @Override
    public boolean saveFile(String directory, String filename, InputStream contents) {
        return saveFile(directory, filename, contents, false);
    }

    @Override
    public boolean saveFile(String directory, String filename, InputStream contents, boolean overwrite) {
        validateBucket(directory);
        validateKey(filename);

        boolean overwritten = false;
        AmazonS3 client = getS3Client();
        try {
            if (client.doesObjectExist(directory, filename)) {
                if (overwrite) {
                    overwritten = true;
                } else {
                    throw new S3FileException("Could not write file, already exists");
                }
            }

            ObjectMetadata metadata = new ObjectMetadata();
            client.putObject(directory, filename, contents, metadata);
        } catch (AmazonServiceException e) {
            throw new S3FileException(String.format("Error from S3 for %s (%s - %s)", filename,
                    e.getErrorCode(), e.getErrorMessage()));
        }

        return overwritten;
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
