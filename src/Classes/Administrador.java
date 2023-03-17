/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Proyecto2Operativos.Proyectos2Operativos;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Hallo
 */
public class Administrador extends Thread{
    
    private volatile boolean keep = true;
    private int ciclo;
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
    
    javax.swing.JTextField colaNivel1JoseTextField;
    
    public Administrador(){
        
    }
    
    public Administrador(javax.swing.JTextField colaNivel1JoseTextField){
        this.colaNivel1JoseTextField = colaNivel1JoseTextField;
    }
    
    @Override
    public void run(){
        
        
        while(isKeep()){
                   
            try{
                Thread.sleep(ciclo*1000);
                
                if(variablesGenerales.numeroCiclos==2){
                    Serie serieJose = new Serie();
                    Serie serieAndy = new Serie();
                    Serie serieUseche = new Serie();

                    this.establecerPrioridad(serieJose, serieAndy, serieUseche);
                    this.asignarId(serieJose, serieAndy, serieUseche);
                    this.encolarSerie(serieJose, serieAndy, serieUseche);
                    
                    System.out.print(serieJose.getId()+" "+serieAndy.getId()+" "+ serieUseche.getId());
                    variablesGenerales.numeroCiclos=0;
                }
                
                
    //            Series que van a la IA
                Serie serieJoseProcesador = this.CampeonJose();
                Serie serieAndyProcesador = this.CampeonAndy();
                Serie serieUsecheProcesador = this.CampeonUseche();

                this.seriesALaIA(serieJoseProcesador, serieAndyProcesador, serieUsecheProcesador);
                
                this.imprimirCola(Administrador.colaNivel1Jose, this.colaNivel1JoseTextField);
                
                variablesGenerales.numeroCiclos=variablesGenerales.numeroCiclos+1;
                
                
                
            }catch(Exception e){
                System.out.println(e);
            }    
            
            
            
        }
    }
    
    
    /**
     * Envía las series a enfrentar a la IA <=> todos los rodajes pueden aportar una serie, de caso contrario, pone de primeras a las series que no son nulas a esperar hasta que pueda haber un enfrentamiento 
     * @param serieJoseProcesador
     * @param serieAndyProcesador
     * @param serieUsecheProcesador 
     */
    public void seriesALaIA(Serie serieJoseProcesador, Serie serieAndyProcesador, Serie serieUsecheProcesador){
        
        try{
            
            if( serieJoseProcesador == null || serieAndyProcesador == null || serieUsecheProcesador == null){

               if(serieJoseProcesador != null){
                          serieJoseProcesador.setNivelPrioridad(1);
                          colaNivel1Jose.addFirst(serieJoseProcesador);
               }

               if(serieAndyProcesador != null){
                          serieAndyProcesador.setNivelPrioridad(1);
                          Administrador.colaNivel1Andy.addFirst(serieAndyProcesador);
               }


               if(serieUsecheProcesador != null){
                          serieUsecheProcesador.setNivelPrioridad(1);
                          Administrador.colaNivel1Useche.addFirst(serieUsecheProcesador);
               }          
            }else{
                       Procesador IA = new Procesador(serieJoseProcesador, serieAndyProcesador, serieUsecheProcesador);
                       IA.start();

                       variablesGenerales.darPasoAdmin.acquire(1);


            }
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    /**
     * Saca la cabeza de la cola NO VACIA respetando las colas de prioridad
     * @return Serie
     */    
    public Serie CampeonJose(){
               
               Serie CampeonJose;
           if(colaNivel1Jose.isEmpty()){
                       if(colaNivel2Jose.isEmpty()){
                                  if(colaNivel3Jose.isEmpty()){
                                             return CampeonJose = null;
                                  }else{
                                            CampeonJose = (Serie) (Administrador.colaNivel3Jose.getHead().getData());
                                            colaNivel1Jose.deleteFirst();
                                            return CampeonJose;
                                  }                   
                       }else{
                                CampeonJose = (Serie) (Administrador.colaNivel2Jose.getHead().getData());
                                 colaNivel1Jose.deleteFirst();  
                                 return CampeonJose;
                       }
            }else{
                       CampeonJose = (Serie) (Administrador.colaNivel1Jose.getHead().getData());
                       colaNivel1Jose.deleteFirst();
                       return CampeonJose;
            }
    }
    
    /**
     * Saca la cabeza de la cola NO VACIA respetando las colas de prioridad
     * @return Serie
     */
    public Serie CampeonAndy(){
               Serie CampeonAndy;
               if(colaNivel1Andy.isEmpty()){
                       if(colaNivel2Andy.isEmpty()){
                                  if(colaNivel3Andy.isEmpty()){
                                             return CampeonAndy = null;
                                  }else{
                                            CampeonAndy = (Serie) (Administrador.colaNivel3Andy.getHead().getData());
                                            colaNivel1Andy.deleteFirst();
                                            return CampeonAndy;
                                  }                   
                       }else{
                                 CampeonAndy = (Serie) (Administrador.colaNivel2Andy.getHead().getData());
                                 colaNivel1Andy.deleteFirst();  
                                 return CampeonAndy;
                       }
            }else{
                       CampeonAndy = (Serie) (Administrador.colaNivel1Andy.getHead().getData());
                       colaNivel1Andy.deleteFirst();
                       return CampeonAndy;
            }
    }
    
    /**
     * Saca la cabeza de la cola NO VACIA respetando las colas de prioridad
     * @return Serie
     */
    public Serie CampeonUseche(){
               Serie CampeonUseche;
               if(colaNivel1Useche.isEmpty()){
                       if(colaNivel2Useche.isEmpty()){
                                  if(colaNivel3Useche.isEmpty()){
                                            return CampeonUseche = null;
                                  }else{
                                            CampeonUseche = (Serie) (Administrador.colaNivel3Useche.getHead().getData());
                                            colaNivel1Useche.deleteFirst();
                                            return CampeonUseche;
                                  }                   
                       }else{
                                 CampeonUseche = (Serie) (Administrador.colaNivel2Useche.getHead().getData());
                                 colaNivel1Useche.deleteFirst();
                                 return CampeonUseche;
                       }
            }else{
                       CampeonUseche = (Serie) (Administrador.colaNivel1Useche.getHead().getData());
                       colaNivel1Useche.deleteFirst();
                       return CampeonUseche;
            }
        }
    
    
    /**
     * Determina cual debería ser la prioridad de la serie que se le pase. Setea tambien: prioridad inicio, duracion, puntos de poder y nro rodaje
     * @param serieJose
     * @param serieAndy
     * @param serieUseche
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
        
        serieJose.setRodajePertenece(1);
        
        
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
        
        serieAndy.setRodajePertenece(2);
        
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
        
        serieUseche.setRodajePertenece(3);
    }
    
    /**
     * Encola las series en su respectivo rodaje en su respectiva cola de prioridad
     * @param serieJose
     * @param serieAndy
     * @param serieUseche
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
//        int sizeColaRefuerzoJose = Administrador.colaRefuerzoJose.size();
        
        int sizeColaNivel2Andy = Administrador.colaNivel2Andy.size();
        int sizeColaNivel3Andy = Administrador.colaNivel3Andy.size();
//        int sizeColaRefuerzoAndy = Administrador.colaRefuerzoAndy.size();
        
        int sizeColaNivel2Useche = Administrador.colaNivel2Useche.size();
        int sizeColaNivel3Useche = Administrador.colaNivel3Useche.size();
//        int sizeColaRefuerzoUseche = Administrador.colaRefuerzoUseche.size();
        
        for(int i = 0; i < sizeColaNivel2Jose; i++){
            
            Serie serieTemp = (Serie) (Administrador.colaNivel2Jose.getHead().getData());
            
            Administrador.colaNivel2Jose.deleteFirst();
            
            if (serieTemp.getContador()<7){
                serieTemp.setContador(serieTemp.getContador() + 1);

                Administrador.colaNivel2Jose.addLast(serieTemp);
            }
            else{
                serieTemp.setContador(0);
                serieTemp.setNivelPrioridad(1);
            
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
                serieTemp1.setNivelPrioridad(2);
            
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
                serieTemp2.setNivelPrioridad(1);
            
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
                serieTemp3.setNivelPrioridad(2);
            
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
                serieTemp4.setNivelPrioridad(1);
            
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
                serieTemp5.setNivelPrioridad(2);
            
                Administrador.colaNivel2Useche.addLast(serieTemp5);
            }
        }
        
    }
    
    /**
     * Saca serie de la cabeza de la cola de refuerzo y se pone en su cola correspondiente (Ya tiene la probabilidad incluida)
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
    
    /**
     * Recibe una cola que se le pase y la imprime sobre un jtextfield que se le pase
     * @param colaCualquiera
     * @param textField
     * @return 
     */
    public void imprimirCola(LinkedList colaCualquiera, javax.swing.JTextField textField){
        
        int sizeCola = colaCualquiera.size();
        Serie arrayTemp[] = new Serie[sizeCola];
        
        for (int i = 0; i < sizeCola; i++){
            
            Serie serieTemp = (Serie) (colaCualquiera.getHead().getData());
            
            colaCualquiera.deleteFirst();
            
            arrayTemp[i] = serieTemp;
            
            colaCualquiera.addLast(serieTemp);
            
        }
        
        textField.setText("");
        
        for (int i = 0; i < sizeCola; i++){
            textField.setText(textField.getText() + " (" + arrayTemp[i].getRodajePertenece() + ", rodaje: " + arrayTemp[i].getContador() + ", ptos poder: "  + arrayTemp[i].getPuntosPoder() + " ), " );
        }
    }

    /**
     * @param ciclo the ciclo to set
     */
    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }
    
    public void asignarId(Serie serieJose, Serie serieAndy, Serie serieUseche){
            
            variablesGenerales f = new variablesGenerales();
            int counter;
            int ev;
            try{
                ev=f.leerJson();
            }
            catch(Exception e){
                ev=-1;
            }
            
            if(ev==-1){
                counter = 0;
            }
            else{
                counter = ev;
            }
            counter =counter +1;
            serieJose.setId(counter);
            counter =counter +1;
            serieAndy.setId(counter);
            counter =counter +1;
            serieUseche.setId(counter);
            f.guardarJson(counter);
            
            
            
    }

    /**
     * @return the keep
     */
    public boolean isKeep() {
        return keep;
    }

    /**
     * @param keep the keep to set
     */
    public void setKeep(boolean keep) {
        this.keep = keep;
    }
}
