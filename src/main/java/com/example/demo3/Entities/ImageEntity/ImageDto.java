package com.example.demo3.Entities.ImageEntity;

import lombok.Data;

@Data
public class ImageDto {
    private String path;
    private String name;
    private String type;
    private Long userId;
    private Long listingId;
}
