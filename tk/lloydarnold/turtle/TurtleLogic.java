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
    int[] fNewLine;
    fNewLine = new int[4];
    fNewLine[0] = this.x;
    fNewLine[1] = this.y;
    logical_move(magnitude);
    fNewLine[2] = this.x;
    fNewLine[3] = this.y;
    lines.add(fNewLine);
  }

  private void backward(int magnitude) {
    int[] bNewLine;
    bNewLine = new int[4];
    bNewLine[0] = this.x;
    bNewLine[1] = this.y;
    logical_move(magnitude*-1);
    bNewLine[2] = this.x;
    bNewLine[3] = this.y;
    lines.add(bNewLine);
  }

  private void left(int magnitude) {
    turn(magnitude*-1);
  }

  private void right(int magnitude) {
    turn(magnitude);
  }

  public void nextMove(String operator, int operand){
    switch (operator) {
      case "FD":
        forward(operand);
      case "BK":
        backward(operand);
      case "LT":
        left(operand);
      case "RT":
        right(operand);
      case "PU":
        this.pen = false;
      case "PD":
        this.pen = true;

    }
  }
}
