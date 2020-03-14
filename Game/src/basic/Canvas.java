package basic;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Canvas  extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //圆包围矩形的左上角位置和宽高
        g.drawOval(50, 50, 300, 300);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(5)); //笔画粗细

        //抗锯齿
        RenderingHints hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );
        g2d.addRenderingHints(hints);
        g2d.setColor(Color.red);

        Ellipse2D circle = new Ellipse2D.Double(100, 100, 200, 200);
        g2d.draw(circle);
    }
}
