package com.atipera.controller;

import com.atipera.model.GitHubRepoResponse;
import com.atipera.model.GithubBranchResponse;
import com.atipera.service.GithubService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users/")
@AllArgsConstructor
public class GithubRepoController {

    private final GithubService githubService;

    @GetMapping("{username}")
    public List<GitHubRepoResponse> getAllRepos(@PathVariable String username) {
        return githubService.getNotForkRepos(username);
    }

    @GetMapping("{username}/{repo}")
    public List<GithubBranchResponse> getAllBranches(@PathVariable String username, @PathVariable String repo) {
        return githubService.getBranches(username, repo);
    }
}