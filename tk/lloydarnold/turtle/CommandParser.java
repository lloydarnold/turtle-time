package tk.lloydarnold.turtle;

import javax.swing.JTextArea;

public class CommandParser {

  ArrayList<String[]> finalCommands = new ArrayList<String[]>();

  private void print(String input) {
    // This can be adapted to output error message in more usable ways
    System.out.println(input);
  }

  public void processCommands(JTextArea textBox) {
    String rawInput = textBox.getText();
    String[] splitInput = rawInput.split("\n");
    finalCommands.clear();

    for (int i = 0; i < splitInput.length ; i++) {
      finalCommands.add(cleanCommand(splitInput[i]) );
    }
  }

  private String[] cleanCommand(String rawLine) {
    String[] tokens = line.split(" ");
    if (tokens.length > 2) {
      print("Uh oh bruddah bro -- you put too much on one line");
      return null;
    }
    tokens = interpret(tokens)
  }

  private String[] interpret(String[] comLine) {
    String operator = processOperator(comLine[0].toUpperCase());
  }

  private String processOperator(String operator){
    switch (operator) {
      case "FD":
      case "FORWARD":
        return "FD";
      case "BK":
      case "BACKWARD":
        return "BK";
      case "LT":
      case "LEFT":
        return "LT";
      case "RT":
      case "RIGHT":
        return "RT";
      case "PU":
      case "PENUP":
        return "PU";
      case "PD":
      case "PENDOWN":
        return "PD";
      default:
        return null;

    }
  }

}
