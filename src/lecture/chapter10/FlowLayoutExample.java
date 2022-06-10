package lecture.chapter10;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutExample extends JFrame {

  private FlowLayoutExample(){
    this.setTitle("Flow Layout Example");

    this.setLayout(new FlowLayout(FlowLayout.LEFT));

    this.add(new JLabel("Hallo WWI2021SEB"));
    this.add(new JTextField("Pausen Dauer"));
    this.add(new JButton("Starte Pause"));

    this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    this.pack();
    this.setVisible(true);
  }

  public static void main(String[] args) {
    System.out.println("Programm startet...");
    new FlowLayoutExample();
    System.out.println("Programm ist zuende...");
  }

}
