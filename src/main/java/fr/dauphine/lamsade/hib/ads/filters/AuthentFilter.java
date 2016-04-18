package main.java.fr.dauphine.lamsade.hib.ads.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.fr.dauphine.lamsade.hib.ads.entities.User;

/**
 * 
 * @author cedric beaumont
 *
 */
@WebFilter(urlPatterns = { "/users", "/user/*", "/user", "/footballers/*", "/footballers", "/clubs/*", "/clubs", "/ads/*", "/ads" })
public class AuthentFilter implements Filter {
  public void destroy() {
  }

  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    HttpSession session = request.getSession();

    User u = (User) session.getAttribute("user");
    if (u != null) {
      chain.doFilter(request, response);
    } else {
      session.setAttribute("alert", "Connectez-vous pour accéder à cette page.");
      response.sendRedirect("/ads");
    }
  }

  public void init(FilterConfig fConfig) throws ServletException {
  }
}