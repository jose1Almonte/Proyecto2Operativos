/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hallo
 */
public class variablesGenerales {
    
    private javax.swing.JLabel LOU;
    private javax.swing.JLabel VELMA;
    private javax.swing.JLabel OTRO;
    public static Semaphore darPasoIA = new Semaphore(0);
    public static Semaphore darPasoAdmin = new Semaphore(0);
    public static Semaphore stop = new Semaphore(1);
    
    public static int numeroCiclos = 0;
    
    public static int terminalCedulaJose = 9; // Probablemente no se usen todos
    public static int terminalCedulaAndy = 8; // Probablemente no se usen todos
    public static int terminalCedulaUseche = 3; // Probablemente no se usen todos
    
    public static int tiempoAnalisisSegundos;
    
    
    
    public variablesGenerales(){
        
    }
    
    public void guardarJson(int c){
        
        counter contador = new counter(c);
        Gson gson = new Gson();
        String json = gson.toJson(contador);
        
        try (FileWriter file = new FileWriter("src\\Archivos\\jsonfile.json")) {
            file.write(json);
//            System.out.println("Contador guardado en archivo JSON");
         } catch (IOException e) {
            e.printStackTrace();
         }   
    }
    
    public int leerJson(){
        Gson gson = new Gson();
        int co =0;
        try (Reader reader = new FileReader("src\\Archivos\\jsonfile.json")) {
           counter contador = gson.fromJson(reader, counter.class);
//           System.out.println("Valor del contador: " + contador.getValor());
           co = contador.getValor();
        } catch (IOException e) {
           e.printStackTrace();
           co =-1;
        }
        return co;
    }
    
    public void guardarSerieJson(int id, int nivelPrioridad, int nivelPrioridadInicio, int rodajePertenece, int duracionMinutos, int contador, int puntosPoder, int vida) throws IOException{
        
        Serie ser = new Serie(id, nivelPrioridad, nivelPrioridadInicio, rodajePertenece, duracionMinutos, contador, puntosPoder, vida);
        Gson gson = new Gson();
        String jsonString = gson.toJson(ser);
        FileWriter fileWriter = new FileWriter("src\\Archivos\\serie.json",true);
        try (PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.print(jsonString);
            printWriter.println();
        } 

    }
    
    public void leerSerieJson(javax.swing.JLabel LOU, javax.swing.JLabel VELMA, javax.swing.JLabel OTRO) throws IOException{
    
        
        FileReader fileReader;
        try {
            int n=0;
            int m=0;
            int o=0;
            fileReader = new FileReader("src\\Archivos\\serie.json");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Gson gson = new Gson();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Serie obj = gson.fromJson(line, Serie.class);
                if(obj.getRodajePertenece()==1){
                    n++;
                }
                else if (obj.getRodajePertenece()==2){
                    m++;
                }
                else{
                    o++;
                }
//                System.out.println(obj.getRodajePertenece());
            }

            bufferedReader.close();
            fileReader.close();
            LOU.setText(String.valueOf(n));
            VELMA.setText(String.valueOf(m));
            OTRO.setText(String.valueOf(o));
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(variablesGenerales.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
