/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.oop.koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author yyaayyaatt
 */
public class DBConnection {
    private Connection koneksi;
    
    public Connection connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver berhasil diload.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Driver tidak ditemukan.");
        }
        
        String url = "jdbc:mysql://localhost:3306/Biodata";
        try {
            koneksi = DriverManager.getConnection(url, "root", "");
            System.out.println("Database berhasil diload.");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Database tidak ditemukan!!!.");
        }
        return koneksi;
    }
}
