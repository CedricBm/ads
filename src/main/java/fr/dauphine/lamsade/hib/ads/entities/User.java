package main.java.fr.dauphine.lamsade.hib.ads.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @author cedric beaumont
 */

@Entity
@Table(name = "users")
@NamedQueries({ @NamedQuery(name = "User.all", query = "select u from User u"), @NamedQuery(name = "User.getByEmail", query = "select u from User u where u.email = :email") })
public class User {
  private int id;
  private int version;
  private String fname;
  private String lname;
  private String email;
  private byte[] password;
  private float solde;
  private Club club;
  private List<Ad> soldAds;
  private List<Ad> boughtAds;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Version
  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
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

  public byte[] getPassword() {
    return password;
  }

  public void setPassword(byte[] password) {
    this.password = password;
  }

  public float getSolde() {
    return solde;
  }

  public void setSolde(float solde) {
    this.solde = solde;
  }

  @OneToOne(mappedBy = "manager", fetch = FetchType.EAGER)
  public Club getClub() {
    return club;
  }

  public void setClub(Club club) {
    this.club = club;
  }

  @OneToMany(mappedBy = "seller")
  public List<Ad> getSoldAds() {
    return soldAds;
  }

  public void setSoldAds(List<Ad> soldAds) {
    this.soldAds = soldAds;
  }

  @OneToMany(mappedBy = "buyer")
  public List<Ad> getBoughtAds() {
    return boughtAds;
  }

  public void setBoughtAds(List<Ad> boughtAds) {
    this.boughtAds = boughtAds;
  }
}
