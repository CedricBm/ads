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
import main.java.fr.dauphine.lamsade.hib.ads.forms.ClubForm;

@WebServlet("/clubs")
public class ClubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger CLUB_SERVLET_LOGGER = Logger.getLogger(ClubServlet.class.getCanonicalName());
	private ClubDao clubDao;
	private ClubForm clubForm;

	public ClubServlet() throws NamingException {
		super();
		clubForm = new ClubForm();
		clubDao = new ClubDao((DataSource) new InitialContext().lookup("jdbc/ads"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("clubs", clubDao.all());
		CLUB_SERVLET_LOGGER.info("GET /clubs");
		this.getServletContext().getRequestDispatcher("/WEB-INF/clubs/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Club club = clubForm.getClub(request);
		if (club!=null)
		{
			clubDao.create(club);
			request.setAttribute("error", null);
		}else
		{
			request.setAttribute("error", 1);
		}
		CLUB_SERVLET_LOGGER.info("POST /clubs");
		doGet(request, response);
	}
}


