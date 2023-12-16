package com.example.inventoryservice;

import com.example.inventoryservice.dao.entities.Creator;
import com.example.inventoryservice.dao.entities.Video;
import com.example.inventoryservice.dao.repositories.CreatorRepository;
import com.example.inventoryservice.dao.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(VideoRepository videoRepository, CreatorRepository creatorRepository){
        return args -> {
            List<Creator> creators=List.of(
                    Creator.builder().name("said").email("said@gmail.com").build(),
                    Creator.builder().name("fahd").email("fahd@gmail.com").build(),
                    Creator.builder().name("omar").email("omar@gmail.com").build()
            );

             creators =creatorRepository.saveAll(creators);

             List<Video> videos=List.of(
                     Video.builder().name("v1").url("v1.com").description("video 1").datepublication(new Date()).creator(creators.get(0)).build(),
                     Video.builder().name("v2").url("v2.com").description("video 2").datepublication(new Date()).creator(creators.get(1)).build(),
                     Video.builder().name("v3").url("v3.com").description("video 3").datepublication(new Date()).creator(creators.get(2)).build()
             );

             videos=videoRepository.saveAll(videos);


        };
    }

}
