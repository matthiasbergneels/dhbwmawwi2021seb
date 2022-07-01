package lecture.excursion;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MemeGenerator {

  public static final String[] MEME_PICTURES = {"10 Guy", "1950s Middle Finger", "1990s First World Problems"};

  private static final String baseUrl = "http://apimeme.com/meme?meme=%s&top=%s&bottom=%s";

  public static void main(String[] args) throws IOException, InterruptedException {
    HttpClient httpClient = HttpClient.newBuilder().build();

    HttpRequest request =
      HttpRequest.newBuilder()
        .uri(URI.create("http://apimeme.com/meme?meme=Alarm-Clock&top=it's+time&bottom=...+to+learn"))
        .GET()
        .build();

    HttpResponse<byte[]> response =
      httpClient.send(request, HttpResponse.BodyHandlers.ofByteArray());

    System.out.println(response.statusCode());

    File imageFile = new File(System.getProperty("user.dir") + File.separator + "image.jpg");
    imageFile.createNewFile();

    try(FileOutputStream writeImageToFile = new FileOutputStream(imageFile)){
      byte[] imageInBytes = response.body();

      writeImageToFile.write(imageInBytes);

    }catch(IOException e){

    }


    byte[] imageMemeBytes = getImageInBytesFromApi("1990s First World Problems", "learning java", "...what?");

    ImageIcon imageMeme = new ImageIcon(imageMemeBytes);

    JFrame memeFrame = new JFrame("My Meme");

    memeFrame.add(new JLabel(imageMeme));

    memeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    memeFrame.pack();
    memeFrame.setVisible(true);


    //System.out.println(new String(response.body()));
  }

  public static byte[] getImageInBytesFromApi(String memeDescriptor, String topText, String bottomText){

    final String targetUrl = String.format(baseUrl, memeDescriptor.replace(" ", "-"), topText.replace(" ", "+"), bottomText.replace(" ", "+"));

    HttpClient httpClient = HttpClient.newBuilder().build();

    HttpRequest request = null;
    HttpResponse<byte[]> response = null;

    try {
      request =
        HttpRequest.newBuilder()
          .uri(URI.create(targetUrl))
          .GET()
          .build();

      response =
        httpClient.send(request, HttpResponse.BodyHandlers.ofByteArray());

      System.out.println(response.statusCode());

    }catch(IOException e){
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    File imageFile = new File(System.getProperty("user.dir") + File.separator + "image_" + memeDescriptor.replace(" ", "-") + ".jpg");

    try(FileOutputStream writeImageToFile = new FileOutputStream(imageFile)){
      if(!imageFile.exists()){
        imageFile.createNewFile();
      }

      byte[] imageInBytes = response.body();
      writeImageToFile.write(imageInBytes);

    }catch(IOException e){

    }

    return response.body();

  }
}
