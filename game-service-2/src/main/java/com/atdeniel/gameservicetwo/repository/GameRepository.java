package com.atdeniel.gameservicetwo.repository;

import com.atdeniel.gameservicetwo.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "games")
public interface GameRepository extends JpaRepository<Game, Long> {

}