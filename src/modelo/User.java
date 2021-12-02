/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.PreparedStatement;
import java.util.Random;
import controlador.MySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author aroma
 */
public class User {
    protected int code;
    protected String name;
    
    public User() {
        this.code = new Random().nextInt(99999999);
        this.name = "Random";
    }
    
    public User(int code, String name) {
        this.code = code;
        this.name = name;
    }
    
    public void ShowData() {
        System.out.println("Codigo: " + this.code);
        System.out.println("Nombre: " + this.name);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    public void insertInTable(){
        MySQL bd = new MySQL("articulos", "root", "");
        
        
         try {
        String[] columns = {"code", "name"};
        PreparedStatement query = bd.CreateInsertStatement("user", columns);
        query.setInt(1, this.code);
        query.setString(2, this.name);
        bd.Insert(query);
        } catch (SQLException err) {
            bd.HandleError("Error al insertar datos en query", err);
        }
        
    }
    
    public void consultFromTable(){
        MySQL bd = new MySQL("articulos", "root", "");
        String condition = "code = ";
        
        condition += String.valueOf(this.code);
        try {
             PreparedStatement query = bd.CreateSelectStatement("user", condition);
            ResultSet users = bd.Select(query);
            if(users.next()) {
                this.code = users.getInt("code");
                this.name = users.getString("name");
            }
            bd.CloseConnection();
        } catch (SQLException err) {
            bd.HandleError("Error al consultar usuario", err);
        }
           
        
    }
}
