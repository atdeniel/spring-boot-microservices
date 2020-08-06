package com.atdeniel.gameserviceone;

import com.atdeniel.gameserviceone.entity.Game;
import com.atdeniel.gameserviceone.repository.GameRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.stream.Stream;

@EnableDiscoveryClient
@SpringBootApplication
public class GameServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameServiceApplication.class, args);
    }

    @Configuration
    static class OktaOAuth2WebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // @formatter:off
            http
                .authorizeRequests().anyRequest().authenticated()
                    .and()
                .oauth2ResourceServer().jwt();
            // @formatter:on
        }
    }

    @Bean
    ApplicationRunner init(GameRepository repository) {
        return args -> {
            Stream.of("Call of Duty: Warzone", "Fornite", "Fallout 4", "League of Legends", "Crysis",
                    "DBFZ", "Apex Legend", "New Super Mario", "Minecraft").forEach(name -> {
                Game game = new Game();
                game.setName(name);
                repository.save(game);
            });
            repository.findAll().forEach(System.out::println);
        };
    }
}



