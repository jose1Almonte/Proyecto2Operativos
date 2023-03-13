/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author Hallo
 */
public class Serie {
    private int id;
    private int nivelPrioridad;
    private int rodajePertenece;
    private int duracionMinutos;    
    private int contador;
    
    private int idPersonaje;
    private int puntosPoder;
    private int vida;
    
    
    /**
     * Constructor
     */
    public Serie(){
        
    }
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the rodajePertenece
     */
    public int getRodajePertenece() {
        return rodajePertenece;
    }

    /**
     * @param rodajePertenece the rodajePertenece to set
     */
    public void setRodajePertenece(int rodajePertenece) {
        this.rodajePertenece = rodajePertenece;
    }

    /**
     * @return the contador
     */
    public int getContador() {
        return contador;
    }

    /**
     * @param contador the contador to set
     */
    public void setContador(int contador) {
        this.contador = contador;
    }

    /**
     * @return the puntosPoder
     */
    public int getPuntosPoder() {
        return puntosPoder;
    }

    /**
     * @param puntosPoder the puntosPoder to set
     */
    public void setPuntosPoder(int puntosPoder) {
        this.puntosPoder = puntosPoder;
    }

    /**
     * @return the vida
     */
    public int getVida() {
        return vida;
    }

    /**
     * @param vida the vida to set
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * @return the nivelPrioridad
     */
    public int getNivelPrioridad() {
        return nivelPrioridad;
    }

    /**
     * @param nivelPrioridad the nivelPrioridad to set
     */
    public void setNivelPrioridad(int nivelPrioridad) {
        this.nivelPrioridad = nivelPrioridad;
    }

    /**
     * @return the duracionMinutos
     */
    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    /**
     * @param duracionMinutos the duracionMinutos to set
     */
    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    /**
     * @return the idPersonaje
     */
    public int getIdPersonaje() {
        return idPersonaje;
    }

    /**
     * @param idPersonaje the idPersonaje to set
     */
    public void setIdPersonaje(int idPersonaje) {
        this.idPersonaje = idPersonaje;
    }
    
    
}
