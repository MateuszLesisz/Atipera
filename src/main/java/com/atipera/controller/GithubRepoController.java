package com.atipera.controller;

import com.atipera.infrastructure.GithubApiGateway;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/")
@AllArgsConstructor
public class GithubRepoController {

    private final GithubApiGateway githubApiGateway;

    @GetMapping("{username}")
    public String getAllRepos(@PathVariable String username) {
        return githubApiGateway.getUserRepos(username);
    }
}