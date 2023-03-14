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
    
    /**
     * Encola las series que se le pasen en su respectiva cola de refuerzo
     * @param serieJose
     * @param serieAndy
     * @param serieUseche 
     */
    public void encolarColaRefuerzo(Serie serieJose, Serie serieAndy, Serie serieUseche){
        Administrador.colaRefuerzoJose.addLast(serieJose);
        Administrador.colaRefuerzoAndy.addLast(serieAndy);
        Administrador.colaRefuerzoUseche.addLast(serieUseche);
    }
    
    /**
     * Suma 1 al contador individual de cada serie de las listas resaltadas al inicio del metodo
     */
    public void sumar1ContadorSeries(){
        
        int sizeColaNivel2Jose = Administrador.colaNivel2Jose.size();
        int sizeColaNivel3Jose = Administrador.colaNivel3Jose.size();
        int sizeColaRefuerzoJose = Administrador.colaRefuerzoJose.size();
        
        int sizeColaNivel2Andy = Administrador.colaNivel2Andy.size();
        int sizeColaNivel3Andy = Administrador.colaNivel3Andy.size();
        int sizeColaRefuerzoAndy = Administrador.colaRefuerzoAndy.size();
        
        int sizeColaNivel2Useche = Administrador.colaNivel2Useche.size();
        int sizeColaNivel3Useche = Administrador.colaNivel3Useche.size();
        int sizeColaRefuerzoUseche = Administrador.colaRefuerzoUseche.size();
        
        for(int i = 0; i < sizeColaNivel2Jose; i++){
            
            Serie serieTemp = (Serie) (Administrador.colaNivel2Jose.getHead().getData());
            
            Administrador.colaNivel2Jose.deleteFirst();
            
            if (serieTemp.getContador()<8){
            
                serieTemp.setContador(serieTemp.getContador() + 1);
            
                Administrador.colaNivel2Jose.addLast(serieTemp);
            }
            else{
                serieTemp.setContador(0);
            
                Administrador.colaNivel1Jose.addLast(serieTemp);
            }
            i++;
        }
        
        for(int i = 0; i < sizeColaNivel3Jose; i++){
            
            Serie serieTemp1 = (Serie) (Administrador.colaNivel3Jose.getHead().getData());
            
            Administrador.colaNivel3Jose.deleteFirst();
            
            if (serieTemp1.getContador()<8){
            
                serieTemp1.setContador(serieTemp1.getContador() + 1);
            
                Administrador.colaNivel3Jose.addLast(serieTemp1);
            }
            else{
                serieTemp1.setContador(0);
            
                Administrador.colaNivel2Jose.addLast(serieTemp1);
            }
            i++;
        }
        
        
         for(int i = 0; i < sizeColaNivel2Andy; i++){
            
            Serie serieTemp2 = (Serie) (Administrador.colaNivel2Andy.getHead().getData());
            
            Administrador.colaNivel2Andy.deleteFirst();
            
            if (serieTemp2.getContador()<8){
            
                serieTemp2.setContador(serieTemp2.getContador() + 1);
            
                Administrador.colaNivel2Andy.addLast(serieTemp2);
            }
            else{
                serieTemp2.setContador(0);
            
                Administrador.colaNivel1Andy.addLast(serieTemp2);
            }
            i++;
        }
        
        for(int i = 0; i < sizeColaNivel3Andy; i++){
            
            Serie serieTemp3 = (Serie) (Administrador.colaNivel3Andy.getHead().getData());
            
            Administrador.colaNivel3Andy.deleteFirst();
            
            if (serieTemp3.getContador()<8){
            
                serieTemp3.setContador(serieTemp3.getContador() + 1);
            
                Administrador.colaNivel3Andy.addLast(serieTemp3);
            }
            else{
                serieTemp3.setContador(0);
            
                Administrador.colaNivel2Andy.addLast(serieTemp3);
            }
            i++;
        }
        
        for(int i = 0; i < sizeColaNivel2Useche; i++){
            
            Serie serieTemp4 = (Serie) (Administrador.colaNivel2Useche.getHead().getData());
            
            Administrador.colaNivel2Useche.deleteFirst();
            
            if (serieTemp4.getContador()<8){
            
                serieTemp4.setContador(serieTemp4.getContador() + 1);
            
                Administrador.colaNivel2Useche.addLast(serieTemp4);
            }
            else{
                serieTemp4.setContador(0);
            
                Administrador.colaNivel1Useche.addLast(serieTemp4);
            }
            i++;
        }
        
        for(int i = 0; i < sizeColaNivel3Useche; i++){
            
            Serie serieTemp5 = (Serie) (Administrador.colaNivel3Useche.getHead().getData());
            
            Administrador.colaNivel3Useche.deleteFirst();
            
            if (serieTemp5.getContador()<8){
            
                serieTemp5.setContador(serieTemp5.getContador() + 1);
            
                Administrador.colaNivel3Useche.addLast(serieTemp5);
            }
            else{
                serieTemp5.setContador(0);
            
                Administrador.colaNivel2Useche.addLast(serieTemp5);
            }
            i++;
        }
        
        for(int i = 0; i < sizeColaRefuerzoJose; i++){
            
            Serie serieTemp6 = (Serie) (Administrador.colaRefuerzoJose.getHead().getData());
            
            Administrador.colaRefuerzoJose.deleteFirst();
            
            serieTemp6.setContador(serieTemp6.getContador() + 1);
            
            Administrador.colaRefuerzoJose.addLast(serieTemp6);
            
            i++;
        }
        
        for(int i = 0; i < sizeColaRefuerzoAndy; i++){
            
            Serie serieTemp7 = (Serie) (Administrador.colaRefuerzoAndy.getHead().getData());
            
            Administrador.colaRefuerzoAndy.deleteFirst();
            
            serieTemp7.setContador(serieTemp7.getContador() + 1);
            
            Administrador.colaRefuerzoAndy.addLast(serieTemp7);
            
            i++;
        }
        
        for(int i = 0; i < sizeColaRefuerzoUseche; i++){
            
            Serie serieTemp8 = (Serie) (Administrador.colaRefuerzoUseche.getHead().getData());
            
            Administrador.colaRefuerzoUseche.deleteFirst();
            
            serieTemp8.setContador(serieTemp8.getContador() + 1);
            
            Administrador.colaRefuerzoUseche.addLast(serieTemp8);
            
            i++;
        }
    }
    
    public void SeleccionarSeriesParaCombate(){
        double ProbRefuerzo = Math.random();
        Serie serie1=null;
        if (ProbRefuerzo<0.4){
            serie1 = (Serie) Administrador.colaRefuerzoAndy.getHead().getData();
            Administrador.colaRefuerzoAndy.deleteFirst();
        }
        else{
            if(Administrador.colaNivel1Andy.getHead() != null){
                serie1 = (Serie) Administrador.colaNivel1Andy.getHead().getData();
            }
            else if(Administrador.colaNivel2Andy.getHead() != null){
                serie1 = (Serie) Administrador.colaNivel2Andy.getHead().getData();
            }
            else if(Administrador.colaNivel3Andy.getHead() != null){
                serie1 = (Serie) Administrador.colaNivel3Andy.getHead().getData();
            }
        }
        
        double ProbRefuerzo2 = Math.random();
        Serie serie2=null;
        if (ProbRefuerzo2<0.4){
            serie2 = (Serie) Administrador.colaRefuerzoJose.getHead().getData();
            Administrador.colaRefuerzoJose.deleteFirst();
        }
        else{
            if(Administrador.colaNivel1Jose.getHead() != null){
                serie2 = (Serie) Administrador.colaNivel1Jose.getHead().getData();
            }
            else if(Administrador.colaNivel2Jose.getHead() != null){
                serie2 = (Serie) Administrador.colaNivel2Jose.getHead().getData();
            }
            else if(Administrador.colaNivel3Jose.getHead() != null){
                serie2 = (Serie) Administrador.colaNivel3Jose.getHead().getData();
            }
        }
        
        double ProbRefuerzo3 = Math.random();
        Serie serie3=null;
        if (ProbRefuerzo3<0.4){
            serie3 = (Serie) Administrador.colaRefuerzoUseche.getHead().getData();
            Administrador.colaRefuerzoUseche.deleteFirst();
        }
        else{
            if(Administrador.colaNivel1Useche.getHead() != null){
                serie3 = (Serie) Administrador.colaNivel1Useche.getHead().getData();
            }
            else if(Administrador.colaNivel2Useche.getHead() != null){
                serie3 = (Serie) Administrador.colaNivel2Useche.getHead().getData();
            }
            else if(Administrador.colaNivel3Useche.getHead() != null){
                serie3 = (Serie) Administrador.colaNivel3Useche.getHead().getData();
            }
        }
        
    }
    
}
