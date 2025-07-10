package org.example.crud.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDataBase {
    public static Connection getConnection(){
        String user="saul";
        String password="password";
        String url ="jdbc:postgresql://localhost:5432/mi_basedatos";
        Connection connection=null;
        Logger logger = Logger.getLogger(ConnectionDataBase.class.getName());
        try{
            connection = DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            logger.log(Level.SEVERE,"Problem with your code is very bad and ugly");
        }
        return connection;
    }
}
