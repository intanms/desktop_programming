/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myaplikasibengkel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author intan
 */
public class Main {
    
    public static void main(String[] args){
        String sql = "SELECT * FROM produk";
        
        try(Connection conn = Koneksi.connectDB()){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                System.out.println(rs.getInt("id_produk") + "\t" +
                        rs.getString("nm_produk") + "\t" +
                        rs.getString("harga_produk"));
                
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
}

