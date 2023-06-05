package com.atipera.controller;

import com.atipera.model.Github;
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
public class GithubRepositoryController {

    private final GithubService githubService;

    @GetMapping("{username}")
    public List<Github> getAllRepos(@PathVariable String username) {
        return githubService.createGithubResponse(username);
    }
}