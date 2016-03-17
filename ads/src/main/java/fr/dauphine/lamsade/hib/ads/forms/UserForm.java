package main.java.fr.dauphine.lamsade.hib.ads.forms;

import javax.servlet.http.HttpServletRequest;

import main.java.fr.dauphine.lamsade.hib.ads.beans.User;
import main.java.fr.dauphine.lamsade.hib.ads.resources.Util;

public class UserForm {

  public User getUser(HttpServletRequest request) {
    User user = new User();
    user.setLname(Util.getInputValue(request, "lname"));
    user.setFname(Util.getInputValue(request, "fname"));
    user.setEmail(Util.getInputValue(request, "email"));
    user.setPassword(Util.encrypt(Util.getInputValue(request, "password")));

    return user;
  }

  public User getUserForEdit(HttpServletRequest request) {
    User user = getUser(request);
    user.setId(Integer.parseInt(Util.getInputValue(request, "id")));

    return user;
  }
}