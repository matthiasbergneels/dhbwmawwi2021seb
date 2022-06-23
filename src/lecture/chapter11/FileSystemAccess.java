package lecture.chapter11;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

public class FileSystemAccess {

  public static void main(String[] args) {


    System.out.println("Liste von Laufwerken / Root Verzeichnisse:");
    System.out.println("==========================================");

    File[] rootList = File.listRoots();

    for(File root : rootList ){
      System.out.println("Pfad: " + root.getPath());
      System.out.println("- existiert: " + root.exists());
      System.out.println("- Lesezugriff: " + root.canRead());
      System.out.println("- Schreibzugriff: " + root.canWrite());
      System.out.println("- Verzeichnis: " + root.isDirectory());
    }


    System.out.println("System Properties:");
    System.out.println("==================");
    Properties systemProperties = System.getProperties();

    Set systemPropertiesKeys = systemProperties.keySet();
    for(Object key : systemPropertiesKeys){
      System.out.println(key + ": " + systemProperties.get(key));
    }

    System.out.println("user.dir Information:");
    System.out.println("=====================");
    File userDir = new File(System.getProperty("user.dir"));

    System.out.println("Name: " + userDir.getName());
    System.out.println("Pfad: " + userDir.getPath());
    System.out.println("Existiert: " + userDir.exists());
    System.out.println("Ist Verzeichnis: " + userDir.isDirectory());
    System.out.println("Ist Datei: " + userDir.isFile());

    System.out.println("Inhalt von " + userDir.getName() + ":");
    System.out.println("=====================================");

    listDirectoryAndContent(userDir, 0);

    System.out.println("Umgang mit Verzeichnissen und Dateien:");
    System.out.println("======================================");

    File myDirectory = new File(System.getProperty("user.dir") + File.separator + "myDirectory");

    System.out.println("Name: " + myDirectory.getName());
    System.out.println("Pfad: " + myDirectory.getPath());
    System.out.println("Existiert: " + myDirectory.exists());

    if(!myDirectory.exists()){
      System.out.println(myDirectory.mkdir());
    }


    System.out.println("Name: " + myDirectory.getName());
    System.out.println("Pfad: " + myDirectory.getPath());
    System.out.println("Existiert: " + myDirectory.exists());

    File myFile = new File(myDirectory.getPath() + File.separator + "myFile.txt");

    System.out.println("Name: " + myFile.getName());
    System.out.println("Pfad: " + myFile.getPath());
    System.out.println("Existiert: " + myFile.exists());

    try {
      System.out.println(myFile.createNewFile());
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("Name: " + myFile.getName());
    System.out.println("Pfad: " + myFile.getPath());
    System.out.println("Existiert: " + myFile.exists());

    File myRenamedFile = new File(myDirectory.getPath() + File.separator + "myRenamedFile.txt");

    System.out.println("Name: " + myRenamedFile.getName());
    System.out.println("Pfad: " + myRenamedFile.getPath());
    System.out.println("Existiert: " + myRenamedFile.exists());

    myFile.renameTo(myRenamedFile);

    System.out.println("Name: " + myFile.getName());
    System.out.println("Pfad: " + myFile.getPath());
    System.out.println("Existiert: " + myFile.exists());

    System.out.println("Name: " + myRenamedFile.getName());
    System.out.println("Pfad: " + myRenamedFile.getPath());
    System.out.println("Existiert: " + myRenamedFile.exists());

    System.out.println("Einlesen von Daten über System.in (Byte)");
    System.out.println("========================================");

    System.out.println("Bitte einen Text eingeben:");

    byte[] input = new byte[255];

    try{
      System.in.read(input, 0, input.length);
    }catch(IOException e){
      System.out.println("Fehler beim lesen von der Konsole");
    }

    System.out.println(input);
    System.out.println(new String(input));


    System.out.println("Einlesen von Daten über System.in (Char)");
    System.out.println("========================================");

    InputStreamReader systemInReader = new InputStreamReader(System.in);
    BufferedReader systemInBufferedReader = new BufferedReader(systemInReader);
    ArrayList<String> linesReadFromConsole = new ArrayList<>();

    System.out.println("Bitte Text eingeben (beenden mit exit)");
    while(true){
      try {
        String inputLine = systemInBufferedReader.readLine();
        if(inputLine.equalsIgnoreCase("exit")){
          break;
        }
        linesReadFromConsole.add(inputLine);

      } catch (IOException e){
        System.out.println("Fehler beim lesen von der Konsole");
      }
    }

    System.out.println("Ausgabe von Konsolen-Text:");
    for(String line : linesReadFromConsole){
      System.out.println(line);
    }

    FileWriter myTextFileWrite = null;

    try {
      myTextFileWrite = new FileWriter(myRenamedFile);

      for(String line : linesReadFromConsole){
        myTextFileWrite.write(line + "\n");
      }

    }catch (IOException e){
      System.out.println("Fehler beim Schreiben der Datei!");
    }finally {
      try {
        myTextFileWrite.close();
      }catch(IOException e){
        System.out.println("Fehler beim Schliessen des FileWriter");
      }
    }

    System.out.println("Datei auslesen:");
    System.out.println("===============");

    try(FileReader myTextFileReader = new FileReader(myRenamedFile);
        BufferedReader myTextFileBufferedReader = new BufferedReader(myTextFileReader)){

      String line;

      while((line = myTextFileBufferedReader.readLine()) != null){
        System.out.println(line);
      }

    }catch(IOException e){
      System.out.println("Fehler beim Lesen der Datei.");
    }

    myRenamedFile.delete();
    myDirectory.delete();
  }



  private static void listDirectoryAndContent(File currentDirectory, int indentation){
    printlnWithIndentation("+" + currentDirectory.getName() +" - "
      + (currentDirectory.canRead() ? "Lesezugriff" : "Kein Lesezugriff") + "; "
      +(currentDirectory.canWrite() ? "Schreibzugriff" : "Kein Schreibzugriff"), indentation );

    File[] currentDirectoryContent = currentDirectory.listFiles();
    for(File currentFile : currentDirectoryContent){
      if(currentFile.isDirectory()){
        listDirectoryAndContent(currentFile, indentation+1);
      }else if(currentFile.isFile()){
        printlnWithIndentation("-" + currentFile.getName()
          + " - "+ (currentFile.canRead() ? "Lesezugriff" : "Kein Lesezugriff") + "; "
          +(currentFile.canWrite() ? "Schreibzugriff" : "Kein Schreibzugriff") + "; "
          + currentFile.length() + " Byte", indentation+1 );
      }
    }

  }

  private static void printlnWithIndentation(String txt, int indentation){
    String indentationText = "";
    for(int i = 0; i < indentation; i++){
      indentationText += "\t";
    }

    System.out.println(indentationText + txt);
  }
}
