package com.benchmark.metrics.postgres;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.benchmark.metrics.data.ProviderInfo;
import com.benchmark.metrics.data.ProviderInfo.State;
import com.benchmark.metrics.data.StateAverage;

/**
 * @author jsanderson
 */
public class DatabaseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseService.class);

    private static final int STATE_COLUMN = 5;
    private static final String NATION = "NATION";

    private final DataSource dataSource;

    @Inject
    public DatabaseService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Optional<ProviderInfo> getProviderInfo(String providerNumber) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("select * from import.provider_info where " +
                    "provnum = ?")) {
                statement.setString(1, providerNumber);
                LOGGER.error("here is the provider number: " + providerNumber);
                ResultSet results = statement.executeQuery();
                if(!results.next()) {
                    return Optional.empty();
                }
                return Optional.of(new ProviderInfo(results));
            } catch (SQLException e) {
                LOGGER.error("Sql exception: ", e);
                throw e;
            }
        }
    }

    public StateAverage getStateAverage(State state) throws SQLException {
        return getStateAverage(state.name()).orElseThrow(IllegalStateException::new);
    }

    public Optional<StateAverage> getStateAverage(String state) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("select * from import.state_averages " +
                    "where " +
                    "state = ?")) {
                statement.setString(1, state);
                ResultSet results = statement.executeQuery();
                if(!results.next()) {
                    return Optional.empty();
                }
                return Optional.of(new StateAverage(results));
            }
        } catch (SQLException e) {
            LOGGER.error("Sql exception: ", e);
            throw e;
        }
    }

    public StateAverage getNationAverage() throws SQLException {
        return getStateAverage(NATION).orElseThrow(IllegalStateException::new);
    }
}
