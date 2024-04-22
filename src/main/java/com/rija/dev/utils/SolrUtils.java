package com.rija.dev.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SolrUtils {
    private static final String SOLR_CORE_URL = "http://localhost:8983/solr/jcg_example_core";

    public static SolrClient getSolrClient() {
        return new HttpSolrClient.Builder(SOLR_CORE_URL)
                .withConnectionTimeout(5000)
                .withSocketTimeout(3000)
                .build();
    }
}
