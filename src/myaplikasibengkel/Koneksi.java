/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myaplikasibengkel;

import com.mysql.jdbc.Connection;
import java.io.FileReader;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author ubuntu
 */
public class Koneksi {
    public static  Connection conn;
    
    public static void main(String[] args) {
    String url = "jdbc:mysql://localhost/toko";
    String user = "root";
    String pass = "";
     try {
        conn = (Connection) DriverManager.getConnection(url, user, pass);
            System.out.println("koneksi berhasil");
        }catch (Exception e) {
            System.out.println("Koneksi gagal"+e.getMessage());
        }
    }
    
    public  static Connection connectDB() {
    try {
    FileReader reader = new FileReader("conf.properties");
    Properties p=new Properties();
    p.load(reader);
    String ip = p.getProperty("ip");
    String port = p.getProperty("port");
    String url = "jdbc:mysql://"+ip+":"+port+"/toko";
    String user = "root";
    String pass = "";
   conn = (Connection) DriverManager.getConnection(url, user, pass);
//            System.out.println("koneksi berhasil");
        }catch (Exception e) {
            System.err.println("Koneksi gagal"+e.getMessage());
        }
     return conn;
    }
}
