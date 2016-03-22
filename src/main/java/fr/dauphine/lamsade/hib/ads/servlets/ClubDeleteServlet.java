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
import main.java.fr.dauphine.lamsade.hib.ads.beans.Club;
import main.java.fr.dauphine.lamsade.hib.ads.dao.ClubDao;


@WebServlet("/clubs/delete")
public class ClubDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger CLUB_DELETE_SERVLET_LOGGER = Logger.getLogger(ClubDeleteServlet.class.getCanonicalName());
	private ClubDao clubDao;

	public ClubDeleteServlet() throws NamingException {
		super();
		clubDao = new ClubDao((DataSource) new InitialContext().lookup("jdbc/ads"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Club club = clubDao.find(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("club", club);
		CLUB_DELETE_SERVLET_LOGGER.info("GET /clubs/delete with id: " + club.getId());
		this.getServletContext().getRequestDispatcher("/WEB-INF/clubs/delete.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		clubDao.delete(Integer.parseInt(request.getParameter("id")));
	    CLUB_DELETE_SERVLET_LOGGER.info("POST /clubs/delete with id: " + request.getParameter("id"));
	    response.sendRedirect("../clubs");
	}

}
