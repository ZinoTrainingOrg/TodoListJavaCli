package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.commons.configuration2.PropertiesConfiguration;

public class DBHandler {
/*
  String connectionUrl = "jdbc:mysql://localhost:3306/TodoApp";
  String user = "java_16_02";
  String pass = "java_16_02";
*/

  PropertiesConfiguration databaseProperties = new PropertiesConfiguration();

  private static Connection connection;

  public DBHandler(){


    String pass = databaseProperties.getString("database.password");
    String user = databaseProperties.getString("database.user");
    String host = databaseProperties.getString("database.host");
    String port = databaseProperties.getString("database.port");
    String dbName = databaseProperties.getString("database.name");
    String connectionUrl = host + ":"+ port + "/" + dbName;
    try {
      connection = DriverManager.getConnection(connectionUrl, user, pass);
    }catch (SQLException ex){
      System.out.println("Unable to connect to database");
      ex.printStackTrace();
    }
  }

  public Connection getConnection() {
    return connection;
  }

}
