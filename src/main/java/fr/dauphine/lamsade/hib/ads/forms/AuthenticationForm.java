package main.java.fr.dauphine.lamsade.hib.ads.forms;

import java.util.Arrays;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

import main.java.fr.dauphine.lamsade.hib.ads.dao.UserDao;
import main.java.fr.dauphine.lamsade.hib.ads.entities.User;
import main.java.fr.dauphine.lamsade.hib.ads.resources.Util;

/**
 * 
 * @author cedric beaumont
 *
 */
@Stateless
public class AuthenticationForm {
  @EJB
  private UserDao userDao;
  @EJB
  private Util util;

  public User getUser(HttpServletRequest request) {
    User user = userDao.getByEmail(util.getInputValue(request, "email"));

    if (user != null && Arrays.equals(util.encrypt(util.getInputValue(request, "password")), user.getPassword())) {
      return user;
    }
    return null;
  }
}