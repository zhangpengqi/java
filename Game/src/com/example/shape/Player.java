package com.example.shape;

import com.example.contract.Controllable;
import com.example.contract.Sprite;
import com.example.main.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Player extends Sprite implements Controllable {

    private int width;
    private int height;
    private int defaultVx;

    public Player(int x, int y, int vx, int vy) {
        super(x, y, vx, vy);

        defaultVx = vx;
    }

    @Override
    public void update() {

        //不调你父类的update()

        x -= vx;

        if (x < 0) {
            vx = -vx;
        }

        if (x + width > Game.getInstance().getCanvasWidth()) {
            vx = -vx;
        }
    }


    @Override
    public void show(Graphics2D g2d) {

        try {
            BufferedImage bufferedImage = ImageIO.read(new File("src/imgs/hero.png"));
            width = bufferedImage.getWidth();
            height = bufferedImage.getHeight();

            g2d.drawImage(bufferedImage, null, x, y - 100);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void emit(int keyCode) {


        switch (keyCode) {
            case 32:

                int r = 20;

                Game.getInstance().addSprite(new Circle(x + width / 2, y - height, (int) (Math.random() * 11 - 5), (int) (Math.random() * 11 - 5), r));

                break;
            case 37:      //left

                vx = 0;
                x -= 20;
                break;
            case 39:      //right
                vx = 0;
                x += 20;
                break;
            case 38:      //up、down
            case 40:
                vx = defaultVx;
        }

    }
}
