package com.atipera.service;

import com.atipera.infrastructure.GithubApiGateway;
import com.atipera.model.GitHubResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class GithubService {

    private final GithubApiGateway githubApiGateway;

    public List<GitHubResponse> getNotForkRepos(String username) {
        List<GitHubResponse> allRepos = githubApiGateway.getUserRepos(username).getBody();
        if (!allRepos.isEmpty()) {
            return allRepos.stream()
                    .filter(f -> !f.isFork())
                    .toList();
        } else {
            return Collections.emptyList();
        }
    }
}