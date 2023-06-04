package com.atipera.infrastructure;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class GithubApiGateway {

    private final String githubApiUrl;
    private final RestTemplate restTemplate;

    GithubApiGateway(@Qualifier("githubApi") RestTemplate restTemplate, @Value("${github.url}") String githubApiUrl) {
        this.restTemplate = restTemplate;
        this.githubApiUrl = githubApiUrl;
    }

    public ResponseEntity<String> getUserRepos(String username) {
        String url = githubApiUrl + "/users/" + username + "/repos";
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class, params);
    }
}