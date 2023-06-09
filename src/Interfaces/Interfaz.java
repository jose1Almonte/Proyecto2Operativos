/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Classes.Administrador;
import Classes.variablesGenerales;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;


/**
 *
 * @author Hallo
 */

public class Interfaz extends javax.swing.JFrame {
public Administrador admin; 
    Clip clip = AudioSystem.getClip();
    Clip clip2 = AudioSystem.getClip();
    Clip clip4;
    public Interfaz() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        initComponents();
        
        this.colaNivel1AndyTextField.setDisabledTextColor(Color.red);
        this.colaNivel2AndyTextField.setDisabledTextColor(Color.red);
        this.colaNivel3AndyTextField.setDisabledTextColor(Color.red);
        this.colaNivel1JoseTextField.setDisabledTextColor(Color.red);
        this.colaNivel2JoseTextField.setDisabledTextColor(Color.red);
        this.colaNivel3JoseTextField.setDisabledTextColor(Color.red);
        this.colaNivel1UsecheTextField.setDisabledTextColor(Color.red);
        this.colaNivel2UsecheTextField.setDisabledTextColor(Color.red);
        this.colaNivel3UsecheTextField.setDisabledTextColor(Color.red);
        this.colaRefuerzoAndyTextField.setDisabledTextColor(Color.red);
        this.colaRefuerzoJoseTextField.setDisabledTextColor(Color.red);
        this.colaRefuerzoUsecheTextField.setDisabledTextColor(Color.red);
        
        this.ataque1.setIcon(null);
        this.ataque2.setIcon(null);
        this.ataque3.setIcon(null);
        this.vida1.setIcon(null);
        this.vida2.setIcon(null);
        this.vida3.setIcon(null);
        
        this.ataque1.setText("");
        this.ataque2.setText("");
        this.ataque3.setText("");
        this.vida1.setText("");
        this.vida2.setText("");
        this.vida3.setText("");
        this.Accion_1.setText("");
        this.Accion_2.setText("");
        this.Accion_3.setText("");
        
        File audio = new File("src\\Archivos\\intro.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audio);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
            
        File audio4 = new File("src\\Archivos\\pelea.wav");
        AudioInputStream audioStream4 = AudioSystem.getAudioInputStream(audio4);
        clip4 = AudioSystem.getClip();
        clip4.open(audioStream4);
        
        
        File audio2 = new File("src\\Archivos\\Boring.wav");
        AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(audio2);
        clip2 = AudioSystem.getClip();
        clip2.open(audioStream2);
        
        
        variablesGenerales var =new variablesGenerales();
        try {
            var.leerSerieJson(this.LOU,this.VELMA,this.OTRO);
            
        } catch (IOException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        this.Camp1.setIcon(null);
        this.Camp2.setIcon(null);
        this.Camp3.setIcon(null);
        ImageIcon giftInicio = new ImageIcon("/Imagenes/chill.gif");
        this.winner.setIcon(giftInicio);
        this.winner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        this.Central.setText("BIENVENIDO");
        admin = new Administrador(this.colaNivel1JoseTextField,
                this.colaNivel2JoseTextField,
                this.colaNivel3JoseTextField,
                this.colaRefuerzoJoseTextField,
                this.colaNivel1AndyTextField,
                this.colaNivel2AndyTextField,
                this.colaNivel3AndyTextField,
                this.colaRefuerzoAndyTextField,
                this.colaNivel1UsecheTextField,
                this.colaNivel2UsecheTextField,
                this.colaNivel3UsecheTextField,
                this.colaRefuerzoUsecheTextField, 
                this.Camp1,
                this.Camp2,
                this.Camp3,
                this.winner,
                this.Central,
                this.LOU,
                this.VELMA,
                this.OTRO, 
                this.serieJoseCombatiendo, 
                this.serieAndyCombatiendo, 
                this.serieUsecheCombatiendo, 
                this.serieGanadora,clip4,
                this.ataque1,
                this.ataque2,
                this.ataque3,
                this.vida1,
                this.vida2,
                this.vida3,
                this.Accion_1,
                this.Accion_2,
                this.Accion_3,
                this.DocumentacionIAJLabel
        );
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
           // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
           private void initComponents() {

                      jLabel58 = new javax.swing.JLabel();
                      serieJoseCombatiendo1 = new javax.swing.JLabel();
                      DocumentacionIAJLabel = new javax.swing.JLabel();
                      jLabel57 = new javax.swing.JLabel();
                      jLabel49 = new javax.swing.JLabel();
                      Evaluacion = new javax.swing.JTextField();
                      tiempoSegundosTextField = new javax.swing.JTextField();
                      jPanel2 = new javax.swing.JPanel();
                      jLabel54 = new javax.swing.JLabel();
                      jLabel15 = new javax.swing.JLabel();
                      colaRefuerzoUsecheTextField = new javax.swing.JTextField();
                      jLabel16 = new javax.swing.JLabel();
                      jLabel17 = new javax.swing.JLabel();
                      jLabel18 = new javax.swing.JLabel();
                      colaNivel3UsecheTextField = new javax.swing.JTextField();
                      jLabel19 = new javax.swing.JLabel();
                      jLabel20 = new javax.swing.JLabel();
                      colaNivel2UsecheTextField = new javax.swing.JTextField();
                      jLabel21 = new javax.swing.JLabel();
                      jLabel22 = new javax.swing.JLabel();
                      jLabel23 = new javax.swing.JLabel();
                      colaNivel1UsecheTextField = new javax.swing.JTextField();
                      jLabel24 = new javax.swing.JLabel();
                      jLabel25 = new javax.swing.JLabel();
                      jLabel26 = new javax.swing.JLabel();
                      jLabel27 = new javax.swing.JLabel();
                      OTRO = new javax.swing.JLabel();
                      jLabel56 = new javax.swing.JLabel();
                      jLabel44 = new javax.swing.JLabel();
                      jLabel59 = new javax.swing.JLabel();
                      jPanel1 = new javax.swing.JPanel();
                      jLabel12 = new javax.swing.JLabel();
                      colaRefuerzoJoseTextField = new javax.swing.JTextField();
                      jLabel4 = new javax.swing.JLabel();
                      jLabel10 = new javax.swing.JLabel();
                      jLabel8 = new javax.swing.JLabel();
                      jLabel50 = new javax.swing.JLabel();
                      LOU = new javax.swing.JLabel();
                      colaNivel3JoseTextField = new javax.swing.JTextField();
                      jLabel11 = new javax.swing.JLabel();
                      jLabel3 = new javax.swing.JLabel();
                      colaNivel2JoseTextField = new javax.swing.JTextField();
                      jLabel9 = new javax.swing.JLabel();
                      jLabel1 = new javax.swing.JLabel();
                      jLabel13 = new javax.swing.JLabel();
                      colaNivel1JoseTextField = new javax.swing.JTextField();
                      jLabel14 = new javax.swing.JLabel();
                      jLabel6 = new javax.swing.JLabel();
                      jLabel5 = new javax.swing.JLabel();
                      jLabel7 = new javax.swing.JLabel();
                      jLabel45 = new javax.swing.JLabel();
                      jLabel51 = new javax.swing.JLabel();
                      jLabel62 = new javax.swing.JLabel();
                      jPanel3 = new javax.swing.JPanel();
                      jLabel28 = new javax.swing.JLabel();
                      colaRefuerzoAndyTextField = new javax.swing.JTextField();
                      jLabel29 = new javax.swing.JLabel();
                      jLabel30 = new javax.swing.JLabel();
                      jLabel31 = new javax.swing.JLabel();
                      colaNivel3AndyTextField = new javax.swing.JTextField();
                      jLabel32 = new javax.swing.JLabel();
                      jLabel33 = new javax.swing.JLabel();
                      colaNivel2AndyTextField = new javax.swing.JTextField();
                      jLabel34 = new javax.swing.JLabel();
                      jLabel35 = new javax.swing.JLabel();
                      jLabel36 = new javax.swing.JLabel();
                      colaNivel1AndyTextField = new javax.swing.JTextField();
                      jLabel37 = new javax.swing.JLabel();
                      jLabel55 = new javax.swing.JLabel();
                      jLabel38 = new javax.swing.JLabel();
                      jLabel39 = new javax.swing.JLabel();
                      jLabel40 = new javax.swing.JLabel();
                      VELMA = new javax.swing.JLabel();
                      jLabel46 = new javax.swing.JLabel();
                      jLabel53 = new javax.swing.JLabel();
                      botonEmpezar = new javax.swing.JButton();
                      jPanel4 = new javax.swing.JPanel();
                      Central = new javax.swing.JLabel();
                      serieGanadora = new javax.swing.JLabel();
                      winner = new javax.swing.JLabel();
                      vida2 = new javax.swing.JLabel();
                      ataque2 = new javax.swing.JLabel();
                      serieAndyCombatiendo = new javax.swing.JLabel();
                      jLabel47 = new javax.swing.JLabel();
                      serieJoseCombatiendo = new javax.swing.JLabel();
                      ataque3 = new javax.swing.JLabel();
                      vida3 = new javax.swing.JLabel();
                      serieUsecheCombatiendo = new javax.swing.JLabel();
                      ataque1 = new javax.swing.JLabel();
                      Camp2 = new javax.swing.JLabel();
                      vida1 = new javax.swing.JLabel();
                      Accion_3 = new javax.swing.JLabel();
                      Accion_2 = new javax.swing.JLabel();
                      Accion_1 = new javax.swing.JLabel();
                      Camp3 = new javax.swing.JLabel();
                      Camp1 = new javax.swing.JLabel();
                      jLabel48 = new javax.swing.JLabel();
                      botonParar = new javax.swing.JButton();
                      jLabel2 = new javax.swing.JLabel();
                      jLabel41 = new javax.swing.JLabel();
                      jLabel42 = new javax.swing.JLabel();
                      jLabel43 = new javax.swing.JLabel();
                      jLabel60 = new javax.swing.JLabel();
                      jLabel61 = new javax.swing.JLabel();

                      jLabel58.setText("jLabel58");

                      serieJoseCombatiendo1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                      serieJoseCombatiendo1.setForeground(new java.awt.Color(255, 255, 255));

                      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                      setResizable(false);
                      getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                      DocumentacionIAJLabel.setFont(new java.awt.Font("Hack NF", 1, 12)); // NOI18N
                      DocumentacionIAJLabel.setForeground(new java.awt.Color(255, 255, 255));
                      DocumentacionIAJLabel.setText("IA ESTA: ESPERANDO POR INSTRUCCIONES");
                      getContentPane().add(DocumentacionIAJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 340, 20));

                      jLabel57.setFont(new java.awt.Font("Hack NF", 1, 12)); // NOI18N
                      jLabel57.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel57.setText("Analisis (seg)");
                      getContentPane().add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

                      jLabel49.setFont(new java.awt.Font("Hack NF", 1, 12)); // NOI18N
                      jLabel49.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel49.setText("Ciclo (seg)");
                      getContentPane().add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

                      Evaluacion.setBackground(new java.awt.Color(204, 255, 255));
                      Evaluacion.setFont(new java.awt.Font("Yu Gothic Light", 1, 12)); // NOI18N
                      Evaluacion.setForeground(new java.awt.Color(0, 0, 0));
                      Evaluacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                      Evaluacion.setText("Tiempo Analisis (seg)");
                      Evaluacion.addFocusListener(new java.awt.event.FocusAdapter() {
                                 public void focusGained(java.awt.event.FocusEvent evt) {
                                            EvaluacionFocusGained(evt);
                                 }
                                 public void focusLost(java.awt.event.FocusEvent evt) {
                                            EvaluacionFocusLost(evt);
                                 }
                      });
                      Evaluacion.addActionListener(new java.awt.event.ActionListener() {
                                 public void actionPerformed(java.awt.event.ActionEvent evt) {
                                            EvaluacionActionPerformed(evt);
                                 }
                      });
                      getContentPane().add(Evaluacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 80, -1));

                      tiempoSegundosTextField.setBackground(new java.awt.Color(204, 255, 255));
                      tiempoSegundosTextField.setFont(new java.awt.Font("Yu Gothic Light", 1, 12)); // NOI18N
                      tiempoSegundosTextField.setForeground(new java.awt.Color(0, 0, 0));
                      tiempoSegundosTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                      tiempoSegundosTextField.setText("Tiempo (seg)");
                      tiempoSegundosTextField.addFocusListener(new java.awt.event.FocusAdapter() {
                                 public void focusGained(java.awt.event.FocusEvent evt) {
                                            tiempoSegundosTextFieldFocusGained(evt);
                                 }
                                 public void focusLost(java.awt.event.FocusEvent evt) {
                                            tiempoSegundosTextFieldFocusLost(evt);
                                 }
                      });
                      tiempoSegundosTextField.addActionListener(new java.awt.event.ActionListener() {
                                 public void actionPerformed(java.awt.event.ActionEvent evt) {
                                            tiempoSegundosTextFieldActionPerformed(evt);
                                 }
                      });
                      getContentPane().add(tiempoSegundosTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 90, -1));

                      jPanel2.setToolTipText("");
                      jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                      jLabel54.setText("jLabel54");
                      jPanel2.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, -1, -1));

                      jLabel15.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel15.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel15.setText("Head");
                      jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 30, -1));

                      colaRefuerzoUsecheTextField.setBackground(new java.awt.Color(204, 255, 255));
                      colaRefuerzoUsecheTextField.setFont(new java.awt.Font("Yu Gothic Light", 1, 12)); // NOI18N
                      colaRefuerzoUsecheTextField.setForeground(new java.awt.Color(0, 0, 0));
                      colaRefuerzoUsecheTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                      colaRefuerzoUsecheTextField.setEnabled(false);
                      jPanel2.add(colaRefuerzoUsecheTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 300, -1));

                      jLabel16.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel16.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel16.setText("Cola de Refuerzo");
                      jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

                      jLabel17.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel17.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel17.setText("Tail");
                      jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, -1, -1));

                      jLabel18.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel18.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel18.setText("Tail");
                      jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, -1, -1));

                      colaNivel3UsecheTextField.setBackground(new java.awt.Color(204, 255, 255));
                      colaNivel3UsecheTextField.setFont(new java.awt.Font("Yu Gothic Light", 1, 12)); // NOI18N
                      colaNivel3UsecheTextField.setForeground(new java.awt.Color(0, 0, 0));
                      colaNivel3UsecheTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                      colaNivel3UsecheTextField.setEnabled(false);
                      colaNivel3UsecheTextField.addActionListener(new java.awt.event.ActionListener() {
                                 public void actionPerformed(java.awt.event.ActionEvent evt) {
                                            colaNivel3UsecheTextFieldActionPerformed(evt);
                                 }
                      });
                      jPanel2.add(colaNivel3UsecheTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 300, -1));

                      jLabel19.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel19.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel19.setText("Head");
                      jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 30, -1));

                      jLabel20.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel20.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel20.setText("Cola de Nivel 3");
                      jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

                      colaNivel2UsecheTextField.setBackground(new java.awt.Color(204, 255, 255));
                      colaNivel2UsecheTextField.setFont(new java.awt.Font("Yu Gothic Light", 1, 12)); // NOI18N
                      colaNivel2UsecheTextField.setForeground(new java.awt.Color(0, 0, 0));
                      colaNivel2UsecheTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                      colaNivel2UsecheTextField.setEnabled(false);
                      jPanel2.add(colaNivel2UsecheTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 300, -1));

                      jLabel21.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel21.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel21.setText("Head");
                      jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 30, -1));

                      jLabel22.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel22.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel22.setText("Cola de Nivel 2");
                      jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

                      jLabel23.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel23.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel23.setText("Head");
                      jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 30, -1));

                      colaNivel1UsecheTextField.setBackground(new java.awt.Color(204, 255, 255));
                      colaNivel1UsecheTextField.setFont(new java.awt.Font("Yu Gothic Light", 1, 12)); // NOI18N
                      colaNivel1UsecheTextField.setForeground(new java.awt.Color(0, 0, 0));
                      colaNivel1UsecheTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                      colaNivel1UsecheTextField.setEnabled(false);
                      jPanel2.add(colaNivel1UsecheTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 300, -1));

                      jLabel24.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel24.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel24.setText("Cola de Nivel 1");
                      jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

                      jLabel25.setFont(new java.awt.Font("Hack NF", 1, 12)); // NOI18N
                      jLabel25.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel25.setText("Game of Thrones (3)");
                      jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, 20));

                      jLabel26.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel26.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel26.setText("Tail");
                      jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, -1));

                      jLabel27.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel27.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel27.setText("Tail");
                      jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, -1, -1));

                      OTRO.setBackground(new java.awt.Color(255, 255, 255));
                      OTRO.setForeground(new java.awt.Color(255, 255, 255));
                      OTRO.setText("jLabel50");
                      jPanel2.add(OTRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

                      jLabel56.setBackground(new java.awt.Color(255, 255, 255));
                      jLabel56.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel56.setText("ganadoras:");
                      jPanel2.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

                      jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LayoutBlue.png"))); // NOI18N
                      jPanel2.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 280));

                      jLabel59.setFont(new java.awt.Font("Hack NF", 1, 12)); // NOI18N
                      jLabel59.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel59.setText("Game of Thrones (3)");
                      jPanel2.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, 20));

                      getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 340, 380, 280));

                      jPanel1.setToolTipText("");
                      jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                      jLabel12.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel12.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel12.setText("Tail");
                      jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 30, -1));

                      colaRefuerzoJoseTextField.setBackground(new java.awt.Color(204, 255, 255));
                      colaRefuerzoJoseTextField.setFont(new java.awt.Font("Yu Gothic Light", 1, 12)); // NOI18N
                      colaRefuerzoJoseTextField.setForeground(new java.awt.Color(0, 0, 0));
                      colaRefuerzoJoseTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                      colaRefuerzoJoseTextField.setEnabled(false);
                      colaRefuerzoJoseTextField.addActionListener(new java.awt.event.ActionListener() {
                                 public void actionPerformed(java.awt.event.ActionEvent evt) {
                                            colaRefuerzoJoseTextFieldActionPerformed(evt);
                                 }
                      });
                      jPanel1.add(colaRefuerzoJoseTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 300, -1));

                      jLabel4.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel4.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel4.setText("Cola de Refuerzo");
                      jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

                      jLabel10.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel10.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel10.setText("Head");
                      jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, -1, -1));

                      jLabel8.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel8.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel8.setText("Head");
                      jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, -1, -1));

                      jLabel50.setBackground(new java.awt.Color(255, 255, 255));
                      jLabel50.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel50.setText("ganadoras:");
                      jPanel1.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

                      LOU.setBackground(new java.awt.Color(255, 255, 255));
                      LOU.setForeground(new java.awt.Color(255, 255, 255));
                      LOU.setText("jLabel50");
                      jPanel1.add(LOU, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

                      colaNivel3JoseTextField.setBackground(new java.awt.Color(204, 255, 255));
                      colaNivel3JoseTextField.setFont(new java.awt.Font("Yu Gothic Light", 1, 12)); // NOI18N
                      colaNivel3JoseTextField.setForeground(new java.awt.Color(0, 0, 0));
                      colaNivel3JoseTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                      colaNivel3JoseTextField.setEnabled(false);
                      jPanel1.add(colaNivel3JoseTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 300, -1));

                      jLabel11.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel11.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel11.setText("Tail");
                      jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 30, -1));

                      jLabel3.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel3.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel3.setText("Cola de Nivel 3");
                      jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

                      colaNivel2JoseTextField.setBackground(new java.awt.Color(204, 255, 255));
                      colaNivel2JoseTextField.setFont(new java.awt.Font("Yu Gothic Light", 1, 12)); // NOI18N
                      colaNivel2JoseTextField.setForeground(new java.awt.Color(0, 0, 0));
                      colaNivel2JoseTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                      colaNivel2JoseTextField.setEnabled(false);
                      jPanel1.add(colaNivel2JoseTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 300, -1));

                      jLabel9.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel9.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel9.setText("Tail");
                      jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 30, -1));

                      jLabel1.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel1.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel1.setText("Cola de Nivel 2");
                      jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

                      jLabel13.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel13.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel13.setText("Tail");
                      jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 30, -1));

                      colaNivel1JoseTextField.setBackground(new java.awt.Color(204, 255, 255));
                      colaNivel1JoseTextField.setFont(new java.awt.Font("Yu Gothic Light", 1, 12)); // NOI18N
                      colaNivel1JoseTextField.setForeground(new java.awt.Color(0, 0, 0));
                      colaNivel1JoseTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                      colaNivel1JoseTextField.setEnabled(false);
                      colaNivel1JoseTextField.addActionListener(new java.awt.event.ActionListener() {
                                 public void actionPerformed(java.awt.event.ActionEvent evt) {
                                            colaNivel1JoseTextFieldActionPerformed(evt);
                                 }
                      });
                      jPanel1.add(colaNivel1JoseTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 300, -1));

                      jLabel14.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel14.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel14.setText("Cola de Nivel 1");
                      jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

                      jLabel6.setFont(new java.awt.Font("Hack NF", 1, 12)); // NOI18N
                      jLabel6.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel6.setText("The Last Of US (1)");
                      jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

                      jLabel5.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel5.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel5.setText("Head");
                      jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

                      jLabel7.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel7.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel7.setText("Head");
                      jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, -1));

                      jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LayoutBlue.png"))); // NOI18N
                      jPanel1.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 280));

                      jLabel51.setBackground(new java.awt.Color(255, 255, 255));
                      jLabel51.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel51.setText("ganadoras:");
                      jPanel1.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

                      jLabel62.setFont(new java.awt.Font("Hack NF", 1, 12)); // NOI18N
                      jLabel62.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel62.setText("The Last Of US (1)");
                      jPanel1.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, 20));

                      getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 380, 280));

                      jPanel3.setToolTipText("");
                      jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                      jLabel28.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel28.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel28.setText("Tail");
                      jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 30, -1));

                      colaRefuerzoAndyTextField.setBackground(new java.awt.Color(204, 255, 255));
                      colaRefuerzoAndyTextField.setFont(new java.awt.Font("Yu Gothic Light", 1, 12)); // NOI18N
                      colaRefuerzoAndyTextField.setForeground(new java.awt.Color(0, 0, 0));
                      colaRefuerzoAndyTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                      colaRefuerzoAndyTextField.setEnabled(false);
                      jPanel3.add(colaRefuerzoAndyTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 300, -1));

                      jLabel29.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel29.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel29.setText("Cola de Refuerzo");
                      jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

                      jLabel30.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel30.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel30.setText("Head");
                      jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, -1, -1));

                      jLabel31.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel31.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel31.setText("Head");
                      jPanel3.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, -1, -1));

                      colaNivel3AndyTextField.setBackground(new java.awt.Color(204, 255, 255));
                      colaNivel3AndyTextField.setFont(new java.awt.Font("Yu Gothic Light", 1, 12)); // NOI18N
                      colaNivel3AndyTextField.setForeground(new java.awt.Color(0, 0, 0));
                      colaNivel3AndyTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                      colaNivel3AndyTextField.setEnabled(false);
                      jPanel3.add(colaNivel3AndyTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 300, -1));

                      jLabel32.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel32.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel32.setText("Tail");
                      jPanel3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 30, -1));

                      jLabel33.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel33.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel33.setText("Cola de Nivel 3");
                      jPanel3.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

                      colaNivel2AndyTextField.setBackground(new java.awt.Color(204, 255, 255));
                      colaNivel2AndyTextField.setFont(new java.awt.Font("Yu Gothic Light", 1, 12)); // NOI18N
                      colaNivel2AndyTextField.setForeground(new java.awt.Color(0, 0, 0));
                      colaNivel2AndyTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                      colaNivel2AndyTextField.setEnabled(false);
                      jPanel3.add(colaNivel2AndyTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 300, -1));

                      jLabel34.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel34.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel34.setText("Tail");
                      jPanel3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 30, -1));

                      jLabel35.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel35.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel35.setText("Cola de Nivel 2");
                      jPanel3.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

                      jLabel36.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel36.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel36.setText("Tail");
                      jPanel3.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 30, -1));

                      colaNivel1AndyTextField.setBackground(new java.awt.Color(204, 255, 255));
                      colaNivel1AndyTextField.setFont(new java.awt.Font("Yu Gothic Light", 1, 12)); // NOI18N
                      colaNivel1AndyTextField.setForeground(new java.awt.Color(0, 0, 0));
                      colaNivel1AndyTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                      colaNivel1AndyTextField.setEnabled(false);
                      colaNivel1AndyTextField.addActionListener(new java.awt.event.ActionListener() {
                                 public void actionPerformed(java.awt.event.ActionEvent evt) {
                                            colaNivel1AndyTextFieldActionPerformed(evt);
                                 }
                      });
                      jPanel3.add(colaNivel1AndyTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 300, -1));

                      jLabel37.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel37.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel37.setText("Cola de Nivel 1");
                      jPanel3.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

                      jLabel55.setBackground(new java.awt.Color(255, 255, 255));
                      jLabel55.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel55.setText("ganadoras:");
                      jPanel3.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

                      jLabel38.setFont(new java.awt.Font("Hack NF", 1, 12)); // NOI18N
                      jLabel38.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel38.setText("VELMA (2)");
                      jPanel3.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

                      jLabel39.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel39.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel39.setText("Head");
                      jPanel3.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

                      jLabel40.setFont(new java.awt.Font("Elephant", 1, 10)); // NOI18N
                      jLabel40.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel40.setText("Head");
                      jPanel3.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, -1));

                      VELMA.setBackground(new java.awt.Color(255, 255, 255));
                      VELMA.setForeground(new java.awt.Color(255, 255, 255));
                      VELMA.setText("jLabel50");
                      jPanel3.add(VELMA, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

                      jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LayoutBlue.png"))); // NOI18N
                      jPanel3.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 280));

                      jLabel53.setText("jLabel53");
                      jPanel3.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

                      getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, 380, 280));

                      botonEmpezar.setBackground(new java.awt.Color(0, 0, 204));
                      botonEmpezar.setForeground(new java.awt.Color(255, 255, 255));
                      botonEmpezar.setText("Empezar");
                      botonEmpezar.addActionListener(new java.awt.event.ActionListener() {
                                 public void actionPerformed(java.awt.event.ActionEvent evt) {
                                            botonEmpezarActionPerformed(evt);
                                 }
                      });
                      getContentPane().add(botonEmpezar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

                      jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                      Central.setBackground(new java.awt.Color(204, 204, 204));
                      Central.setFont(new java.awt.Font("Hack NF", 1, 48)); // NOI18N
                      Central.setForeground(new java.awt.Color(255, 51, 51));
                      Central.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                      Central.setText("jLabel50");
                      jPanel4.add(Central, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 120, 1250, -1));

                      serieGanadora.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                      serieGanadora.setForeground(new java.awt.Color(255, 255, 255));
                      jPanel4.add(serieGanadora, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 380, 20));

                      winner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/chill.gif"))); // NOI18N
                      jPanel4.add(winner, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, -1, 270));

                      vida2.setBackground(new java.awt.Color(255, 255, 255));
                      vida2.setForeground(new java.awt.Color(255, 255, 255));
                      vida2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vidas.png"))); // NOI18N
                      vida2.setText("100");
                      jPanel4.add(vida2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, -1, -1));

                      ataque2.setBackground(new java.awt.Color(255, 255, 255));
                      ataque2.setForeground(new java.awt.Color(255, 255, 255));
                      ataque2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/espada.png"))); // NOI18N
                      ataque2.setText("100");
                      ataque2.setAutoscrolls(true);
                      jPanel4.add(ataque2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, -1, -1));

                      serieAndyCombatiendo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                      serieAndyCombatiendo.setForeground(new java.awt.Color(255, 255, 255));
                      jPanel4.add(serieAndyCombatiendo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 250, 40));

                      jLabel47.setFont(new java.awt.Font("Hack NF", 1, 24)); // NOI18N
                      jLabel47.setForeground(new java.awt.Color(255, 255, 255));
                      jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                      jLabel47.setText("ZONA DE BATALLA");
                      jPanel4.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 10, 1250, -1));

                      serieJoseCombatiendo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                      serieJoseCombatiendo.setForeground(new java.awt.Color(255, 255, 255));
                      jPanel4.add(serieJoseCombatiendo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 200, 30));

                      ataque3.setBackground(new java.awt.Color(255, 255, 255));
                      ataque3.setForeground(new java.awt.Color(255, 255, 255));
                      ataque3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/espada.png"))); // NOI18N
                      ataque3.setText("100");
                      ataque3.setAutoscrolls(true);
                      jPanel4.add(ataque3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 220, -1, -1));

                      vida3.setBackground(new java.awt.Color(255, 255, 255));
                      vida3.setForeground(new java.awt.Color(255, 255, 255));
                      vida3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vidas.png"))); // NOI18N
                      vida3.setText("100");
                      jPanel4.add(vida3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 270, -1, -1));

                      serieUsecheCombatiendo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                      serieUsecheCombatiendo.setForeground(new java.awt.Color(255, 255, 255));
                      jPanel4.add(serieUsecheCombatiendo, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 190, 30));

                      ataque1.setBackground(new java.awt.Color(255, 255, 255));
                      ataque1.setForeground(new java.awt.Color(255, 255, 255));
                      ataque1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/espada.png"))); // NOI18N
                      ataque1.setText("100");
                      ataque1.setAutoscrolls(true);
                      jPanel4.add(ataque1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, -1, -1));

                      Camp2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/10.gif"))); // NOI18N
                      jPanel4.add(Camp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, -1, -1));

                      vida1.setBackground(new java.awt.Color(255, 255, 255));
                      vida1.setForeground(new java.awt.Color(255, 255, 255));
                      vida1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vidas.png"))); // NOI18N
                      vida1.setText("100");
                      jPanel4.add(vida1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, -1, -1));

                      Accion_3.setBackground(new java.awt.Color(255, 255, 255));
                      Accion_3.setFont(new java.awt.Font("Matura MT Script Capitals", 1, 24)); // NOI18N
                      Accion_3.setForeground(new java.awt.Color(255, 204, 51));
                      Accion_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                      jPanel4.add(Accion_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, 200, 50));

                      Accion_2.setBackground(new java.awt.Color(255, 255, 255));
                      Accion_2.setFont(new java.awt.Font("Matura MT Script Capitals", 1, 24)); // NOI18N
                      Accion_2.setForeground(new java.awt.Color(255, 204, 51));
                      Accion_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                      jPanel4.add(Accion_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 230, 50));

                      Accion_1.setBackground(new java.awt.Color(255, 255, 255));
                      Accion_1.setFont(new java.awt.Font("Matura MT Script Capitals", 1, 24)); // NOI18N
                      Accion_1.setForeground(new java.awt.Color(255, 204, 51));
                      Accion_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                      jPanel4.add(Accion_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 220, 50));

                      Camp3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/9.gif"))); // NOI18N
                      jPanel4.add(Camp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 40, -1, -1));

                      Camp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/6.gif"))); // NOI18N
                      jPanel4.add(Camp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 360, 250));

                      jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LayoutBlue.png"))); // NOI18N
                      jPanel4.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 320));

                      getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 1060, 320));

                      botonParar.setBackground(new java.awt.Color(0, 0, 204));
                      botonParar.setForeground(new java.awt.Color(255, 255, 255));
                      botonParar.setText("Parar");
                      botonParar.addActionListener(new java.awt.event.ActionListener() {
                                 public void actionPerformed(java.awt.event.ActionEvent evt) {
                                            botonPararActionPerformed(evt);
                                 }
                      });
                      getContentPane().add(botonParar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 230, -1, -1));

                      jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LayoutBlue.png"))); // NOI18N
                      getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1230, 590));

                      jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LayoutBlue.png"))); // NOI18N
                      getContentPane().add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 1230, 590));

                      jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LayoutBlue.png"))); // NOI18N
                      getContentPane().add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 590));

                      jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LayoutBlue.png"))); // NOI18N
                      getContentPane().add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 1230, 590));

                      jLabel60.setText("jLabel60");
                      getContentPane().add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

                      jLabel61.setText("jLabel61");
                      getContentPane().add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

                      pack();
           }// </editor-fold>//GEN-END:initComponents

    private void tiempoSegundosTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiempoSegundosTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tiempoSegundosTextFieldActionPerformed

    private void tiempoSegundosTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tiempoSegundosTextFieldFocusGained
        if(this.tiempoSegundosTextField.getText().equals("Tiempo (seg)")){
            this.tiempoSegundosTextField.setText("");
            this.tiempoSegundosTextField.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_tiempoSegundosTextFieldFocusGained

    private void tiempoSegundosTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tiempoSegundosTextFieldFocusLost
        if(this.tiempoSegundosTextField.getText().equals("")){
            this.tiempoSegundosTextField.setText("Tiempo (seg)");
            this.tiempoSegundosTextField.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_tiempoSegundosTextFieldFocusLost

    private void colaNivel1JoseTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colaNivel1JoseTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_colaNivel1JoseTextFieldActionPerformed

    private void colaNivel1AndyTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colaNivel1AndyTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_colaNivel1AndyTextFieldActionPerformed

    private void colaRefuerzoJoseTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colaRefuerzoJoseTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_colaRefuerzoJoseTextFieldActionPerformed

    private void colaNivel3UsecheTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colaNivel3UsecheTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_colaNivel3UsecheTextFieldActionPerformed

    private void botonEmpezarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEmpezarActionPerformed
        
        this.clip.stop();
        this.clip2.stop();
        clip4.loop(Clip.LOOP_CONTINUOUSLY);
        this.botonEmpezar.setEnabled(false);
        this.botonParar.setEnabled(true);
        
        try{
            
            int tiempo;
            
            try{
                tiempo = Integer.parseInt(tiempoSegundosTextField.getText());
                
                if(tiempo < 0){
                    tiempo = 0;
                    this.tiempoSegundosTextField.setText("0");
                }
                
                
            }catch(Exception e){
                
                tiempo = 0;
                this.tiempoSegundosTextField.setText("0");
            }
                        
            
            admin.setCiclo(tiempo);
            
            
            if(admin.isKeep()==false){
                admin = new Administrador(this.colaNivel1JoseTextField, 
                        this.colaNivel2JoseTextField, 
                        this.colaNivel3JoseTextField, 
                        this.colaRefuerzoJoseTextField, 
                        this.colaNivel1AndyTextField, 
                        this.colaNivel2AndyTextField,
                        this.colaNivel3AndyTextField,
                        this.colaRefuerzoAndyTextField,
                        this.colaNivel1UsecheTextField,
                        this.colaNivel2UsecheTextField,
                        this.colaNivel3UsecheTextField,
                        this.colaRefuerzoUsecheTextField, 
                        this.Camp1,
                        this.Camp2,
                        this.Camp3,
                        this.winner, 
                        this.Central,
                        this.LOU,
                        this.VELMA,
                        this.OTRO, 
                        this.serieJoseCombatiendo, 
                        this.serieAndyCombatiendo, 
                        this.serieUsecheCombatiendo, 
                        this.serieGanadora,
                        this.clip4,
                        this.ataque1,
                this.ataque2,
                this.ataque3,
                this.vida1,
                this.vida2,
                this.vida3,
                this.Accion_1,
                this.Accion_2,
                this.Accion_3,
                this.DocumentacionIAJLabel);
            }
            
            try{
                
                
                int evaluacion = Integer.parseInt(this.Evaluacion.getText());
                
                if(evaluacion >= 0){
                    
                    variablesGenerales.tiempoAnalisisSegundos= evaluacion;
                }else{
                    this.Evaluacion.setText("22");
                    variablesGenerales.tiempoAnalisisSegundos = 22;
                }
                
                
            }catch(Exception e){
                
                    this.Evaluacion.setText("22");
                    variablesGenerales.tiempoAnalisisSegundos = 22;
                
            }
            
            admin.setKeep(true);
            admin.setCiclo(tiempo);
            admin.start();
            
            
            
            
            this.Evaluacion.setForeground(new Color(0, 0, 0));
            this.tiempoSegundosTextField.setForeground(new Color(0, 0, 0));
            this.tiempoSegundosTextField.setEditable(false);
            this.Evaluacion.setEditable(false);
        }
        catch(Exception e){
            System.out.print("Error");
            this.botonEmpezar.setEnabled(true);
            this.Central.setText("ERROR");
            this.clip4.stop();
        }
        
        
  
    }//GEN-LAST:event_botonEmpezarActionPerformed

    private void botonPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPararActionPerformed
        
        
        admin.setKeep(false);
        this.clip4.stop();
        clip2.loop(Clip.LOOP_CONTINUOUSLY);
        this.botonEmpezar.setEnabled(true);
        this.Camp1.setIcon(null);
        this.Camp2.setIcon(null);
        this.Camp3.setIcon(null);
        this.Central.setText("");
        ImageIcon giftInicio = new ImageIcon(getClass().getResource("/Imagenes/chill.gif"));
        this.winner.setIcon(giftInicio);
        this.winner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        try {
            Thread.sleep(2000);
            this.clip4.stop();
            clip2.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (InterruptedException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        admin.setKeep(false);
        this.botonEmpezar.setEnabled(true);
        this.Camp1.setIcon(null);
        this.Camp2.setIcon(null);
        this.Camp3.setIcon(null);
        this.Central.setText("");
        this.winner.setIcon(giftInicio);
        this.winner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        this.DocumentacionIAJLabel.setText("IA ESTA: ESPERANDO POR INSTRUCCIONES");
        this.tiempoSegundosTextField.setEditable(true);
        this.Evaluacion.setEditable(true);
        
    }//GEN-LAST:event_botonPararActionPerformed

    private void EvaluacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EvaluacionFocusGained
        
        if(this.Evaluacion.getText().equals("Tiempo Analisis (seg)")){
            this.Evaluacion.setText("");
            this.Evaluacion.setForeground(new Color(0, 0, 0));
        }
        
    }//GEN-LAST:event_EvaluacionFocusGained

    private void EvaluacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EvaluacionFocusLost
        
        if(this.Evaluacion.getText().equals("")){
            this.Evaluacion.setText("Tiempo Analisis (seg)");
            this.Evaluacion.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_EvaluacionFocusLost

    private void EvaluacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EvaluacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EvaluacionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Interfaz().setVisible(true);
                } catch (UnsupportedAudioFileException ex) {
                    Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

           // Variables declaration - do not modify//GEN-BEGIN:variables
           private javax.swing.JLabel Accion_1;
           private javax.swing.JLabel Accion_2;
           private javax.swing.JLabel Accion_3;
           private javax.swing.JLabel Camp1;
           private javax.swing.JLabel Camp2;
           private javax.swing.JLabel Camp3;
           private javax.swing.JLabel Central;
           private javax.swing.JLabel DocumentacionIAJLabel;
           private javax.swing.JTextField Evaluacion;
           private javax.swing.JLabel LOU;
           private javax.swing.JLabel OTRO;
           private javax.swing.JLabel VELMA;
           private javax.swing.JLabel ataque1;
           private javax.swing.JLabel ataque2;
           private javax.swing.JLabel ataque3;
           private javax.swing.JButton botonEmpezar;
           private javax.swing.JButton botonParar;
           private javax.swing.JTextField colaNivel1AndyTextField;
           private javax.swing.JTextField colaNivel1JoseTextField;
           private javax.swing.JTextField colaNivel1UsecheTextField;
           private javax.swing.JTextField colaNivel2AndyTextField;
           private javax.swing.JTextField colaNivel2JoseTextField;
           private javax.swing.JTextField colaNivel2UsecheTextField;
           private javax.swing.JTextField colaNivel3AndyTextField;
           private javax.swing.JTextField colaNivel3JoseTextField;
           private javax.swing.JTextField colaNivel3UsecheTextField;
           private javax.swing.JTextField colaRefuerzoAndyTextField;
           private javax.swing.JTextField colaRefuerzoJoseTextField;
           private javax.swing.JTextField colaRefuerzoUsecheTextField;
           private javax.swing.JLabel jLabel1;
           private javax.swing.JLabel jLabel10;
           private javax.swing.JLabel jLabel11;
           private javax.swing.JLabel jLabel12;
           private javax.swing.JLabel jLabel13;
           private javax.swing.JLabel jLabel14;
           private javax.swing.JLabel jLabel15;
           private javax.swing.JLabel jLabel16;
           private javax.swing.JLabel jLabel17;
           private javax.swing.JLabel jLabel18;
           private javax.swing.JLabel jLabel19;
           private javax.swing.JLabel jLabel2;
           private javax.swing.JLabel jLabel20;
           private javax.swing.JLabel jLabel21;
           private javax.swing.JLabel jLabel22;
           private javax.swing.JLabel jLabel23;
           private javax.swing.JLabel jLabel24;
           private javax.swing.JLabel jLabel25;
           private javax.swing.JLabel jLabel26;
           private javax.swing.JLabel jLabel27;
           private javax.swing.JLabel jLabel28;
           private javax.swing.JLabel jLabel29;
           private javax.swing.JLabel jLabel3;
           private javax.swing.JLabel jLabel30;
           private javax.swing.JLabel jLabel31;
           private javax.swing.JLabel jLabel32;
           private javax.swing.JLabel jLabel33;
           private javax.swing.JLabel jLabel34;
           private javax.swing.JLabel jLabel35;
           private javax.swing.JLabel jLabel36;
           private javax.swing.JLabel jLabel37;
           private javax.swing.JLabel jLabel38;
           private javax.swing.JLabel jLabel39;
           private javax.swing.JLabel jLabel4;
           private javax.swing.JLabel jLabel40;
           private javax.swing.JLabel jLabel41;
           private javax.swing.JLabel jLabel42;
           private javax.swing.JLabel jLabel43;
           private javax.swing.JLabel jLabel44;
           private javax.swing.JLabel jLabel45;
           private javax.swing.JLabel jLabel46;
           private javax.swing.JLabel jLabel47;
           private javax.swing.JLabel jLabel48;
           private javax.swing.JLabel jLabel49;
           private javax.swing.JLabel jLabel5;
           private javax.swing.JLabel jLabel50;
           private javax.swing.JLabel jLabel51;
           private javax.swing.JLabel jLabel53;
           private javax.swing.JLabel jLabel54;
           private javax.swing.JLabel jLabel55;
           private javax.swing.JLabel jLabel56;
           private javax.swing.JLabel jLabel57;
           private javax.swing.JLabel jLabel58;
           private javax.swing.JLabel jLabel59;
           private javax.swing.JLabel jLabel6;
           private javax.swing.JLabel jLabel60;
           private javax.swing.JLabel jLabel61;
           private javax.swing.JLabel jLabel62;
           private javax.swing.JLabel jLabel7;
           private javax.swing.JLabel jLabel8;
           private javax.swing.JLabel jLabel9;
           private javax.swing.JPanel jPanel1;
           private javax.swing.JPanel jPanel2;
           private javax.swing.JPanel jPanel3;
           private javax.swing.JPanel jPanel4;
           private javax.swing.JLabel serieAndyCombatiendo;
           private javax.swing.JLabel serieGanadora;
           private javax.swing.JLabel serieJoseCombatiendo;
           private javax.swing.JLabel serieJoseCombatiendo1;
           private javax.swing.JLabel serieUsecheCombatiendo;
           private javax.swing.JTextField tiempoSegundosTextField;
           private javax.swing.JLabel vida1;
           private javax.swing.JLabel vida2;
           private javax.swing.JLabel vida3;
           private javax.swing.JLabel winner;
           // End of variables declaration//GEN-END:variables
}
