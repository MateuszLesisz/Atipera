package com.atipera.service;

import com.atipera.infrastructure.GithubApiGateway;
import com.atipera.model.GitHubRepository;
import com.atipera.model.Github;
import com.atipera.model.GithubBranch;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class GithubService {

    private final GithubApiGateway githubApiGateway;

    public List<Github> createGithubResponse(String username) {
        List<Github> response = new ArrayList<>();
        List<GitHubRepository> repositories = getNotForkRepos(username);

        repositories.forEach(f -> {
            Github github = new Github();
            github.setRepositoryName(f.getName());
            github.setOwnerLogin(f.getOwner().getLogin());
            github.setBranch(getBranches(f.getOwner().getLogin(), f.getName()));
            response.add(github);
        });
        return response;
    }

    private List<GitHubRepository> getNotForkRepos(String username) {
        List<GitHubRepository> allRepos = githubApiGateway.getUserRepos(username).getBody();
        if (!allRepos.isEmpty()) {
            return allRepos.stream()
                    .filter(f -> !f.isFork())
                    .toList();
        } else {
            return Collections.emptyList();
        }
    }

    private List<GithubBranch> getBranches(String username, String repo) {
        List<GithubBranch> allBranches = githubApiGateway.getBranchForRepo(username, repo).getBody();
        if (!allBranches.isEmpty()) {
            return allBranches;
        } else {
            return Collections.emptyList();
        }
    }
}