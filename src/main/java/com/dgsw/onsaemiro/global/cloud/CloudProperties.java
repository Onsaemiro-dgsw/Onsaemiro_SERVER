package com.dgsw.onsaemiro.global.cloud;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "application.cloud.aws")
public class CloudProperties {
    private String accessKey;
    private String secretAccessKey;
    private String bucketName;
}
