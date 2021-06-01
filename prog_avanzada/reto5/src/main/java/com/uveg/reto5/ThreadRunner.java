/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uveg.reto5;

import javax.swing.JTextArea;
/**
 *
 * @author vgutierrez
 */
public class ThreadRunner extends Thread {
    private Runner runner;
    private JTextArea textArea;
    static private boolean emptyLine = true;

    ThreadRunner(Runner runner, JTextArea textArea) {
        this.runner = runner;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        try {
            ThreadRunner.sleep(this.runner.getSpeed() * 1000);
            String newtext = this.textArea.getText();
            newtext += this.countLines() + " - " + this.runner.getName() + " - Tiempo: " + String.valueOf(this.runner.getSpeed()) + " segundos\n";
            this.textArea.setText(newtext);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private String countLines() {
        String[] lines = this.textArea.getText().split("[\n|\r]");
        int amount = lines.length;
        if (!emptyLine) {
            amount++;
        } else {
            emptyLine = false;
        }
        return String.valueOf(amount);
    }
}
