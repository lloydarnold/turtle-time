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
    x = 100;
    y = 100;
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
    if (angle<360) angle += 360;
  }

  private void logical_move(int magnitude) {
    Double rad = Math.toRadians(angle);
    x += magnitude * (int)Math.sin(rad);
    y += magnitude * (int)Math.cos(rad);
  }

  private void forward(int magnitude) {
    int[] newLine;
    int[] newLine = new int[3];
    newLine[0] = this.x;
    newLine[1] = this.y;
    logical_move(magnitude);
    newLine[2] = this.x;
    newLine[3] = this.y;
    lines.add(newLine);
  }

  private void backward(int magnitude) {
    int[] newLine;
    int[] newLine = new int[3];
    newLine[0] = this.x;
    newLine[1] = this.y;
    logical_move(magnitude*-1);
    newLine[2] = this.x;
    newLine[3] = this.y;
    lines.add(newLine);
  }


}
