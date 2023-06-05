package com.atipera.controller;

import com.atipera.model.Github;
import com.atipera.service.GithubService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/")
@AllArgsConstructor
public class GithubRepositoryController {

    private final GithubService githubService;

    @GetMapping("{username}")
    public List<Github> getAllRepos(@RequestHeader(value = "Accept") String header, @PathVariable String username) {
        return githubService.createGithubResponse(username, header);
    }
}