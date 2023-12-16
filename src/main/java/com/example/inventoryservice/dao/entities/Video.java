package com.example.inventoryservice.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Video {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String url;
    public String description;
    public Date datepublication;
    @ManyToOne
    @JoinColumn(name = "creator_id")
    public Creator creator;
}
