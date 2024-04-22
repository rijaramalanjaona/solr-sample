package com.rija.dev.indexing;

import com.rija.dev.utils.DataGenerator;
import com.rija.dev.utils.SolrUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class IndexingBySolrInputDocument {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexingBySolrInputDocument.class);
    private static final SolrClient SOLR_CLIENT = SolrUtils.getSolrClient();

    public static void main(String[] args) {
        List<SolrInputDocument> docs = buildSolrInputDocuments();
        LOGGER.info("Indexing {} articles...\n", docs.size());

        try {
            SOLR_CLIENT.add(docs);
            SOLR_CLIENT.commit();
            LOGGER.info("{} articles indexed.\n", docs.size());
        } catch (SolrServerException | IOException e) {
            LOGGER.error("Failed to indexing articles: {}", e.getMessage());
        }
    }

    private static List<SolrInputDocument> buildSolrInputDocuments() {
        return DataGenerator.getArticles().stream()
                .map(article -> {
                    final SolrInputDocument doc = new SolrInputDocument();
                    doc.addField("id", article.getId());
                    doc.addField("category", article.getCategory());
                    doc.addField("title", article.getTitle());
                    doc.addField("author", article.getAuthor());
                    doc.addField("published", article.isPublished());
                    return doc;
                })
                .collect(Collectors.toList());
    }
}
