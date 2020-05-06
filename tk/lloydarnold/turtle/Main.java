package tk.lloydarnold.turtle;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;


public class Main extends JFrame {

    public JButton runCode;
    private JTextArea commandBox;

    public Main() {

        initUI();
    }

    private void initUI() {

        runCode = new JButton("Run Script");
        commandBox = new JTextArea(10, 10);
        commandBox.setBounds(10, 400, 600, 130);
        runCode.setBounds(700, 420, 100, 100);

        add(runCode);
        add(commandBox);

        TurtleLogic[] turt = {new TurtleLogic(425, 200)};
        TurtleGraphics tG = new TurtleGraphics(turt, this);
        tG.setBounds(10, 10, 580, 380);
        add(tG);

        setSize(850, 600);
        setTitle("Logo Simulator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public JButton getButton() {return runCode; }
    public JTextArea getTextArea() {return commandBox; }

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
