/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

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
        
        if(this.serieJose.getPuntosPoder() > this.serieAndy.getPuntosPoder() && this.serieJose.getPuntosPoder() > this.serieUseche.getPuntosPoder()){
            return this.serieJose;
            
        }else if(this.serieAndy.getPuntosPoder() > this.serieJose.getPuntosPoder() && this.serieAndy.getPuntosPoder() > this.serieUseche.getPuntosPoder()){
            return this.serieAndy;
            
        }else if(this.serieUseche.getPuntosPoder() > this.serieJose.getPuntosPoder() && this.serieUseche.getPuntosPoder() > this.serieJose.getPuntosPoder()){
            return this.serieUseche;
            
        }else{
            
            int randomTemp = 1 + (int) (Math.random() + 2);
            
            switch (randomTemp) {
                case 3 -> {
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
