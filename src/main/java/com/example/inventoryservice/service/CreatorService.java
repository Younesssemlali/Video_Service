package com.example.inventoryservice.service;

import com.example.inventoryservice.dao.entities.Creator;
import com.example.inventoryservice.dao.repositories.CreatorRepository;
import com.example.inventoryservice.dto.CreatorRequest;
import com.example.inventoryservice.mapper.CreatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class CreatorService {

    @Autowired
    private CreatorRepository creatorRepository ;
    @Autowired
    private CreatorMapper creatorMapper;



    public Creator creatorById(Long id) {
        return creatorRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Creator %s not found",id)));
    }

    public Creator saveCreator( CreatorRequest CreatorRequest){
        Creator creator  = creatorMapper.fromCreatorRequestToCreator(CreatorRequest);
        return creatorRepository.save(creator);
    }

    public CreatorRequest getCreator(Long id){
        Creator creator =  creatorRepository.findById(id).get();
        return this.creatorMapper.fromCreatorToCreatorRequest(creator);
    }
}

