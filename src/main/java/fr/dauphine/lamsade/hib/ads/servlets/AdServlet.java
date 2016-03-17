package main.java.fr.dauphine.lamsade.hib.ads.servlets;

import java.io.IOException;

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
@WebServlet("/ads")
public class AdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  private AdDao ad;
	  private AdForm af;

	  public AdServlet() throws NamingException {
	    super();
	    ad = new AdDao((DataSource) new InitialContext().lookup("jdbc/ads"));
	    af = new AdForm();
	  }

	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setAttribute("ads", ad.all());
	    this.getServletContext().getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
	  }

	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Ad a = af.getAd(request);
	    ad.create(a);
	    doGet(request, response);
	  }

}
