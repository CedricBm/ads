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
import main.java.fr.dauphine.lamsade.hib.ads.entities.Ad;
import main.java.fr.dauphine.lamsade.hib.ads.forms.AdForm;

/**
 * Servlet implementation class AdModifyServlet
 */
/**
 * @author inaki calzada
 */
@WebServlet("/ads/modify")
public class AdModifyServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final Logger LOGGER = Logger.getLogger(UserServlet.class.getCanonicalName());
  @EJB
  private AdDao ad;
  @EJB
  private AdForm af;
  
  public AdModifyServlet() throws NamingException {
    super();
  }
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Ad a = ad.find(Integer.parseInt(request.getParameter("id")));
    request.setAttribute("ad", a);
    LOGGER.info("GET /ads/modify with id: " + a.getId());
    this.getServletContext().getRequestDispatcher("/WEB-INF/ads/edit.jsp").forward(request, response);
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Ad a = af.getAdForEdit(request);
    if (a != null) {
      ad.save(a);
      request.setAttribute("error", null);
      LOGGER.info("POST /ads/modify with id: " + a.getId());
      response.sendRedirect("../ads");
    } else {
      request.setAttribute("error", 1);
      doGet(request, response);
    }
    
  }
  
}
