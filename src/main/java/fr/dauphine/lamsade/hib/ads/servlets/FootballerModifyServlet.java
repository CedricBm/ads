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

import main.java.fr.dauphine.lamsade.hib.ads.dao.FootballerDao;
import main.java.fr.dauphine.lamsade.hib.ads.entities.Footballer;
import main.java.fr.dauphine.lamsade.hib.ads.forms.FootballerForm;

/**
 * @author yassine ramrami
 */
@WebServlet("/footballers/modify")
public class FootballerModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(UserServlet.class.getCanonicalName());
	@EJB
	private FootballerDao fd;
	@EJB
	private FootballerForm ff;

	public FootballerModifyServlet() throws NamingException {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Footballer f = fd.find(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("footballer", f);
		LOGGER.info("GET /footballers/modify with id: " + f.getId());
		this.getServletContext().getRequestDispatcher("/WEB-INF/footballers/edit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Footballer f = ff.getFootballerForEdit(request);
		if (f != null) {
			fd.save(f);
			request.setAttribute("error", null);
			LOGGER.info("POST /footballers/modify with id: " + f.getId());
			response.sendRedirect("../footballers");
		} else {
			request.setAttribute("error", 1);
			doGet(request, response);
		}
	}

}
