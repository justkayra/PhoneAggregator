package com.example.aggregator;

import com.example.aggregator.health.TemplateHealthCheck;
import com.example.aggregator.resource.MainResource;
import com.example.aggregator.util.FileUtils;
import io.dropwizard.Application;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.client.JerseyClientBuilder;

import java.io.InputStream;
import java.util.HashSet;


public class Server extends Application<DefaultConfiguration> {
    public static HashSet<String> allowedPrefixes;
    public static String extService;


    public static void main(String[] args) throws Exception {
        new Server().run(args);
    }

    @Override
    public String getName() {
        return "aggregator";
    }

    public void run(DefaultConfiguration config, Environment environment) {
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck();
        environment.healthChecks().register("template", healthCheck);

        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(config.getPrefixesFilePath());
        allowedPrefixes = FileUtils.readFile(in);
        extService = config.getExternalServiceURL();

        JerseyEnvironment restEnv = environment.jersey();
        restEnv.register(new MainResource(new JerseyClientBuilder().build()));
    }

}
