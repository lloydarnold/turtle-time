package tk.lloydarnold.turtle;

import javax.swing.JTextArea;

public class CommandParser {

  public void process_commands(JTextArea textBox) {
    String rawInput = textBox.getText();
    String[] splitInpit = rawInput.split("\n");
  }

}
