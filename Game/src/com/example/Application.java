package com.example;

import com.example.main.Game;
import com.example.shape.Circle;
import com.example.shape.Player;

import java.awt.*;

public class Application {

    public static void main(String[] args) {

        int canvasWidth = 800;
        int canvasHeight = 600;

        Game game = new Game("Hello", canvasWidth, canvasHeight);

        int r = 50;
        int x = (int) (Math.random() * canvasWidth - 2 * r) + r;
        int y = (int) (Math.random() * canvasHeight - 2 * r) + r;
//
        game.addSprite(new Circle(x, y, (int) (Math.random() * 11 - 5), (int) (Math.random() * 11 - 5), r));
//
        game.addSprite(new Circle(500, 100, 2, 50, r));

       game.addSprite(new Player(canvasWidth / 2, canvasHeight - 50, (int) (Math.random() * 11 - 5), (int) (Math.random() * 11 - 5)));



        for (int i = 0; i < 10; i++) {
//            int x = (int) (Math.random() * canvasWidth - 2 * r) + r;
//            int y = (int) (Math.random() * canvasHeight - 2 * r) + r;
            game.addSprite(new Circle(x, y, (int) (Math.random() * 11 - 5), (int) (Math.random() * 11 - 5), r));
        }

        game.start();

//        //放到事件分发线程中去创建窗口
//        EventQueue.invokeLater(() -> {
//            game.start();
//        });

    }
}
