package main.java.fr.dauphine.lamsade.hib.ads.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author inaki calzada
 */
@Entity
@Table(name = "ads")
@NamedQueries({ @NamedQuery(name = "Ad.all", query = "select a from Ad a"),
    @NamedQuery(name = "Ad.search", query = "select a from Ad a where a.title like :title and a.price >= :price and a.description like :description and a.availableAt >= :availableAt") })
public class Ad {
  private int id;
  private String title;
  private float price;
  private String description;
  private boolean buyable;
  private Date availableAt;
  private boolean available;
  private User seller;
  private User buyer;
  private Footballer footballer;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isBuyable() {
    return buyable;
  }

  public void setBuyable(boolean buyable) {
    this.buyable = buyable;
  }

  @Column(name = "available_at")
  public Date getAvailableAt() {
    return availableAt;
  }

  public void setAvailableAt(Date availableAt) {
    this.availableAt = availableAt;
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean isAvailable) {
    this.available = isAvailable;
  }

  @ManyToOne
  @JoinColumn(name = "seller_id")
  public User getSeller() {
    return seller;
  }

  public void setSeller(User seller) {
    this.seller = seller;
  }

  @ManyToOne
  @JoinColumn(name = "buyer_id")
  public User getBuyer() {
    return buyer;
  }

  public void setBuyer(User buyer) {
    this.buyer = buyer;
  }

  @ManyToOne
  @JoinColumn(name = "footballer_id")
  public Footballer getFootballer() {
    return footballer;
  }

  public void setFootballer(Footballer footballer) {
    this.footballer = footballer;
  }
}
