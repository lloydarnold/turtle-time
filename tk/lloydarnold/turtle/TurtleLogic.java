package tk.lloydarnold.turtle;

import java.lang.Math;
import java.util.ArrayList;

public class TurtleLogic {
  int x;
  int y;
  boolean pen;
  boolean isSelected;
  int angle;  // Bearing - 0-359 inclusive
  ArrayList<int[]> lines = new ArrayList<int[]>();

  // Graphics2D g2d;

  enum commands{
    LT,
    RT,
    FD,
    BK,
    PU,
    PD
  }

  public TurtleLogic(){
    x = 0;
    y = 0;
    pen = true;
    isSelected = true;
  }

  public TurtleLogic(int x, int y){
    x = x;
    y = y;
    pen = true;
    isSelected = true;
  }

  private void turn(int turn_factor){
    angle += turn_factor;
    angle = angle % 360;
  }

  private void logical_move(int magnitude) {
    Double rad = Math.toRadians(angle);
    x += magnitude * (int)Math.sin(rad);
    y += magnitude * (int)Math.cos(rad);
  }

}
