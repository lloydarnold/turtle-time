package tk.lloydarnold.turtle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

class TurtleGraphics extends JPanel
          implements ActionListener {

  TurtleLogic[] myTurtles = null;

    public TurtleGraphics(TurtleLogic[] myTurtles, JButton parentbutton){
      setFocusable(true);
      this.myTurtles = myTurtles;
      parentbutton.addActionListener(this);
    }

    private void doDrawing(Graphics g) {
      int[] tempLine;
      Graphics2D g2d = (Graphics2D) g;
      g2d.setPaint(new Color(150, 150, 150));

      for (int i = 0; i < myTurtles.length ; i++ ) {
        g2d.fillRect(myTurtles[i].x - 5, myTurtles[i].y - 5, 10, 10);
        for (int j = 0; j < myTurtles[i].lines.size() ; ) {
          tempLine = myTurtles[i].lines.get(j);
          g2d.drawLine(tempLine[0], tempLine[1], tempLine[2], tempLine[3]);
        }
      }
    }

  @Override
  public void actionPerformed(ActionEvent e) {
    repaint();

  }


    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    public void trial_move(){
      myTurtles[0].nextMove("FD", 50);
    }
}
