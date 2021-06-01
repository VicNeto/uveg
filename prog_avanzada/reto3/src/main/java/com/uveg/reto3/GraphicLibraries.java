/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uveg.reto3;

import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
/**
 *
 * @author vgutierrez
 */
public class GraphicLibraries extends JFrame implements MouseListener {
    private JButton windows;
    private JButton metal;
    private JButton motif;
    
    public GraphicLibraries() {
        setTitle("Look And Feels");
        windows = new JButton("Nimbus");
        windows.addMouseListener(this);
        metal = new JButton("Metal");
        metal.addMouseListener(this);
        motif = new JButton("Motif");
        motif.addMouseListener(this);
        // setLayout(new FlowLayout());
        add(windows);
        add(metal);
        add(motif);
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        String LAF;
        if(me.getSource() == windows)
            LAF = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
        else if(me.getSource() == metal)
            LAF = "javax.swing.plaf.metal.MetalLookAndFeel";
        else
            LAF = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
        try {
            UIManager.setLookAndFeel(LAF);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            System.out.println("Error setting the LAF..." + e);
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
