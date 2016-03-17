package main.java.fr.dauphine.lamsade.hib.ads.beans;

import java.sql.Date;

// Yassine Ramrami
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

  private int clubId;

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

  public int getNbGoals() {
    return nbGoals;
  }

  public void setNbGoals(int nbGoals) {
    this.nbGoals = nbGoals;
  }

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

  public int getNbGamesInternational() {
    return nbGamesInternational;
  }

  public void setNbGamesInternational(int nbGamesInternational) {
    this.nbGamesInternational = nbGamesInternational;
  }

  public String getStrongFoot() {
    return strongFoot;
  }

  public void setStrongFoot(String strongFoot) {
    this.strongFoot = strongFoot;
  }

  public int getClubId() {
    return clubId;
  }

  public void setClubId(int clubId) {
    this.clubId = clubId;
  }
}
