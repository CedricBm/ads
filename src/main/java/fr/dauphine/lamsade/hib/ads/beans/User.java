package main.java.fr.dauphine.lamsade.hib.ads.beans;

/**
 * 
 * @author cedric beaumont
 *
 */
public class User {
  private int id;
  private String fname;
  private String lname;
  private String email;
  private String password;
  private Club club;

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Club getClub() {
    return club;
  }

  public void setClub(Club club) {
    this.club = club;
  }
}
