package com.example.inventoryservice.service;

import com.example.inventoryservice.dao.entities.Video;
import com.example.inventoryservice.dao.repositories.CreatorRepository;
import com.example.inventoryservice.dao.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VideoService {
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private CreatorRepository creatorRepository;


    public List<Video> videoList() {
        return videoRepository.findAll();
    }


    public Video saveVideo(Video video) {
        creatorRepository.save(video.getCreator());
        return videoRepository.save(video);
    }

}
