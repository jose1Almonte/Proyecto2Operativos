/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    javax.swing.JLabel serieJoseCombatiendo;
    javax.swing.JLabel serieAndyCombatiendo;
    javax.swing.JLabel serieUsecheCombatiendo;
    javax.swing.JLabel serieGanadoraText;
    
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
            javax.swing.JLabel serieGanadoraText
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
    }
    
    @Override
    public void run(){
        
        try{
            this.serieJoseCombatiendo.setText("( " + this.serieJose.getId() + ", " + this.serieJose.getRodajePertenece() + " )");
            this.serieAndyCombatiendo.setText("( " + this.serieAndy.getId() + ", " + this.serieAndy.getRodajePertenece() + " )");
            this.serieUsecheCombatiendo.setText("( " + this.serieUseche.getId() + ", " + this.serieUseche.getRodajePertenece() + " )");
            
            
            this.probabilidadesBatalla();
            
            
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
    public void probabilidadesBatalla() throws IOException, InterruptedException{
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
            
            this.probabilidadesBatallaAuxiliar(probBatalla, x1, x2, x3);
            
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
    private void probabilidadesBatallaAuxiliar(double probBatalla, int x1, int x2, int x3) throws IOException{
        
        if (this.probHayGanador(probBatalla)){
                
                this.camp1.setIcon(null);
                this.camp2.setIcon(null);
                this.camp3.setIcon(null);
                
                Serie serieGanadora = this.puntosPoderMasAlto();
                
                System.out.println("RODAJE GANADOR: " + serieGanadora.getRodajePertenece());
                
                
            switch (serieGanadora.getRodajePertenece()) {
                case 1 -> {
                    if(x1==1){
                        ImageIcon gift = new ImageIcon(getClass().getResource("/Imagenes/12.gif"));
                        this.winner.setIcon(gift);
                        this.winner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        this.central.setText("Ganador RICK");
                        
                        
                    }
                    else if(x1==2){
                        
                        ImageIcon gift = new ImageIcon(getClass().getResource("/Imagenes/29.gif"));
                        this.winner.setIcon(gift);
                        this.winner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        this.central.setText("Ganador MORTY");
                        
                    }
                    var.guardarSerieJson(serieJose.getId(), serieJose.getNivelPrioridad(), serieJose.getNivelPrioridadInicio(), serieJose.getRodajePertenece(), serieJose.getDuracionMinutos(), serieJose.getContador(), serieJose.getPuntosPoder(), serieJose.getVida());
                }
                case 2 -> {
                    if(x2==1){
                        ImageIcon gift = new ImageIcon(getClass().getResource("/Imagenes/jeryr.gif"));
                        this.winner.setIcon(gift);
                        this.winner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        this.central.setText("Ganador JERRY");
                    }
                    else if(x2==2){
                        
                        ImageIcon gift = new ImageIcon(getClass().getResource("/Imagenes/17.gif"));
                        this.winner.setIcon(gift);
                        this.winner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        this.central.setText("Ganadora SUMMER");
                    }
                    var.guardarSerieJson(serieAndy.getId(), serieAndy.getNivelPrioridad(), serieAndy.getNivelPrioridadInicio(), serieAndy.getRodajePertenece(), serieAndy.getDuracionMinutos(), serieAndy.getContador(), serieAndy.getPuntosPoder(), serieAndy.getVida());
                }
                default -> {
                    if(x3==1){
                        ImageIcon gift = new ImageIcon(getClass().getResource("/Imagenes/13.gif"));
                        this.winner.setIcon(gift);
                        this.winner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        this.central.setText("Ganador BIRD PERSON");
                        var.guardarSerieJson(serieUseche.getId(), serieUseche.getNivelPrioridad(), serieUseche.getNivelPrioridadInicio(), serieUseche.getRodajePertenece(), serieUseche.getDuracionMinutos(), serieUseche.getContador(), serieUseche.getPuntosPoder(), serieUseche.getVida());
                    }
                    else if(x3==2){
                        
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

            }else if(this.probHayEmpate(probBatalla)){
                this.camp1.setIcon(null);
                this.camp2.setIcon(null);
                this.camp3.setIcon(null);

    //            Crear un metodo que ponga en su lista de prioridad respectiva las series que se le pasen
                ImageIcon gifto2 = new ImageIcon(getClass().getResource("/Imagenes/empate.gif"));
                this.winner.setIcon(gifto2);
                this.winner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                this.central.setText("EMPATE");
                Administrador admin = new Administrador();
                admin.encolarSerie(this.serieJose, this.serieAndy, this.serieUseche);
//                System.out.println("Empataron");
                

            }else{

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
    public int simuladorBatalla() {
        
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
                                 target.setVida(target.getVida()-damage);
                                 
                                 System.out.println(atacante.getRodajePertenece() + " ataca " + target.getRodajePertenece() + " haciendole " + damage + " de dano! ");
                                 
                                 if(target.getVida() <= 0){
                                            System.out.println(target.getRodajePertenece() + " ha sido derrotado" );
                                 }
                                 if(todosCampeonesMuertos(jugadores)){
                                            System.out.println("tenemos un ganador ");
                                            listo = false;
                                 }
                      }
                                 
                              
//                      atacar ( this.serieJose, this.serieAndy, this.serieUseche);
//                      atacar ( this.serieAndy, this.serieJose, this.serieUseche);
//                      atacar ( this.serieUseche, this.serieJose, this.serieAndy );
           }
        
        if(campeonJose.getVida() > 0){
            return this.serieJose.getId();
            
        }else if(campeonAndy.getVida() > 0 ){
            return this.serieAndy.getId();
            
        }else{            
            
            double randomDoubleTemp = (Math.random()*3);
            
            
            int randomTemp = (int) randomDoubleTemp;   
            
            
            switch (randomTemp) {
                case 1 -> {
                    return this.serieAndy;
                }
                case 2 -> {
                    return this.serieUseche;
                }
                default -> {
                    return this.serieJose;
                }
            }
            
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
    


    
    
    
    
    
    
}
