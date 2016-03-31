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
import main.java.fr.dauphine.lamsade.hib.ads.forms.FootballerForm;

/**
 * Servlet implementation class FootballerServlet
 */
/**
 * 
 * @author yassine ramrani
 *
 */
@WebServlet("/footballers")
public class FootballerServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(UserServlet.class.getCanonicalName());
    
	  private FootballerDao fd;
	  private FootballerForm ff;

	  public FootballerServlet() throws NamingException {
	    super();
	    fd = new FootballerDao((DataSource) new InitialContext().lookup("jdbc/ads"));
	    ff = new FootballerForm();
	  }

	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setAttribute("footballers", fd.all());
	    LOGGER.info("GET /footballers");
	    this.getServletContext().getRequestDispatcher("/WEB-INF/footballers/index.jsp").forward(request, response);
	  }

	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Footballer f = ff.getFootballer(request);
	    fd.create(f);
	    LOGGER.info("POST /footballers");
	    doGet(request, response);
	  }

}
