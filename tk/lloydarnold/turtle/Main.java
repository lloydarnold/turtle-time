package tk.lloydarnold.turtle;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;


public class Main extends JFrame {

    private JLabel statusbar;
    private JButton runCode;
    private JTextArea commandBox;

    public Main() {

        initUI();
    }

    private void initUI() {

        statusbar = new JLabel(" Welcome to BTEC Logo :)");
        runCode = new JButton("Run Script");
        commandBox = new JTextArea(10, 10);
        commandBox.setBounds(10, 400, 600, 130);
        runCode.setBounds(700, 420, 100, 100);
        add(statusbar, BorderLayout.NORTH);
        add(runCode);
        add(commandBox);
        TurtleLogic[] turt = {new TurtleLogic()};
        TurtleGraphics tG = new TurtleGraphics(turt, runCode);
        tG.setBounds(10, 10, 580, 380);
        add(tG);

        setSize(850, 600);
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
