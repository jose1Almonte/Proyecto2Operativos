/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

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
            
    
    public Procesador(Serie serieJose, Serie serieAndy, Serie serieUseche,javax.swing.JLabel camp1, javax.swing.JLabel camp2, javax.swing.JLabel camp3, javax.swing.JLabel winner ){
        this.serieJose = serieJose;
        this.serieAndy = serieAndy;
        this.serieUseche = serieUseche;
        this.camp1=camp1;
        this.camp2=camp2;
        this.camp3=camp3;
        this.winner=winner;
    }
    
    @Override
    public void run(){
        
        try{
            double probcampeon1 = Math.random();
            double probcampeon2 = Math.random();
            double probcampeon3 = Math.random();
//            System.out.println("Evaluando...");
//            Thread.sleep(1000);
//            System.out.println("Ya evalué");
            this.winner.setIcon(null);

            if(probcampeon1<=0.5){
                ImageIcon gift = new ImageIcon(getClass().getResource("/Imagenes/2.gif"));
                this.camp1.setIcon(gift);
                this.camp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            }
            else{
                ImageIcon gift = new ImageIcon(getClass().getResource("/Imagenes/3.gif"));
                this.camp1.setIcon(gift);
                this.camp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            }
            
            if(probcampeon1<=0.5){
                ImageIcon gift = new ImageIcon(getClass().getResource("/Imagenes/5.gif"));
                this.camp1.setIcon(gift);
                this.camp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            }
            else{
                ImageIcon gift = new ImageIcon(getClass().getResource("/Imagenes/3.gif"));
                this.camp1.setIcon(gift);
                this.camp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            }

            double probBatalla = Math.random();


            if (this.probHayGanador(probBatalla)){

                Serie serieGanadora = this.puntosPoderMasAlto();
                System.out.println("Hay ganador" );

            }else if(this.probHayEmpate(probBatalla)){

    //            Crear un metodo que ponga en su lista de prioridad respectiva las series que se le pasen

                Administrador admin = new Administrador();
                admin.encolarSerie(this.serieJose, this.serieAndy, this.serieUseche);
                System.out.println("Empataron");

            }else{

    //            Crear un metodo que ponga en su lista de refuerzo respectiva las series que se le pasen
                Administrador admin = new Administrador();
                admin.encolarColaRefuerzo(this.serieJose, this.serieAndy, this.serieUseche);
                System.out.println("Se mandaron a refuerzo");
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        variablesGenerales.darPasoAdmin.release();
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
    public Serie puntosPoderMasAlto(){
        
//        System.out.println("Jose: " + this.serieJose.getPuntosPoder());
//        System.out.println("Andy: " + this.serieAndy.getPuntosPoder());
//        System.out.println("Useche: " + this.serieUseche.getPuntosPoder());
        
        if(this.serieJose.getPuntosPoder() > this.serieAndy.getPuntosPoder() && this.serieJose.getPuntosPoder() > this.serieUseche.getPuntosPoder()){
            return this.serieJose;
            
        }else if(this.serieAndy.getPuntosPoder() > this.serieJose.getPuntosPoder() && this.serieAndy.getPuntosPoder() > this.serieUseche.getPuntosPoder()){
            return this.serieAndy;
            
        }else if(this.serieUseche.getPuntosPoder() > this.serieJose.getPuntosPoder() && this.serieUseche.getPuntosPoder() > this.serieJose.getPuntosPoder()){
            return this.serieUseche;
            
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
