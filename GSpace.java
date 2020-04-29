package tk.lloydarnold;

import java.awt.BasicStroke;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Surface extends JPanel {

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.drawLine(20, 40, 250, 40);

        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class GSpace extends JFrame {

    public GSpace() {

        initUI();
    }

    private void initUI() {

        add(new Surface());

        setTitle("Basic strokes");
        setSize(280, 270);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void test() {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                GSpace ex = new GSpace();
                ex.setVisible(true);
            }
        });
    }
}
