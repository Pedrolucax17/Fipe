package com.fipe.fipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Datas(
        @JsonAlias("codigo")
        Long code,
        @JsonAlias("name")
        String name)
{

}
