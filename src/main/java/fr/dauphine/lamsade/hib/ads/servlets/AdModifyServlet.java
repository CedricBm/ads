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
 * Servlet implementation class AdModifyServlet
 */
@WebServlet("/ads/modify")
public class AdModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  private AdDao ad;
	  private AdForm af;

	  public AdModifyServlet() throws NamingException {
	    super();
	    ad = new AdDao((DataSource) new InitialContext().lookup("jdbc/ads"));
	    af = new AdForm();
	  }

	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Ad a = ad.find(Integer.parseInt(request.getParameter("id")));
	    request.setAttribute("ad", a);
	    this.getServletContext().getRequestDispatcher("/WEB-INF/ads/edit.jsp").forward(request, response);
	  }

	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Ad a = af.getAdForEdit(request);
	    ad.save(a);
	    response.sendRedirect("ads");
	  }

}
