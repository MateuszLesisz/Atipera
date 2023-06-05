package com.atipera.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GithubBranchResponse {

    @JsonProperty("name")
    private String name;
    @JsonProperty("commit")
    private Commit commit;
}