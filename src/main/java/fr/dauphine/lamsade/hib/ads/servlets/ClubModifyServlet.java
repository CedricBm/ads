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

/**
 * Servlet implementation class ClubModifyServlet
 */
/**
 * 
 * @author mathias pereira
 *
 */
@WebServlet("/clubs/modify")
public class ClubModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger CLUB_MODIFY_SERVLET_LOGGER = Logger.getLogger(ClubModifyServlet.class.getCanonicalName());
	private ClubDao clubDao;
	private ClubForm clubForm;

	public ClubModifyServlet() throws NamingException {
		super();
		clubForm =new ClubForm();
		clubDao = new ClubDao((DataSource) new InitialContext().lookup("jdbc/ads"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Club club = clubDao.find(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("club", club);
		CLUB_MODIFY_SERVLET_LOGGER.info("GET /clubs/modify with id: " + club.getId());
		this.getServletContext().getRequestDispatcher("/WEB-INF/clubs/edit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Club club = clubForm.getClubForEdit(request);
		if(club!=null)
		{
			clubDao.save(club); 
			request.setAttribute("error", null);
			CLUB_MODIFY_SERVLET_LOGGER.info("POST /clubs/modify with id: " + club.getId());
			response.sendRedirect("../clubs");
		}else
		{
			request.setAttribute("error", 1);
			doGet(request,response);
		}
	}

}
