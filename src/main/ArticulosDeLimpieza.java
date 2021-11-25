/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controlador.MySQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.User;

/**
 *
 * @author aroma
 */
public class ArticulosDeLimpieza {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MySQL bd = new MySQL("articulos", "root", "");
        User user = null;
        
        // Ejemplo de como hacer una query insert
        try {
            // Columnas de la tabla
            String[] columns = {"code", "name"};
            PreparedStatement query = bd.CreateSelectStatement("user", "code = 20310066");
            query.setInt(1, 20310066);
            query.setString(2, "Antonio Romano");
            bd.Insert(query);
        } catch (SQLException err) {
            bd.HandleError("Error al insertar datos en query", err);
        }
        
        // Ejemplo de como hacer una query select
        try {
            PreparedStatement query = bd.CreateSelectStatement("user", "code = 20310066");
            ResultSet users = bd.Select(query);
            if(users.next()) {
                user = new User(users.getInt("code"), users.getString("name"));
            }
            bd.CloseConnection();
            user.ShowData();
        } catch (SQLException err) {
            bd.HandleError("Error al consultar usuario", err);
        }
    }
    
}
