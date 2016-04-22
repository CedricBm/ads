package main.java.fr.dauphine.lamsade.hib.ads.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

import main.java.fr.dauphine.lamsade.hib.ads.dao.ClubDao;
import main.java.fr.dauphine.lamsade.hib.ads.dao.FootballerDao;
import main.java.fr.dauphine.lamsade.hib.ads.entities.Footballer;
import main.java.fr.dauphine.lamsade.hib.ads.entities.User;
import main.java.fr.dauphine.lamsade.hib.ads.resources.FormException;
import main.java.fr.dauphine.lamsade.hib.ads.resources.Util;

/**
 * @author yassine ramrami
 */

@Stateless
public class FootballerForm {
  @EJB
  private Util util;
  @EJB
  private ClubDao cd;
  @EJB
  private FootballerDao fd;
  
  public Footballer getFootballer(HttpServletRequest request) {
    
    Footballer f = new Footballer();
    f.setFname(util.getInputValue(request, "fname"));
    f.setLname(util.getInputValue(request, "lname"));
    f.setPosition(util.getInputValue(request, "position"));
    f.setNationality(util.getInputValue(request, "nationality"));
    f.setSize(Float.parseFloat(util.getInputValue(request, "size")));
    f.setWeigh(Float.parseFloat(util.getInputValue(request, "weigh")));
    f.setNbGoals(Integer.parseInt(util.getInputValue(request, "nb_goals")));
    f.setNbGames(Integer.parseInt(util.getInputValue(request, "nb_games")));
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    Date parsed;
    try {
      parsed = format.parse(util.getInputValue(request, "birthdate"));
      java.sql.Date sql = new java.sql.Date(parsed.getTime());
      f.setBirthdate(sql);
    } catch (ParseException e) {
      throw new FormException("Error while trying parse information from request footballers: " + e);
    }
    f.setNbGamesInternational(Integer.parseInt(util.getInputValue(request, "nb_games_international")));
    f.setStrongFoot(util.getInputValue(request, "strong_foot"));
    f.setClub(cd.find(Integer.parseInt(util.getInputValue(request, "club_id"))));
    return f;
  }
  
  public Footballer getFootballerForEdit(HttpServletRequest request) {
    Footballer f = getFootballer(request);
    f.setId(Integer.parseInt(util.getInputValue(request, "id")));
    return f;
  }
  
  public Footballer getFootballerForBuy(HttpServletRequest request) {
    return fd.find(Integer.parseInt(util.getInputValue(request, "footballer_id")));
  }
}
