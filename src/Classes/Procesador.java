/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

/**
 *
 * @author Hallo
 */
public class Procesador extends Thread{
    Serie serieJose;
    Serie serieAndy;
    Serie serieUseche;
    private javax.swing.JLabel camp1;
    private javax.swing.JLabel camp2;
    private javax.swing.JLabel camp3;
    private javax.swing.JLabel winner;
    private javax.swing.JLabel central;
    private javax.swing.JLabel LOU;
    private javax.swing.JLabel VELMA;
    private javax.swing.JLabel OTRO;
    Clip clip4;
    
    javax.swing.JLabel serieJoseCombatiendo;
    javax.swing.JLabel serieAndyCombatiendo;
    javax.swing.JLabel serieUsecheCombatiendo;
    javax.swing.JLabel serieGanadoraText;
    javax.swing.JLabel lucha1;
    javax.swing.JLabel lucha2;
    javax.swing.JLabel lucha3;
    javax.swing.JLabel vida1;
    javax.swing.JLabel vida2;
    javax.swing.JLabel vida3;
    javax.swing.JLabel Accion_1;
    javax.swing.JLabel Accion_2;
    javax.swing.JLabel Accion_3;
    javax.swing.JLabel DocumentacionIAJLabel;
    
    variablesGenerales var=new variablesGenerales();
            
    
    public Procesador(Serie serieJose,
            Serie serieAndy, 
            Serie serieUseche,
            javax.swing.JLabel camp1, 
            javax.swing.JLabel camp2, 
            javax.swing.JLabel camp3, 
            javax.swing.JLabel winner,
            javax.swing.JLabel central,
            javax.swing.JLabel LOU,
            javax.swing.JLabel VELMA,
            javax.swing.JLabel OTRO,
            javax.swing.JLabel serieJoseCombatiendo, 
            javax.swing.JLabel serieAndyCombatiendo, 
            javax.swing.JLabel serieUsecheCombatiendo, 
            javax.swing.JLabel serieGanadoraText,Clip clip4,
            javax.swing.JLabel lucha1,
            javax.swing.JLabel lucha2, javax.swing.JLabel lucha3,
            javax.swing.JLabel vida1, javax.swing.JLabel vida2, javax.swing.JLabel vida3,
            javax.swing.JLabel Accion_1,javax.swing.JLabel Accion_2,javax.swing.JLabel Accion_3,
            javax.swing.JLabel DocumentacionIAJLabel
    ){
        this.serieJose = serieJose;
        this.serieAndy = serieAndy;
        this.serieUseche = serieUseche;
        this.camp1=camp1;
        this.camp2=camp2;
        this.camp3=camp3;
        this.winner=winner;
        this.central=central;
        this.LOU=LOU;
        this.VELMA=VELMA;
        this.OTRO=OTRO;
        this.serieJoseCombatiendo = serieJoseCombatiendo;
        this.serieAndyCombatiendo = serieAndyCombatiendo;
        this.serieUsecheCombatiendo = serieUsecheCombatiendo;
        this.serieGanadoraText = serieGanadoraText;
        this.clip4=clip4;
        this.Accion_1 = Accion_1;
        this.Accion_2 = Accion_2;
        this.Accion_3 = Accion_3;
        this.vida1=vida1;
        this.vida2=vida2;
        this.vida3=vida3;
        this.lucha1=lucha1;
        this.lucha2=lucha2;
        this.lucha3=lucha3;
        this.DocumentacionIAJLabel = DocumentacionIAJLabel;
    }
    
    @Override
    public void run(){
        
        this.DocumentacionIAJLabel.setText("IA ESTA: ANALIZANDO");
        
        try{
             while(Administrador.keep){    
                
                File audio = new File("src\\Archivos\\1.wav");
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audio);
                Clip clip = AudioSystem.getClip();
                
                File audio2 = new File("src\\Archivos\\3.wav");
                AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(audio2);
                Clip clip2 = AudioSystem.getClip();
                
                File audio3 = new File("src\\Archivos\\w.wav");
                AudioInputStream audioStream3 = AudioSystem.getAudioInputStream(audio3);
                Clip clip3 = AudioSystem.getClip();
                
                
             try {
                    clip.open(audioStream);
                    clip2.open(audioStream2);
                    clip3.open(audioStream3);
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
                }
                
             
                this.serieJoseCombatiendo.setText("( " + this.serieJose.getId() + ", TLOU, prioInic: " + this.serieJose.getNivelPrioridadInicio() + " )");
                this.serieAndyCombatiendo.setText("( " + this.serieAndy.getId() + ", VELMA, prioInic: " + this.serieAndy.getNivelPrioridadInicio() + " )");
                this.serieUsecheCombatiendo.setText("( " + this.serieUseche.getId() + ", GOT, prioInic: " + this.serieUseche.getNivelPrioridadInicio() + " )");
                this.probabilidadesBatalla( clip,clip2,clip3);
                
                break;
            }
             
        }catch(Exception e){
        }
        
        variablesGenerales.darPasoAdmin.release();
    }
    
    /**
     * Selecciona GIFS de cada Rodaje, y utiliza un metodo auxiliar para determinar si se gana, empata o pierde
     * @throws IOException
     * @throws InterruptedException 
     */
    public void probabilidadesBatalla(Clip clip,Clip clip2,Clip clip3) throws IOException, InterruptedException, LineUnavailableException, UnsupportedAudioFileException{
        
        ImageIcon luchas = new ImageIcon(getClass().getResource("/Imagenes/espada.png"));
        ImageIcon vidas = new ImageIcon(getClass().getResource("/Imagenes/vidas.png"));
        
        
        this.lucha1.setIcon(luchas);
        this.vida1.setIcon(vidas);
        this.lucha2.setIcon(luchas);
        this.vida2.setIcon(vidas);
        this.lucha3.setIcon(luchas);
        this.vida3.setIcon(vidas);
        this.vida1.setText(String.valueOf(this.serieJose.getVida()));
        this.vida2.setText(String.valueOf(this.serieAndy.getVida()));
        this.vida3.setText(String.valueOf(this.serieUseche.getVida()));
        this.lucha1.setText(String.valueOf( this.serieJose.getPuntosPoder()));
        this.lucha2.setText(String.valueOf(this.serieAndy.getPuntosPoder()));
        this.lucha3.setText(String.valueOf(this.serieUseche.getPuntosPoder()));
       
        double probcampeon1 = Math.random();
            double probcampeon2 = Math.random();
            double probcampeon3 = Math.random();
            
            this.winner.setIcon(null);
            int x1=0;
            int x2=0;
            int x3=0;
            this.central.setText("");
            
            if(probcampeon1<=0.5){
                ImageIcon gift = new ImageIcon(getClass().getResource("/Imagenes/2.gif"));
                this.camp1.setIcon(gift);
                this.camp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                
                x1=1;
                
            }
            else{
                ImageIcon gift = new ImageIcon(getClass().getResource("/Imagenes/3.gif"));
                this.camp1.setIcon(gift);
                this.camp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                
                x1=2;
            }
            
            if(probcampeon2<=0.5){
                ImageIcon gift2 = new ImageIcon(getClass().getResource("/Imagenes/5.gif"));
                this.camp2.setIcon(gift2);
                this.camp2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                x2=1;
            }
            else{
                ImageIcon gift2 = new ImageIcon(getClass().getResource("/Imagenes/Summer2.gif"));
                this.camp2.setIcon(gift2);
                this.camp2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                x2=2;
            }
            if(probcampeon3<=0.5){
                ImageIcon gift3 = new ImageIcon(getClass().getResource("/Imagenes/9.gif"));
                this.camp3.setIcon(gift3);
                this.camp3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                x3=1;
            }
            else{
                ImageIcon gift3 = new ImageIcon(getClass().getResource("/Imagenes/10.gif"));
                this.camp3.setIcon(gift3);
                this.camp3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                x3=2;
            }
            
            double probBatalla = Math.random();
            
            
            this.serieGanadoraText.setText("");
            
            Thread.sleep(variablesGenerales.tiempoAnalisisSegundos * 1000 / 12);
            this.probabilidadesBatallaAuxiliar(probBatalla, x1, x2, x3,clip,clip2,clip3);
            
            this.serieJoseCombatiendo.setText("");
            this.serieAndyCombatiendo.setText("");
            this.serieUsecheCombatiendo.setText("");
            this.serieGanadoraText.setText("");
    }
    
    /**
     * Metodo auxiliar de probabilidadesBatalla, indica si se gana empata o pierde y las acciones a hacer en cada caso
     * @param probBatalla
     * @param x1
     * @param x2
     * @param x3
     * @throws IOException 
     */
    private void probabilidadesBatallaAuxiliar(double probBatalla, int x1, int x2, int x3,Clip clip, Clip clip2,Clip clip3) throws IOException, LineUnavailableException, UnsupportedAudioFileException{
        
        
        if (this.probHayGanador(probBatalla)){
                
                Serie serieGanadora = this.simuladorBatalla();
                this.lucha1.setIcon(null);
                this.lucha2.setIcon(null);
                this.lucha3.setIcon(null);
                this.vida1.setIcon(null);
                this.vida2.setIcon(null);
                this.vida3.setIcon(null);

                this.lucha1.setText("");
                this.lucha2.setText("");
                this.lucha3.setText("");
                this.vida1.setText("");
                this.vida2.setText("");
                this.vida3.setText("");
                this.Accion_1.setText("");
                this.Accion_2.setText("");
                this.Accion_3.setText("");
                this.serieAndyCombatiendo.setText("");
                this.serieJoseCombatiendo.setText("");
                this.serieUsecheCombatiendo.setText("");
        
                this.camp1.setIcon(null);
                this.camp2.setIcon(null);
                this.camp3.setIcon(null);
                
            switch (serieGanadora.getRodajePertenece()) {
                
                case 1 -> {
                    if(x1==1){
                        this.clip4.stop();
                        if(Administrador.keep){
                            clip3.start();
                            ImageIcon gift = new ImageIcon(getClass().getResource("/Imagenes/12.gif"));
                            this.winner.setIcon(gift);
                            this.winner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            this.central.setText("Ganador RICK");
                        }
                        
                        
                    }
                    else if(x1==2){
                        this.clip4.stop();
                        if(Administrador.keep){
                            clip3.start();
                            ImageIcon gift = new ImageIcon(getClass().getResource("/Imagenes/29.gif"));
                            this.winner.setIcon(gift);
                            this.winner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            this.central.setText("Ganador MORTY");
                        }

                    }
                    if(Administrador.keep){
                        var.guardarSerieJson(serieJose.getId(), serieJose.getNivelPrioridad(), serieJose.getNivelPrioridadInicio(), serieJose.getRodajePertenece(), serieJose.getDuracionMinutos(), serieJose.getContador(), serieJose.getPuntosPoder(), serieJose.getVida());
                    }
                }
                case 2 -> {
                    if(x2==1){
                        if(Administrador.keep){
                            this.clip4.stop();
                            clip3.start();
                            ImageIcon gift = new ImageIcon(getClass().getResource("/Imagenes/jeryr.gif"));
                            this.winner.setIcon(gift);
                            this.winner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            this.central.setText("Ganador JERRY");
                        }
                    }
                    else if(x2==2){
                        if(Administrador.keep){
                            this.clip4.stop();
                            clip3.start();
                            ImageIcon gift = new ImageIcon(getClass().getResource("/Imagenes/17.gif"));
                            this.winner.setIcon(gift);
                            this.winner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            this.central.setText("Ganadora SUMMER");
                        }
                    }
                    if(Administrador.keep){
                    var.guardarSerieJson(serieAndy.getId(), serieAndy.getNivelPrioridad(), serieAndy.getNivelPrioridadInicio(), serieAndy.getRodajePertenece(), serieAndy.getDuracionMinutos(), serieAndy.getContador(), serieAndy.getPuntosPoder(), serieAndy.getVida());
                    }
                }
                default -> {
                    if(x3==1){
                        if(Administrador.keep){
                            this.clip4.stop();
                            clip3.start();
                            ImageIcon gift = new ImageIcon(getClass().getResource("/Imagenes/13.gif"));
                            this.winner.setIcon(gift);
                            this.winner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            this.central.setText("Ganador BIRD PERSON");
                            var.guardarSerieJson(serieUseche.getId(), serieUseche.getNivelPrioridad(), serieUseche.getNivelPrioridadInicio(), serieUseche.getRodajePertenece(), serieUseche.getDuracionMinutos(), serieUseche.getContador(), serieUseche.getPuntosPoder(), serieUseche.getVida());
                        }
                    }
                    else if(x3==2){
                        if(Administrador.keep){
                            this.clip4.stop();
                            clip3.start();
                            ImageIcon gift = new ImageIcon(getClass().getResource("/Imagenes/26.gif"));
                            this.winner.setIcon(gift);
                            this.winner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            this.central.setText("Ganadora BETH");
                            var.guardarSerieJson(serieUseche.getId(), serieUseche.getNivelPrioridad(), serieUseche.getNivelPrioridadInicio(), serieUseche.getRodajePertenece(), serieUseche.getDuracionMinutos(), serieUseche.getContador(), serieUseche.getPuntosPoder(), serieUseche.getVida());
                        }
                    }
                }
            }
            
                if(Administrador.keep){
                    
                    String rodaje;
                    
                    switch(serieGanadora.getRodajePertenece()){
                        case 1:
                          rodaje = "TLOU";  
                          break;
                        case 2:
                          rodaje = "VELMA";  
                          break;
                        default:
                          rodaje = "Game of Thrones";  
                          break;
                            
                    }
                    
                    this.serieGanadoraText.setText("Serie Ganadora: (ID: " + serieGanadora.getId() + ", RODAJE: " + rodaje + ")");
                }
                try {
                    var.leerSerieJson(this.LOU, this.VELMA, this.OTRO);
                } catch (IOException ex) {
                    Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(Administrador.keep){
                    clip3.stop();
                    clip4.loop(Clip.LOOP_CONTINUOUSLY);
                }

            }else if(this.probHayEmpate(probBatalla)){
                
            try {    
                Thread.sleep((variablesGenerales.tiempoAnalisisSegundos * 1000) - (variablesGenerales.tiempoAnalisisSegundos/12 * 1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                this.simuladorBatalla2();
                this.lucha1.setIcon(null);
                this.lucha2.setIcon(null);
                this.lucha3.setIcon(null);
                this.vida1.setIcon(null);
                this.vida2.setIcon(null);
                this.vida3.setIcon(null);

                this.lucha1.setText("");
                this.lucha2.setText("");
                this.lucha3.setText("");
                this.vida1.setText("");
                this.vida2.setText("");
                this.vida3.setText("");
                this.Accion_1.setText("");
                this.Accion_2.setText("");
                this.Accion_3.setText("");
                this.serieAndyCombatiendo.setText("");
                this.serieJoseCombatiendo.setText("");
                this.serieUsecheCombatiendo.setText("");
                
                    this.camp1.setIcon(null);
                    this.camp2.setIcon(null);
                    this.camp3.setIcon(null);
                if(Administrador.keep){
                    clip.start();
                
        //            Crear un metodo que ponga en su lista de prioridad respectiva las series que se le pasen
                    ImageIcon gifto2 = new ImageIcon(getClass().getResource("/Imagenes/empate.gif"));
                    this.winner.setIcon(gifto2);
                    this.winner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    this.central.setText("EMPATE");
                    Administrador admin = new Administrador();
                    admin.encolarSerie(this.serieJose, this.serieAndy, this.serieUseche);
                }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(Administrador.keep){
                clip.stop();
            }

            }else{
                
            try {
                Thread.sleep((variablesGenerales.tiempoAnalisisSegundos * 1000) - (variablesGenerales.tiempoAnalisisSegundos/12 * 1000) );
            } catch (InterruptedException ex) {
                Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                this.lucha1.setIcon(null);
                this.lucha2.setIcon(null);
                this.lucha3.setIcon(null);
                this.vida1.setIcon(null);
                this.vida2.setIcon(null);
                this.vida3.setIcon(null);

                this.lucha1.setText("");
                this.lucha2.setText("");
                this.lucha3.setText("");
                this.vida1.setText("");
                this.vida2.setText("");
                this.vida3.setText("");
                this.Accion_1.setText("");
                this.Accion_2.setText("");
                this.Accion_3.setText("");
                this.serieAndyCombatiendo.setText("");
                this.serieJoseCombatiendo.setText("");
                this.serieUsecheCombatiendo.setText("");
                if(Administrador.keep){
                    clip2.start();
                
    //            Crear un metodo que ponga en su lista de refuerzo respectiva las series que se le pasen
                    this.camp1.setIcon(null);
                    this.camp2.setIcon(null);
                    this.camp3.setIcon(null);
                    ImageIcon gifto3 = new ImageIcon(getClass().getResource("/Imagenes/refuerzo.gif"));
                    this.winner.setIcon(gifto3);


                    this.winner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    this.central.setText("REFUERZO");
                
                    Administrador admin = new Administrador();
                    admin.encolarColaRefuerzo(this.serieJose, this.serieAndy, this.serieUseche);
                }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
            }
                clip2.stop();
            }
        
            this.serieJoseCombatiendo.setText("");
            this.serieAndyCombatiendo.setText("");
            this.serieUsecheCombatiendo.setText("");
            
            
    }
    
    /**
     * Te dice si esta batalla debe haber un ganador o no
     * @param probBatalla
     * @return boolean 
     */
    public boolean probHayGanador(double probBatalla){
        return probBatalla <= 0.40;
    }
    
    /**
     * Te dice si esta batalla debe haber un empate
     * @param probBatalla
     * @return boolean
     */
    public boolean probHayEmpate(double probBatalla){
        return probBatalla > 0.40 && probBatalla <= 0.67;
    }
    
    /**
     * Te indica cual serie, de las tres que pasaron, es la ganadora
     * @return Serie 
     */
    public Serie simuladorBatalla() {
        
           Serie campeonJose = this.serieJose;
           Serie campeonAndy = this.serieAndy;
           Serie campeonUseche = this.serieUseche;
           int vidaResp1 =this.serieJose.getVida();
           int vidaResp2 =this.serieAndy.getVida();
           int vidaResp3 =this.serieUseche.getVida();
           
           Serie[] jugadores = {campeonJose,campeonAndy,campeonUseche};
           Random rand = new Random();
           
           boolean listo = true;
           while( listo && Administrador.keep){
                      
                    try {
                        Thread.sleep(variablesGenerales.tiempoAnalisisSegundos * 1000 / 12);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                       
                      aleatarioJugadores(jugadores, rand);
                      
                      for (int i = 0; i < jugadores.length; i++) {
                                 Serie atacante = jugadores[i];
                                 
                                 if (atacante.getVida() <= 0){
                                            continue;
                                 }
                                 
                                 Serie[] targets = elegirPersonajeObjetivo(jugadores, atacante);
                                 int objetivoIndex  = rand.nextInt(targets.length);
                                 Serie target = targets[objetivoIndex];
                                 int damage = atacante.getPuntosPoder();
                                 if(target.getVida()-damage>0){
                                    
                                            target.setVida(target.getVida()-damage);
                                    
                                            switch (atacante.getRodajePertenece()) {
                                                       case 1 -> {this.Accion_1.setForeground(Color.yellow);
                                                                  this.Accion_1.setText(Integer.toString(damage));
                                                                  this.Accion_2.setText(null);
                                                                  this.Accion_3.setText(null);
                                                       }
                                                                  
                                                       
                                                       case 2 -> {this.Accion_2.setForeground(Color.yellow);
                                                                  this.Accion_2.setText(Integer.toString(damage));
                                                                  this.Accion_1.setText(null);
                                                                  this.Accion_3.setText(null);
                                                       }
                                                       
                                                       default -> {this.Accion_3.setForeground(Color.yellow);
                                                                  this.Accion_3.setText(Integer.toString(damage));
                                                                  this.Accion_1.setText(null);
                                                                  this.Accion_2.setText(null);
                                                       }
                                            }
                                            switch (target.getRodajePertenece()) {
                                                       case 1 -> {this.Accion_1.setForeground(Color.red);
                                                                  this.Accion_1.setText(Integer.toString(damage));}
                                                                       
                                                       case 2 ->{this.Accion_2.setForeground(Color.red);
                                                                  this.Accion_2.setText(Integer.toString(damage));}
                                                       
                                                       default ->{this.Accion_3.setForeground(Color.red);
                                                                  this.Accion_3.setText(Integer.toString(damage));}
                                            }
                                            //this.peleaDesc.setText(atacante.getRodajePertenece() + " ataca a " + target.getRodajePertenece() + " haciendole " + damage + " de golpe! ");
//                                    System.out.println(atacante.getRodajePertenece() + " ataca a " + target.getRodajePertenece() + " haciendole " + damage + " de dano! ");
                                 }else if(target.getVida()==0){
                                     target.setVida(0);
                                 }
                                 else{
                                    target.setVida(target.getVida()-damage);
                                    target.setVida(0);
                                    
                                    switch (atacante.getRodajePertenece()) {
                                                       case 1 -> {this.Accion_1.setForeground(Color.blue);
                                                                  this.Accion_1.setText(Integer.toString(damage));
                                                                  this.Accion_2.setText(null);
                                                                  this.Accion_3.setText(null);
                                                       }
                                                                  
                                                       
                                                       case 2 -> {this.Accion_2.setForeground(Color.blue);
                                                                  this.Accion_2.setText(Integer.toString(damage));
                                                                  this.Accion_1.setText(null);
                                                                  this.Accion_3.setText(null);
                                                       }
                                                       
                                                       default -> {this.Accion_3.setForeground(Color.blue);
                                                                  this.Accion_3.setText(Integer.toString(damage));
                                                                  this.Accion_1.setText(null);
                                                                  this.Accion_2.setText(null);
                                                       }
                                            }
                                            switch (target.getRodajePertenece()) {
                                                       case 1 -> {this.Accion_1.setForeground(Color.black);
                                                                  this.Accion_1.setText(Integer.toString(damage));}
                                                                       
                                                       case 2 ->{this.Accion_2.setForeground(Color.black);
                                                                  this.Accion_2.setText(Integer.toString(damage));}
                                                       
                                                       default ->{this.Accion_3.setForeground(Color.black);
                                                                  this.Accion_3.setText(Integer.toString(damage));}
                                            }
                                    
                                  //  this.peleaDesc.setText(atacante.getRodajePertenece() + " ataca " + target.getRodajePertenece() + " liquidandolo");
//                                    System.out.println(atacante.getRodajePertenece() + " ataca " + target.getRodajePertenece() + " liquidandolo");
                                 }
                                 if(target.getVida() <= 0){
//                                            System.out.println(target.getRodajePertenece() + " ha sido derrotado" );
                                 }
                                 if(todosCampeonesMuertos(jugadores)){
//                                            System.out.println("tenemos un ganador ");
                                 }
                      }
                                 
                        this.vida1.setText(String.valueOf(this.serieJose.getVida()));
                        this.vida2.setText(String.valueOf(this.serieAndy.getVida()));
                        this.vida3.setText(String.valueOf(this.serieUseche.getVida()));
                        this.lucha1.setText(String.valueOf( this.serieJose.getPuntosPoder()));
                        this.lucha2.setText(String.valueOf(this.serieAndy.getPuntosPoder()));
                        this.lucha3.setText(String.valueOf(this.serieUseche.getPuntosPoder()));              
//                      atacar ( this.serieJose, this.serieAndy, this.serieUseche);
//                      atacar ( this.serieAndy, this.serieJose, this.serieUseche);
//                      atacar ( this.serieUseche, this.serieJose, this.serieAndy );
                        if(this.serieJose.getVida() == 0 && this.serieAndy.getVida()==0){ 
                            listo = false;
                            break;}
                        else if(this.serieJose.getVida() == 0 && this.serieUseche.getVida()==0){ 
                            listo = false;
                            break;}
                        else if(this.serieAndy.getVida() == 0 && this.serieUseche.getVida()==0){ 
                            listo = false;
                            break;}

                        if(!Administrador.keep){
                            this.vida1.setText(String.valueOf(vidaResp1));
                            this.vida2.setText(String.valueOf(vidaResp2));
                            this.vida3.setText(String.valueOf(vidaResp3));
                        }

           }
        
        if(campeonJose.getVida() > 0){
            return this.serieJose;
            
        }else if(campeonAndy.getVida() > 0 ){
            return this.serieAndy;
            
        }else{            
            
            return this.serieUseche;
            
        }
        
   
    }
    
    public static <T> void aleatarioJugadores(T[] lista, Random rand){
               for(int i = lista.length-1; i >0; i--){
                          int j = rand.nextInt(i + 1);
                          T temp = lista[i];
                          lista[i] = lista[j];
                          lista[j] = temp;
               }
    }
    
    public static Serie[] elegirPersonajeObjetivo(Serie[] campeones, Serie campeon) {
        Serie[] otrosCampeones = new Serie[campeones.length - 1];
        int j = 0;
        for (int i = 0; i < campeones.length; i++) {
            if (campeones[i] != campeon) {
                otrosCampeones[j++] = campeones[i];
            }
        }
        return otrosCampeones;
    }
    
    public static boolean todosCampeonesMuertos(Serie[] campeones) {
        int muertos = 0;
        for (int i = 0; i < campeones.length; i++) {
            if (campeones[i].getVida() < 0) {
                muertos++;
            }
        }
        if(muertos >= 2){
                   return true;
        }
               return false;
    }
    
    
    
    

    /**
     * @return the camp1
     */
    public javax.swing.JLabel getCamp1() {
        return camp1;
    }

    /**
     * @param camp1 the camp1 to set
     */
    public void setCamp1(javax.swing.JLabel camp1) {
        this.camp1 = camp1;
    }

    /**
     * @return the camp2
     */
    public javax.swing.JLabel getCamp2() {
        return camp2;
    }

    /**
     * @param camp2 the camp2 to set
     */
    public void setCamp2(javax.swing.JLabel camp2) {
        this.camp2 = camp2;
    }

    /**
     * @return the camp3
     */
    public javax.swing.JLabel getCamp3() {
        return camp3;
    }

    /**
     * @param camp3 the camp3 to set
     */
    public void setCamp3(javax.swing.JLabel camp3) {
        this.camp3 = camp3;
    }

    /**
     * @return the winner
     */
    public javax.swing.JLabel getWinner() {
        return winner;
    }

    /**
     * @param winner the winner to set
     */
    public void setWinner(javax.swing.JLabel winner) {
        this.winner = winner;
    }
    


    
    public void simuladorBatalla2() {
        
           Serie campeonJose = this.serieJose;
           Serie campeonAndy = this.serieAndy;
           Serie campeonUseche = this.serieUseche;
           
           int vidaFinal1 =this.serieJose.getVida();
           int vidaFinal2 =this.serieAndy.getVida();
           int vidaFinal3 =this.serieUseche.getVida();
           
           Serie[] jugadores = {campeonJose,campeonAndy,campeonUseche};
           Random rand = new Random();
           
           boolean listo = true;
           while( listo && Administrador.keep){
                      
                      try {
                        Thread.sleep(variablesGenerales.tiempoAnalisisSegundos * 1000 / 12);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                      aleatarioJugadores(jugadores, rand);
                      
                      for (int i = 0; i < jugadores.length; i++) {
                                 Serie atacante = jugadores[i];
                                 
                                 if (atacante.getVida() < 0){
                                            continue;
                                 }
                                 
                                 Serie[] targets = elegirPersonajeObjetivo(jugadores, atacante);
                                 int objetivoIndex  = rand.nextInt(targets.length);
                                 Serie target = targets[objetivoIndex];
                                 int damage = atacante.getPuntosPoder();
                                 if(target.getVida()-damage>1){
                                    
                                    target.setVida(target.getVida()-damage);
                                                                        
                                     switch (atacante.getRodajePertenece()) {
                                                       case 1 -> {this.Accion_1.setForeground(Color.yellow);
                                                                  this.Accion_1.setText(Integer.toString(damage));
                                                                  this.Accion_2.setText(null);
                                                                  this.Accion_3.setText(null);
                                                       }
                                                                  
                                                       
                                                       case 2 -> {this.Accion_2.setForeground(Color.yellow);
                                                                  this.Accion_2.setText(Integer.toString(damage));
                                                                  this.Accion_1.setText(null);
                                                                  this.Accion_3.setText(null);
                                                       }
                                                       
                                                       default -> {this.Accion_3.setForeground(Color.yellow);
                                                                  this.Accion_3.setText(Integer.toString(damage));
                                                                  this.Accion_1.setText(null);
                                                                  this.Accion_2.setText(null);
                                                       }
                                            }
                                            switch (target.getRodajePertenece()) {
                                                       case 1 -> {this.Accion_1.setForeground(Color.red);
                                                                  this.Accion_1.setText(Integer.toString(damage));}
                                                                       
                                                       case 2 ->{this.Accion_2.setForeground(Color.red);
                                                                  this.Accion_2.setText(Integer.toString(damage));}
                                                       
                                                       default ->{this.Accion_3.setForeground(Color.red);
                                                                  this.Accion_3.setText(Integer.toString(damage));}
                                            }
                                    //this.peleaDesc.setText(atacante.getRodajePertenece() + " ataca a " + target.getRodajePertenece() + " haciendole " + damage + " de golpe! ");
//                                    System.out.println(atacante.getRodajePertenece() + " ataca a " + target.getRodajePertenece() + " haciendole " + damage + " de dano! ");
                                 }
                                 else if(target.getVida()==1){
                                     target.setVida(1);
                                     //this.peleaDesc.setText(atacante.getRodajePertenece() + " fallo ");
                                     
                                      switch (atacante.getRodajePertenece()) {
                                                       case 1 -> {this.Accion_1.setForeground(Color.white);
                                                                  this.Accion_1.setText("FALLO");
                                                                  this.Accion_2.setText(null);
                                                                  this.Accion_3.setText(null);
                                                       }
                                                       
                                                       case 2 -> {this.Accion_2.setForeground(Color.white);
                                                                  this.Accion_2.setText("FALLO");
                                                                  this.Accion_1.setText(null);
                                                                  this.Accion_3.setText(null);
                                                       }
                                                       
                                                       default -> {this.Accion_3.setForeground(Color.white);
                                                                  this.Accion_3.setText("FALLO");
                                                                  this.Accion_1.setText(null);
                                                                  this.Accion_2.setText(null);
                                                       }
                                            }
//                                            switch (target.getRodajePertenece()) {
//                                                       case 1 -> {this.Accion_1.setForeground(Color.red);
//                                                                  this.Accion_1.setText(Integer.toString(damage));}
//                                                                       
//                                                       case 2 ->{this.Accion_2.setForeground(Color.red);
//                                                                  this.Accion_2.setText(Integer.toString(damage));}
//                                                       
//                                                       default ->{this.Accion_3.setForeground(Color.red);
//                                                                  this.Accion_3.setText(Integer.toString(damage));}
//                                            }
                                 }
                                 else{
                                    target.setVida(target.getVida()-damage);
                                    target.setVida(1);
                                    //this.peleaDesc.setText(atacante.getRodajePertenece() + " ataca a " + target.getRodajePertenece() + "dejandole a 1 de vida");
                                    
                                     switch (atacante.getRodajePertenece()) {
                                                       case 1 -> {this.Accion_1.setForeground(Color.yellow);
                                                                  this.Accion_1.setText(Integer.toString(damage));
                                                                  this.Accion_2.setText(null);
                                                                  this.Accion_3.setText(null);
                                                       }
                                                       
                                                       case 2 -> {this.Accion_2.setForeground(Color.yellow);
                                                                  this.Accion_2.setText(Integer.toString(damage));
                                                                  this.Accion_1.setText(null);
                                                                  this.Accion_3.setText(null);
                                                       }
                                                       
                                                       default -> {this.Accion_3.setForeground(Color.yellow);
                                                                  this.Accion_3.setText(Integer.toString(damage));
                                                                  this.Accion_1.setText(null);
                                                                  this.Accion_2.setText(null);
                                                       }
                                            }
                                            switch (target.getRodajePertenece()) {
                                                       case 1 -> {this.Accion_1.setForeground(Color.green);
                                                                  this.Accion_1.setText("ESQUIVADO");}
                                                                       
                                                       case 2 ->{this.Accion_2.setForeground(Color.green);
                                                                  this.Accion_2.setText("ESQUIVADO");}
                                                       
                                                       default ->{this.Accion_3.setForeground(Color.green);
                                                                  this.Accion_3.setText("ESQUIVADO");}
                                            }
                                 }
                                 if(target.getVida() <= 0){
//                                            System.out.println(target.getRodajePertenece() + " ha sido derrotado" );
                                 }
                                 if(todosCampeonesMuertos(jugadores)){
//                                            System.out.println("tenemos un ganador ");
                                            
                                 }
                      }
                                 
                        this.vida1.setText(String.valueOf(this.serieJose.getVida()));
                        this.vida2.setText(String.valueOf(this.serieAndy.getVida()));
                        this.vida3.setText(String.valueOf(this.serieUseche.getVida()));
                        this.lucha1.setText(String.valueOf( this.serieJose.getPuntosPoder()));
                        this.lucha2.setText(String.valueOf(this.serieAndy.getPuntosPoder()));
                        this.lucha3.setText(String.valueOf(this.serieUseche.getPuntosPoder()));      
                        if(!Administrador.keep){
                            this.vida1.setText(String.valueOf(vidaFinal1));
                            this.vida2.setText(String.valueOf(vidaFinal2));
                            this.vida3.setText(String.valueOf(vidaFinal3));
                        }
//                      atacar ( this.serieJose, this.serieAndy, this.serieUseche);
//                      atacar ( this.serieAndy, this.serieJose, this.serieUseche);
//                      atacar ( this.serieUseche, this.serieJose, this.serieAndy );
                        if(this.serieJose.getVida() == 1 && this.serieAndy.getVida()==1 && this.serieUseche.getVida()==1){ 
                            listo = false;
                            break;}


           }
           this.serieJose.setVida(vidaFinal1);
           this.serieAndy.setVida(vidaFinal2);
           this.serieUseche.setVida(vidaFinal3);
    }
    
    
    
    
}
