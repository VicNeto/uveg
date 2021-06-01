/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uveg.reto5;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author vgutierrez
 */
public class AthleticRaceInterface extends JFrame implements MouseListener {
    public JTextField newRunner;
    public JTextArea runnerRegistered;
    public JTextArea results;
    public JButton register;
    public JButton init;
    public JButton restart;
    public JButton end;
    public JLabel registryLabel;
    public JLabel registeredLabel;
    public JLabel resultsLabel;
    private Runner [] runners;
    private int runnersCount;
    
    public AthleticRaceInterface () {
        setTitle("Carrera atletica");
        setSize(480, 520);
        setLayout(null);
        setLocationRelativeTo(null);
        // Runners
        this.runners = new Runner[5];
        this.runnersCount = 0;
        
        // Registry layout
        registryLabel = new JLabel("Registrar corredor");
        registryLabel.setBounds(10, 10, 200, 30);
        newRunner = new JTextField();
        newRunner.setBounds(10, 40, 200, 30);
        register = new JButton("Registrar");
        register.setBounds(240, 40, 200, 30);
        
        // Registered runners layout
        registeredLabel = new JLabel("Corredores registrados");
        registeredLabel.setBounds(10, 80, 200, 20);
        runnerRegistered = new JTextArea();
        runnerRegistered.setBounds(10, 110, 430, 180);
        
        // Results layout
        resultsLabel = new JLabel("Resultados");
        resultsLabel.setBounds(10, 310, 200, 20);
        results = new JTextArea();
        results.setBounds(10, 340, 260, 130);
        init = new JButton("Iniciar");
        init.setBounds(280, 340, 160, 30);
        restart = new JButton("Reiniciar");
        restart.setBounds(280, 390, 160, 30);
        end = new JButton("Terminar");
        end.setBounds(280, 440, 160, 30);

        // Listener buttons
        register.addMouseListener(this);
        init.addMouseListener(this);
        restart.addMouseListener(this);
        end.addMouseListener(this);
        
        getContentPane().add(registryLabel);
        getContentPane().add(newRunner);
        getContentPane().add(register);
        getContentPane().add(registeredLabel);
        getContentPane().add(runnerRegistered);
        getContentPane().add(resultsLabel);
        getContentPane().add(results);
        getContentPane().add(init);
        getContentPane().add(restart);
        getContentPane().add(end);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void registerRunner(MouseEvent me) {
        if (this.runnersCount < 5) {
            String runnerName = this.newRunner.getText();
            String regex = "\\w+";
            Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
            Matcher matcher = pattern.matcher(runnerName);
            
            if (matcher.find()) {
                this.newRunner.setText("");
                this.runners[this.runnersCount] = new Runner(runnerName);
                this.runnersCount++;
                String areaText = "";
                for (int i = 0; i < this.runnersCount; i++) {
                    areaText += String.valueOf(i+1) + " - " + this.runners[i].getName() + "\n";
                }
                this.runnerRegistered.setText(areaText);
            } else {
                JOptionPane.showMessageDialog(this,
                    "Nombre vacio no permitido",
                    "Name error",
                    JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Numero máximo de corredores alcanzado",
                    "Runners error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void runRace(MouseEvent me) {
        this.results.setText("");
        if (this.runnersCount == 5) {
            ThreadRunner[] runnersThreads = new ThreadRunner[5];
            for (int i=0; i < this.runnersCount; i++) {
                runnersThreads[i] = new ThreadRunner(this.runners[i], this.results);
                runnersThreads[i].start();
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Faltan corredores por registrar",
                    "Runners error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clean(MouseEvent me) {
        this.runnersCount = 0;
        this.runners = new Runner[5];
        this.runnerRegistered.setText("");
        this.results.setText("");
        this.newRunner.setText("");
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == this.register) {
            this.registerRunner(me);
        } else if (me.getSource() == this.init) {
            this.runRace(me);
        } else if (me.getSource() == this.restart) {
            this.clean(me);
        } else if (me.getSource() == this.end) {
            System.exit(0);
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
