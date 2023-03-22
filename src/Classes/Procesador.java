/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

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
    javax.swing.JLabel peleaDesc;
    
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
            javax.swing.JLabel peleaDesc
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
        this.peleaDesc=peleaDesc;
        this.vida1=vida1;
        this.vida2=vida2;
        this.vida3=vida3;
        this.lucha1=lucha1;
        this.lucha2=lucha2;
        this.lucha3=lucha3;
    }
    
    @Override
    public void run(){
        
        try{
                
                
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
            
            this.serieJoseCombatiendo.setText("( " + this.serieJose.getId() + ", " + this.serieJose.getRodajePertenece() + " )");
            this.serieAndyCombatiendo.setText("( " + this.serieAndy.getId() + ", " + this.serieAndy.getRodajePertenece() + " )");
            this.serieUsecheCombatiendo.setText("( " + this.serieUseche.getId() + ", " + this.serieUseche.getRodajePertenece() + " )");
            
            
            this.probabilidadesBatalla( clip,clip2,clip3);
            
        }catch(Exception e){
//            System.out.println(e);
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
            Thread.sleep(2000);
            
            this.probabilidadesBatallaAuxiliar(probBatalla, x1, x2, x3,clip,clip2,clip3);
            
            Thread.sleep(2000);
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
                this.peleaDesc.setText("");
        
            
                
                this.camp1.setIcon(null);
                this.camp2.setIcon(null);
                this.camp3.setIcon(null);
                
                
                System.out.println("RODAJE GANADOR: " + serieGanadora.getRodajePertenece());
                
                
            switch (serieGanadora.getRodajePertenece()) {
                
                case 1 -> {
                    if(x1==1){
                        this.clip4.stop();
                        clip3.start();
                        ImageIcon gift = new ImageIcon(getClass().getResource("/Imagenes/12.gif"));
                        this.winner.setIcon(gift);
                        this.winner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        this.central.setText("Ganador RICK");
                        
                        
                    }
                    else if(x1==2){
                        this.clip4.stop();
                        clip3.start();
                        ImageIcon gift = new ImageIcon(getClass().getResource("/Imagenes/29.gif"));
                        this.winner.setIcon(gift);
                        this.winner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        this.central.setText("Ganador MORTY");
                        
                    }
                    var.guardarSerieJson(serieJose.getId(), serieJose.getNivelPrioridad(), serieJose.getNivelPrioridadInicio(), serieJose.getRodajePertenece(), serieJose.getDuracionMinutos(), serieJose.getContador(), serieJose.getPuntosPoder(), serieJose.getVida());
                }
                case 2 -> {
                    if(x2==1){
                        this.clip4.stop();
                        clip3.start();
                        ImageIcon gift = new ImageIcon(getClass().getResource("/Imagenes/jeryr.gif"));
                        this.winner.setIcon(gift);
                        this.winner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        this.central.setText("Ganador JERRY");
                    }
                    else if(x2==2){
                        this.clip4.stop();
                        clip3.start();
                        ImageIcon gift = new ImageIcon(getClass().getResource("/Imagenes/17.gif"));
                        this.winner.setIcon(gift);
                        this.winner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        this.central.setText("Ganadora SUMMER");
                    }
                    var.guardarSerieJson(serieAndy.getId(), serieAndy.getNivelPrioridad(), serieAndy.getNivelPrioridadInicio(), serieAndy.getRodajePertenece(), serieAndy.getDuracionMinutos(), serieAndy.getContador(), serieAndy.getPuntosPoder(), serieAndy.getVida());
                }
                default -> {
                    if(x3==1){
                        this.clip4.stop();
                        clip3.start();
                        ImageIcon gift = new ImageIcon(getClass().getResource("/Imagenes/13.gif"));
                        this.winner.setIcon(gift);
                        this.winner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        this.central.setText("Ganador BIRD PERSON");
                        var.guardarSerieJson(serieUseche.getId(), serieUseche.getNivelPrioridad(), serieUseche.getNivelPrioridadInicio(), serieUseche.getRodajePertenece(), serieUseche.getDuracionMinutos(), serieUseche.getContador(), serieUseche.getPuntosPoder(), serieUseche.getVida());
                    }
                    else if(x3==2){
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
            
            
//                System.out.println("Hay ganador" );
                this.serieGanadoraText.setText("Serie Ganadora: (ID: " + serieGanadora.getId() + ", RODAJE: " + serieGanadora.getRodajePertenece() + ")");

                try {
                    var.leerSerieJson(this.LOU, this.VELMA, this.OTRO);
                } catch (IOException ex) {
                    Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                //                System.out.println("Empataron");
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
                }
                    clip3.stop();
                    clip4.loop(Clip.LOOP_CONTINUOUSLY);
                

            }else if(this.probHayEmpate(probBatalla)){
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
                this.peleaDesc.setText("");
                
                this.camp1.setIcon(null);
                this.camp2.setIcon(null);
                this.camp3.setIcon(null);
                
                clip.start();

    //            Crear un metodo que ponga en su lista de prioridad respectiva las series que se le pasen
                ImageIcon gifto2 = new ImageIcon(getClass().getResource("/Imagenes/empate.gif"));
                this.winner.setIcon(gifto2);
                this.winner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                this.central.setText("EMPATE");
                Administrador admin = new Administrador();
                admin.encolarSerie(this.serieJose, this.serieAndy, this.serieUseche);
            try {
                //                System.out.println("Empataron");
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
            }
                clip.stop();

            }else{
                
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
                this.peleaDesc.setText("");
                
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
//                System.out.println("Se mandaron a refuerzo");
            try {
                //                System.out.println("Empataron");
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
        
//        System.out.println("Jose: " + this.serieJose.getPuntosPoder());
//        System.out.println("Andy: " + this.serieAndy.getPuntosPoder());
//        System.out.println("Useche: " + this.serieUseche.getPuntosPoder());
           Serie campeonJose = this.serieJose;
           Serie campeonAndy = this.serieAndy;
           Serie campeonUseche = this.serieUseche;
           
           Serie[] jugadores = {campeonJose,campeonAndy,campeonUseche};
           Random rand = new Random();
           
           boolean listo = true;
           while( listo){
                      
                      try {
                                 Thread.sleep(500);
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
                                    this.peleaDesc.setText(atacante.getRodajePertenece() + " ataca " + target.getRodajePertenece() + " haciendole " + damage + " de golpe! ");
                                    System.out.println(atacante.getRodajePertenece() + " ataca " + target.getRodajePertenece() + " haciendole " + damage + " de dano! ");
                                 }
                                 else{
                                    target.setVida(target.getVida()-damage);
                                    target.setVida(0);
                                    

                                    System.out.println(atacante.getRodajePertenece() + " ataca " + target.getRodajePertenece() + " haciendole " + damage + " de dano! ");
                                 }
                                 if(target.getVida() <= 0){
                                            System.out.println(target.getRodajePertenece() + " ha sido derrotado" );
                                 }
                                 if(todosCampeonesMuertos(jugadores)){
                                            System.out.println("tenemos un ganador ");
                                            listo = false;
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
                        if(this.serieJose.getVida() == 0 && this.serieAndy.getVida()==0){ break;}
                        else if(this.serieJose.getVida() == 0 && this.serieUseche.getVida()==0){ break;}
                        else if(this.serieAndy.getVida() == 0 && this.serieUseche.getVida()==0){ break;}


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
        
//        System.out.println("Jose: " + this.serieJose.getPuntosPoder());
//        System.out.println("Andy: " + this.serieAndy.getPuntosPoder());
//        System.out.println("Useche: " + this.serieUseche.getPuntosPoder());
           Serie campeonJose = this.serieJose;
           Serie campeonAndy = this.serieAndy;
           Serie campeonUseche = this.serieUseche;
           
           int vidaFinal1 =this.serieJose.getVida();
           int vidaFinal2 =this.serieAndy.getVida();
           int vidaFinal3 =this.serieUseche.getVida();
           
           Serie[] jugadores = {campeonJose,campeonAndy,campeonUseche};
           Random rand = new Random();
           
           boolean listo = true;
           while( listo){
                      
                      try {
                                 Thread.sleep(500);
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
                                    this.peleaDesc.setText(atacante.getRodajePertenece() + " ataca a" + target.getRodajePertenece() + " haciendole " + damage + " de golpe! ");
                                    System.out.println(atacante.getRodajePertenece() + " ataca " + target.getRodajePertenece() + " haciendole " + damage + " de dano! ");
                                 }
                                 else{
                                    target.setVida(target.getVida()-damage);
                                    target.setVida(1);
                                    

                                    System.out.println(atacante.getRodajePertenece() + " ataca a" + target.getRodajePertenece() + " haciendole " + damage + " de dano! ");
                                 }
                                 if(target.getVida() <= 0){
                                            System.out.println(target.getRodajePertenece() + " ha sido derrotado" );
                                 }
                                 if(todosCampeonesMuertos(jugadores)){
                                            System.out.println("tenemos un ganador ");
                                            listo = false;
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
                        if(this.serieJose.getVida() == 1 && this.serieAndy.getVida()==1 && this.serieUseche.getVida()==1){ break;}


           }
           this.serieJose.setVida(vidaFinal1);
           this.serieAndy.setVida(vidaFinal2);
           this.serieUseche.setVida(vidaFinal3);
    }
    
    
    
    
}
