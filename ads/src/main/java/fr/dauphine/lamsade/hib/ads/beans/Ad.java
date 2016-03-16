package main.java.fr.dauphine.lamsade.hib.ads.beans;

import java.sql.Date;

// Inaki Calzada
public class Ad {
  private int id;
  private float price;
  private String description;
  private boolean buyable;
  private Date availableAt;
  private boolean isAvailable;

  private int sellerId;
  private int buyerId;
  private int footballerId;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public Date getAvailableAt() {
    return availableAt;
  }

  public void setAvailableAt(Date availableAt) {
    this.availableAt = availableAt;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public void setAvailable(boolean isAvailable) {
    this.isAvailable = isAvailable;
  }

  public int getSellerId() {
    return sellerId;
  }

  public void setSellerId(int sellerId) {
    this.sellerId = sellerId;
  }

  public int getBuyerId() {
    return buyerId;
  }

  public void setBuyerId(int buyerId) {
    this.buyerId = buyerId;
  }

  public int getFootballerId() {
    return footballerId;
  }

  public void setFootballerId(int footballerId) {
    this.footballerId = footballerId;
  }
}
