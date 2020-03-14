package shape;

import contract.Sprite;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends Sprite {

    public int r;

    public Circle() {
        super();
    }

    public Circle(int r) {
        this.r = r;
    }

    public Circle(int x, int y, int vx, int vy, int r) {
        super(x, y, vx, vy);
        this.r = r;
    }

    @Override
    public void show(Graphics2D g2d) {
        Ellipse2D circle=new Ellipse2D.Double(x-r,y-r,2*r,2*r);
        g2d.draw(circle);
    }
    public  void update(){
        super.update();
    }
}
