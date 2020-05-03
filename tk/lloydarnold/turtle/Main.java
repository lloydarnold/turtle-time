package tk.lloydarnold.turtle;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Main extends JFrame {

    private JLabel statusbar;

    public Main() {

        initUI();
    }

    private void initUI() {

        statusbar = new JLabel(" Welcome to BTEC Logo :)");
        add(statusbar, BorderLayout.SOUTH);
        TurtleLogic[] turt = {new TurtleLogic()};
        TurtleGraphics tG = new TurtleGraphics(turt);
        add(tG);

        setSize(600, 400);
        setTitle("Logo Simulator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

      public static void main(String[] args){
        System.out.println("Kick it! ");

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                Main ex = new Main();
                ex.setVisible(true);
            }
        });

      }
    }
