/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


import controlador.MySQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author aroma
 */
public class CleaningArticle {
    
    protected int code;
    protected String name;
    protected boolean status;

    
    public CleaningArticle(){
        
    }
    
    public CleaningArticle(int code, String name){
        this.code = code;
        this.name = name;
        this.status = false;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public void showData(){
        System.out.println(this.code);
        System.out.println(this.name);
        System.out.println(this.status);
    }
    
    public void insertInTable(){
        MySQL bd = new MySQL("articulos", "root", "");
        
         try {
        String[] columns = {"code","name","lended"};
        PreparedStatement query = bd.CreateInsertStatement("cleaningarticle", columns);
        query.setInt(1, this.code);
        query.setString(2, this.name);
       query.setBoolean(3, this.status);
        bd.Insert(query);
        } catch (SQLException err) {
            bd.HandleError("Error al insertar datos en query", err);
        }
    }
    
    public void consultFromTable (){
        MySQL bd = new MySQL("articulos", "root", "");
        
        String condition = "code = ";
        
        condition += String.valueOf(this.code);
        try {
             PreparedStatement query = bd.CreateSelectStatement("cleaningarticle", condition);
            ResultSet cleaningArticles = bd.Select(query);
            if(cleaningArticles.next()) {
                this.code = cleaningArticles.getInt("code");
                this.name = cleaningArticles.getString("name");
                this.status = cleaningArticles.getBoolean("lended");
            }
            bd.CloseConnection();
        } catch (Exception err) {
            bd.HandleError("Error al consultar usuario", err);
        }
    }
}
