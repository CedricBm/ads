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

import main.java.fr.dauphine.lamsade.hib.ads.beans.Ad;
import main.java.fr.dauphine.lamsade.hib.ads.dao.AdDao;

/**
 * Servlet implementation class AdDeleteServlet
 */
/**
 * @author inaki calzada
 */
@WebServlet("/ads/delete")
public class AdDeleteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final Logger LOGGER = Logger.getLogger(UserDeleteServlet.class.getCanonicalName());
  @EJB
  private AdDao ad;
  
  public AdDeleteServlet() throws NamingException {
    super();
  }
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Ad a = ad.find(Integer.parseInt(request.getParameter("id")));
    request.setAttribute("ad", a);
    LOGGER.info("GET /ads/delete with id: " + a.getId());
    this.getServletContext().getRequestDispatcher("/WEB-INF/ads/delete.jsp").forward(request, response);
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ad.delete(Integer.parseInt(request.getParameter("id")));
    LOGGER.info("POST /ads/delete with id: " + request.getParameter("id"));
    response.sendRedirect("../ads");
  }
  
}
