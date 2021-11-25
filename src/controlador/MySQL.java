/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.*;

/**
 *
 * @author aroma
 */
public class MySQL {
    
    Connection conn;
    
    // Constructor
    public MySQL() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception err) {
            System.out.println("Error al cargar controlador");
            System.out.println(err);
        }
    }
    
}
