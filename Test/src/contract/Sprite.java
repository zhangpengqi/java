package contract;

import java.awt.*;

public abstract class Sprite {
    protected int x;
    protected int y;
    protected int vx;
    protected int vy;

    protected int age=1;

    public Sprite() {
    }

    public Sprite(int x, int y, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    public abstract void show(Graphics2D g2d);

    public void update(){
        x+=vx;
        y+=vy;
        age++;
    }
}
