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
      PreparedStatement ps = c.prepareStatement("insert into ads (title, price, description, buyable, available_at, available, seller_id, footballer_id) values (?,?,?,?,?,TRUE,?,?)");
      ps.setString(1, a.getTitle());
      ps.setFloat(2, a.getPrice());
      ps.setString(3, a.getDescription());
      ps.setBoolean(4, a.isBuyable());
      ps.setDate(5, a.getAvailableAt());
      ps.setInt(6, a.getSellerId());
      ps.setInt(7, a.getFootballerId());
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
      PreparedStatement ps = c.prepareStatement("update ads set  title = ?, price = ?, description = ?, buyable = ?, available_at = ?, available = ?," + (a.getBuyerId() == 0 ? "buyer_id = NULL" : " buyer_id = ?") + ", seller_id = ?, footballer_id = ? where id = ?");
      ps.setString(1, a.getTitle());
      ps.setFloat(2, a.getPrice());
      ps.setString(3, a.getDescription());
      ps.setBoolean(4, a.isBuyable());
      ps.setDate(5, a.getAvailableAt());
      ps.setBoolean(6, a.isAvailable());
      if (a.getBuyerId() == 0) {
        ps.setInt(7, a.getSellerId());
        ps.setInt(8, a.getFootballerId());
        ps.setInt(9, a.getId());
      } else {
        ps.setInt(7, a.getBuyerId());
        ps.setInt(8, a.getSellerId());
        ps.setInt(9, a.getFootballerId());
        ps.setInt(10, a.getId());
      }
      
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
      a.setTitle(rs.getString("title"));
      a.setPrice(rs.getFloat("price"));
      a.setDescription(rs.getString("description"));
      a.setBuyable(rs.getBoolean("buyable"));
      a.setAvailableAt(rs.getDate("available_at"));
      a.setBuyable(rs.getBoolean("available"));
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
