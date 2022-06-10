package lecture.excursion.java18;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleWebServerExample {

  public static void main(String[] args) {

    try {
      HttpServer myServer = HttpServer.create(new InetSocketAddress(8080), 0);

      myServer.createContext("/hello", new HttpHandler() {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
          System.out.println("URI: " + exchange.getRequestURI());
          System.out.println("Method: " + exchange.getRequestMethod());

          String response = """
                        <!DOCTYPE html>
                        <html lang="en">
                          <head>
                            <meta charset="UTF-8">
                            <meta name="viewport" content="width=device-width, initial-scale=1.0">
                            <meta http-equiv="X-UA-Compatible" content="ie=edge">
                            <title>HTML 5 Boilerplate</title>
                            <link rel="stylesheet" href="style.css">
                          </head>
                          <body>
                        	<h1>Welcome World!</h1>
                          </body>
                        </html>
                        """;

          exchange.sendResponseHeaders(200, response.length());
          OutputStream os = exchange.getResponseBody();
          os.write(response.getBytes());
          os.close();
        }
      });

      myServer.createContext("/time", new HttpTimeHandler());


      myServer.createContext("/stop", exchange -> {
        System.out.println("URI: " + exchange.getRequestURI());
        System.out.println("Method: " + exchange.getRequestMethod());

        String response = """
                        <!DOCTYPE html>
                        <html lang="en">
                          <head>
                            <meta charset="UTF-8">
                            <meta name="viewport" content="width=device-width, initial-scale=1.0">
                            <meta http-equiv="X-UA-Compatible" content="ie=edge">
                            <title>HTML 5 Boilerplate</title>
                            <link rel="stylesheet" href="style.css">
                          </head>
                          <body>
                        	<h1>Good Bye</h1>
                          </body>
                        </html>
                        """;

        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();

        myServer.stop(5);
      });


      myServer.setExecutor(null);
      myServer.start();

    }catch(Exception e){
      System.out.println("Da ist was schief gegangen!");
    }
  }
}
