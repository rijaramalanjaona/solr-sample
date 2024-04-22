package com.rija.dev.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Article {
    private String id;
    private String category;
    private String title;
    private String author;
    private boolean published;
}
