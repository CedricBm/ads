package main.java.fr.dauphine.lamsade.hib.ads.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.fr.dauphine.lamsade.hib.ads.dao.UserDao;
import main.java.fr.dauphine.lamsade.hib.ads.entities.User;
import main.java.fr.dauphine.lamsade.hib.ads.forms.UserForm;

/**
 * 
 * @author cedric beaumont
 *
 */
@WebServlet("/signup")
public class SubscribeServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @EJB
  private UserDao ud;
  @EJB
  private UserForm uf;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    User u = uf.getUser(request);
    ud.create(u);
    request.getSession().setAttribute("success", "Inscription réussie!");
    response.sendRedirect("/ads");
  }
}
