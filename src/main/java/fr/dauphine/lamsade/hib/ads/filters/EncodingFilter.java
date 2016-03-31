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

/**
 * 
 * @author cedric beaumont
 *
 */
// Encodes every request to UTF-8 format. Allows special characters (e.g. accents) when submitting a form
@WebFilter("/*")
public class EncodingFilter implements Filter {
  public void destroy() {
  }

  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    request.setCharacterEncoding("UTF-8");
    chain.doFilter(request, response);
  }

  public void init(FilterConfig fConfig) throws ServletException {
  }
}