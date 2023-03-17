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
    
    public static boolean keep = true;
    
    public static Semaphore darPasoIA = new Semaphore(0);
    public static Semaphore darPasoAdmin = new Semaphore(0);
    
    public static int numeroCiclos = 2;
    
    public static int terminalCedulaJose = 9; // Probablemente no se usen todos
    public static int terminalCedulaAndy = 8; // Probablemente no se usen todos
    public static int terminalCedulaUseche = 3; // Probablemente no se usen todos
    
    
    
    public variablesGenerales(){
        
    }
}
