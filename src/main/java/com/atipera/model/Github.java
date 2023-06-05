package com.atipera.model;

import lombok.Data;

import java.util.List;

@Data
public class Github {

    private String repositoryName;
    private String ownerLogin;
    private List<GithubBranch> branch;

}