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
        // tG.setPreferredSize(new Dimension(500, 500));
        tG.setBackground(new Color(8, 87, 239));

        c = new GridBagConstraints( 0, 0, 2, 1, 1.0, 0.7,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 10, 10, 10),
                0, 200 );

        metaPane.add(tG, c);

        // configure constraints for command box
        c = new GridBagConstraints( 0, 1, 1, 1, 0.7, 0.3,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 10, 10, 10),
                0, 0 );

        metaPane.add(commandBox, c);

        // configure constraints for button
        c = new GridBagConstraints( 1, 1, 1, 1, 0.3, 0.3,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(30, 50, 30, 50),
                0, 0 );

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
