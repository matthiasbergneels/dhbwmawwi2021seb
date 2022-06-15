package lecture.chapter10;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

public class Logon extends JFrame{

  public Logon() throws ParseException{
    this.setTitle("Logon");

    final String[] PROTOCOL_VALUE_HELP = {"FTP", "Telnet", "SMTP", "HTTP"};
    JComboBox<String> myComboBox = new JComboBox<>(PROTOCOL_VALUE_HELP);

    JFormattedTextField portField = new JFormattedTextField(new MaskFormatter("#####"));
    portField.setColumns(3);

    myComboBox.addItemListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent e) {
        System.out.println("ItemEvent - Item:" + e.getItem());
        System.out.println("ItemEvent - ParameterString:" + e.paramString());
        System.out.println("ItemEvent - StateChange:" + e.getStateChange());

        if(e.getStateChange() == ItemEvent.SELECTED){

          JComboBox<String> sourceComboBox = (JComboBox<String>) e.getSource();

          String selectedItem = (String)sourceComboBox.getSelectedItem();
          System.out.println("Aktuell selektiert: " + selectedItem);

          if(e.getItem().equals("FTP")){
            portField.setText("21");
          } else if(e.getItem().equals("HTTP")){
            portField.setText("80");
            sourceComboBox.addItem("HTTPS");
          } else if(e.getItem().equals("HTTPS")){
            portField.setText("443");
            portField.setVisible(false);
          } else {
            portField.setText("");
          }
        }
      }
    });

    // initialize Panels
    JPanel mainPanel = new JPanel(new BorderLayout());

    JPanel southPanel = new JPanel(new FlowLayout());
    JPanel centerPanel = new JPanel(new FlowLayout());

    JPanel connectionPanel = new JPanel(new GridLayout(0, 2));
    JPanel filePanel = new JPanel(new GridLayout(0, 2));

    FlowLayout cellFlowLayout = new FlowLayout(FlowLayout.LEFT);

    //create & assign elements for connection area
    JPanel flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JLabel("User:"));
    connectionPanel.add(flowLayoutForCell);
    //flowLayoutForCell = new JPanel(cellFlowLayout);
    //flowLayoutForCell.add(new JTextField(3));
    //connectionPanel.add(flowLayoutForCell);
    connectionPanel.add(new JTextField(3)); // --> kein extra JPanel mit FlowLayout

    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JLabel("Passwort:"));
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JPasswordField(5));
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JLabel("Art:"));
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(myComboBox);
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JLabel("Host:"));
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    JTextField host = new JTextField(5);
    flowLayoutForCell.add(host);
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JLabel("Port:"));
    connectionPanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(portField);
    connectionPanel.add(flowLayoutForCell);

    // create & add Fields for File Area
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JLabel("Quelle:"));
    filePanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JTextField(10));
    filePanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JLabel("Ziel:"));
    filePanel.add(flowLayoutForCell);
    flowLayoutForCell = new JPanel(cellFlowLayout);
    flowLayoutForCell.add(new JTextField(10));
    filePanel.add(flowLayoutForCell);

    // create & assign Buttons
    JButton okButton = new JButton("Ausgeben");
    JButton cancelButton = new JButton("Schliessen");

    ActionListener buttonListener = e -> {
      System.out.println("ActionEvent - ActionCommand: " + e.getActionCommand());
      System.out.println("ActionEvent - Parameter String: " + e.paramString());
      System.out.println("ActionEvent - Modifiers: " + e.getModifiers());
      System.out.println("ActionEvent - When: " + e.getWhen());

      if(e.getSource() == okButton){
        System.out.println("Protokoll: " + myComboBox.getSelectedItem() + " - Port: " + portField.getText());
      } else if (e.getSource() == cancelButton){
        System.out.println("Programm wird geschlossen");
        System.exit(0);
      }

    };

    okButton.addActionListener(buttonListener);
    cancelButton.addActionListener(buttonListener);

    southPanel.add(okButton);
    southPanel.add(cancelButton);

    // create & assign Borders
    Border etchedBorder = BorderFactory.createEtchedBorder();
    Border connectionBorder = BorderFactory.createTitledBorder(etchedBorder, "Verbindung");
    Border fileBorder = BorderFactory.createTitledBorder(etchedBorder, "Datei");
    Border centerBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED);

    connectionPanel.setBorder(connectionBorder);
    filePanel.setBorder(fileBorder);
    centerPanel.setBorder(centerBorder);

    // combine Panels
    centerPanel.add(connectionPanel);
    centerPanel.add(filePanel);

    mainPanel.add(centerPanel, BorderLayout.CENTER);
    mainPanel.add(southPanel, BorderLayout.SOUTH);

    this.add(mainPanel);

    // set JFrame behavior
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.pack();
    this.setVisible(true);
  }

  public static void main(String[] args) throws ParseException {
    new Logon();
  }
}
