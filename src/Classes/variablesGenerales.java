/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Hallo
 */
public class variablesGenerales {
    
    public static boolean keep = true;
    
    public static Semaphore darPasoIA = new Semaphore(0);
    public static Semaphore darPasoAdmin = new Semaphore(0);
    
    public static int numeroCiclos = 2;
    
    public static int terminalCedulaJose = 9; // Probablemente no se usen todos
    public static int terminalCedulaAndy = 8; // Probablemente no se usen todos
    public static int terminalCedulaUseche = 3; // Probablemente no se usen todos
    
    
    
    public variablesGenerales(){
        
    }
    
    public void guardarJson(int c){
        
        counter contador = new counter(c);
        Gson gson = new Gson();
        String json = gson.toJson(contador);
        
        try (FileWriter file = new FileWriter("contador.json")) {
            file.write(json);
            System.out.println("Contador guardado en archivo JSON");
         } catch (IOException e) {
            e.printStackTrace();
         }   
    }
    
    public int leerJson(){
        Gson gson = new Gson();
        int co =0;
        try (Reader reader = new FileReader("contador.json")) {
           counter contador = gson.fromJson(reader, counter.class);
           System.out.println("Valor del contador: " + contador.getValor());
           co = contador.getValor();
        } catch (IOException e) {
           e.printStackTrace();
           co =-1;
        }
        return co;
    }
}
