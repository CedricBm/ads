package main.java.fr.dauphine.lamsade.hib.ads.resources;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

/**
 * @author cedric beaumont
 */

@Stateless
public class Util {
  
  public String getInputValue(HttpServletRequest request, String inputName) {
    String value = request.getParameter(inputName);
    if (value == null || value.trim().length() == 0) {
      return null;
    } else {
      return value.trim();
    }
  }
  
  public byte[] encrypt(String password) {
    try {
      java.security.MessageDigest d = null;
      d = java.security.MessageDigest.getInstance("SHA-256");
      d.reset();
      d.update(password.getBytes());
      return d.digest();
    } catch (Throwable ex) {
      throw new RuntimeException("Password encryption error");
    }
  }
}
