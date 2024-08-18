package com.pack.RestAPI.vehicle;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class VehicleConfig {

    @Bean
    CommandLineRunner commandLineRunner(VehicleRepository repository){
        return args -> {

            //repository.saveAll(List.of(vehicle1,vehicle2));
        };
    }

}