/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author novan
 */
public class MysqlConnection {
    public static Connection Koneksi() throws Exception{
        String url = "jdbc:mysql://localhost:3306/smsgateway";
        String user = "root";
        String pass = "";
        Connection koneksi = null;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        koneksi = (Connection) DriverManager.getConnection(url, user, pass);
        return koneksi;
}
}
