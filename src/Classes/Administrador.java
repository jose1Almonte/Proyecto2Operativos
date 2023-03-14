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
                Administrador.colaNivel1Jose.addLast(serieJose,0);
                break;
            case 2:
                Administrador.colaNivel2Jose.addLast(serieJose,0);
                break;
            default:
                Administrador.colaNivel3Jose.addLast(serieJose,0);
                break;
        }
        
        int nivelAndy = serieAndy.getNivelPrioridad();
        
        switch (nivelAndy){
            case 1:
                Administrador.colaNivel1Andy.addLast(serieAndy,0);
                break;
            case 2:
                Administrador.colaNivel2Andy.addLast(serieAndy,0);
                break;
            default:
                Administrador.colaNivel3Andy.addLast(serieAndy,0);
                break;
        }
        
        int nivelUseche = serieUseche.getNivelPrioridad();
        
        switch (nivelUseche) {
            case 1:
                Administrador.colaNivel1Useche.addLast(serieUseche,0);
                break;
            case 2:
                Administrador.colaNivel2Useche.addLast(serieUseche,0);
                break;
            default:
                Administrador.colaNivel3Useche.addLast(serieUseche,0);
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
        Administrador.colaRefuerzoJose.addLast(serieJose,0);
        Administrador.colaRefuerzoAndy.addLast(serieAndy,0);
        Administrador.colaRefuerzoUseche.addLast(serieUseche,0);
    }
    
    /**
     * Suma 1 al contador individual de cada serie de las listas resaltadas al inicio del metodo
     */
    public void sumar1ContadorSeries(){
        
        
        
        //int sizeColaNivel2Jose = Administrador.colaNivel2Jose.size();
        //int sizeColaNivel3Jose = Administrador.colaNivel3Jose.size();
        //int sizeColaRefuerzoJose = Administrador.colaRefuerzoJose.size();
        
        //int sizeColaNivel2Andy = Administrador.colaNivel2Andy.size();
        //int sizeColaNivel3Andy = Administrador.colaNivel3Andy.size();
        //int sizeColaRefuerzoAndy = Administrador.colaRefuerzoAndy.size();
        
        //int sizeColaNivel2Useche = Administrador.colaNivel2Useche.size();
        //int sizeColaNivel3Useche = Administrador.colaNivel3Useche.size();
        //int sizeColaRefuerzoUseche = Administrador.colaRefuerzoUseche.size();
        //
        //for(int i = 0; i < sizeColaNivel2Jose; i++){
            
        //    Serie serieTemp = (Serie) (Administrador.colaNivel2Jose.getHead().getData());
            
        //    Administrador.colaNivel2Jose.deleteFirst();
            
        //    if(serieTemp.getContador() == 7){
        //        serieTemp.setContador(0);
        //        serieTemp.setNivelPrioridad(1);
                
        //        Administrador.colaNivel1Jose.addLast(serieTemp);
        //    }else{                
        //        serieTemp.setContador(serieTemp.getContador() + 1);

        //        Administrador.colaNivel2Jose.addLast(serieTemp);
        //    }
            
            
        //    i++;
        //}
        
        //TERMINAR LO DEMÁS
        
        
        
    }
    
    public void actualizarSerieAndy2(){
        LinkedList serieAuxiliar = new LinkedList();
        while(true){
            LinkedList listaConDatos = colaNivel2Andy.deleteFirst();
            if(listaConDatos ==null){
                break;
            }
            int count=listaConDatos.getCounter1();
            if (count <8){
                count =count++;
                serieAuxiliar.addLast(listaConDatos.getData1(), count);
            }
            else{
                count =0;
                colaNivel1Andy.addLast(listaConDatos.getData1(), count);
            }
        }
        colaNivel2Andy = serieAuxiliar;
    }
    
    public void actualizarSerieAndy3(){
        LinkedList serieAuxiliar = new LinkedList();
        while(true){
            LinkedList listaConDatos = colaNivel3Andy.deleteFirst();
            if(listaConDatos ==null){
                break;
            }
            int count=listaConDatos.getCounter1();
            if (count <8){
                count =count++;
                serieAuxiliar.addLast(listaConDatos.getData1(), count);
            }
            else{
                count =0;
                colaNivel2Andy.addLast(listaConDatos.getData1(), count);
            }
        }
        colaNivel3Andy = serieAuxiliar;
    }
    
    public void actualizarSerieJose2(){
        LinkedList serieAuxiliar = new LinkedList();
        while(true){
            LinkedList listaConDatos = colaNivel2Jose.deleteFirst();
            if(listaConDatos ==null){
                break;
            }
            int count=listaConDatos.getCounter1();
            if (count <8){
                count =count++;
                serieAuxiliar.addLast(listaConDatos.getData1(), count);
            }
            else{
                count =0;
                colaNivel1Jose.addLast(listaConDatos.getData1(), count);
            }
        }
        colaNivel2Jose = serieAuxiliar;
    }
    
     public void actualizarSerieJose3(){
        LinkedList serieAuxiliar = new LinkedList();
        while(true){
            LinkedList listaConDatos = colaNivel3Jose.deleteFirst();
            if(listaConDatos ==null){
                break;
            }
            int count=listaConDatos.getCounter1();
            if (count <8){
                count =count++;
                serieAuxiliar.addLast(listaConDatos.getData1(), count);
            }
            else{
                count =0;
                colaNivel2Jose.addLast(listaConDatos.getData1(), count);
            }
        }
        colaNivel3Jose = serieAuxiliar;
    }
    
    public void actualizarSerieUseche2(){
        LinkedList serieAuxiliar = new LinkedList();
        while(true){
            LinkedList listaConDatos = colaNivel2Useche.deleteFirst();
            if(listaConDatos ==null){
                break;
            }
            int count=listaConDatos.getCounter1();
            if (count <8){
                count =count++;
                serieAuxiliar.addLast(listaConDatos.getData1(), count);
            }
            else{
                count =0;
                colaNivel1Useche.addLast(listaConDatos.getData1(), count);
            }
        }
        colaNivel2Useche = serieAuxiliar;
    }
    
    public void actualizarSerieUseche3(){
        LinkedList serieAuxiliar = new LinkedList();
        while(true){
            LinkedList listaConDatos = colaNivel3Useche.deleteFirst();
            if(listaConDatos ==null){
                break;
            }
            int count=listaConDatos.getCounter1();
            if (count <8){
                count =count++;
                serieAuxiliar.addLast(listaConDatos.getData1(), count);
            }
            else{
                count =0;
                colaNivel2Useche.addLast(listaConDatos.getData1(), count);
            }
        }
        colaNivel3Useche = serieAuxiliar;
    }
    
}
