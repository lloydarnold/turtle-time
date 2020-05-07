package tk.lloydarnold.turtle;

import java.awt.*;

import javax.swing.*;


public class Main extends JFrame {

    public JButton runCode;
    private JTextArea commandBox;
    public  JPanel metaPane;
    public Main() {

        initUI();

    }

    private void initUI() {

        metaPane = new JPanel( new GridBagLayout() );
        GridBagConstraints c = new GridBagConstraints();

        runCode = new JButton("Run Script");
        commandBox = new JTextArea(10, 10);

        TurtleLogic[] turt = { new TurtleLogic(425, 200) };
        TurtleGraphics tG = new TurtleGraphics(turt, this);
        tG.setPreferredSize(new Dimension(500, 500));
        tG.setBackground(new Color(8, 87, 239));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0.8;
        c.weightx = 1.0;
        c.gridx = 0;
        c.gridwidth = 2;
        c.gridy = 0;
        c.ipady = 400;

        metaPane.add(tG, c);

        // configure constraints for command box
        c.ipady = 40;
        c.gridx = 0;
        c.weightx = 0.7;
        c.gridwidth = 1;
        c.gridy = 1;
        c.weighty = 0.2;
        metaPane.add(commandBox, c);

        // configure constraints for button
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 0.3;
        c.weighty = 0.2;
        metaPane.add(runCode, c);

        add(metaPane);
        setSize(850, 600);
        setTitle("Logo Simulator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public JTextArea getTextArea() {return this.commandBox; }

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
