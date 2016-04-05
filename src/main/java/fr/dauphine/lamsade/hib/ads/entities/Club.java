package main.java.fr.dauphine.lamsade.hib.ads.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author mathias pereira
 */
@Entity
@Table(name = "clubs")
@NamedQueries({ @NamedQuery(name = "Club.all", query = "select c from Club c") })
public class Club {
  private int id;
  private String name;
  private Date creationDate;
  private String website;
  private int nbTrophies;
  private String address;
  private String country;
  private User manager;
  private List<Footballer> footballers;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
  
  @Column(name = "creation_date")
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
  
  @Column(name = "nb_trophies")
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
  
  @OneToOne
  @JoinColumn(name = "manager_id")
  public User getManager() {
    return manager;
  }
  
  public void setManager(User manager) {
    this.manager = manager;
  }
  
  @OneToMany(mappedBy = "club")
  public List<Footballer> getFootballers() {
    return footballers;
  }
  
  public void setFootballers(List<Footballer> footballers) {
    this.footballers = footballers;
  }
}
