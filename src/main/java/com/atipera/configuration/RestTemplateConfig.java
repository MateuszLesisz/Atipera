package com.atipera.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@Configuration
public class RestTemplateConfig {

    private static final int DEFAULT_CONNECTION_TIMEOUT = 100000;

    @Bean
    @Qualifier("githubApi")
    public RestTemplate githubApiRestTemplate() {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectionRequestTimeout(DEFAULT_CONNECTION_TIMEOUT);
        requestFactory.setConnectTimeout(DEFAULT_CONNECTION_TIMEOUT);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }
}