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
 * Servlet implementation class ClubModifyServlet
 */
/**
 * @author mathias pereira
 */
@WebServlet("/clubs/modify")
public class ClubModifyServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final Logger LOGGER = Logger.getLogger(ClubModifyServlet.class.getCanonicalName());
  @EJB
  private ClubDao clubDao;
  @EJB
  private ClubForm clubForm;
  
  public ClubModifyServlet() throws NamingException {
    super();
  }
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Club club = clubDao.find(Integer.parseInt(request.getParameter("id")));
    request.setAttribute("club", club);
    LOGGER.info("GET /clubs/modify with id: " + club.getId());
    this.getServletContext().getRequestDispatcher("/WEB-INF/clubs/edit.jsp").forward(request, response);
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Club club = clubForm.getClubForEdit(request);
    if (club != null) {
      clubDao.save(club);
      request.setAttribute("error", null);
      LOGGER.info("POST /clubs/modify with id: " + club.getId());
      response.sendRedirect("../clubs");
    } else {
      request.setAttribute("error", 1);
      doGet(request, response);
    }
  }
  
}
