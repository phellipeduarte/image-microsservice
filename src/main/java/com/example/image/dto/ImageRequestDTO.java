package com.example.image.dto;

import org.springframework.web.multipart.MultipartFile;

public record ImageRequestDTO(MultipartFile imageFile) {
}
