package lecture.chapter10;

import javax.swing.*;

public class MyFirstUi {

  public static void main(String[] args) {

      JFrame myFirstUi = new JFrame("My first UI");

      //myFirstUi.setSize(200, 400);

      JLabel myText = new JLabel("Hallo WWI2021SEB!");
      JButton myButton = new JButton("Pause");

      myFirstUi.add(myButton);
      myFirstUi.add(myText);

      myFirstUi.pack();
      myFirstUi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFirstUi.setVisible(true);
  }
}
