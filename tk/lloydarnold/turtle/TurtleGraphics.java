package tk.lloydarnold.turtle;

import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;

class TurtleGraphics extends JPanel
          implements ActionListener {

  private final TurtleLogic[] myTurtles;
  private final JTextArea parentTxt;
  private final CommandParser parser;
  private BufferedImage turtleImg;
  
  public TurtleGraphics(TurtleLogic[] myTurtles, @NotNull Main parent){
      setFocusable(true);
      this.myTurtles = myTurtles;
      parent.runCode.addActionListener(this);
      this.parentTxt = parent.getTextArea();
      this.parser = new CommandParser();

      try {
        turtleImg = ImageIO.read(getClass().getResource("resources/turtle-img.png"));
      } catch (IOException e) {e.printStackTrace();}

    }

    // TODO replace square with turtle
    private void doDrawing(Graphics g) {
      int[] tempLine;
      Graphics2D g2d = (Graphics2D) g;
      g2d.setPaint(new Color(132, 208, 133));

      for (int i = 0; i < myTurtles.length ; i++ ) {
        for (int j = 0; j < myTurtles[i].lines.size() ; j++ ) {
          tempLine = myTurtles[i].lines.get(j);
          g2d.drawLine(tempLine[0], tempLine[1], tempLine[2], tempLine[3]);
        }
        
        if (this.turtleImg != null) {
            g2d.drawImage(turtleImg, myTurtles[i].getX() - 15, myTurtles[i].getY() - 15, 30, 30, null);
        }  else { g2d.fillRect(myTurtles[i].getX() - 5, myTurtles[i].getY() - 5, 10, 10); }
      }
    }

  @Override
  public void actionPerformed(ActionEvent e) {
    ArrayList<String[]> turtleCommands = parser.processCommands(parentTxt);
    makeMoves(turtleCommands);
    this.repaint();
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
