/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Srcko
 */
public class DbConnection {

    static Connection conn = null;
    static DbConnection db = null;
    static DbConnection instance =null;
    private String url = "jdbc:mysql://localhost:3307/prodavnica";
    private String user = "root";
    private String password = "";

    private DbConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
         Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
         Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static DbConnection getInstance()
    {
       if(instance == null)
            instance = new DbConnection();
       return instance;
    }
    
    public static Connection getConn() {
        if (db == null) {
            db = new DbConnection();
        }
        return conn;
    }
}