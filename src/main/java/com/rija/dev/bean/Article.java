package com.rija.dev.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.solr.client.solrj.beans.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
