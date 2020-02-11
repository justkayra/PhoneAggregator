package com.example.aggregator;

import io.dropwizard.Configuration;

public class DefaultConfiguration extends Configuration {
  private String externalServiceURL;
    private String prefixesFilePath;

    public String getExternalServiceURL() {
        return externalServiceURL;
    }

    public String getPrefixesFilePath() {
        return prefixesFilePath;
    }
}
