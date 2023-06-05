package com.atipera.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Commit {

    @JsonProperty("sha")
    public String sha;
}