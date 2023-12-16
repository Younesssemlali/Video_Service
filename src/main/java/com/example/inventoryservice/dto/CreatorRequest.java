package com.example.inventoryservice.dto;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class CreatorRequest {
    private String name;
    private String email;
}
