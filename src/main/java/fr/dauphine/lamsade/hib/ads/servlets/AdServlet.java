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

import main.java.fr.dauphine.lamsade.hib.ads.beans.Ad;
import main.java.fr.dauphine.lamsade.hib.ads.dao.AdDao;
import main.java.fr.dauphine.lamsade.hib.ads.forms.AdForm;

/**
 * Servlet implementation class AdServlet
 */
/**
 * 
 * @author inaki calzada
 *
 */
@WebServlet("/ads")
public class AdServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final Logger LOGGER = Logger.getLogger(UserServlet.class.getCanonicalName());

  private AdDao ad;
  private AdForm af;

  public AdServlet() throws NamingException {
    super();
    ad = new AdDao((DataSource) new InitialContext().lookup("jdbc/ads"));
    af = new AdForm();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("ads", ad.all());
    LOGGER.info("GET /ads");
    this.getServletContext().getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Ad a = af.getAd(request);
    if (a!=null)
    {
      ad.create(a);
      request.setAttribute("error", null);
    }else
    {
      request.setAttribute("error", 1);
    }
    LOGGER.info("POST /ads");
    doGet(request, response);
  }

}
