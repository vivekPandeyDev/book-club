package com.bookhive.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.minio.MinioClient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@EnableConfigurationProperties(MinioConfig.class)
@ConfigurationProperties(prefix = "minio")
public class MinioConfig {

    private String url;

    private String accessKey;


    private String secretKey;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(url)
                .credentials(accessKey, secretKey)
                .build();
    }
}
