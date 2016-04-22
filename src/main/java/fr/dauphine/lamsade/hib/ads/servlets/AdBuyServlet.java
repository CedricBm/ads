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

import main.java.fr.dauphine.lamsade.hib.ads.dao.AdDao;
import main.java.fr.dauphine.lamsade.hib.ads.dao.ClubDao;
import main.java.fr.dauphine.lamsade.hib.ads.dao.FootballerDao;
import main.java.fr.dauphine.lamsade.hib.ads.dao.UserDao;
import main.java.fr.dauphine.lamsade.hib.ads.entities.Ad;
import main.java.fr.dauphine.lamsade.hib.ads.entities.Club;
import main.java.fr.dauphine.lamsade.hib.ads.entities.Footballer;
import main.java.fr.dauphine.lamsade.hib.ads.entities.User;
import main.java.fr.dauphine.lamsade.hib.ads.forms.AdForm;
import main.java.fr.dauphine.lamsade.hib.ads.forms.FootballerForm;
import main.java.fr.dauphine.lamsade.hib.ads.forms.UserForm;

/**
 * @author Inaki Calzada
 */
@WebServlet("/ads/buy")
public class AdBuyServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final Logger LOGGER = Logger.getLogger(UserServlet.class.getCanonicalName());
  @EJB
  private AdDao ad;
  @EJB
  private AdForm af;
  @EJB
  private UserDao ud;
  @EJB
  private UserForm uf;
  @EJB
  private FootballerDao fd;
  @EJB
  private FootballerForm ff;
  @EJB
  private ClubDao cd;
  
  public AdBuyServlet() throws NamingException {
    super();
  }
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Ad a = ad.find(Integer.parseInt(request.getParameter("id")));
    request.setAttribute("ad", a);
    LOGGER.info("GET /ads/buy with id: " + a.getId());
    this.getServletContext().getRequestDispatcher("/WEB-INF/ads/buy.jsp").forward(request, response);
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Ad a = af.getAdForEdit(request);
    if (a != null) {
      User u = uf.getUserForBuy(request);
      if(u != null)
      {
        ud.withdraw(u.getId(), a.getPrice());
        Footballer f = ff.getFootballerForBuy(request);
        Club c = cd.getByManager(u.getId());
        fd.changeClub(f.getId(), c);
        ad.buy(a.getId(), u);
      }
      request.setAttribute("error", null);
      LOGGER.info("POST /ads/buy with id: " + a.getId());
      response.sendRedirect("../ads");
    } else {
      request.setAttribute("error", 1);
      doGet(request, response);
    }
    
  }
}
