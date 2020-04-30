package tk.lloydarnold;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.util.Math;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Turtle {
  int x;
  int y;
  boolean pen;
  int angle;  // Bearing - 0-359 inclusive
  // Graphics2D g2d;

  enum commands{
    LT,
    RT,
    FD,
    BK,
    PU,
    PD
  }

  public Turtle(){
    x = 0;
    y = 0;
    pen = true;
  }

  private turn(int turn_factor){
    angle += turn_factor;
    angle = angle % 360;
  }

  private logical_move(int magnitude) {
    Double rad = Math.toRadians();
    x += magnitude * Math.sin(rad);
    y += magnitude * Math.cos(rad);
  }

}
