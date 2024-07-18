package com.fipe.fipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataVehicles(
        @JsonAlias("Valor")
        String value,
        @JsonAlias("Marca")
        String brand,
        @JsonAlias("Modelo")
        String model,
        @JsonAlias("AnoModelo")
        String year,
        @JsonAlias("Combustivel")
        String fuelType
) {
}
