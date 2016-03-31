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

import main.java.fr.dauphine.lamsade.hib.ads.beans.Footballer;
import main.java.fr.dauphine.lamsade.hib.ads.dao.FootballerDao;

/**
 * 
 * @author yassine ramrani
 *
 */
@WebServlet("/footballers/delete")
public class FootballerDeleteServlet extends HttpServlet{
	  private static final long serialVersionUID = 1L;
	  private static final Logger LOGGER = Logger.getLogger(UserDeleteServlet.class.getCanonicalName());

	  private FootballerDao fd;

	  public FootballerDeleteServlet() throws NamingException {
	    super();
	    fd = new FootballerDao((DataSource) new InitialContext().lookup("jdbc/ads"));
	  }

	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Footballer f = fd.find(Integer.parseInt(request.getParameter("id")));
	    request.setAttribute("footballer", f);
	    LOGGER.info("GET /footballers/delete with id: " + f.getId());
	    this.getServletContext().getRequestDispatcher("/WEB-INF/footballers/delete.jsp").forward(request, response);
	  }

	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    fd.delete(Integer.parseInt(request.getParameter("id")));
	    LOGGER.info("POST /footballers/delete with id: " + request.getParameter("id"));
	    response.sendRedirect("../footballers");
	  }
	
}
