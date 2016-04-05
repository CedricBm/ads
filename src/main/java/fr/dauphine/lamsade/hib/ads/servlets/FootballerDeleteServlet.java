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

import main.java.fr.dauphine.lamsade.hib.ads.dao.FootballerDao;
import main.java.fr.dauphine.lamsade.hib.ads.entities.Footballer;

/**
 * @author yassine ramrani
 */
@WebServlet("/footballers/delete")
public class FootballerDeleteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final Logger LOGGER = Logger.getLogger(UserDeleteServlet.class.getCanonicalName());
  @EJB
  private FootballerDao fd;
  
  public FootballerDeleteServlet() throws NamingException {
    super();
  }
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Footballer f = fd.find(Integer.parseInt(request.getParameter("id")));
    request.setAttribute("footballer", f);
    LOGGER.info("GET /footballers/delete with id: " + f.getId());
    this.getServletContext().getRequestDispatcher("/WEB-INF/footballers/delete.jsp").forward(request, response);
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    fd.delete(Integer.parseInt(request.getParameter("id")));
    LOGGER.info("POST /footballers/delete with id: " + request.getParameter("id"));
    response.sendRedirect("../footballers");
  }
  
}
