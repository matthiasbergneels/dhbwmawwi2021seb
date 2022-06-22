package excercises.chapter10.meldeamt;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Locale;
import java.util.ResourceBundle;

public class MeldeamtUI extends JFrame {

    private static final String RESSOURCE_IDENTIFIER_UILABELS = "excercises.chapter10.meldeamt.i18n.uilabels";

    private static final String ACTION_ADD = "ADD";
    private static final String ACTION_SHOW = "SHOW";
    private static final String ACTION_SEARCH = "SEARCH";
    private static final String ACTION_DELETE = "DELETE";
    private static final String ACTION_SHOWLIST = "SHOWLIST";
    private static final String ACTION_CLOSE = "CLOSE";
    private static final String ACTION_LANGUAGE_DE = "ACTION_LANGUAGE_DE";
    private static final String ACTION_LANGUAGE_EN = "ACTION_LANGUAGE_EN";

    private JLabel lblNotifications;
    private JComboBox<Einwohner.Title> cbbTitle;
    private JTextField tfName;
    private JTextField tfVorname;
    private JTextField tfGebName;
    private JTextField tfEmail;
    private ButtonGroup maritalGroup;

    private String currentMaritalStatus = Einwohner.FAMILIENSTAND_VERHEIRATET;

    public MeldeamtUI(Locale locale) {
        super();

        // Internationalisierung
        if(locale != null){
            Locale.setDefault(locale);
        }

        ResourceBundle uiLabelBundle = ResourceBundle.getBundle(RESSOURCE_IDENTIFIER_UILABELS);

        this.setTitle(uiLabelBundle.getString("frametitle"));
        this.setLayout(new BorderLayout());

        // ActionListener - Buttons
        ActionListener btnListener = (ActionEvent e) -> {

          String action = e.getActionCommand();

          switch(action) {
            case ACTION_ADD -> {
              boolean erg = ListenOperationen
                .hinzufuegen(tfName.getText(), tfVorname.getText(),
                  tfGebName.getText(), tfEmail.getText(),
                  (Einwohner.Title) cbbTitle.getSelectedItem(),
                  currentMaritalStatus);
              if (erg) {
                lblNotifications.setText("Einwohner "
                  + tfName.getText()
                  + " erfolgreich hinzugefügt!");
              } else {
                lblNotifications.setText("Einwohner "
                  + tfName.getText()
                  + " NICHT erfolgreich hinzugefügt!");
              }
            }
                case ACTION_SHOW -> {
                    boolean erg = ListenOperationen.anzeigen(tfName.getText(),
                            tfVorname.getText());
                    if (erg) {
                        lblNotifications.setText("Einwohner "
                                + tfName.getText() + " angezeigt!");
                    } else {
                        lblNotifications.setText("Einwohner "
                                + tfName.getText() + " NICHT angezeigt!");
                    }
            }
                case ACTION_SEARCH -> {
                  boolean erg = ListenOperationen.suchen(tfName.getText(),
                    tfVorname.getText());
                  if (erg) {
                    lblNotifications.setText("Einwohner "
                      + tfName.getText() + " gefunden!");
                  } else {
                    lblNotifications.setText("Einwohner "
                      + tfName.getText() + " NICHT gefunden!");
                  }
                }
               case ACTION_DELETE -> {
                 boolean erg = ListenOperationen.loeschen(tfName.getText(),
                   tfVorname.getText());
                 if (erg) {
                   lblNotifications.setText("Einwohner "
                     + tfName.getText() + " gelöscht!");
                 } else {
                   lblNotifications.setText("Einwohner "
                     + tfName.getText() + " NICHT gefunden!");
                 }
               }
                case ACTION_SHOWLIST -> {
                    ListenOperationen.listeAusgeben();

                }
                case ACTION_CLOSE -> {
                    ListenOperationen.speichernEinwohnerListeInDatei();
                    System.exit(0);

                }
                case ACTION_LANGUAGE_DE -> {
                    ListenOperationen.speichernEinwohnerListeInDatei();
                    this.dispose();
                    new MeldeamtUI(new Locale("de"));
                }
                case ACTION_LANGUAGE_EN -> {
                    ListenOperationen.speichernEinwohnerListeInDatei();
                    this.dispose();
                    new MeldeamtUI(new Locale("en"));
                }
        }
        };

        // Action Listener - RadioButtonGroup Familienstand
        ActionListener rbgMaritalStatus = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                JRadioButton btn = (JRadioButton) arg0.getSource();

                currentMaritalStatus = btn.getText();

                if (btn.isSelected()) {
                    if (btn.getText().equals(Einwohner.FAMILIENSTAND_LEDIG)) {
                        tfGebName.setText("");
                        tfGebName.setEditable(false);
                    } else {
                        tfGebName.setEditable(true);
                    }

                }

            }
        };

        // Panels im BorderLayout
        JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // "Eingedrückter" Centerbereich
        Border loweredBevelBorder = BorderFactory
                .createBevelBorder(BevelBorder.LOWERED);
        centerPanel.setBorder(loweredBevelBorder);

        this.add(northPanel, BorderLayout.NORTH);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(centerPanel, BorderLayout.CENTER);

        // North Panel - Leiste für Meldungen
        lblNotifications = new JLabel("");
        northPanel.add(lblNotifications);

        // Center Panel - Eingabebereich
        Border etchedBorder = BorderFactory.createEtchedBorder();

        // Kontaktdaten
        JPanel contactDataPanel = new JPanel(new GridLayout(0, 2));
        Border contactEtchedBorder = BorderFactory.createTitledBorder(
                etchedBorder, uiLabelBundle.getString("frametitle_adress"));
        contactDataPanel.setBorder(contactEtchedBorder);
        centerPanel.add(contactDataPanel);

        Einwohner.Title[] titleValues = {Einwohner.Title.MRS, Einwohner.Title.MR, Einwohner.Title.DIVERS};

        cbbTitle = new JComboBox<Einwohner.Title>(titleValues);
        tfName = new JTextField(20);
        tfName.setText("Mustermann");
        tfVorname = new JTextField(20);
        tfVorname.setText("Mimi");
        tfGebName = new JTextField(20);
        tfGebName.setText("Musterfrau");
        tfEmail = new JTextField(20);
        tfEmail.setText("mimi.mustermann@email.de");

        contactDataPanel.add(new JLabel(uiLabelBundle.getString("label_title")+":"));
        cbbTitle.setToolTipText("Anrede auswählen");
        contactDataPanel.add(cbbTitle);
        contactDataPanel.add(new JLabel(uiLabelBundle.getString("label_name")+":"));
        tfName.setToolTipText("Nachname eingeben - z.B. \"Mustermann\"");
        contactDataPanel.add(tfName);
        contactDataPanel.add(new JLabel(uiLabelBundle.getString("label_firstname")+":"));
        contactDataPanel.add(tfVorname);
        contactDataPanel.add(new JLabel(uiLabelBundle.getString("label_birthname")+":"));
        contactDataPanel.add(tfGebName);
        contactDataPanel.add(new JLabel(uiLabelBundle.getString("label_email")+":"));
        contactDataPanel.add(tfEmail);

        // Familienstand
        JPanel maritalStatusPanel = new JPanel(new GridLayout(0, 1));
        Border maritalEtchedBorder = BorderFactory.createTitledBorder(
                etchedBorder, uiLabelBundle.getString("frametitle_familystatus"));
        maritalStatusPanel.setBorder(maritalEtchedBorder);
        centerPanel.add(maritalStatusPanel);

        maritalGroup = new ButtonGroup();

        JRadioButton rbtL = new JRadioButton(Einwohner.FAMILIENSTAND_LEDIG);
        JRadioButton rbtVH = new JRadioButton(
                Einwohner.FAMILIENSTAND_VERHEIRATET);
        JRadioButton rbtVW = new JRadioButton(Einwohner.FAMILIENSTAND_VERWITWET);
        JRadioButton rbtG = new JRadioButton(Einwohner.FAMILIENSTAND_GESCHIEDEN);

        rbtVH.setSelected(true);

        maritalGroup.add(rbtL);
        rbtL.addActionListener(rbgMaritalStatus);
        maritalGroup.add(rbtVH);
        rbtVH.addActionListener(rbgMaritalStatus);
        maritalGroup.add(rbtVW);
        rbtVW.addActionListener(rbgMaritalStatus);
        maritalGroup.add(rbtG);
        rbtG.addActionListener(rbgMaritalStatus);

        maritalStatusPanel.add(rbtL);
        maritalStatusPanel.add(rbtVH);
        maritalStatusPanel.add(rbtVW);
        maritalStatusPanel.add(rbtG);

        // South Panel - Leiste für Buttons

        JButton btnAdd = new JButton(uiLabelBundle.getString("btn_add"));
        btnAdd.setActionCommand(ACTION_ADD);
        btnAdd.addActionListener(btnListener);

        JButton btnShow = new JButton(uiLabelBundle.getString("btn_show"));
        btnShow.setActionCommand(ACTION_SHOW);
        btnShow.addActionListener(btnListener);

        JButton btnSearch = new JButton(uiLabelBundle.getString("btn_search"));
        btnSearch.setActionCommand(ACTION_SEARCH);
        btnSearch.addActionListener(btnListener);

        JButton btnDelete = new JButton(uiLabelBundle.getString("btn_delete"));
        btnDelete.setActionCommand(ACTION_DELETE);
        btnDelete.addActionListener(btnListener);

        JButton btnShowList = new JButton(uiLabelBundle.getString("btn_showlist"));
        btnShowList.setActionCommand(ACTION_SHOWLIST);
        btnShowList.addActionListener(btnListener);


        southPanel.add(btnAdd);
        southPanel.add(btnShow);
        southPanel.add(btnSearch);
        southPanel.add(btnDelete);
        southPanel.add(btnShowList);



        JMenuItem menuItemAdd = new JMenuItem(uiLabelBundle.getString("btn_add"));
        menuItemAdd.setActionCommand(ACTION_ADD);
        menuItemAdd.addActionListener(btnListener);

        JMenuItem menuItemDelete = new JMenuItem(uiLabelBundle.getString("btn_delete"));
        menuItemDelete.setActionCommand(ACTION_DELETE);
        menuItemDelete.addActionListener(btnListener);

        JMenuItem menuItemClose = new JMenuItem(uiLabelBundle.getString("btn_close"));
        menuItemClose.setActionCommand(ACTION_CLOSE);
        menuItemClose.addActionListener(btnListener);

        JMenu general = new JMenu(uiLabelBundle.getString("menu_common"));
        general.add(menuItemAdd);
        general.add(menuItemDelete);
        general.addSeparator();
        general.add(menuItemClose);


        JMenuItem menuItemSearch = new JMenuItem(uiLabelBundle.getString("btn_search"));
        menuItemSearch.setActionCommand(ACTION_SEARCH);
        menuItemSearch.addActionListener(btnListener);

        JMenuItem menuItemShowList = new JMenuItem(uiLabelBundle.getString("btn_showlist"));
        menuItemShowList.setActionCommand(ACTION_SHOWLIST);
        menuItemShowList.addActionListener(btnListener);

        JMenu listFunctions = new JMenu(uiLabelBundle.getString("menu_listfunctions"));
        listFunctions.add(menuItemSearch);
        listFunctions.add(menuItemShowList);

        JMenuItem menuLanguageDe = new JMenuItem(uiLabelBundle.getString("btn_language_de"));
        menuLanguageDe.setActionCommand(ACTION_LANGUAGE_DE);
        menuLanguageDe.addActionListener(btnListener);

        JMenuItem menuLanguageEn = new JMenuItem(uiLabelBundle.getString("btn_language_en"));
        menuLanguageEn.setActionCommand(ACTION_LANGUAGE_EN);
        menuLanguageEn.addActionListener(btnListener);

        JMenu menuLanguage = new JMenu(uiLabelBundle.getString("menu_language"));
        menuLanguage.add(menuLanguageDe);
        menuLanguage.add(menuLanguageEn);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(general);
        menuBar.add(listFunctions);
        menuBar.add(menuLanguage);

        this.setJMenuBar(menuBar);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                ListenOperationen.ladenEinwohnerListeVonDatei();
            }

            @Override
            public void windowClosing(WindowEvent e) {
                ListenOperationen.speichernEinwohnerListeInDatei();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        //Listenoperationen.readSetFromFile();
        new MeldeamtUI(null);
    }
}

