package lecture.chapter10;

import javax.swing.*;
import java.awt.*;

public class GridLayoutExample extends JFrame {

  private GridLayoutExample(){
    this.setTitle("Grid Layout Example");

    this.setLayout(new GridLayout(0,2));

    this.add(new JButton("Zelle 1"));
    this.add(new JButton("Zelle 2"));
    this.add(new JButton("Zelle 3"));
    this.add(new JButton("Zelle 4"));

    JPanel cell5Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    cell5Panel.add(new JButton("Zelle 5"));
    this.add(cell5Panel);

    this.add(new JButton("Zelle 6"));
    this.add(new JButton("Zelle 7"));
    this.add(new JButton("Zelle 8"));
    this.add(new JButton("Zelle 9"));
    this.add(new JButton("Zelle 10"));

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
    this.setVisible(true);
  }

  public static void main(String[] args) {
    new GridLayoutExample();
  }
}
