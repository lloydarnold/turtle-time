package tk.lloydarnold.turtle;

import org.jetbrains.annotations.NotNull;

import java.lang.Math;
import java.util.ArrayList;

public class TurtleLogic {
  private int x;
  private int y;
  boolean pen;
  boolean isSelected;
  private int angle;  // Bearing - 0-359 inclusive. Measured clockwise from due North.
  public ArrayList<int[]> lines = new ArrayList<int[]>();

  public TurtleLogic(int x, int y){
    this.x = x;
    this.y = y;
    angle = 0;
    pen = true;
    isSelected = true;
  }

  private void turn(int turn_factor){
    angle += turn_factor;
    angle = angle % 360;
    if (angle < 0) { angle += 360; }
  }

  public void logical_move(int magnitude) {
    double rad = Math.toRadians(angle - 180); // -180 deals with fact that y axis in cartesian space is opposite to y in java
    this.x = x + (int)(magnitude * Math.sin(rad));
    this.y = y + (int)(magnitude * Math.cos(rad));
  }

  public void forward(int magnitude) {
    int[] fNewLine;
    fNewLine = new int[4];

    fNewLine[0] = this.x;
    fNewLine[1] = this.y;

    logical_move(magnitude);

    fNewLine[2] = this.x;
    fNewLine[3] = this.y;

    if (this.pen) { lines.add(fNewLine); }
  }

  private void backward(int magnitude) {
    int[] bNewLine;
    bNewLine = new int[4];

    bNewLine[0] = this.x;
    bNewLine[1] = this.y;

    logical_move(magnitude*-1);

    bNewLine[2] = this.x;
    bNewLine[3] = this.y;

    if (this.pen) { lines.add(bNewLine); }
  }

  private void right(int magnitude) {
    turn(magnitude*-1);
  }

  private void left(int magnitude) {
    turn(magnitude);
  }

  public void nextMove(@NotNull String operator, int operand){
    switch (operator) {
      case "FD":
        forward(operand);
        break;
      case "BK":
        backward(operand);
        break;
      case "LT":
        left(operand);
        break;
      case "RT":
        right(operand);
        break;
      case "PU":
        this.pen = false;
        break;
      case "PD":
        this.pen = true;
        break;
      case "nothing":
        break;

    }
  }

  public void resetLines(){
    this.lines = new ArrayList<int[]>();
  }

  public void setX (int newX) { this.x = newX; }
  public void setY (int newY) { this.y = newY; }
  public void setAng (int newAng) { this.angle = newAng; }

  public int getX() { return this.x; }
  public int getY() { return this.y; }
  public int getAng() { return this.angle; }

}
