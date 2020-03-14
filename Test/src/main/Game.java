package main;

import contract.Sprite;

import javax.swing.*;
import java.util.*;

public class Game extends JFrame {
    private static Game instance;

    private int canvasWidth;
    private int canvasHeight;

    private List<Sprite> spriteList =new ArrayList<Sprite>();

    public Game(String title,int canvasWidth,int canvasHeight){
        super(title);
        this.canvasWidth=canvasWidth;
        this.canvasHeight=canvasHeight;
        Game.instance=this;
    }
    public static Game getInstance(){
        return instance;
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }
    public void addSprite(Sprite sprite){
        spriteList.add(sprite);
    }
    public  void init(){

    }
}
