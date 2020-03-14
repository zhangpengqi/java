package basic;

import javax.swing.*;
import java.awt.*;

public class Demo1 {
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel=new Canvas();
        panel.setPreferredSize(new Dimension(500,500));
        frame.setContentPane(panel);

        frame.pack();

        frame.setVisible(true);
    }
}
