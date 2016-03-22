package main.java.fr.dauphine.lamsade.hib.ads.forms;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import main.java.fr.dauphine.lamsade.hib.ads.beans.Club;
import main.java.fr.dauphine.lamsade.hib.ads.dao.ClubDao;
import main.java.fr.dauphine.lamsade.hib.ads.resources.Util;

public class ClubForm {
	 private static final Logger CLUB_FORM_LOGGER = Logger.getLogger(ClubDao.class.getCanonicalName());

	  public Club getClub(HttpServletRequest request) {

	    Club club = new Club();
	    try {
	      club.setName(Util.getInputValue(request, "name"));
	      club.setCountry(Util.getInputValue(request, "country"));
	      club.setAddress(Util.getInputValue(request, "address"));
	      club.setWebsite(Util.getInputValue(request, "website"));
	      club.setNbTrophies(Integer.parseInt(Util.getInputValue(request, "nbTrophies")));
	      club.setManagerId(Integer.parseInt(Util.getInputValue(request, "managerId")));
	      SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	      Date parsedDate;
	      parsedDate = dateFormat.parse(Util.getInputValue(request, "creationDate"));
	      java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
	      club.setCreationDate(sqlDate);
	    } catch (Exception e) {
	    	CLUB_FORM_LOGGER.severe("Error while trying parse information from request ads: " + e);
	      return null;
	    }
	    return club;
	  }

	  public Club getClubForEdit(HttpServletRequest request) {
	    Club club = getClub(request);
	    if(club != null)
	      club.setId(Integer.parseInt(Util.getInputValue(request, "id")));
	    return club;
	  }
}
