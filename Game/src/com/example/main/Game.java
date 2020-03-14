package com.example.main;

import com.example.contract.Controllable;
import com.example.contract.Sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

/**
 * 游戏主类
 */
public class Game extends JFrame {
    private static Game instance;

    private int canvasWidth;   // 画板宽
    private int canvasHeight;  // 画板高

    private ArrayList<Sprite> spriteList = new ArrayList<>();       // 所有精灵对象

    public Game(String title, int canvasWidth, int canvasHeight) {
        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        Game.instance = this;
    }

    public static Game getInstance() {
        return instance;
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }


    public void addSprite(Sprite sprite) {
        spriteList.add(sprite);
    }

    public void init() {
        setResizable(false);                                    // 禁止调整窗体大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         // 点窗口上X的行为

        Canvas canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        setContentPane(canvas);

        // setSize(canvasWidth, canvasHeight);
        pack(); //根据内部canvas画布来调整大小

        setVisible(true);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());

                List<Controllable> controllableList = new ArrayList<>();

                for (Sprite sprite : spriteList) {
                    if (sprite instanceof Controllable) {
                        // ((Control) shape).emit(e.getKeyCode()); //不要在遍历集合的时候，向集合中添加元素
                        controllableList.add((Controllable) sprite);
                    }
                }

                for (Controllable c : controllableList) {
                    c.emit(e.getKeyCode());
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public void start() {

        init();

        new Thread(() -> {

            while (true) {

                //倒序删除
                int size = spriteList.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (spriteList.get(i).age > 1000) {
                        spriteList.remove(i);
                    }
                }

                for (Sprite sprite : spriteList) {
                    sprite.update();
                }

                repaint();// 重新绘制，会触发Canvas.paintComponent()

                try {
                    Thread.sleep(20);   // 1秒50次
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

    }

    private class Canvas extends JPanel {

        public Canvas() {
            super(true); //双缓存
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            //圆包围矩形的左上角位置和宽高
            //g.drawOval(50, 50, 300, 300);

            Graphics2D g2d = (Graphics2D) g;

            g2d.setStroke(new BasicStroke(1)); //笔画粗细

            //抗锯齿
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );
            g2d.addRenderingHints(hints);
            g2d.setColor(Color.red);

            for (Sprite sprite : spriteList) {
                sprite.show(g2d);
            }
        }
    }
}
