package main.java.fr.dauphine.lamsade.hib.ads.servlets;

import java.io.IOException;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.fr.dauphine.lamsade.hib.ads.dao.UserDao;
import main.java.fr.dauphine.lamsade.hib.ads.entities.User;
import main.java.fr.dauphine.lamsade.hib.ads.forms.UserForm;

/**
 * @author cedric beaumont
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final Logger LOGGER = Logger.getLogger(UserServlet.class.getCanonicalName());
  @EJB
  private UserDao ud;
  @EJB
  private UserForm uf;

  public UserServlet() throws NamingException {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    User u = ud.find(Integer.parseInt(request.getParameter("id")));
    request.setAttribute("user", u);
    LOGGER.info("GET /user with id: " + u.getId());
    this.getServletContext().getRequestDispatcher("/WEB-INF/users/edit.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    User u = uf.getUserForEdit(request);
    ud.save(u);
    LOGGER.info("POST /user with id: " + u.getId());
    response.sendRedirect("users");
  }
}
