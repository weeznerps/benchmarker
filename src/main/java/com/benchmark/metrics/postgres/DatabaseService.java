package com.benchmark.metrics.postgres;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    public Optional<ProviderInfo> getProviderInfoByNumber(String providerNumber) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("select * from import.provider_info where " +
                    "provnum = ?")) {
                statement.setString(1, providerNumber);

                ResultSet results = statement.executeQuery();
                if(!results.next()) {
                    return Optional.empty();
                }
                if(results.getFetchSize() > 1) {
                    throw new SQLException("Too many results");
                }
                return Optional.of(new ProviderInfo(results));
            } catch (SQLException e) {
                LOGGER.error("Sql exception: ", e);
                throw e;
            }
        }
    }

    public List<ProviderInfo> searchProviderInfoByName(String searchString) throws SQLException {

        String[] searchStrings = searchString.trim().split(" ");
        LOGGER.error(searchStrings.toString());
        StringBuilder statementBuilder = new StringBuilder("select * from import.provider_info where provname like ?");
        for(int i = 0; i < searchStrings.length; i++) {
            statementBuilder.append(" and like ? ");
        }
        LOGGER.error(statementBuilder.toString());
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(statementBuilder.toString())) {
                for(int i = 1; i <= searchString.length(); i++) {
                    statement.setString(i, "%" + searchStrings[i-1] + "%");
                }
                ResultSet results = statement.executeQuery();

                List<ProviderInfo> providers = new ArrayList<>();
                while(results.next()) {
                    providers.add(new ProviderInfo(results));
                }
                return providers;
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
