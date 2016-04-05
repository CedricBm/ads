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

import main.java.fr.dauphine.lamsade.hib.ads.dao.ClubDao;
import main.java.fr.dauphine.lamsade.hib.ads.entities.Club;

/**
 * @author mathias pereira
 */
@WebServlet("/clubs/delete")
public class ClubDeleteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final Logger LOGGER = Logger.getLogger(ClubDeleteServlet.class.getCanonicalName());
  @EJB
  private ClubDao clubDao;
  
  public ClubDeleteServlet() throws NamingException {
    super();
  }
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Club club = clubDao.find(Integer.parseInt(request.getParameter("id")));
    request.setAttribute("club", club);
    LOGGER.info("GET /clubs/delete with id: " + club.getId());
    this.getServletContext().getRequestDispatcher("/WEB-INF/clubs/delete.jsp").forward(request, response);
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    clubDao.delete(Integer.parseInt(request.getParameter("id")));
    LOGGER.info("POST /clubs/delete with id: " + request.getParameter("id"));
    response.sendRedirect("../clubs");
  }
  
}
