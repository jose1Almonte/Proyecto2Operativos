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
        
        
        while(variablesGenerales.keep){
            
            Serie serieJose = new Serie();
            Serie serieAndy = new Serie();
            Serie serieUseche = new Serie();
            
            this.establecerPrioridad(serieJose);
            this.establecerPrioridad(serieAndy);
            this.establecerPrioridad(serieUseche);
            
            System.out.println( "Prioridad: " + serieJose.getNivelPrioridad() + ". Duración: " + serieJose.getDuracionMinutos());
            
            
            
            
        }
    }
    
    /**
     * Determina cual debería ser la prioridad de la serie que se le pase
     * @param serieNombreRodaje
     */
    public void establecerPrioridad(Serie serieNombreRodaje){
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
        
        
        switch (total) {
            case 5 ->                 {
                    //            prioridad 1
                    serieNombreRodaje.setNivelPrioridad(1);
                    serieNombreRodaje.setNivelPrioridadInicio(1);
                    int duracionMinutos = (int) (Math.random()*90 + 90);
                    serieNombreRodaje.setDuracionMinutos(duracionMinutos);
                    break;
                }
            case 4 ->                 {
                    //            prioridad 2
                    serieNombreRodaje.setNivelPrioridad(2);
                    serieNombreRodaje.setNivelPrioridadInicio(2);
                    int duracionMinutos = (int) (Math.random()*30 + 60);
                    serieNombreRodaje.setDuracionMinutos(duracionMinutos);
                    break;
                }
            default ->                 {
                    //            prioridad 3
                    serieNombreRodaje.setNivelPrioridad(3);
                    serieNombreRodaje.setNivelPrioridadInicio(3);
                    int duracionMinutos = (int) (Math.random()*59);
                    serieNombreRodaje.setDuracionMinutos(duracionMinutos);
                }
        }
    }
    
    /**
     * Encola las series en su respectivo rodaje en su respectiva cola de prioridad
     */
    public void encolarSerie(Serie serieJose, Serie serieAndy, Serie serieUseche){
        serieJose.setNivelPrioridad(serieJose.getNivelPrioridadInicio());
        serieJose.setContador(0);
        
        serieAndy.setNivelPrioridad(serieAndy.getNivelPrioridadInicio());
        serieAndy.setContador(0);
        
        serieUseche.setNivelPrioridad(serieUseche.getNivelPrioridadInicio());
        serieUseche.setContador(0);
        
        int nivelJose = serieJose.getNivelPrioridad();
        
        switch (nivelJose) {
            case 1:
                Administrador.colaNivel1Jose.addLast(serieJose);
                break;
            case 2:
                Administrador.colaNivel2Jose.addLast(serieJose);
                break;
            default:
                Administrador.colaNivel3Jose.addLast(serieJose);
                break;
        }
        
        int nivelAndy = serieAndy.getNivelPrioridad();
        
        switch (nivelAndy){
            case 1:
                Administrador.colaNivel1Andy.addLast(serieAndy);
                break;
            case 2:
                Administrador.colaNivel2Andy.addLast(serieAndy);
                break;
            default:
                Administrador.colaNivel3Andy.addLast(serieAndy);
                break;
        }
        
        int nivelUseche = serieUseche.getNivelPrioridad();
        
        switch (nivelUseche) {
            case 1:
                Administrador.colaNivel1Useche.addLast(serieUseche);
                break;
            case 2:
                Administrador.colaNivel2Useche.addLast(serieUseche);
                break;
            default:
                Administrador.colaNivel3Useche.addLast(serieUseche);
                break;
        }
    }
    
    public void encolarColaRefuerzo(Serie serieJose, Serie serieAndy, Serie serieUseche){
        Administrador.colaRefuerzoJose.addLast(serieJose);
        Administrador.colaRefuerzoAndy.addLast(serieAndy);
        Administrador.colaRefuerzoUseche.addLast(serieUseche);
    }
    
    
    
}
