package basic;

import javax.swing.*;
import java.awt.*;

public class Hello {
    public static void main(String[] args) {

        JFrame frame = new JFrame();

        frame.setResizable(true);                                    // 禁止调整窗体大小
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         // 点窗口上X的行为

//         frame.setSize(600, 400);

        JPanel panel = new Canvas();
        panel.setPreferredSize(new Dimension(600, 400));
        frame.setContentPane(panel);

        //有Pane后，根据内部来调整窗体大小
        frame.pack();

        frame.setVisible(true);
    }
}


