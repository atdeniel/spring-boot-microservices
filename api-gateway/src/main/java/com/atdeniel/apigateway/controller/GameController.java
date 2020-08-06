package com.atdeniel.apigateway.controller;

import com.atdeniel.apigateway.client.GameClient;
import com.atdeniel.apigateway.data.Game;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
class GameController {

    private final GameClient gameClient;

    public GameController(GameClient gameClient) {
        this.gameClient = gameClient;
    }

    private Collection<Game> fallback() {
        return new ArrayList<>();
    }


    @GetMapping("/good-games")
    @CrossOrigin
    @HystrixCommand(fallbackMethod = "fallback")
    public Collection<Game> goodGames() {
        return gameClient.readGames()
                .getContent()
                .stream()
                .filter(this::isCool)
                .collect(Collectors.toList());
    }

    private boolean isCool(Game game) {
        return !game.getName().equals("DBFZ") &&
                !game.getName().equals("New Super Mario") &&
                !game.getName().equals("Minecraft");
    }


    @GetMapping("/hello-home")
    @CrossOrigin
    public String hello() {
        return gameClient.sayHello();
    }
}


