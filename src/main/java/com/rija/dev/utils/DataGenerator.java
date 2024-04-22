package com.rija.dev.utils;

import com.rija.dev.bean.Article;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DataGenerator {
    public static List<Article> getArticles() {
        return List.of(
                new Article("0553573333", "java", "Java Array Example", "Kevin Yang", true),
                new Article("0626166238", "java", "Java Arrays Showcases", "Kevin Yang", true),
                new Article("0221234283", "java", "Java ArrayList 101", "Kevin Yang", true),
                new Article("0553579908", "java", "Java Remote Method Invocation Example", "Kevin Yang", true),
                new Article("055357342Y", "java", "Java StringTokenizer Example", "Kevin Yang", true),
                new Article("0553292123", "java", "Java HashMap Example", "Evan Swing", true),
                new Article("0928237471", "java", "Java HashSet Example", "Evan Swing", true),
                new Article("0818231712", "solr", "Apache SolrCloud Example", "Kevin Yang", true),
                new Article("0812521390", "solr", "The Solr Runbook", "James Cook", false),
                new Article("0812550706", "solr", "The Apache Solr Cookbook", "James Cook", true),
                new Article("0441385532", "solr", "The Solr REST API", "Steven Thomas", false),
                new Article("0380014300", "solr", "SolrCloud Tutorial", "Roger Goodwill", true));
    }
}
