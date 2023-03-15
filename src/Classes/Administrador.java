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
            
            this.establecerPrioridad(serieJose, serieAndy, serieUseche);
            
            
            System.out.println( "Prioridad: " + serieJose.getNivelPrioridad() + ". Duración: " + serieJose.getDuracionMinutos());
            
            
            
            
        }
    }
    
    /**
     * Determina cual debería ser la prioridad de la serie que se le pase , duracion, puntosPoder
     * @param serieNombreRodaje
     */
    public void establecerPrioridad(Serie serieJose, Serie serieAndy, Serie serieUseche){
        
//        The Last of Us (Jose)
        double introProb = Math.random();
        double inicio1Prob = Math.random();
        double inicio2Prob = Math.random();
        double cierre1Prob = Math.random();
        double cierre2Prob = Math.random();
        double creditoProb = Math.random();
        double peleaProb1 = Math.random();
        double peleaProb2 = Math.random();
        double peleaProb3 = Math.random();
        
        int intro = 0;
        int inicio1 = 0;
        int inicio2 = 0;
        int cierre1 = 0;
        int cierre2 = 0;
        int credito = 0;
        
        if(introProb <= 0.75){
            intro = 1;
        }else{
            intro = 0;
        }
        
        if(inicio1Prob <= 0.84){
            inicio1 = 1;
        }else{
            inicio1 = 0;
        }
        
        if(inicio2Prob <= 0.84){
            inicio2 = 1;
        }else{
            inicio2 = 0;
        }
        
        if(cierre1Prob <= 0.80){
            cierre1 = 1;
        }else{
            cierre1 = 0;
        }
        
        if(cierre2Prob <= 0.80){
            cierre2 = 1;
        }else{
            cierre2 = 0;
        }
        
        if(creditoProb <= 0.85){
            credito = 1;
        }else{
            credito = 0;
        }
        
        int total = intro + inicio1 + inicio2 + cierre1 + cierre2 + credito;
        
        if(total >= 5){
            serieJose.setNivelPrioridad(1);
            serieJose.setNivelPrioridadInicio(1);
            serieJose.setDuracionMinutos( (int) (Math.random()*90 + 90));
            serieJose.setPuntosPoder((int) (peleaProb3*2+5));
        }else if(total >= 3){
            serieJose.setNivelPrioridad(2);
            serieJose.setNivelPrioridadInicio(2);
            serieJose.setDuracionMinutos( (int) (Math.random()*30 + 60));
            serieJose.setPuntosPoder((int) (peleaProb3*2+3));
            
        }else{
            serieJose.setNivelPrioridad(3);
            serieJose.setNivelPrioridadInicio(3);
            serieJose.setDuracionMinutos( (int) (Math.random()*60));
            serieJose.setPuntosPoder((int) (peleaProb3*2+1));
            
        }
        
        
        // VELMA (Andy)
        
        double intro1ProbAndy = Math.random();
        double intro2ProbAndy = Math.random();
        double inicioProbAndy = Math.random();
        double cierreProbAndy = Math.random();
        double credito1ProbAndy = Math.random();
        double credito2ProbAndy = Math.random();
        
        int intro1Andy = 0;
        int intro2Andy = 0;
        int inicioAndy = 0;
        int cierreAndy = 0;
        int credito1Andy = 0;
        int credito2Andy = 0;
        
        if(intro1ProbAndy < 0.75){
            intro1Andy = 1;
        }else{
            intro1Andy = 0;            
        }
        
        if(intro2ProbAndy < 0.75){
            intro2Andy = 1;
        }else{
            intro2Andy = 0;            
        }
        
        if(inicioProbAndy < 0.75){
            inicioAndy = 1;
        }else{
            inicioAndy = 0;            
        }
        
        if(cierreProbAndy < 0.75){
            cierreAndy = 1;
        }else{
            cierreAndy = 0;            
        }
        
        if(credito1ProbAndy < 0.75){
            credito1Andy = 1;
        }else{
            credito1Andy = 0;            
        }
        
        if(credito2ProbAndy < 0.75){
            credito2Andy = 1;
        }else{
            credito2Andy = 0;            
        }
        
        total = intro1Andy + intro2Andy + inicioAndy + cierreAndy + credito1Andy + credito2Andy;
        
        if(total >= 5){
            serieAndy.setNivelPrioridad(1);
            serieAndy.setNivelPrioridadInicio(1);
            serieAndy.setPuntosPoder((int) (peleaProb1*2+5));
            serieAndy.setDuracionMinutos( (int) (Math.random()*90 + 90));
        }else if(total >= 3){
            serieAndy.setNivelPrioridad(2);
            serieAndy.setNivelPrioridadInicio(2);
            serieAndy.setPuntosPoder((int) (peleaProb1*2+3));
            serieAndy.setDuracionMinutos( (int) (Math.random()*30 + 60));
        }else{
            serieAndy.setNivelPrioridad(3);
            serieAndy.setNivelPrioridadInicio(3);
            serieAndy.setPuntosPoder((int) (peleaProb1*2+1));
            serieAndy.setDuracionMinutos( (int) (Math.random()*60 ));
            
        }
        
//        Game of Thrones (Useche)
        double introProbUseche = Math.random();
        double inicioProbUseche = Math.random(); 
        double cierre1ProbUseche = Math.random();
        double cierre2ProbUseche = Math.random();
        double creditoProbUseche = Math.random();
        
        int introUseche = 0;
        int inicioUseche = 0;
        int cierre1Useche = 0;
        int cierre2Useche = 0;
        int creditoUseche = 0;
        
        if(introProbUseche <= 0.75){
            introUseche = 1;
        }else{
            introUseche = 0;
            
        }
        
        if(inicioProbUseche <= 0.84){
            inicioUseche = 1;
        }else{
            inicioUseche = 0;
            
        }
        
        if(cierre1ProbUseche <= 0.80){
            cierre1Useche = 1;
        }else{
            cierre1Useche = 0;
        }
        
        if(cierre2ProbUseche <= 0.80){
            cierre2Useche = 1;
        }else{
            cierre2Useche = 0;
        }
        
        if(creditoProbUseche <= 0.85){
            creditoUseche = 1;
        }else{
            creditoUseche = 0;
        }
        
        total = introUseche + inicioUseche + cierre1Useche + cierre2Useche + creditoUseche;
        
        if(total == 5){
            serieUseche.setNivelPrioridad(1);
            serieUseche.setNivelPrioridadInicio(1);
            serieUseche.setPuntosPoder((int) (peleaProb2*2+5));
            serieUseche.setDuracionMinutos( (int) (Math.random()*90 + 90));
        }else if(total >= 3){
            serieUseche.setNivelPrioridad(2);
            serieUseche.setNivelPrioridadInicio(2);
            serieUseche.setPuntosPoder((int) (peleaProb2*2+3));
            serieUseche.setDuracionMinutos( (int) (Math.random()*30 + 60));
        }else{
            serieUseche.setNivelPrioridad(3);
            serieUseche.setNivelPrioridadInicio(3);
            serieUseche.setPuntosPoder((int) (peleaProb2*2+1));
            serieUseche.setDuracionMinutos( (int) (Math.random()*60));
            
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
            
            if (serieTemp.getContador()<7){
                serieTemp.setContador(serieTemp.getContador() + 1);

                Administrador.colaNivel2Jose.addLast(serieTemp);
            }
            else{
                serieTemp.setContador(0);
            
                Administrador.colaNivel1Jose.addLast(serieTemp);
            }
        }
        
        for(int i = 0; i < sizeColaNivel3Jose; i++){
            
            Serie serieTemp1 = (Serie) (Administrador.colaNivel3Jose.getHead().getData());
            
            Administrador.colaNivel3Jose.deleteFirst();
            
            if (serieTemp1.getContador()<7){
            
                serieTemp1.setContador(serieTemp1.getContador() + 1);
            
                Administrador.colaNivel3Jose.addLast(serieTemp1);
            }
            else{
                serieTemp1.setContador(0);
            
                Administrador.colaNivel2Jose.addLast(serieTemp1);
            }
        }
        
        
         for(int i = 0; i < sizeColaNivel2Andy; i++){
            
            Serie serieTemp2 = (Serie) (Administrador.colaNivel2Andy.getHead().getData());
            
            Administrador.colaNivel2Andy.deleteFirst();
            
            if (serieTemp2.getContador()<7){
            
                serieTemp2.setContador(serieTemp2.getContador() + 1);
            
                Administrador.colaNivel2Andy.addLast(serieTemp2);
            }
            else{
                serieTemp2.setContador(0);
            
                Administrador.colaNivel1Andy.addLast(serieTemp2);
            }
        }
        
        for(int i = 0; i < sizeColaNivel3Andy; i++){
            
            Serie serieTemp3 = (Serie) (Administrador.colaNivel3Andy.getHead().getData());
            
            Administrador.colaNivel3Andy.deleteFirst();
            
            if (serieTemp3.getContador()<7){
            
                serieTemp3.setContador(serieTemp3.getContador() + 1);
            
                Administrador.colaNivel3Andy.addLast(serieTemp3);
            }
            else{
                serieTemp3.setContador(0);
            
                Administrador.colaNivel2Andy.addLast(serieTemp3);
            }
        }
        
        for(int i = 0; i < sizeColaNivel2Useche; i++){
            
            Serie serieTemp4 = (Serie) (Administrador.colaNivel2Useche.getHead().getData());
            
            Administrador.colaNivel2Useche.deleteFirst();
            
            if (serieTemp4.getContador()<7){
            
                serieTemp4.setContador(serieTemp4.getContador() + 1);
            
                Administrador.colaNivel2Useche.addLast(serieTemp4);
            }
            else{
                serieTemp4.setContador(0);
            
                Administrador.colaNivel1Useche.addLast(serieTemp4);
            }
        }
        
        for(int i = 0; i < sizeColaNivel3Useche; i++){
            
            Serie serieTemp5 = (Serie) (Administrador.colaNivel3Useche.getHead().getData());
            
            Administrador.colaNivel3Useche.deleteFirst();
            
            if (serieTemp5.getContador()<7){
            
                serieTemp5.setContador(serieTemp5.getContador() + 1);
            
                Administrador.colaNivel3Useche.addLast(serieTemp5);
            }
            else{
                serieTemp5.setContador(0);
            
                Administrador.colaNivel2Useche.addLast(serieTemp5);
            }
        }
        
        for(int i = 0; i < sizeColaRefuerzoAndy; i++){
            
            Serie serieTemp7 = (Serie) (Administrador.colaRefuerzoAndy.getHead().getData());
            
            Administrador.colaRefuerzoAndy.deleteFirst();
            
            if(serieTemp7.getContador() < 7){
                
                serieTemp7.setContador(serieTemp7.getContador() + 1);
                
            }else{
                
                if(serieTemp7.getNivelPrioridad() == 2){
                    serieTemp7.setNivelPrioridad(1);
                }else if(serieTemp7.getNivelPrioridad() == 3){
                    serieTemp7.setNivelPrioridad(2);
                    
                }
                
                serieTemp7.setContador(0);
            }
            
            
            Administrador.colaRefuerzoAndy.addLast(serieTemp7);
            
        }
        
        for(int i = 0; i < sizeColaRefuerzoJose; i++){
            
            Serie serieTemp8 = (Serie) (Administrador.colaRefuerzoJose.getHead().getData());
            
            Administrador.colaRefuerzoJose.deleteFirst();
            
            if(serieTemp8.getContador() < 7){
                
                serieTemp8.setContador(serieTemp8.getContador() + 1);
                
            }else{
                
                if(serieTemp8.getNivelPrioridad() == 2){
                    serieTemp8.setNivelPrioridad(1);
                }else if(serieTemp8.getNivelPrioridad() == 3){
                    serieTemp8.setNivelPrioridad(2);
                    
                }
                
                serieTemp8.setContador(0);
            }
            
            
            Administrador.colaRefuerzoJose.addLast(serieTemp8);
            
        }
        
        
        for(int i = 0; i < sizeColaRefuerzoUseche; i++){
            
            Serie serieTemp9 = (Serie) (Administrador.colaRefuerzoUseche.getHead().getData());
            
            Administrador.colaRefuerzoUseche.deleteFirst();
            
            if(serieTemp9.getContador() < 7){
                
                serieTemp9.setContador(serieTemp9.getContador() + 1);
                
            }else{
                
                if(serieTemp9.getNivelPrioridad() == 2){
                    serieTemp9.setNivelPrioridad(1);
                }else if(serieTemp9.getNivelPrioridad() == 3){
                    serieTemp9.setNivelPrioridad(2);
                    
                }
                
                serieTemp9.setContador(0);
            }
            
            
            Administrador.colaRefuerzoUseche.addLast(serieTemp9);
            
        }
        
        
    }
    
    /**
     * Saca serie de la cabeza de la cola de refuerzo y se pone en su cola correspondiente
     */
    public void sacarCabezaRefuerzo(){
        double probRefuerzoJose = Math.random();
        double probRefuerzoAndy = Math.random();
        double probRefuerzoUseche = Math.random();
        
        if (probRefuerzoJose <= 0.40){
            Serie serieJose = (Serie) Administrador.colaRefuerzoJose.getHead().getData();
            Administrador.colaRefuerzoJose.deleteFirst();
            
            serieJose.setPuntosPoder(serieJose.getPuntosPoder() + 1);
            
            if(serieJose.getNivelPrioridad() == 1){
                Administrador.colaNivel1Jose.addLast(serieJose);
            }else if(serieJose.getNivelPrioridad() == 2){
                Administrador.colaNivel2Jose.addLast(serieJose);                
            }else{
                Administrador.colaNivel3Jose.addLast(serieJose);                
            }
        }
        
        if (probRefuerzoAndy <= 0.40){
            Serie serieAndy = (Serie) Administrador.colaRefuerzoAndy.getHead().getData();
            Administrador.colaRefuerzoAndy.deleteFirst();
            
            serieAndy.setPuntosPoder(serieAndy.getPuntosPoder() + 1);
            
            if(serieAndy.getNivelPrioridad() == 1){
                Administrador.colaNivel1Andy.addLast(serieAndy);
            }else if(serieAndy.getNivelPrioridad() == 2){
                Administrador.colaNivel2Andy.addLast(serieAndy);                
            }else{
                Administrador.colaNivel3Andy.addLast(serieAndy);                
            }
        }
        
        if (probRefuerzoUseche <= 0.40){
            Serie serieUseche = (Serie) Administrador.colaRefuerzoUseche.getHead().getData();
            Administrador.colaRefuerzoUseche.deleteFirst();
            
            serieUseche.setPuntosPoder(serieUseche.getPuntosPoder() + 1);
            
            if(serieUseche.getNivelPrioridad() == 1){
                Administrador.colaNivel1Useche.addLast(serieUseche);
            }else if(serieUseche.getNivelPrioridad() == 2){
                Administrador.colaNivel2Useche.addLast(serieUseche);                
            }else{
                Administrador.colaNivel3Useche.addLast(serieUseche);
            }
        }
        
    }
    
}
