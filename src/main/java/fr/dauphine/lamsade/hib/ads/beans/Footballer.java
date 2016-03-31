package main.java.fr.dauphine.lamsade.hib.ads.beans;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author yassine ramrami
 */
@Entity
@Table(name = "footballers")
@NamedQueries({ @NamedQuery(name = "Footballer.all", query = "select f from Footballer f"),
    @NamedQuery(name = "Footballer.find", query = "select f from Footballer f where f.id=:id") })
public class Footballer {
  private int id;
  private String fname;
  private String lname;
  private String position;
  private String nationality;
  private float size;
  private float weigh;
  private int nbGoals;
  private int nbGames;
  private Date birthdate;
  private int nbGamesInternational;
  private String strongFoot;
  private Club club;
  private List<Ad> ads;
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getFname() {
    return fname;
  }
  
  public void setFname(String fname) {
    this.fname = fname;
  }
  
  public String getLname() {
    return lname;
  }
  
  public void setLname(String lname) {
    this.lname = lname;
  }
  
  public String getPosition() {
    return position;
  }
  
  public void setPosition(String position) {
    this.position = position;
  }
  
  public String getNationality() {
    return nationality;
  }
  
  public void setNationality(String nationality) {
    this.nationality = nationality;
  }
  
  public float getSize() {
    return size;
  }
  
  public void setSize(float size) {
    this.size = size;
  }
  
  public float getWeigh() {
    return weigh;
  }
  
  public void setWeigh(float weigh) {
    this.weigh = weigh;
  }
  
  @Column(name = "nb_goals")
  public int getNbGoals() {
    return nbGoals;
  }
  
  public void setNbGoals(int nbGoals) {
    this.nbGoals = nbGoals;
  }
  
  @Column(name = "nb_games")
  public int getNbGames() {
    return nbGames;
  }
  
  public void setNbGames(int nbGames) {
    this.nbGames = nbGames;
  }
  
  public Date getBirthdate() {
    return birthdate;
  }
  
  public void setBirthdate(Date birthdate) {
    this.birthdate = birthdate;
  }
  
  @Column(name = "nb_games_international")
  public int getNbGamesInternational() {
    return nbGamesInternational;
  }
  
  public void setNbGamesInternational(int nbGamesInternational) {
    this.nbGamesInternational = nbGamesInternational;
  }
  
  @Column(name = "strong_foot")
  public String getStrongFoot() {
    return strongFoot;
  }
  
  public void setStrongFoot(String strongFoot) {
    this.strongFoot = strongFoot;
  }
  
  @ManyToOne
  @JoinColumn(name = "club_id")
  public Club getClub() {
    return club;
  }
  
  public void setClub(Club club) {
    this.club = club;
  }
  
  @OneToMany(mappedBy = "footballer")
  public List<Ad> getAds() {
    return ads;
  }
  
  public void setAds(List<Ad> ads) {
    this.ads = ads;
  }
  
}
