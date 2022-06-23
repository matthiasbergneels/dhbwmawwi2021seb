package lecture.chapter11;

import java.io.*;
import java.util.ArrayList;

public class PersistPersons {

  public static void main(String[] args) {

    ArrayList<Person> personList = new ArrayList<>();

    personList.add(new Person("Klaus", "Müller"));
    personList.add(new Person("Gabi", "Fritz"));
    personList.add(new Person("Hans", "Zeus"));
    personList.add(new Person("Michaela", "Amadeus"));



    // Manuelle Serialisierung und Deserialisierung
    File myPersonFile = new File(System.getProperty("user.dir") + File.separator + "personFile.txt");

    try {
      myPersonFile.createNewFile();
    } catch (IOException e) {
      e.printStackTrace();
    }

    try(FileWriter myPersonFileWriter = new FileWriter(myPersonFile)){

      for(Person currentPerson : personList){
        // manuelle Serialisierung
        String personStringLine = currentPerson.getName() + "," + currentPerson.getFamilyName() + "\n";

        myPersonFileWriter.write(personStringLine);
      }

    }catch(IOException e){
      System.out.println("Fehler beim Schreiben der Person-Datei");
    }


    try(FileReader myPersonFileReader = new FileReader(myPersonFile);
        BufferedReader myPersonBufferedFileReader = new BufferedReader(myPersonFileReader)){

      String line;

      while((line = myPersonBufferedFileReader.readLine()) != null){
        // manuelle de-Serialisierung
        String[] personData = line.split(",");
        Person currentPerson = new Person(personData[0], personData[1]);

        System.out.println(currentPerson);
      }

    } catch(Exception e){
      System.out.println("Fehler beim Lesen der Person-Datei");
    }


    // Java Serialzable
    File myPersonObjectFile = new File(System.getProperty("user.dir") + File.separator + "personFile.dat");

    try(OutputStream myPersonObjectFileStream = new FileOutputStream(myPersonObjectFile);
        ObjectOutputStream myPersonObjectStream = new ObjectOutputStream(myPersonObjectFileStream)){

        for(Person currentPerson : personList){
          myPersonObjectStream.writeObject(currentPerson);
        }

    }catch(IOException e){
      System.out.println("Fehler beim Schreiben der Person-Objekte");
    }


    try(InputStream myPersonObjectFileInputStream = new FileInputStream(myPersonObjectFile);
        ObjectInputStream myPersonObjectObjectInputStream = new ObjectInputStream(myPersonObjectFileInputStream)){

      while(true){
        try {
          Person currentPerson = (Person) myPersonObjectObjectInputStream.readObject();
          System.out.println("Deserialisiert: " + currentPerson);

        }catch(EOFException e){
          break;
        }
      }

    }catch(IOException e){
      System.out.println("Fehler beim Lesen der Person-Objekte");
    }catch(ClassNotFoundException e){
      System.out.println("Fehler bei der Deserialisierung");
    }


  }
}
