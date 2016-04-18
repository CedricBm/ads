package main.java.fr.dauphine.lamsade.hib.ads.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.fr.dauphine.lamsade.hib.ads.entities.User;
import main.java.fr.dauphine.lamsade.hib.ads.forms.AuthenticationForm;
import main.java.fr.dauphine.lamsade.hib.ads.resources.Util;

/**
 * 
 * @author cedric beaumont
 *
 */
@WebServlet("/login")
public class AuthenticationServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @EJB
  private AuthenticationForm authenticationForm;
  @EJB
  private Util util;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (util.currentUser(request.getSession()) == null) {
      this.getServletContext().getRequestDispatcher("/WEB-INF/connection/authentication.jsp").forward(request, response);
    } else {
      request.getSession().setAttribute("notice", "Vous êtes déjà connecté.");
      response.sendRedirect("/ads/users");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    User u = authenticationForm.getUser(request);

    if (u == null) {
      request.setAttribute("error", "Votre login ou mot de passe est erroné.");
      this.getServletContext().getRequestDispatcher("/WEB-INF/connection/authentication.jsp").forward(request, response);
    } else {
      util.login(u, request.getSession());
      request.getSession().setAttribute("notice", "Connexion réussie!");
      response.sendRedirect("/ads/users");
    }
  }
}