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
    protected boolean lended;
    private String tableName;

    
    public CleaningArticle(){
        this.code = 0;
        this.name = "";
        this.lended = false;
        this.tableName = "cleaning_article";
    }
    
    public CleaningArticle(int code, String name){
        this.code = code;
        this.name = name;
        this.lended = false;
        this.tableName = "cleaning_article";
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

    public boolean getStatus() {
        return this.lended;
    }

    public void setStatus(boolean lended) {
        this.lended = lended;
    }
    
    public void showData(){
        System.out.println(this.code);
        System.out.println(this.name);
        System.out.println(this.lended ? "Prestado" : "Disponible");
    }
    
    public boolean insertInTable(){
        MySQL bd = new MySQL("articulos", "root", "");
        
        try {
            String[] columns = {"code","name","lended"};
            PreparedStatement query = bd.CreateInsertStatement(this.tableName, columns);
            query.setInt(1, this.code);
            query.setString(2, this.name);
            query.setBoolean(3, this.lended);
            bd.InsertOrUpdate(query);
            return true;
        } catch (SQLException err) {
            bd.HandleError("Error al insertar datos en query", err);
            return false;
        }
    }
    
    public void consultFromTable (int code){
        MySQL bd = new MySQL("articulos", "root", "");
        String condition = "code = " + String.valueOf(code);
        
        try {
            PreparedStatement query = bd.CreateSelectStatement(this.tableName, condition);
            ResultSet cleaningArticles = bd.Select(query);
            if(cleaningArticles.next()) {
                this.code = cleaningArticles.getInt("code");
                this.name = cleaningArticles.getString("name");
                this.lended = cleaningArticles.getBoolean("lended");
            }
            bd.CloseConnection();
        } catch (Exception err) {
            bd.HandleError("Error al consultar usuario", err);
        }
    }
    public void updateArticleStatus(String code,int status){
        MySQL bd = new MySQL("articulos", "root", "");
        
        try {
           PreparedStatement query = bd.createUpdateStatement(this.tableName ,code);
           query.setInt(1, status);
           bd.InsertOrUpdate(query);
        } catch (Exception e) {
            bd.HandleError("Error al actualizar status", e);
        }
        
        
    }
    
    public void UpdateInTable() {
        MySQL bd = new MySQL("articulos", "root", "");
        String[] columns = {"code","name","lended"};
        String condition = "code = " + String.valueOf(code);
        
        try {
            PreparedStatement query = bd.CreateUpdateStatement(this.tableName, columns, condition);
            bd.InsertOrUpdate(query);
        } catch (Exception err) {
            bd.HandleError("Error al consultar usuario", err);
        }
    }
    
    public boolean DeleteFromTable() {
        MySQL bd = new MySQL("articulos", "root", "");
        String condition = "code = " + String.valueOf(code);
        
        try {
            PreparedStatement query = bd.CreateDeleteStatement(this.tableName, condition);
            bd.InsertOrUpdate(query);
            return true;
        } catch (Exception err) {
            bd.HandleError("Error al consultar usuario", err);
            return false;
        }
    }
}
