package com.benchmark.metrics.setup;

import javax.inject.Singleton;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.benchmark.metrics.postgres.DatabaseService;

/**
 * @author jsanderson
 */
class DependencyBinder extends AbstractBinder {

    private static final Logger LOGGER = LoggerFactory.getLogger(DependencyBinder.class);

    private InitialContext initialContext = initContext();
    protected void configure() {
        bindCommon();
        bindServices();
        bindDataSource();
    }

    private void bindCommon() {
        bind(HttpClientBuilder.create().build()).to(HttpClient.class);
    }

    private void bindServices() {
        bindAsContract(DatabaseService.class).in(Singleton.class);
    }

    private void bindDataSource() {
        try {
            bind((DataSource) initialContext.lookup("java:comp/env/medicare/data")).to(DataSource.class);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    private InitialContext initContext() {
        try {
            return new InitialContext();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}
