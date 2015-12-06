package com.anton.myfilms;

import com.anton.myfilms.dao.FilmRepository;
import com.anton.myfilms.model.Film;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        System.out.println("Hello!");
        SpringApplication.run(Application.class);
    }


    @Bean
    public CommandLineRunner demo(FilmRepository repository) {
        return (args) -> {

            // save a couple of customers
            repository.save(new Film("The Walking Dead", "deadmans"));
            repository.save(new Film("Fargo", "killers"));


            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Film film : repository.findAll()) {
                log.info(film.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Film film = repository.findOne(1L);
            log.info("Films found with findOne(1L):");
            log.info("--------------------------------");
            log.info(film.toString());
            log.info("");


            // fetch customers by last name
            log.info("Film found with findByName('Fargo'):");
            log.info("--------------------------------------------");
            for (Film item : repository.findByName("Fargo")) {
                log.info(item.toString());
            }
            log.info("");
        };
    }
}
