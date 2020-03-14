package com.example.contract;

import java.awt.*;

/**
 * 精灵类
 */
public abstract class Sprite {

    public int x;
    public int y;
    public int vx;
    public int vy;

    public int hp = 100;
    public int age = 1;

    public Sprite(int x, int y, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    public abstract void show(Graphics2D g2d);


    public void update() {
        x += vx;
        y += vy;

        age++;
    }

}
