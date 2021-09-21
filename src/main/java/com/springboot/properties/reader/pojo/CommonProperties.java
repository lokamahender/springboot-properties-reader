package com.springboot.properties.reader.pojo;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @author mahenderloka
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@PropertySources({
        @PropertySource("classpath:common-config.properties"),
        @PropertySource("classpath:server-config.properties")
})
public class CommonProperties {

    //common

    @Value("${custom.common.databaseUrl}")
    private String databaseUrl;

    @Value("${custom.common.userName}")
    private String userName;

    @Value("${custom.common.password}")
    private String password;

    @Value("${custom.common.secretKey}")
    private String secretKey;

    @Value("${custom.common.environment}")
    private String environment;


    @Value("${server.common.serverName}")
    private String serverName;

    @Value("${server.common.ipAddress}")
    private String ipAddress;

    @Value("${server.common.ipAddress}")
    private String active;

}