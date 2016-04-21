package main.java.fr.dauphine.lamsade.hib.ads.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

import main.java.fr.dauphine.lamsade.hib.ads.dao.FootballerDao;
import main.java.fr.dauphine.lamsade.hib.ads.dao.UserDao;
import main.java.fr.dauphine.lamsade.hib.ads.entities.Ad;
import main.java.fr.dauphine.lamsade.hib.ads.resources.FormException;
import main.java.fr.dauphine.lamsade.hib.ads.resources.Util;

/**
 * @author inaki calzada
 */

@Stateless
public class AdForm {
  @EJB
  private Util util;
  @EJB
  private UserDao ud;
  @EJB
  private FootballerDao fd;

  public Ad getAd(HttpServletRequest request) {

    Ad ad = new Ad();
    try {
      ad.setTitle(util.getInputValue(request, "title"));
      if (util.getInputValue(request, "price") != null)
        ad.setPrice(Float.parseFloat(util.getInputValue(request, "price")));
      ad.setDescription(util.getInputValue(request, "description"));
      if (util.getInputValue(request, "buyable") != null) {
        ad.setBuyable("1".equals(util.getInputValue(request, "buyable")));
      }
      SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

      Date parsed = new Date();
      if (util.getInputValue(request, "available_at") != null)
        parsed = format.parse(util.getInputValue(request, "available_at"));
      java.sql.Date sql = new java.sql.Date(parsed.getTime());
      ad.setAvailableAt(sql);

      if (util.getInputValue(request, "available") != null)
        ad.setAvailable(Boolean.parseBoolean(util.getInputValue(request, "available")));

      if (util.getInputValue(request, "buyer_id") != null)
        ad.setBuyer(ud.find(Integer.parseInt(util.getInputValue(request, "buyer_id"))));

      if (util.getInputValue(request, "seller_id") != null)
        ad.setSeller(ud.find(Integer.parseInt(util.getInputValue(request, "seller_id"))));
      if (util.getInputValue(request, "footballer_id") != null)
        ad.setFootballer(fd.find(Integer.parseInt(util.getInputValue(request, "footballer_id"))));
    } catch (ParseException e) {
      throw new FormException("Error while trying parse information from request ads: " + e);
    }
    return ad;
  }

  public Ad getAdForEdit(HttpServletRequest request) {
    Ad ad = getAd(request);
    if (ad != null) {
      ad.setId(Integer.parseInt(util.getInputValue(request, "id")));
    }
    return ad;
  }
}
