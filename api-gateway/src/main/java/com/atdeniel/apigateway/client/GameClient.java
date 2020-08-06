package com.atdeniel.apigateway.client;

import com.atdeniel.apigateway.data.Game;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("game-service")
public interface GameClient {

    @GetMapping("/games")
    @CrossOrigin
    CollectionModel<Game> readGames();

    @GetMapping("/home")
    @CrossOrigin
    String sayHello();

}


