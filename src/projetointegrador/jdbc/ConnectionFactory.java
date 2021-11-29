package projetointegrador.jdbc;

import java.sql.*;

public class ConnectionFactory {
    static public Connection getConnection(){
        try {
            final String url = "jdbc:mysql://localhost:3306/nextlevel_db" +
            "?verifyServerCertificate=false&useSSL=true";
            final String user = "root";
            final String password = "";
            
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
