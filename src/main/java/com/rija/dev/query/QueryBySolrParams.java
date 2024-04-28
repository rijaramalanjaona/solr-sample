package com.rija.dev.query;

import com.rija.dev.utils.SolrUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.MapSolrParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class QueryBySolrParams {
    private static final Logger LOGGER = LoggerFactory.getLogger(QueryBySolrParams.class);
    private static final SolrClient SOLR_CLIENT = SolrUtils.getSolrClient();

    public static void main(String[] args) {
        final Map<String, String> queryParamMap = new HashMap<>();
        queryParamMap.put("q", "author:\"Kevin Yang\"");
        queryParamMap.put("fl", "id, title, author");
        queryParamMap.put("sort", "id asc");

        MapSolrParams queryParams = new MapSolrParams(queryParamMap);

        QueryResponse response = null;
        try {
            response = SOLR_CLIENT.query(queryParams);
        } catch (SolrServerException | IOException e) {
            LOGGER.error("Failed to search articles: {}", e.getMessage());
        }

        if (response != null) {
            LOGGER.info("Found {} articles", response.getResults().getNumFound());
            response.getResults().forEach(article -> LOGGER.info(article.toString()));
        }
    }
}
