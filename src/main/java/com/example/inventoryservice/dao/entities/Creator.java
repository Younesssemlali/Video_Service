package com.example.inventoryservice.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Creator {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String email;
    @OneToMany(mappedBy = "creator")
    public List<Video> video;
}
