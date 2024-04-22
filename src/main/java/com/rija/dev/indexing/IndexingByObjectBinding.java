package com.rija.dev.indexing;

import com.rija.dev.bean.Article;
import com.rija.dev.utils.DataGenerator;
import com.rija.dev.utils.SolrUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class IndexingByObjectBinding {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexingByObjectBinding.class);
    private static final SolrClient SOLR_CLIENT = SolrUtils.getSolrClient();

    public static void main(String[] args) {
        List<Article> articles = DataGenerator.getArticles();
        LOGGER.info("Indexing {} articles...", articles.size());

        try {
            SOLR_CLIENT.addBeans(articles);
            SOLR_CLIENT.commit();
            LOGGER.info("{} articles indexed", articles.size());
        } catch (SolrServerException | IOException e) {
            LOGGER.error("Failed to indexing articles: {}", e.getMessage());
        }
    }
}
