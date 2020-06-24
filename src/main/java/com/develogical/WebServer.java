package com.develogical;

import com.develogical.web.ApiResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.function.Function;
import java.util.stream.Stream;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.develogical.web.StatusPage;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlet.Source;

public class WebServer {

  public WebServer() throws Exception {

    Server server = new Server(portNumberToUse());

    ServletHandler handler = new ServletHandler();
    handler.addServletWithMapping(new ServletHolder(new RootPage()), "/*");
    handler.addServletWithMapping(new ServletHolder(new Api()), "/api/*");
    handler.addServletWithMapping(new ServletHolder(new CacheDisplay()), "/cache/*");
    server.setHandler(handler);

    server.start();
  }

  static class Api extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String query = req.getParameter("q");
      new ApiResponse(new QueryProcessor().process(query)).writeTo(resp);
    }
  }

  static class CacheDisplay extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      StringBuilder builder = new StringBuilder();
      QueryProcessor.cache.forEach(str -> {
        builder.append("<p>");
        builder.append(str.substring(8));
        builder.append("</p>");
      });
      PrintWriter writer = resp.getWriter();
      
      resp.setContentType("text/html");
      writer.println("<html>");
      writer.println("<body>");
      writer.println("<h3>Queries</h3>");
      writer.println(builder.toString());
      writer.println("</body>");
      writer.println("</html>");
      
    }
  }

  private static class RootPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      new StatusPage().writeTo(resp);
    }
  }

  private Integer portNumberToUse() {
    return System.getenv("PORT") != null ? Integer.valueOf(System.getenv("PORT")) : 5000;
  }

  public static void main(String[] args) throws Exception {
    new WebServer();
  }
}