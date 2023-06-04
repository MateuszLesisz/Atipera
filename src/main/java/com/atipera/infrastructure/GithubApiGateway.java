package com.atipera.infrastructure;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GithubApiGateway {

    private final String githubApiUrl;
    private final RestTemplate restTemplate;

    GithubApiGateway(@Qualifier("githubApi") RestTemplate restTemplate, @Value("${github.url}") String githubApiUrl) {
        this.restTemplate = restTemplate;
        this.githubApiUrl = githubApiUrl;
    }

    public String getUserRepos(String username) {
        String url = githubApiUrl + "/users/" + username + "/repos";
        return restTemplate.getForObject(url, String.class);
    }
}