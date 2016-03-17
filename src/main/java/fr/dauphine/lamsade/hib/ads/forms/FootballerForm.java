package main.java.fr.dauphine.lamsade.hib.ads.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import main.java.fr.dauphine.lamsade.hib.ads.beans.Footballer;
import main.java.fr.dauphine.lamsade.hib.ads.resources.Util;

public class FootballerForm {

	
	public Footballer getFootballer(HttpServletRequest request){
		
		Footballer f = new Footballer();
		f.setFname(Util.getInputValue(request, "fname"));
		f.setLname(Util.getInputValue(request, "lname"));
		f.setPosition(Util.getInputValue(request, "position"));
		f.setNationality(Util.getInputValue(request, "nationality"));
		f.setSize(Float.parseFloat(Util.getInputValue(request, "size")));
		f.setWeigh(Float.parseFloat(Util.getInputValue(request, "weigh")));
		f.setNbGoals(Integer.parseInt(Util.getInputValue(request, "nb_goals")));
		f.setNbGames(Integer.parseInt(Util.getInputValue(request, "nb_games")));
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	    Date parsed;
		try {
			parsed = format.parse(Util.getInputValue(request, "birthdate"));
			java.sql.Date sql = new java.sql.Date(parsed.getTime());
		    f.setBirthdate(sql);
		} catch (ParseException e) {
			return null;
		}
		f.setNbGamesInternational(Integer.parseInt(Util.getInputValue(request, "nb_games_international")));
		f.setStrongFoot(Util.getInputValue(request, "strong_foot"));
		f.setClubId(Integer.parseInt(Util.getInputValue(request, "club_id")));
		return f;
	}
	 
	public Footballer getFootballerForEdit(HttpServletRequest request) {
		Footballer f = getFootballer(request);
		  f.setId(Integer.parseInt(Util.getInputValue(request, "id")));

	    return f;
	  }
}
