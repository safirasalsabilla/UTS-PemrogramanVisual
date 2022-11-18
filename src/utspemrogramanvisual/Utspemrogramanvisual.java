/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package utspemrogramanvisual;


import java.sql.Connection;
import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.logging.Logger;

/**
 *
 * @author Labkom-M9
 */
public class Utspemrogramanvisual {
    String jdbcDriver = "com.mysql.cj.jdbc.Driver";
            String dbUrl = "jdbc:mysql://localhost/mahasiswa";
            String user = "root";
            String password = "";
            
            Connection con;
            Statement st;
            ResultSet rs;
            PreparedStatement ps;
            
            boolean respons;
            
            public Utspemrogramanvisual() {
                
        try {
            Class.forName(jdbcDriver);
            System.out.println("driver load.");
        } catch (ClassNotFoundException ex) {
            System.out.println("driver tidak ditemukan");
            java.util.logging.Logger.getLogger(Utspemrogramanvisual.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            con = DriverManager.getConnection(dbUrl, user, password);
            System.out.println("berhasil terkoneksi dengan mysql");
        } catch (SQLException ex) {
            System.out.println("gagal terkoneksi, periksa config mysql!");
            java.util.logging.Logger.getLogger(Utspemrogramanvisual.class.getName()).log(Level.SEVERE, null, ex);
        }

                
                  
            }
            public boolean insertmahasiswa(String nim, String nama, String programstudi, String fakultas) throws SQLException {
                String query = "insert into datamahasiswa (nim, nama, programstudi, fakultas) values (?, ?, ?, ?)";
                try {
                    ps = con.prepareStatement(query);
                    ps.setString(1, nim);
                    ps.setString(2, nama);
                    ps.setString(3, programstudi);
                    ps.setString(4, fakultas);
                    ps.executeUpdate();
                    respons = true;
                    System.out.println("sukses insert.");
                } catch (SQLException ex) {
                    respons = false;
                    System.out.println("gagal menambahkan.");
                    Logger.getLogger(Utspemrogramanvisual.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                return respons;
            }
            
            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
