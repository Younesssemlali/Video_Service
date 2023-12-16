package com.example.inventoryservice.web;

import com.example.inventoryservice.dao.entities.Creator;
import com.example.inventoryservice.dao.entities.Video;
import com.example.inventoryservice.dto.CreatorRequest;
import com.example.inventoryservice.service.CreatorService;
import com.example.inventoryservice.service.VideoService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VideoGraphQlController {

    private  CreatorService creatorService;
    private VideoService videoService;



    @QueryMapping
    public List<Video> videoList() {
        return videoService.videoList();
    }

    @QueryMapping
    public Creator creatorById(@Argument Long id) {
        return creatorService.creatorById(id);
    }

    @MutationMapping
    public Video saveVideo(@Argument Video video) {
        return videoService.saveVideo(video);
    }

    @MutationMapping
    public Creator saveCreator(@Argument CreatorRequest CreatorRequest) {
        return creatorService.saveCreator(CreatorRequest);
    }

    @QueryMapping
    public CreatorRequest getCreator(@Argument Long id) {
        return creatorService.getCreator(id);
    }
}
