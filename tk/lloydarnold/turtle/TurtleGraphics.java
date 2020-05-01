package tk.lloydarnold.turtle;

import java.awt.BasicStroke;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Surface extends JPanel {

    private void doDrawing(Graphics g, int x1, int y1, int x2, int y2) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(x1, y1, x2, y2);

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g, 10, 10, 100, 100);
    }
}

public class TurtleGraphics extends JFrame {

    public TurtleGraphics() {

        initUI();
    }

    private void initUI() {

        add(new Surface());

        setTitle("Turtle Time");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void drawLine(int x1, int y1, int x2, int y2) {
      // Surface.drawLine();
    }

    public static void test() {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                TurtleGraphics ex = new TurtleGraphics();
                ex.setVisible(true);
            }
        });
    }
}
