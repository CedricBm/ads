package main.java.fr.dauphine.lamsade.hib.ads.servlets;

import java.io.IOException;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import main.java.fr.dauphine.lamsade.hib.ads.beans.User;
import main.java.fr.dauphine.lamsade.hib.ads.dao.UserDao;
import main.java.fr.dauphine.lamsade.hib.ads.forms.UserForm;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final Logger LOGGER = Logger.getLogger(UserServlet.class.getCanonicalName());

  private UserDao ud;
  private UserForm uf;

  public UserServlet() throws NamingException {
    super();
    ud = new UserDao((DataSource) new InitialContext().lookup("jdbc/ads"));
    uf = new UserForm();
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
