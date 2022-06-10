package lecture.excursion.java18;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class HttpTimeHandler implements HttpHandler {


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
                        	<h1>Time goes here...</h1>
                          </body>
                        </html>
                        """;

    exchange.sendResponseHeaders(200, response.length());
    OutputStream os = exchange.getResponseBody();
    os.write(response.getBytes());
    os.close();
  }
}
