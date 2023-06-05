package com.atipera.service;

import com.atipera.infrastructure.GithubApiGateway;
import com.atipera.model.GitHubRepoResponse;
import com.atipera.model.GithubBranchResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class GithubService {

    private final GithubApiGateway githubApiGateway;

    public List<GitHubRepoResponse> getNotForkRepos(String username) {
        List<GitHubRepoResponse> allRepos = githubApiGateway.getUserRepos(username).getBody();
        if (!allRepos.isEmpty()) {
            return allRepos.stream()
                    .filter(f -> !f.isFork())
                    .toList();
        } else {
            return Collections.emptyList();
        }
    }

    public List<GithubBranchResponse> getBranches(String username, String repo) {
        List<GithubBranchResponse> allBranches = githubApiGateway.getBranchForRepo(username, repo).getBody();
        if (!allBranches.isEmpty()) {
            return allBranches;
        } else {
            return Collections.emptyList();
        }
    }
}