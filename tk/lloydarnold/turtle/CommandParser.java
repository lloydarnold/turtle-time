package tk.lloydarnold.turtle;

// TODO add looping support
/* interpreter add loop and end loop tags. Then add parse loops method which takes arraylist and iterates through it to
* add loopity loops like a boss. */

// TODO fix issue of extra whitespace being counted as tokens

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.JTextArea;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class CommandParser {

  ArrayList<String[]> finalCommands = new ArrayList<String[]>();

  private void print(String input) {
    // This can be adapted to output error message in more user friendly ways (eg. to text area)
    if (input == null) { System.out.println("null"); }
    else { System.out.println(input); }
  }

  public ArrayList<String[]> processCommands(@NotNull JTextArea textBox) {
    String rawInput = textBox.getText();
    String[] splitInput = rawInput.split("\n");
    String[] temp;
    String[] errorMess = {"nothing", "nothing"};
    finalCommands.clear();

    for (int i = 0; i < splitInput.length ; i++) {
      temp = cleanCommand(splitInput[i]);
      if ( temp != null ) { finalCommands.add(temp); }
      else { finalCommands.add(errorMess); }
      // print( finalCommands.get(i)[0] );
    }

    finalCommands = processLoops(finalCommands);
    return finalCommands;
  }
  
  private @NotNull ArrayList<String[]> processLoops(@NotNull ArrayList<String[]> commands){
    ArrayList<String[]> withLoops = new ArrayList<String[]>();
    Stack<Integer> headPointers = new Stack<Integer>();

    int holdInt;
    String[] temp;


    for (int i = 0; i < commands.size() ; i++) {
      temp = commands.get(i);

      if (temp[0].equals("start_loop") && !temp[1].equals("nothing")) {
        holdInt = Integer.parseInt(temp[1]);
        for (int j = 0; j < holdInt; j++) { headPointers.push(i); }

      } else if ( temp[0].equals("end_loop")) {
        try {i = headPointers.pop(); }
        catch (EmptyStackException ignored) {}

      } else{
        withLoops.add(temp);

      }
    }
    return withLoops;
  }

  private String @Nullable [] cleanCommand(@NotNull String rawLine) {
    String[] tokens = rawLine.split(" ");
    if (tokens.length > 2) {
      print("Uh oh bruddah bro -- you put too much on one line");
      return null;
    }
    tokens = interpret(tokens);
    return tokens;
  }

  private String @Nullable [] interpret(String @NotNull [] comLine) {
    String operator = processOperator(comLine[0].toUpperCase());
    String[] returnable;

    if (operator == null) {
      print("Sorry, I don't understand that instruction");
      return null;

    } else if (! (operator.equals("PU") || operator.equals("PD") || operator.equals("end_loop"))) {
      String operand = processOperand(comLine[1]);
      returnable = new String[] { operator, operand };

    } else {
      returnable = new String[] { operator, "nothing" };
    }

    return returnable;
  }

  private @Nullable String processOperator(@NotNull String operator){
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
      case "LOOP":
        return "start_loop";
       case "ENDLOOP":
        return "end_loop";
      default:
        return null;
    }
  }

  private String processOperand(String operand) {
      operand = operand.strip();
      if (!isNumeric(operand)) {
        print("Operands must be numeric");
        return "nothing";
      } else {
        return operand;
      }
  }

  private static boolean isNumeric(@NotNull String str) {
    return str.matches("\\d+?");
  }

}
