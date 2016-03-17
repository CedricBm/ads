package main.java.fr.dauphine.lamsade.hib.ads.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import main.java.fr.dauphine.lamsade.hib.ads.beans.Ad;

public class AdDao {
  DataSource ds;

  public AdDao(DataSource ds) {
    this.ds = ds;
  }

  public ArrayList<Ad> all() {
    ArrayList<Ad> ads = new ArrayList<>();
    try {
      Connection c = ds.getConnection();
      PreparedStatement ps = c.prepareStatement("select * from ads order by id");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        ads.add(map(rs));
      }
      c.close();
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }

    return ads;
  }

  public boolean create(Ad a) {
    try {
      Connection c = ds.getConnection();
      PreparedStatement ps = c.prepareStatement("insert into ads (price, description, buyable, available_at, is_available, buyer_id, seller_id, footballer_id) values (?,?,?,?,?,?,?,?)");
      ps.setFloat(1, a.getPrice());
      ps.setString(2, a.getDescription());
      ps.setBoolean(3, a.isBuyable());
      ps.setDate(4, a.getAvailableAt());
      ps.setBoolean(5, a.isAvailable());
      ps.setInt(6, a.getBuyerId());
      ps.setInt(7, a.getSellerId());
      ps.setInt(8, a.getFootballerId());
      ps.executeUpdate();
      c.close();
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }

    return true;
  }

  public Ad find(int id) {
    Ad a = null;
    try {
      Connection c = ds.getConnection();
      PreparedStatement ps = c.prepareStatement("select * from ads where id = ?");
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        a = map(rs);
      }
      c.close();
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }

    return a;
  }

  public boolean save(Ad a) {
    try {
      Connection c = ds.getConnection();
      PreparedStatement ps = c.prepareStatement("update ads set price = ?, description = ?, buyable = ?, available_at = ?, is_available = ?, buyer_id = ?, seller_id = ?, footballer_id = ? where id = ?");
      ps.setFloat(1, a.getPrice());
      ps.setString(2, a.getDescription());
      ps.setBoolean(3, a.isBuyable());
      ps.setDate(4, a.getAvailableAt());
      ps.setBoolean(5, a.isAvailable());
      ps.setInt(6, a.getBuyerId());
      ps.setInt(7, a.getSellerId());
      ps.setInt(8, a.getFootballerId());
      ps.setInt(9, a.getId());
      ps.executeUpdate();
      c.close();
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }

    return true;
  }

  public boolean delete(int id) {
    try {
      Connection c = ds.getConnection();
      PreparedStatement ps = c.prepareStatement("delete from ads where id = ?");
      ps.setInt(1, id);
      ps.executeUpdate();
      c.close();
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }

    return true;
  }

  private Ad map(ResultSet rs) {
    Ad a = new Ad();
    try {
      a.setId(rs.getInt("id"));
      a.setPrice(rs.getFloat("price"));
      a.setDescription(rs.getString("description"));
      a.setBuyable(rs.getBoolean("buyable"));
      a.setAvailableAt(rs.getDate("available_at"));
      a.setBuyable(rs.getBoolean("is_available"));
      a.setBuyerId(rs.getInt("buyer_id"));
      a.setSellerId(rs.getInt("seller_id"));
      a.setFootballerId(rs.getInt("footballer_id"));
      
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    return a;
  }
}
