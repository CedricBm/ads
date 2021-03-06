package main.java.fr.dauphine.lamsade.hib.ads.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author cedric beaumont
 *
 */
@WebServlet("/accueil")
public class LandingServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    if (session.getAttribute("alert") != null) {
      request.setAttribute("alert", session.getAttribute("alert"));
      session.removeAttribute("alert");
    }
    if (session.getAttribute("notice") != null) {
      request.setAttribute("notice", session.getAttribute("notice"));
      session.removeAttribute("notice");
    }
    if (session.getAttribute("success") != null) {
      request.setAttribute("success", session.getAttribute("success"));
      session.removeAttribute("success");
    }
    this.getServletContext().getRequestDispatcher("/WEB-INF/landing/landing.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
