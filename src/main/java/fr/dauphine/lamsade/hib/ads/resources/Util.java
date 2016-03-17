package main.java.fr.dauphine.lamsade.hib.ads.resources;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

public final class Util {
  private static final Logger LOGGER = Logger.getLogger(Util.class.getCanonicalName());

  public static String getInputValue(HttpServletRequest request, String inputName) {
    String value = request.getParameter(inputName);
    if (value == null || value.trim().length() == 0) {
      return null;
    } else {
      return value.trim();
    }
  }

  public static String encrypt(String password) {
    try {
      java.security.MessageDigest d = null;
      d = java.security.MessageDigest.getInstance("SHA-256");
      d.reset();
      d.update(password.getBytes());
      return new String(d.digest());
    } catch (Throwable ex) {
      LOGGER.severe("Encryption failed. " + ex);
    }
    return null;
  }
}