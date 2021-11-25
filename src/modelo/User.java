/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Random;

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
}
