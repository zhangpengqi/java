package com.example.shape;

import com.example.contract.Sprite;
import com.example.main.Game;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * 圆
 */
public class Circle extends Sprite {

    public int r;

    //构造方法不会继承，得自己写一个
    public Circle(int x, int y, int vx, int vy, int r) {
        super(x, y, vx, vy);
        this.r = r;
    }

    public void show(Graphics2D g2d) {
        Ellipse2D circle = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
        g2d.draw(circle);
    }

    public void update() {
        super.update();

        collision(0, 0,
                Game.getInstance().getCanvasWidth(),
                Game.getInstance().getCanvasHeight());
    }

    /**
     * 碰撞检测
     */
    private void collision(int minX, int minY, int maxX, int maxY) {
        if (x - r < minX) {     // 所在位置的x值，减去半径，最小值，说明已到达最左边
            x = r;              // 贴着左边
            vx = -vx;           // 速度取反
        }

        if (x + r > maxX) {
            x = maxX - r;
            vx = -vx;
        }

        if (y - r < minY) {
            y = r;
            vy = -vy;
        }

        if (y + r > maxY) {
            y = maxY - r;
            vy = -vy;
        }
    }
}
