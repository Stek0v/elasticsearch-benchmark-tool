package io.logz.benchmarks.elasticsearch.configuration;

import io.logz.benchmarks.elasticsearch.exceptions.InvalidConfigurationException;

/**
 * Created by roiravhon on 9/21/16.
 */
public class ElasticsearchConfiguration implements BaseConfiguration {

    private String elasticsearchAddress;
    private String elasticsearchProtocol = "http";
    private int elasticsearchPort = 9200;
    private int numberOfShards = 1;
    private int numberOfReplicas = 0;
    private String userName;
    private String password;

    // For Jackson
    @SuppressWarnings("unused")
    public ElasticsearchConfiguration() {

    }

    @SuppressWarnings("unused")
    public ElasticsearchConfiguration(String elasticsearchAddress, String elasticsearchProtocol, Integer elasticsearchPort, Integer numberOfShards, Integer numberOfReplicas, String userName, String password) {
        this.elasticsearchAddress = elasticsearchAddress;
        this.elasticsearchProtocol = elasticsearchProtocol;
        this.elasticsearchPort = elasticsearchPort;
        this.numberOfShards = numberOfShards;
        this.numberOfReplicas = numberOfReplicas;
        this.userName = userName;
        this.password = password;
    }

    public String getElasticsearchAddress() {
        return elasticsearchAddress;
    }

    public String getElasticsearchProtocol() {
        return elasticsearchProtocol;
    }

    public int getElasticsearchPort() {
        return elasticsearchPort;
    }

    public int getNumberOfShards() {
        return numberOfShards;
    }

    public int getNumberOfReplicas() {
        return numberOfReplicas;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void validateConfig() throws InvalidConfigurationException {

        if (elasticsearchAddress == null || elasticsearchAddress == "") {
            throw new InvalidConfigurationException("elasticsearchAddress must be set!");
        }

        if (!elasticsearchProtocol.equals("http")) {
            throw new InvalidConfigurationException("Only supporting http protocol for Elasticsearch for now");
        }
    }
}
