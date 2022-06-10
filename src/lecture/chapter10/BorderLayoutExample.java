package lecture.chapter10;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutExample extends JFrame {

  private BorderLayoutExample(){
    this.setTitle("Border Layout Example");

    this.setLayout(new BorderLayout()); // <-- eigentlich unnötig, weil Default LayoutManager

    this.add(new JButton("Button North"), BorderLayout.NORTH);
    this.add(new JButton("Button South"), BorderLayout.SOUTH);
    this.add(new JButton("Button East"), BorderLayout.EAST);
    this.add(new JButton("Button West"), BorderLayout.WEST);

    JPanel centerPanel = new JPanel();
    centerPanel.setLayout(new FlowLayout());
    centerPanel.add(new JButton("Button Center"));
    centerPanel.add(new JButton("Button Center 2"));

    this.add(centerPanel, BorderLayout.CENTER);


    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
    this.setVisible(true);
  }

  public static void main(String[] args) {
    new BorderLayoutExample();
  }
}
