package com.rija.dev.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.solr.client.solrj.beans.Field;

@Getter
@Setter
@AllArgsConstructor
public class Article {
    @Field
    private String id;
    @Field
    private String category;
    @Field
    private String title;
    @Field
    private String author;
    @Field
    private boolean published;
}
