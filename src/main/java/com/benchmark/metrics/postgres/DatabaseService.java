package com.benchmark.metrics.postgres;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    public ResultSet getProviderInfo(String providerNumber) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("select * from import.provider_info where " +
                    "provnum = ?")) {
                statement.setString(1, providerNumber);
                return statement.executeQuery();
            } catch (SQLException e) {
                LOGGER.error("Sql exception: ", e);
                throw e;
            }
        }
    }

    public ResultSet getStateAverage(String state) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement stateStatement = connection.prepareStatement("select * from import.state_averages " +
                    "where " +
                    "state = ?'")) {
                stateStatement.setString(1, state);
                return stateStatement.executeQuery();
            }
        } catch (SQLException e) {
            LOGGER.error("Sql exception: ", e);
            throw e;
        }
    }

    public ResultSet getNationAverage() throws SQLException {
        return getStateAverage(NATION);
    }
}
