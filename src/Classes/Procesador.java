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
public class Procesador extends Thread{
    Serie serieJose;
    Serie serieAndy;
    Serie serieUseche;
            
    
    public Procesador(Serie serieJose, Serie serieAndy, Serie serieUseche){
        this.serieJose = serieJose;
        this.serieAndy = serieAndy;
        this.serieUseche = serieUseche;
    }
    
    @Override
    public void run(){
        
        double probBatalla = Math.random();
        
        
        if (this.probHayGanador(probBatalla)){
            
            Serie serieGanadora = this.puntosPoderMasAlto();
//            System.out.println("Soy la IA, y estoy trabajando con: "+ serieGanadora.getRodajePertenece() + " "  + serieGanadora.getNivelPrioridad() + " " + serieGanadora.getDuracionMinutos() );
            
        }else if(this.probHayEmpate(probBatalla)){
            
//            Crear un metodo que ponga en su lista de prioridad respectiva las series que se le pasen

            Administrador admin = new Administrador();
            admin.encolarSerie(this.serieJose, this.serieAndy, this.serieUseche);
            
        }else{
            
//            Crear un metodo que ponga en su lista de refuerzo respectiva las series que se le pasen
            Administrador admin = new Administrador();
            admin.encolarColaRefuerzo(this.serieJose, this.serieAndy, this.serieUseche);
                        
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
    
    
    
}
