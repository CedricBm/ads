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

@WebServlet("/users")
public class UsersServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final Logger LOGGER = Logger.getLogger(UsersServlet.class.getCanonicalName());

  private UserDao ud;
  private UserForm uf;

  public UsersServlet() throws NamingException {
    super();
    ud = new UserDao((DataSource) new InitialContext().lookup("jdbc/ads"));
    uf = new UserForm();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("users", ud.all());
    LOGGER.info("GET /users");
    this.getServletContext().getRequestDispatcher("/WEB-INF/users/index.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    User u = uf.getUser(request);
    ud.create(u);
    LOGGER.info("POST /users");
    doGet(request, response);
  }
}
