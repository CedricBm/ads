package main.java.fr.dauphine.lamsade.hib.ads.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import main.java.fr.dauphine.lamsade.hib.ads.beans.Ad;
import main.java.fr.dauphine.lamsade.hib.ads.resources.Util;

public class AdForm {

  public Ad getAd(HttpServletRequest request) {
    Ad ad = new Ad();
    ad.setTitle(Util.getInputValue(request, "title"));
    ad.setPrice(Float.parseFloat(Util.getInputValue(request, "price")));
    ad.setDescription(Util.getInputValue(request, "description"));
    ad.setBuyable(Boolean.parseBoolean(Util.getInputValue(request, "buyable")));
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    Date parsed;
    try {
      parsed = format.parse(Util.getInputValue(request, "available_at"));
      java.sql.Date sql = new java.sql.Date(parsed.getTime());
      ad.setAvailableAt(sql);
    } catch (ParseException e) {
      return null;
    }
    ad.setAvailable(Boolean.parseBoolean(Util.getInputValue(request, "available")));
    if (Util.getInputValue(request, "buyer_id") != null)
      ad.setBuyerId(Integer.parseInt(Util.getInputValue(request, "buyer_id")));
    ad.setSellerId(Integer.parseInt(Util.getInputValue(request, "seller_id")));
    ad.setFootballerId(Integer.parseInt(Util.getInputValue(request, "footballer_id")));
    return ad;
  }

  public Ad getAdForEdit(HttpServletRequest request) {
    Ad ad = getAd(request);
    ad.setId(Integer.parseInt(Util.getInputValue(request, "id")));

    return ad;
  }
}