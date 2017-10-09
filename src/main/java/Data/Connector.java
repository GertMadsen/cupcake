/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author GertLehmann
 */
public class Connector {
// Gerts localhost.
//    private final static String DRIVER = "com.mysql.jdbc.Driver";
//    private final static String URL = "jdbc:mysql://localhost:3306/cupcake";
//    private final static String USER = "cupcakeuser";
//    private final static String PASSWORD = "cupcake1971";
//    
//  Christians MySQL aerver.

    private final static String DRIVER = "com.mysql.jdbc.Driver";
    private final static String URL = "jdbc:mysql://46.101.152.26:3306/cupcake";
    private final static String USER = "cupcakeuser";
    private final static String PASSWORD = "cupcakemysql";

//  Gerts MySQL aerver.
//    private final static String DRIVER = "com.mysql.jdbc.Driver";
//    private final static String URL = "jdbc:mysql://138.197.189.73:3306/cupcake";
//    private final static String USER = "cupcakeuser";
//    private final static String PASSWORD = "cupcake1971";
    private static Connection conn = null;

    public static Connection getConnection() {

        if (conn != null) {
            return conn;
        }
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection() {
        try {
            conn.close();
            conn = null;
        } catch (SQLException e) {
            System.out.println("Exception thrown  :" + e);
        }
    }
}
