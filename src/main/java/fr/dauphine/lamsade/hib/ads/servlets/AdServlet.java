package main.java.fr.dauphine.lamsade.hib.ads.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.fr.dauphine.lamsade.hib.ads.dao.AdDao;
import main.java.fr.dauphine.lamsade.hib.ads.dao.FootballerDao;
import main.java.fr.dauphine.lamsade.hib.ads.dao.UserDao;
import main.java.fr.dauphine.lamsade.hib.ads.entities.Ad;
import main.java.fr.dauphine.lamsade.hib.ads.forms.AdForm;
import main.java.fr.dauphine.lamsade.hib.ads.resources.Util;

/**
 * Servlet implementation class AdServlet
 */
/**
 * @author inaki calzada
 */
@WebServlet("/ads")
public class AdServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final Logger LOGGER = Logger.getLogger(UserServlet.class.getCanonicalName());
  @EJB
  private AdDao ad;
  @EJB
  private AdForm af;
  @EJB
  private Util util;
  @EJB
  private UserDao ud;
  @EJB
  private FootballerDao fd;

  public AdServlet() throws NamingException {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("ads", ad.all());
    LOGGER.info("GET /ads");
    this.getServletContext().getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Ad a = af.getAd(request);
    if (a != null && request.getParameter("ajouter") != null) {
      ad.create(a);
      request.setAttribute("error", null);
      LOGGER.info("POST /ads");
      doGet(request, response);
    } else if (a != null && request.getParameter("rechercher") != null) {
      String titre = (util.getInputValue(request, "title") == null ? "" : util.getInputValue(request, "title"));
      float prix = (util.getInputValue(request, "price") == null ? 0
          : Float.parseFloat(util.getInputValue(request, "price")));
      String desc = (util.getInputValue(request, "description") == null ? ""
          : util.getInputValue(request, "description"));
      SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
      Date parsed = new Date();
      try {
        parsed = (util.getInputValue(request, "available_at") == null ? new Date()
            : format.parse(util.getInputValue(request, "available_at")));
      } catch (ParseException e) {
      }
      java.sql.Date date = new java.sql.Date(parsed.getTime());
      int sellerId = (util.getInputValue(request, "seller_id") == null ? 0 : Integer.parseInt(util.getInputValue(request, "seller_id")));
      int footballerId = (util.getInputValue(request, "footballer_id") == null ? 0 : Integer.parseInt(util.getInputValue(request, "footballer_id")));
      request.setAttribute("ads", ad.findMultiple(titre, prix, desc, date,sellerId,footballerId));
      request.setAttribute("error", null);
      LOGGER.info("POST /ads");
      this.getServletContext().getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    } else {
      request.setAttribute("error", 1);
      LOGGER.info("POST /ads");
      doGet(request, response);
    }
  }

}
