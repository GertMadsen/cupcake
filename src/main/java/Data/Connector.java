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
   
//  Christians MySQL aerver.
    private final static String DRIVER = "com.mysql.jdbc.Driver";
    private final static String URL = "jdbc:mysql://46.101.152.26:3306/cupcake";
    private final static String USER = "cupcakeuser";
    private final static String PASSWORD = "cupcakemysql";

//  Gerts MySQL aerver.
//    private final static String URL = "jdbc:mysql://138.197.189.73:3306/cupcake";
//    private final static String USER = "cupcakeuser";
//    private final static String PASSWORD = "cupcake1971";

    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }
}
