package tk.lloydarnold.turtle;

public class Main {

  public static void main(String[] args){
    System.out.println("Kick it! ");
    TurtleLogic[] turt = {new TurtleLogic()};
    TurtleGraphics g = new TurtleGraphics(turt);
    g.test(turt);
  }
}
