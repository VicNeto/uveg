/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uveg.reto1;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseListener;
/**
 *
 * @author vgutierrez
 */
public class EventButton extends JFrame implements MouseListener {
    private JTextField resultField;
    private JButton num0;
    private JButton num1;
    private JButton num2;
    private JButton num3;
    private JButton num4;
    private JButton num5;
    private JButton num6;
    private JButton num7;
    private JButton num8;
    private JButton num9;
    private JButton add;
    private JButton sub;
    private JButton mult;
    private JButton div;
    private JButton calc;
    private JButton clear;
    public String currentValue;
    public float result;
    public float firstValue;
    public float secondValue;
    public char operator;
    
    public EventButton() {
        setTitle("Calculadora");
        setSize(355, 450);
        setLayout(null);
        setLocationRelativeTo(null);

        currentValue = "";
        result = 0;
        
        resultField = new JTextField();
        resultField.setBounds(10, 10, 335, 50);
        
        num1 =  new JButton("1");
        num1.setBounds(10, 70, 80, 80);
        num2 =  new JButton("2");
        num2.setBounds(95, 70, 80, 80);
        num3 =  new JButton("3");
        num3.setBounds(180, 70, 80, 80);
        num4 =  new JButton("4");
        num4.setBounds(10, 155, 80, 80);
        num5 =  new JButton("5");
        num5.setBounds(95, 155, 80, 80);
        num6 =  new JButton("6");
        num6.setBounds(180, 155, 80, 80);
        num7 =  new JButton("7");
        num7.setBounds(10, 240, 80, 80);
        num8 =  new JButton("8");
        num8.setBounds(95, 240, 80, 80);
        num9 =  new JButton("9");
        num9.setBounds(180, 240, 80, 80);
        num0 =  new JButton("0");
        num0.setBounds(95, 325, 80, 80);
        add = new JButton("+");
        add.setBounds(265, 70, 80, 80);
        sub = new JButton("-");
        sub.setBounds(265, 155, 80, 80);
        mult = new JButton("*");
        mult.setBounds(265, 240, 80, 80);
        div = new JButton("/");
        div.setBounds(265, 325, 80, 80);
        calc = new JButton("=");
        calc.setBounds(10, 325, 80, 80);
        clear = new JButton("C");
        clear.setBounds(180, 325, 80, 80);

        num1.addMouseListener(this);
        num2.addMouseListener(this);
        num3.addMouseListener(this);
        num4.addMouseListener(this);
        num5.addMouseListener(this);
        num6.addMouseListener(this);
        num7.addMouseListener(this);
        num8.addMouseListener(this);
        num9.addMouseListener(this);
        num0.addMouseListener(this);
        add.addMouseListener(this);
        sub.addMouseListener(this);
        mult.addMouseListener(this);
        div.addMouseListener(this);
        clear.addMouseListener(this);
        calc.addMouseListener(this);
        
        getContentPane().add(resultField);
        getContentPane().add(num1);
        getContentPane().add(num2);
        getContentPane().add(num3);
        getContentPane().add(num4);
        getContentPane().add(num5);
        getContentPane().add(num6);
        getContentPane().add(num7);
        getContentPane().add(num8);
        getContentPane().add(num9);
        getContentPane().add(num0);
        getContentPane().add(add);
        getContentPane().add(sub);
        getContentPane().add(mult);
        getContentPane().add(div);
        getContentPane().add(calc);
        getContentPane().add(clear);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        char tmp = this.getCharacter(me);
        if (Character.isDigit(tmp)) {
            if (currentValue.length() > 0 && !Character.isDigit(currentValue.charAt(0))) {
                currentValue = "";
            }
            currentValue+=tmp;
        } else if (tmp == 'c') {
            currentValue = "";
        } else if (tmp == '+' || tmp =='-' || tmp == '*' || tmp == '/') {
            firstValue = Float.parseFloat(currentValue);
            operator = tmp;
            currentValue = String.valueOf(tmp);
        } else if (tmp == '=') {
            try {
                secondValue = Float.parseFloat(currentValue);
                this.calculate();
                currentValue = String.valueOf(result);
            } catch (Exception e) {
                currentValue = "";
                System.out.println(e);
            }
        }
        resultField.setText(currentValue);
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

    public void calculate() {
        if (operator == '+') {
            result = firstValue + secondValue;
        }
        if (operator == '-') {
            result = firstValue - secondValue;
        }
        if (operator == '*') {
            result = firstValue * secondValue;
        }
        if (operator == '/') {
            result = firstValue / secondValue;
        }
    }

    public char getCharacter(MouseEvent me) {
        if (me.getSource() == num0) {
            return '0';
        }
        if (me.getSource() == num1) {
            return '1';
        }
        if (me.getSource() == num2) {
            return '2';
        }
        if (me.getSource() == num3) {
            return '3';
        }
        if (me.getSource() == num4) {
            return '4';
        }
        if (me.getSource() == num5) {
            return '5';
        }
        if (me.getSource() == num6) {
            return '6';
        }
        if (me.getSource() == num7) {
            return '7';
        }
        if (me.getSource() == num8) {
            return '8';
        }
        if (me.getSource() == num9) {
            return '9';
        }
        if (me.getSource() == add) {
            return '+';
        }
        if (me.getSource() == sub) {
            return '-';
        }
        if (me.getSource() == mult) {
            return '*';
        }
        if (me.getSource() == div) {
            return '/';
        }
        if (me.getSource() == calc) {
            return '=';
        }
        return 'c';
    }
}
