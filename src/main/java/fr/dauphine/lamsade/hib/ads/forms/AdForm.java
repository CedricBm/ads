package main.java.fr.dauphine.lamsade.hib.ads.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import main.java.fr.dauphine.lamsade.hib.ads.beans.Ad;
import main.java.fr.dauphine.lamsade.hib.ads.resources.FormException;
import main.java.fr.dauphine.lamsade.hib.ads.resources.Util;

/**
 * @author inaki calzada
 */

@Stateless
public class AdForm {
  @Inject
  private Util util;
  
  public Ad getAd(HttpServletRequest request) {
    
    Ad ad = new Ad();
    try {
      ad.setTitle(util.getInputValue(request, "title"));
      ad.setPrice(Float.parseFloat(util.getInputValue(request, "price")));
      ad.setDescription(util.getInputValue(request, "description"));
      ad.setBuyable(Boolean.parseBoolean(util.getInputValue(request, "buyable")));
      SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
      
      Date parsed;
      parsed = format.parse(util.getInputValue(request, "available_at"));
      java.sql.Date sql = new java.sql.Date(parsed.getTime());
      ad.setAvailableAt(sql);
      
      ad.setAvailable(Boolean.parseBoolean(util.getInputValue(request, "available")));
      
      if (util.getInputValue(request, "buyer_id") != null)
        ad.setBuyerId(Integer.parseInt(util.getInputValue(request, "buyer_id")));
      
      ad.setSellerId(Integer.parseInt(util.getInputValue(request, "seller_id")));
      ad.setFootballerId(Integer.parseInt(util.getInputValue(request, "footballer_id")));
    } catch (ParseException e) {
      throw new FormException("Error while trying parse information from request ads: " + e);
    }
    return ad;
  }
  
  public Ad getAdForEdit(HttpServletRequest request) {
    Ad ad = getAd(request);
    if (ad != null)
      ad.setId(Integer.parseInt(util.getInputValue(request, "id")));
    return ad;
  }
}
