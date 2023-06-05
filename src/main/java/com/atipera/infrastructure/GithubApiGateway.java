package com.atipera.infrastructure;

import com.atipera.model.GitHubRepoResponse;
import com.atipera.model.GithubBranchResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class GithubApiGateway {

    private final String githubApiUrl;
    private final RestTemplate restTemplate;

    GithubApiGateway(@Qualifier("githubApi") RestTemplate restTemplate, @Value("${github.url}") String githubApiUrl) {
        this.restTemplate = restTemplate;
        this.githubApiUrl = githubApiUrl;
    }

    public ResponseEntity<List<GitHubRepoResponse>> getUserRepos(String username) {
        String url = githubApiUrl + "/users/" + username + "/repos";
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<>() {
        });
    }

    public ResponseEntity<List<GithubBranchResponse>> getBranchForRepo(String owner, String repo) {
        String url = githubApiUrl + "/repos" + "/" + owner + "/" + repo + "/branches";
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<>() {
        });
    }
}