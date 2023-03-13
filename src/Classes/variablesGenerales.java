/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Hallo
 */
public class variablesGenerales {
    
    public static Semaphore darPasoIA = new Semaphore(0);
    public static Semaphore darPasoAdmin = new Semaphore(1);
    
    public static int numeroCiclos = 0;
    
    
    
    public variablesGenerales(){
        
    }
}
