package com.fipe.fipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public record Data(
        @JsonAlias("codigo")
        String code,
        @JsonAlias("nome")
        String name)
{

}
