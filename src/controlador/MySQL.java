/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.CleaningArticle;

/**
 *
 * @author aroma
 */
public class MySQL {
    
    private Connection conn;
    private PreparedStatement query;
    private String bdName;
    private String user;
    private String pass;
    
    // Constructor
    public MySQL() {
        this.bdName = "articulos";
        this.user = "root";
        this.pass = "";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = null;
        } catch (ClassNotFoundException err) {
            this.HandleError("Error al cargar driver MySQL", err);
        }
    }
    
    public MySQL(String bdName, String user, String pass) {
        this.bdName = bdName;
        this.user = user;
        this.pass = pass;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = null;
        } catch (ClassNotFoundException err) {
            this.HandleError("Error al cargar driver MySQL", err);
        }
    }
    
    private void OpenConnection() {
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/" + this.bdName + "?serverTimezone=GMT-5", this.user, this.pass);
        } catch (SQLException err) {
            this.HandleError("Error al conectar a BD", err);
        }
    }
    
    public void CloseConnection() {
        try {
            this.conn.close();
        } catch (SQLException err) {
            this.HandleError("Error al cerrar conexión a BD", err);
        }
    }
    
    public void HandleError(String customMessage, Exception err) {
        System.out.println(customMessage);
        System.out.println(err.getMessage());
    }
    
    // insert methods
    public PreparedStatement CreateInsertStatement(String tableName, String[] columns) {
        try {
            String query = "insert into " + tableName + "(";
            for(int i = 0; i < columns.length; i++) {
                query += columns[i];
                if(i != columns.length - 1) query += ",";
            }
            query += ") values (";
            for(int i = 0; i < columns.length; i++) {
                query += "?";
                if(i != columns.length - 1) query += ",";
            }
            query += ")";
            if(this.conn == null || this.conn.isClosed()) this.OpenConnection();
            this.OpenConnection();
            return this.conn.prepareStatement(query);
        } catch(SQLException err) {
            this.HandleError("Error al crear query", err);
            return null;
        }
    }
    
    public PreparedStatement CreateInsertStatement(String tableName, int columnsNumber) {
        try {
            String query = "insert into " + tableName + " values (";
            for(int i = 0; i < columnsNumber; i++) {
                query += "?";
                if(i != columnsNumber - 1) query += ",";
            }
            query += ")";
            if(this.conn == null || this.conn.isClosed()) this.OpenConnection();
            this.OpenConnection();
            return this.conn.prepareStatement(query);
        } catch(SQLException err) {
            this.HandleError("Error al crear query", err);
            return null;
        }
    }
    
    // select methods
    public PreparedStatement CreateSelectStatement(String tableName, String conditions) {
        PreparedStatement sqlQuery = null;
        try {
            String query = "select * from " + tableName + (conditions.length() > 0 ? (" where " + conditions) : (""));
            if(this.conn == null || this.conn.isClosed()) this.OpenConnection();
            this.OpenConnection();
            sqlQuery = this.conn.prepareStatement(query);
        } catch(SQLException err) {
            this.HandleError("Error al crear query", err);
        }
        return sqlQuery;
    }
    
    public PreparedStatement CreateSelectStatement(String tableName){
        PreparedStatement sqlQuery = null;
        
         try {
            String query = "select * from " + tableName;
            if(this.conn == null || this.conn.isClosed()) this.OpenConnection();
           
            sqlQuery = this.conn.prepareStatement(query);
        } catch(SQLException err) {
            this.HandleError("Error al crear query", err);
        }
        return sqlQuery;
        
        
    }
    
    public void Insert(PreparedStatement query) {
        try {
            query.executeUpdate();
            this.CloseConnection();
        } catch (SQLException err) {
            this.HandleError("Error al ejecutar insert", err);
        }
    }
    
    public ResultSet Select(PreparedStatement query) {
        ResultSet result = null;
        try {
            result = query.executeQuery();
        } catch (SQLException err) {
            this.HandleError("Error al ejecutar insert", err);
        }
        return result;
    }
    public PreparedStatement createUpdateStatement(String table,String code){
        PreparedStatement sqlQuery = null;
        
        try {
            String query ="UPDATE " + table + " set lended=? WHERE code=" + code;
            if(this.conn == null || this.conn.isClosed()) this.OpenConnection();
            sqlQuery = this.conn.prepareStatement(query);
        } catch (Exception err) {
          this.HandleError("Error al actualizar la base de datos", err);
        }
        
        return sqlQuery;
        
    }
    public CleaningArticle searchInTable(String codigo){
        CleaningArticle ca = null;
        ResultSet rs = null;
        String condition = "code = ";
        
        condition += codigo;
        
        try {
           PreparedStatement query = CreateSelectStatement("cleaningarticle",condition);
           rs = this.Select(query);
           if(rs.next()){
               ca = new CleaningArticle();
                ca.setCode(rs.getInt("code")) ;
                ca.setName(rs.getString("name"));
                ca.setStatus(rs.getBoolean("lended")) ;
           }
           this.CloseConnection();
           
        } catch (Exception err) {
            
          this.HandleError("no se encontró el articulo", err);
        }
        return ca;
    }
    
}
