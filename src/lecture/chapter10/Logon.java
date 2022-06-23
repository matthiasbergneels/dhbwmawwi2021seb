package lecture.chapter10;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

public class Logon extends JFrame{

  private static final String ACTION_COMMAND_PRINT = "ACTION_PRINT";
  private static final String ACTION_COMMAND_CLOSE = "ACTION_CLOSE";

  public Logon() throws ParseException{
    this.setTitle("Logon");

    this.setBounds(-500, -500, 300, 400);

    final String[] PROTOCOL_VALUE_HELP = {"FTP", "Telnet", "SMTP", "HTTP"};
    JComboBox<String> myComboBox = new JComboBox<>(PROTOCOL_VALUE_HELP);

    JFormattedTextField portField = new JFormattedTextField(new MaskFormatter("#####"));
    portField.setColumns(3);

    myComboBox.addItemListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent e) {
        printThreadID();
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
    JButton okButton = new JButton("Ausgabe");
    okButton.setActionCommand(ACTION_COMMAND_PRINT);
    JButton cancelButton = new JButton("Schliessen");
    cancelButton.setActionCommand(ACTION_COMMAND_CLOSE);

    ActionListener buttonListener = e -> {
      printThreadID();
      System.out.println("ActionEvent - ActionCommand: " + e.getActionCommand());
      System.out.println("ActionEvent - Parameter String: " + e.paramString());
      System.out.println("ActionEvent - Modifiers: " + e.getModifiers());
      System.out.println("ActionEvent - When: " + e.getWhen());

      switch(e.getActionCommand()){
        case ACTION_COMMAND_PRINT:
          System.out.println("Protokoll: " + myComboBox.getSelectedItem() + " - Port: " + portField.getText());
          break;
        case ACTION_COMMAND_CLOSE:
          System.out.println("Programm wird geschlossen");
          System.exit(0);
          break;
      }

      /*
      if(e.getActionCommand().equals("Ausgeben") ){
        System.out.println("Protokoll: " + myComboBox.getSelectedItem() + " - Port: " + portField.getText());
      } else if (e.getActionCommand().equals("Schliessen")){
        System.out.println("Programm wird geschlossen");
        System.exit(0);
      }

       */

    };

    okButton.addActionListener(buttonListener);
    cancelButton.addActionListener(buttonListener);

    MouseListener buttonMouseListener = new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {

      }

      @Override
      public void mousePressed(MouseEvent e) {

      }

      @Override
      public void mouseReleased(MouseEvent e) {

      }

      @Override
      public void mouseEntered(MouseEvent e) {
        System.out.println("Entered Component with Mouse");
        System.out.println("Koordinaten: " + e.getPoint());
        if(e.getSource() instanceof JButton){
          ((JButton)e.getSource()).setEnabled(false);
        }

      }

      @Override
      public void mouseExited(MouseEvent e) {
        System.out.println("Exit Component with Mouse");
        System.out.println("Koordinaten: " + e.getPoint());
        if(e.getSource() instanceof JButton) {
          ((JButton) e.getSource()).setEnabled(true);
        }
      }
    };

    okButton.addMouseListener(buttonMouseListener);
    cancelButton.addMouseListener(buttonMouseListener);
    this.addMouseListener(buttonMouseListener);

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

    JMenuBar myMenuBar = new JMenuBar();

    JMenu fileMenu = new JMenu("Datei");

    JMenuItem okMenuItem = new JMenuItem("Ausgeben");
    okMenuItem.setActionCommand(ACTION_COMMAND_PRINT);
    okMenuItem.addActionListener(buttonListener);
    JMenuItem cancelMenuItem = new JMenuItem("Beenden");
    cancelMenuItem.setActionCommand(ACTION_COMMAND_CLOSE);
    cancelMenuItem.addActionListener(buttonListener);

    fileMenu.add(okMenuItem);
    fileMenu.add(cancelMenuItem);

    myMenuBar.add(fileMenu);

    this.setJMenuBar(myMenuBar);

    MenuBar myAwtMenuBar = new MenuBar();

    Menu myAwtMenu = new Menu("Dateien");

    MenuItem myAwtMenuItem = new MenuItem("Schliessen");
    myAwtMenuItem.setActionCommand(ACTION_COMMAND_CLOSE);
    myAwtMenuItem.addActionListener(buttonListener);

    myAwtMenu.add(myAwtMenuItem);
    myAwtMenuBar.add(myAwtMenu);

    this.setMenuBar(myAwtMenuBar);

    // set JFrame behavior
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.pack();
    this.setVisible(true);
  }

  public static void main(String[] args) throws ParseException {
    GraphicsDevice defaultScreenDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    System.out.println("Screen Dimension: " + defaultScreenDevice.getDefaultConfiguration().getBounds().getWidth()
                        + " x " + defaultScreenDevice.getDefaultConfiguration().getBounds().getHeight());


    GraphicsEnvironment virtualGraphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice[] screens = virtualGraphicsEnvironment.getScreenDevices();

    for(GraphicsDevice screen : screens){
      System.out.println(screen);
      System.out.println(screen.getDefaultConfiguration());
      System.out.println(screen.getDisplayMode());
      System.out.println(screen.getDefaultConfiguration().getBounds());
      System.out.println(screen.getDefaultConfiguration().getBounds().getWidth() + " x " + screen.getDefaultConfiguration().getBounds().getHeight());
      System.out.println(screen.getDefaultConfiguration().getBounds().getX() + " / " + screen.getDefaultConfiguration().getBounds().getY());
    }



    printThreadID();
    new Logon();
  }

  private static void printThreadID(){
    System.out.println("Aktueller Thread: " + Thread.currentThread().getId() + " / " + Thread.currentThread().getName() + "; Thread Gruppe: " + Thread.currentThread().getThreadGroup());
  }
}
