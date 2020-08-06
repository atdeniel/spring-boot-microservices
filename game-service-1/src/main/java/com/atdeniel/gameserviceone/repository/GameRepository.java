package com.atdeniel.gameserviceone.repository;

import com.atdeniel.gameserviceone.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "games")
public interface GameRepository extends JpaRepository<Game, Long> {

}