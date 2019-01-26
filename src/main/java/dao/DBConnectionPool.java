/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import config.ConfiguracionYaml;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


/**
 *
 * @author oscar
 */
public class DBConnectionPool {

    private static DBConnectionPool dbconection = null;

    private DataSource hirakiDatasource = null;

    DBConnectionPool() {
        hirakiDatasource = getDataSourceHikari();
    }

    public static DBConnectionPool getInstance() {
        if (dbconection == null) {
            dbconection = new DBConnectionPool();
        }

        return dbconection;
    }

    public Connection getConnection() throws Exception {
        Class.forName(ConfiguracionYaml.getInstance().getDriverDB());
        Connection connection;
        connection = hirakiDatasource.getConnection();

        return connection;
    }

    public DataSource getDataSourceFromServer() throws NamingException {
        Context ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("jdbc/db4free");
        return ds;

    }

    private DataSource getDataSourceHikari() {
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(ConfiguracionYaml.getInstance().getUrlDB());
        config.setUsername(ConfiguracionYaml.getInstance().getUserDB());
        config.setPassword(ConfiguracionYaml.getInstance().getPassDB());
        config.setDriverClassName(ConfiguracionYaml.getInstance().getDriverDB());
        config.setMaximumPoolSize(10);

        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource datasource = new HikariDataSource(config);

        return datasource;
    }

   

    public void cerrarConexion(Connection connection) {
        try {
          
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cerrarPool() {
        hirakiDatasource = null;
    }
}
