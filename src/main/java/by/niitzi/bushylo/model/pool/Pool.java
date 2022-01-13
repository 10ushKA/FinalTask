package by.niitzi.bushylo.model.pool;

import java.sql.Connection;
import java.sql.SQLException;

public interface Pool {
    Connection getConnection() throws SQLException;
    boolean releaseConnection(Connection connection);
}
