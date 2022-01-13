package by.niitzi.bushylo.model.pool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PoolConfiguration {
    protected static final String DB_HOST = "db.host";
    protected static final String DB_LOGIN = "db.login";
    protected static final String DB_PASSWORD = "db.password";
    protected static final String DB_DRIVER_NAME = "db.driver-name";
    protected static final String CONNECTION_POOL_SIZE = "connection-pool-size";
    protected static final String WAIT_CONNECTION_TIMEOUT = "wait-connection-timeout";

    static final PoolConfiguration configurator = new PoolConfiguration();
    private static final String CONFIG_PROPERTIES = "resources//config.properties";
    private final Properties properties = new Properties();

    private PoolConfiguration() {
        InputStream inputStream;
        try {
            inputStream = this.getClass().getClassLoader().getResourceAsStream(CONFIG_PROPERTIES);
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Properties file not found", e);
        }
    }

    static PoolConfiguration getConfigurator() {return configurator;}
         Properties getProperties() {return properties;}
    }



