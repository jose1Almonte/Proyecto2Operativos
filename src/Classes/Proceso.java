/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Andy
 */
public class Proceso {
    Proceso pNext;
    int id;
    private int duracion;
    private int counter;
    private int prioridad;
    
    public Proceso(int id2,int duracion){
        id=id2;
        this.duracion=duracion;
    }
    
    public Proceso getpNext() {
        return pNext;
    }
    
    public void setpNext(Proceso pNext) {
        this.pNext = pNext;
    }

    public int getElement() {
        return id;
    }

    public void setElement(int element) {
        this.id = element;
    }

    /**
     * @return the duracion
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(int duracion) {
        this.duracion=duracion;
    }

    /**
     * @return the counter
     */
    public int getCounter() {
        return counter;
    }

    /**
     * @param counter the counter to set
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }

    /**
     * @return the prioridad
     */
    public int getPrioridad() {
        return prioridad;
    }

    /**
     * @param prioridad the prioridad to set
     */
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    
    
    
}
