package com.yobelbackend.yobelbackend.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Character {
    private Long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Location originLocation;
    private Location lastKnownLocation;
    private String image;
    private List<String> episode;
    private String url;
    private String created;
}
