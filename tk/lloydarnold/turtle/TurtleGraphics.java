package tk.lloydarnold.turtle;

import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.lang.Math;

class TurtleGraphics extends JPanel
          implements ActionListener {

  private final TurtleLogic[] myTurtles;
  private final JTextArea parentTxt;
  private final Main parent;
  private final CommandParser parser;
  private BufferedImage turtleImg;
  
  public TurtleGraphics(TurtleLogic[] myTurtles, @NotNull Main parent){
      setFocusable(true);
      this.myTurtles = myTurtles;
      this.parent = parent;
      parent.runCode.addActionListener(this);
      parent.resetCanvas.addActionListener(this);
      this.parentTxt = parent.getTextArea();
      this.parser = new CommandParser();

      try {
        turtleImg = ImageIO.read(getClass().getResource("resources/turtle-img.png"));
      } catch (IOException e) {e.printStackTrace();}

    }

    private void doDrawing(Graphics g) {
      int[] tempLine;
      TurtleLogic tempTurtle;
      Graphics2D g2d = (Graphics2D) g;
      g2d.setPaint(new Color(132, 208, 133));

      for (int i = 0; i < myTurtles.length ; i++ ) {
          tempTurtle = myTurtles[i];

        for (int j = 0; j < tempTurtle.lines.size() ; j++ ) {
          tempLine = tempTurtle.lines.get(j);
          g2d.drawLine(tempLine[0], tempLine[1], tempLine[2], tempLine[3]);
        }

        AffineTransform backup = g2d.getTransform();
        AffineTransform rotate = AffineTransform.getRotateInstance(Math.toRadians(tempTurtle.getAng() * -1),
                tempTurtle.getX(), tempTurtle.getY());

        g2d.setTransform(rotate);
        if (this.turtleImg != null) {
            g2d.drawImage(turtleImg, tempTurtle.getX() - 15, tempTurtle.getY() - 15, 30, 30, null);
        } else { g2d.fillRect(tempTurtle.getX() - 5, tempTurtle.getY() - 5, 10, 10); }
        g2d.setTransform(backup);
      }
    }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == parent.runCode) {
    ArrayList<String[]> turtleCommands = parser.processCommands(parentTxt);
    makeMoves(turtleCommands);
    } else if (e.getSource() == parent.resetCanvas) {
      clear_turtles();
    }
    this.repaint();
  }

  private void clear_turtles(){
    for (int i = 0; i < myTurtles.length; i++) {
      myTurtles[i].resetLines();
      myTurtles[i].setX(Math.floorDiv( this.getWidth(), 2 ));
      myTurtles[i].setY(Math.floorDiv( this.getHeight(), 2 ));
      myTurtles[i].setAng(0);
    }
  }

  private void makeMoves(@NotNull ArrayList<String[]> commands){
    String operator;
    int operand;
    for (int i = 0; i < commands.size() ; i++ ) {
      if (commands.get(i) != null) {
        operator = commands.get(i)[0];
        try { operand = Integer.parseInt(commands.get(i)[1]); }
        catch (Exception e ) { operand = 0 ; }
        myTurtles[0].nextMove(operator, operand);
      }
    }
  }

  @Override
  public void paintComponent(Graphics g) {
      super.paintComponent(g);
      doDrawing(g);
  }

}
