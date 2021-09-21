package com.springboot.properties.reader.pojo;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author mahenderloka
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@ConfigurationProperties("spring.common")
public class Properties {

    private String databaseUrl;
    private String userName;
    private String password;
    private String secretKey;
    private String environment;
}
