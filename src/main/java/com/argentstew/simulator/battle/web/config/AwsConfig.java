package com.argentstew.simulator.battle.web.config;

import com.amazonaws.auth.AWSCredentialsProviderChain;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * com.argentstew.simulator.battle.web.config
 * 12/21/2021
 *
 * @author argen
 */
@Configuration
public class AwsConfig {

    @Bean
    @Profile("prod")
    public AWSCredentialsProviderChain awsCredentials() {
        return new DefaultAWSCredentialsProviderChain();
    }

    @Bean
    @Profile("prod")
    public AmazonS3ClientBuilder s3ClientBuilder(AWSCredentialsProviderChain credentials) {
        return AmazonS3ClientBuilder.standard()
                .withCredentials(credentials)
                .withRegion(Regions.US_EAST_1);
    }
}
