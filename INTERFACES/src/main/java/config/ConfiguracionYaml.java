/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author dam2
 */
public class ConfiguracionYaml {

    private static ConfiguracionYaml config;

    private ConfiguracionYaml() {

    }

//    public static ConfiguracionYaml getInstance() {
//
//        if (config == null) {
//            try {
//                Yaml yaml = new Yaml();
//                config = (ConfiguracionYaml) yaml.loadAs(
//                        new FileInputStream("config/configuracionUsuario.yml"),
//                        ConfiguracionYaml.class);
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(ConfiguracionYaml.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return config;
//    }

    private String user;
    private String pass;
    private String urlDBsqlServer;
    private String driverDBsqlServer;
    private String userDBsqlServer;
    private String passDBsqlServer;
    private String urlDBmySql;
    private String driverDBmySql;
    private String userDBmySql;
    private String passDBmySql;
    private String mailFrom;
    private String smtpServer;
    private String smtpPort;
    private String mailPass;
    private String dbms;

    public String getDbms() {
        return dbms;
    }

    public void setDbms(String dbms) {
        this.dbms = dbms;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUrlDB() {
        if (getDbms().equals("sqlServer")) {
            return urlDBsqlServer;
        } else {
            return urlDBmySql;
        }

    }

    public String getDriverDB() {
        if (getDbms().equals("sqlServer")) {
            return driverDBsqlServer;
        } else {
            return driverDBmySql;
        }
    }

    public String getUserDB() {
        if (getDbms().equals("sqlServer")) {
            return userDBsqlServer;
        } else {
            return userDBmySql;
        }
    }

    public String getPassDB() {
        if (getDbms().equals("sqlServer")) {
            return passDBsqlServer;
        } else {
            return passDBmySql;
        }
    }

    public void setUrlDBsqlServer(String urlDBsqlServer) {
        this.urlDBsqlServer = urlDBsqlServer;
    }

    public void setDriverDBsqlServer(String driverDBsqlServer) {
        this.driverDBsqlServer = driverDBsqlServer;
    }

    public void setUserDBsqlServer(String userDBsqlServer) {
        this.userDBsqlServer = userDBsqlServer;
    }

    public void setPassDBsqlServer(String passDBsqlServer) {
        this.passDBsqlServer = passDBsqlServer;
    }

    public void setUrlDBmySql(String urlDBmySql) {
        this.urlDBmySql = urlDBmySql;
    }

    public void setDriverDBmySql(String driverDBmySql) {
        this.driverDBmySql = driverDBmySql;
    }

    public void setUserDBmySql(String userDBmySql) {
        this.userDBmySql = userDBmySql;
    }

    public void setPassDBmySql(String passDBmySql) {
        this.passDBmySql = passDBmySql;
    }

    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    public String getSmtpServer() {
        return smtpServer;
    }

    public void setSmtpServer(String smtpServer) {
        this.smtpServer = smtpServer;
    }

    public String getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(String smtpPort) {
        this.smtpPort = smtpPort;
    }

    public String getMailPass() {
        return mailPass;
    }

    public void setMailPass(String mailPass) {
        this.mailPass = mailPass;
    }

}
