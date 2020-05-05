package tk.lloydarnold.turtle;

import javax.swing.JTextArea;
import java.util.ArrayList;

public class CommandParser {

  ArrayList<String[]> finalCommands = new ArrayList<String[]>();

  private void print(String input) {
    // This can be adapted to output error message in more usable ways
    System.out.println(input);
  }

  public ArrayList<String[]> processCommands(JTextArea textBox) {
    String rawInput = textBox.getText();
    String[] splitInput = rawInput.split("\n");
    finalCommands.clear();

    for (int i = 0; i < splitInput.length ; i++) {
      finalCommands.add(cleanCommand(splitInput[i]) );
      print(finalCommands.get(i)[0]);
    }
    
    return finalCommands;
  }

  private String[] cleanCommand(String rawLine) {
    String[] tokens = rawLine.split(" ");
    if (tokens.length > 2) {
      print("Uh oh bruddah bro -- you put too much on one line");
      return null;
    }
    tokens = interpret(tokens);
    return tokens;
  }

  private String[] interpret(String[] comLine) {
    String operator = processOperator(comLine[0].toUpperCase());
    String[] returnable;

    if (operator == null) {
      print("Sorry, I don't understand that instruction");
      return null;

    } else if (! (operator.equals("PU") || operator.equals("PD"))) {
      String operand = processOperand(comLine[1]);
      returnable = new String[] { operator, operand };

    } else {
      returnable = new String[] { operator };
    }

    return returnable;
  }

  private String processOperator(String operator){
    switch (operator.strip()) {
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

  private String processOperand(String operand) {
      operand = operand.strip();
      if (!isNumeric(operand)) {
        print("Operands must be numeric");
        return null;
      } else {
        return operand;
      }
  }

  private static boolean isNumeric(String str) {
    return str.matches("-?\\d+(\\.\\d+)?");
  }

}
