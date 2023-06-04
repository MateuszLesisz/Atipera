package com.atipera.controller;

import com.atipera.infrastructure.GithubApiGateway;
import com.atipera.model.GitHubResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users/")
@AllArgsConstructor
public class GithubRepoController {

    private final GithubApiGateway githubApiGateway;

    @GetMapping("{username}")
    public ResponseEntity<List<GitHubResponse>> getAllRepos(@PathVariable String username) {
        return githubApiGateway.getUserRepos(username);
    }
}