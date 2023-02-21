/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */

public class MyConnection {
    public static MyConnection instance;
    public Connection connexion;
    private String url = "jdbc:mysql://localhost:3306/pidev"; 
    private String user = "root"; 
    private String password = ""; 

    public MyConnection() {
        try {
            connexion = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established");
        } catch (SQLException ex) {
            System.out.println("Error while connecting to database: " + ex.getMessage());
        }
    }

    public static MyConnection getInstance() {
        if (instance == null) {
            instance = new MyConnection();
        }
        return instance;
    }

    public Connection getConnexion() {
        return connexion;
    }
}

   
