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
        
    }
    
}
