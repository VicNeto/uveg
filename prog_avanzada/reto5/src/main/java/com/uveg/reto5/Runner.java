/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uveg.reto5;

import java.util.Random;

/**
 *
 * @author vgutierrez
 */
public class Runner {
    private String name;
    private int speed;

    Runner(String name) {
        this.name = name;
        Random random = new Random();
        this.speed = random.nextInt(30);
    }

    public String getName() {
        return this.name;
    }

    public int getSpeed() {
        return this.speed;
    }
}
