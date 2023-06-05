package com.atipera.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GitHubRepository {

    @JsonProperty("name")
    private String name;
    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("fork")
    private boolean fork;

}