package com.equipo13.mapy;

import com.equipo13.mapy.repositories.items.SkuDataLogisiticaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class MapyApplication {
     public static void main(String[] args) {
        SpringApplication.run(MapyApplication.class, args);

    }


    @Bean
    public CommandLineRunner commandLineRunner(SkuDataLogisiticaRepository ctx) {
         return args -> {
             ctx.deleteAll();
         };
    }







}
