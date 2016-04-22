package main.java.fr.dauphine.lamsade.hib.ads.forms;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

import main.java.fr.dauphine.lamsade.hib.ads.dao.UserDao;
import main.java.fr.dauphine.lamsade.hib.ads.entities.User;
import main.java.fr.dauphine.lamsade.hib.ads.resources.Util;

/**
 * @author cedric beaumont
 */

@Stateless
public class UserForm {
  @EJB
  private Util util;
  @EJB
  private UserDao ud;

  public User getUser(HttpServletRequest request) {
    User user = new User();
    user.setLname(util.getInputValue(request, "lname"));
    user.setFname(util.getInputValue(request, "fname"));
    user.setEmail(util.getInputValue(request, "email"));
    user.setPassword(util.encrypt(util.getInputValue(request, "password")));

    return user;
  }

  public User getUserForEdit(HttpServletRequest request) {
    User user = ud.find(Integer.parseInt(util.getInputValue(request, "id")));
    user.setLname(util.getInputValue(request, "lname"));
    user.setFname(util.getInputValue(request, "fname"));
    user.setEmail(util.getInputValue(request, "email"));
    user.setPassword(util.encrypt(util.getInputValue(request, "password")));

    return user;
  }
  
  public User getUserForBuy(HttpServletRequest request) {
    return ud.find(Integer.parseInt(util.getInputValue(request, "buyer_id")));
  }
}
