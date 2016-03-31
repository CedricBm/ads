package main.java.fr.dauphine.lamsade.hib.ads.beans;

import java.sql.Date;

/**
 * 
 * @author mathias pereira
 *
 */
public class Club {
  private int id;
  private String name;
  private Date creationDate;
  private String website;
  private int nbTrophies;
  private String address;
  private String country;

  private int managerId;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public int getNbTrophies() {
    return nbTrophies;
  }

  public void setNbTrophies(int nbTrophies) {
    this.nbTrophies = nbTrophies;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public int getManagerId() {
    return managerId;
  }

  public void setManagerId(int managerId) {
    this.managerId = managerId;
  }
}
