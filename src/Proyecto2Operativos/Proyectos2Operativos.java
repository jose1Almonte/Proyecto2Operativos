/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Proyecto2Operativos;

import Classes.Administrador;
import Classes.counter;
import Classes.variablesGenerales;
import Interfaces.Interfaz;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Andy
 */
public class Proyectos2Operativos {
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Interfaz interfaz = new Interfaz();
        variablesGenerales f = new variablesGenerales();
        int counter=0;
        try{
            counter = f.leerJson();
        }catch(Exception e){
        }
        interfaz.setVisible(true);
        while(true){
            
        }
       
    }
    
}
