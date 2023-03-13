/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Andy
 */
public class Procesador {
    int ci = 27;
    Proceso serieA;
    Proceso serieB;
    
    public Procesador(Proceso serieA,Proceso serieB){
        this.serieA= serieA;
        this.serieB=serieB;
    }
    
    public void Decision(){
        float numero = (float) Math.random();
        float numero2 = (float) Math.random();
        if (numero<0.4){
            if(numero2<0.50){
                System.out.print("se selecciono"+ serieA.getElement());
            }
            else{
                System.out.print("se selecciono"+ serieB.getElement());
            }
        }
        else if(numero<0.67 && numero >=0.4){
            int priA=serieA.getPrioridad();
            int priB=serieB.getPrioridad();
        //aqui el sistema operativo debe encolar 
        }
        else{
        //aqui el sistema operativo debe encolar 
        }
        
    }
    
}
