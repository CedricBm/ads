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
 * 
 * @author yassine ramrani
 *
 */
@WebServlet("/footballers/modify")
public class FootballerModifyServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(UserServlet.class.getCanonicalName());
    
	  private FootballerDao fd;
	  private FootballerForm ff;

	  public FootballerModifyServlet() throws NamingException {
	    super();
	    fd = new FootballerDao((DataSource) new InitialContext().lookup("jdbc/ads"));
	    ff = new FootballerForm();
	  }

	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Footballer f = fd.find(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("footballers", f);
	    LOGGER.info("GET /footballers/modify with id: " + f.getId());
	    this.getServletContext().getRequestDispatcher("/WEB-INF/footballers/edit.jsp").forward(request, response);
	  }

	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Footballer f = ff.getFootballerForEdit(request);
	    fd.create(f);
	    LOGGER.info("POST /footballers/modify with id: " + f.getId());
	    doGet(request, response);
	  }

}