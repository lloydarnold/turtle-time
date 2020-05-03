package tk.lloydarnold.turtle;

import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;


class DrawSurface extends JPanel {

    private void doDrawing(Graphics g, int x1, int y1, int x2, int y2) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawLine(x1, y1, x2, y2);

    }

    private void initSpace(TurtleLogic[] panelMyTurtles) {
      setFocusable(true);

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g, 10, 10, 100, 100);
    }
}

public class TurtleGraphics extends JFrame {

    TurtleLogic[] frameMyTurtles = null;
    private JLabel statusbar;

    public TurtleGraphics(TurtleLogic[] frameMyTurtles) {

        this.frameMyTurtles = frameMyTurtles;
        initUI();
    }

    private void initUI() {

        statusbar = new JLabel(" Welcome to BTEC Logo :)");
        add(statusbar, BorderLayout.SOUTH);
        DrawSurface dSurf = new DrawSurface();
        add(dSurf);

        setSize(600, 400);
        setTitle("Logo Simulator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void test(TurtleLogic[] frameMyTurtles) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                TurtleGraphics ex = new TurtleGraphics(frameMyTurtles);
                ex.setVisible(true);
            }
        });
    }
}
