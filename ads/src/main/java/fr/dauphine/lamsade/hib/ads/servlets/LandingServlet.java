package main.java.fr.dauphine.lamsade.hib.ads.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/accueil")
public class LandingServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      try {
        DataSource ds = (DataSource) new InitialContext().lookup("jdbc/ads_pg");
        Connection c = ds.getConnection();
        PreparedStatement ps = c.prepareStatement("insert into users (fname, lname, email, password) values ('ced', 'ced', 'ced@ced.fr', 'password')");
        ps.executeQuery();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    this.getServletContext().getRequestDispatcher("/WEB-INF/landing/landing.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
