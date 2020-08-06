package com.atdeniel.apigateway.data;

import lombok.Data;

@Data
public class Game {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}