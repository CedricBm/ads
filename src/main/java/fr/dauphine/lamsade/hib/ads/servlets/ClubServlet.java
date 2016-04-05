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
import main.java.fr.dauphine.lamsade.hib.ads.forms.ClubForm;

/**
 * @author mathias pereira
 */
@WebServlet("/clubs")
public class ClubServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final Logger LOGGER = Logger.getLogger(ClubServlet.class.getCanonicalName());
  @EJB
  private ClubDao clubDao;
  @EJB
  private ClubForm clubForm;
  
  public ClubServlet() throws NamingException {
    super();
  }
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("clubs", clubDao.all());
    LOGGER.info("GET /clubs");
    this.getServletContext().getRequestDispatcher("/WEB-INF/clubs/index.jsp").forward(request, response);
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Club club = clubForm.getClub(request);
    if (club != null) {
      clubDao.create(club);
      request.setAttribute("error", null);
    } else {
      request.setAttribute("error", 1);
    }
    LOGGER.info("POST /clubs");
    doGet(request, response);
  }
}
