package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnect
{
    public static Connection connect()throws SQLException,ClassNotFoundException
    {
        //Connection String of jar file 
        //Connection path
        String dbDriver = "com.mysql.jdbc.Driver"; 
        String dbURL = "jdbc:mysql://localhost:3306/"; 
        //Database details.
        String dbName = "college"; 
        String dbUsername = "root"; 
        String dbPassword = "";
        
        Class.forName(dbDriver); 
        Connection con = DriverManager.getConnection(dbURL + dbName, 
                                                     dbUsername,  
                                                     dbPassword);
        return con;        
    }
}
