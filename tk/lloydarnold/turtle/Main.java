package tk.lloydarnold.turtle;

import java.awt.*;

import javax.swing.*;


public class Main extends JFrame {

    public JButton runCode, resetCanvas;
    private JTextArea commandBox;
    public  JPanel metaPane;
    public Main() {

        initUI();

    }
    
    private void initUI() {

        GridBagConstraints c;   // placeholder. Instantiated afresh for each new component.
        int rails = 25; // left and right margin width in pixels

        metaPane = new JPanel( new GridBagLayout() );
        metaPane.setBackground(new Color(18, 69, 121));

        runCode = new JButton("Run Script");
        resetCanvas = new JButton("Reset Screen");
        commandBox = new JTextArea(10, 10);

        TurtleLogic[] turt = { new TurtleLogic(425, 200) };
        TurtleGraphics tG = new TurtleGraphics(turt, this);
        tG.setBackground(new Color(8, 87, 239));

        c = new GridBagConstraints( 0, 0, 3, 1, 1.0, 0.7,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(20, rails, 10, rails),
                0, 200 );

        metaPane.add(tG, c);

        // configure constraints & style for Text Area

        c = new GridBagConstraints( 0, 1, 1, 1, 0.8, 0.3,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, rails + 5, 20, 20),
                0, 0 );

        commandBox.setBackground(new Color(170, 199, 234));
        commandBox.setMargin(new Insets(10, 10, 10, 10));

        metaPane.add(commandBox, c);

        // configure constraints for run button
        c = new GridBagConstraints( 1, 1, 1, 1, 0.1, 0.3,
                GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(30, 20, 30, 10),
                0, 0 );
        runCode.setPreferredSize(new Dimension(120, 90));

        metaPane.add(runCode, c);

        // configure constraints for reset button
        c = new GridBagConstraints( 2, 1, 1, 1, 0.1, 0.3,
                GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(30, 0, 30, rails + 5),
                0, 0 );
        resetCanvas.setPreferredSize(new Dimension(120, 90));

        metaPane.add(resetCanvas, c);

        add(metaPane);
        setSize(850, 600);
        setTitle("Logo Simulator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public JTextArea getTextArea() {return this.commandBox; }

    public static void main(String[] args){
        System.out.println("Kick it! ");

        EventQueue.invokeLater(() -> {
            Main ex = new Main();
            ex.setVisible(true);
        });

      }
    }
