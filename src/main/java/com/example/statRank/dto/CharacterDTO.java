package com.example.statRank.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class CharacterDTO {
    private Long id;
    private String name;
    private MultipartFile uploadFile;
    private String image;
    private String content;
    private int stat1;
    private int stat2;
    private int stat3;
    private int stat4;
    private int stat5;
}
