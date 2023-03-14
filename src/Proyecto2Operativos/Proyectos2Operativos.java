/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Proyecto2Operativos;

import Classes.Administrador;
import Interfaces.Prueba;

/**
 *
 * @author Andy
 */
public class Proyectos2Operativos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Prueba p =new Prueba();
        p.setVisible(true);
        
        Administrador admin = new Administrador();
        
        admin.start();
    }
    
}
