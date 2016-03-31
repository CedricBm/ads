package main.java.fr.dauphine.lamsade.hib.ads.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import main.java.fr.dauphine.lamsade.hib.ads.beans.Club;
import main.java.fr.dauphine.lamsade.hib.ads.resources.FormException;
import main.java.fr.dauphine.lamsade.hib.ads.resources.Util;

/**
 * @author mathias pereira
 */
@Stateless
public class ClubForm {
  @Inject
  private Util util;
  
  public Club getClub(HttpServletRequest request) {
    
    Club club = new Club();
    try {
      club.setName(util.getInputValue(request, "name"));
      club.setCountry(util.getInputValue(request, "country"));
      club.setAddress(util.getInputValue(request, "address"));
      club.setWebsite(util.getInputValue(request, "website"));
      club.setNbTrophies(Integer.parseInt(util.getInputValue(request, "nbTrophies")));
      club.setManagerId(Integer.parseInt(util.getInputValue(request, "managerId")));
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
      Date parsedDate;
      parsedDate = dateFormat.parse(util.getInputValue(request, "creationDate"));
      java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
      club.setCreationDate(sqlDate);
    } catch (ParseException e) {
      throw new FormException("Error while trying parse information from request clubs: " + e);
    }
    return club;
  }
  
  public Club getClubForEdit(HttpServletRequest request) {
    Club club = getClub(request);
    if (club != null)
      club.setId(Integer.parseInt(util.getInputValue(request, "id")));
    return club;
  }
}
