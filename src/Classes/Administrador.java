/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Hallo
 */
public class Administrador extends Thread{
    
    int contador;

    public static LinkedList colaNivel1Jose = new LinkedList();
    public static LinkedList colaNivel2Jose = new LinkedList();
    public static LinkedList colaNivel3Jose = new LinkedList();
    public static LinkedList colaRefuerzoJose = new LinkedList();

    public static LinkedList colaNivel1Andy = new LinkedList();
    public static LinkedList colaNivel2Andy = new LinkedList();
    public static LinkedList colaNivel3Andy = new LinkedList();
    public static LinkedList colaRefuerzoAndy = new LinkedList();

    public static LinkedList colaNivel1Useche = new LinkedList();
    public static LinkedList colaNivel2Useche = new LinkedList();
    public static LinkedList colaNivel3Useche = new LinkedList();
    public static LinkedList colaRefuerzoUseche = new LinkedList();
    
    @Override
    public void run(){
        
        
        while(true){
            Serie serieJose = new Serie();
            Serie serieAndy = new Serie();
            Serie serieUseche = new Serie();
            
        }
    }
    /**
     * Determina cual debería ser la prioridad de la serie que se le pase
     * @param serieNombreRodaje
     * @return prioridad de la serie
     */
    public int establecerPrioridad(Serie serieNombreRodaje){
        double introProb = Math.random();
        double inicio1Prob = Math.random();
        double inicio2Prob = Math.random();
        double cierreProb = Math.random();
        double creditosProb = Math.random();
        
        int intro;
        int inicio1;
        int inicio2;
        int cierre;
        int creditos;
        
        if (introProb <= 0.75){
            intro = 1;
        }else{
            intro = 0;
        }
        
        if (inicio1Prob <= 0.84){
            inicio1 = 1;
        }else{
            inicio1 = 0;
            
        }
        
        if (inicio2Prob <= 0.84){            
            inicio2 = 1;
        }else{            
            inicio2 = 0;
        }
        
        if (cierreProb <= 0.80){
            cierre = 1;
        }else{
            cierre = 0;            
        }
        
        if (creditosProb <= 0.85){
            creditos = 1;
        }else{
            creditos = 0;            
        }
        
        int total = intro + inicio1 + inicio2 + cierre + creditos;
        
        if(total <= 1){
//            prioridad 1
            return 1;
        }else if(total <= 3){
//            prioridad 2
            return 2;
        }else{
//            prioridad 3
            return 3;
        }
    }
}
