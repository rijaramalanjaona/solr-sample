package com.rija.dev.query;

import com.rija.dev.bean.Article;
import com.rija.dev.utils.SolrUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class QueryBySolrQueryAndObjectBinding {
    private static final Logger LOGGER = LoggerFactory.getLogger(QueryBySolrQueryAndObjectBinding.class);
    private static final SolrClient SOLR_CLIENT = SolrUtils.getSolrClient();

    public static void main(String[] args) {
        final SolrQuery solrQuery = new SolrQuery("author: \"Kevin Yang\"");
        solrQuery.addField("id");
        solrQuery.addField("title");
        solrQuery.addField("author");
        solrQuery.setSort("id", SolrQuery.ORDER.asc);
        solrQuery.setRows(2);

        QueryResponse response = null;
        try {
            response = SOLR_CLIENT.query(solrQuery);
        } catch (SolrServerException | IOException e) {
            LOGGER.error("Failed to search articles: {}", e.getMessage());
        }

        if (response != null) {
            LOGGER.info("Found {} articles", response.getResults().getNumFound());
            List<Article> articles = response.getBeans(Article.class);
            articles.forEach(article -> LOGGER.info(article.toString()));
        }
    }
}
