package main.java.fr.dauphine.lamsade.hib.ads.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import main.java.fr.dauphine.lamsade.hib.ads.beans.User;

public class UserDao {
  DataSource ds;

  public UserDao(DataSource ds) {
    this.ds = ds;
  }

  public ArrayList<User> all() {
    ArrayList<User> users = new ArrayList<>();
    try {
      Connection c = ds.getConnection();
      PreparedStatement ps = c.prepareStatement("select * from users order by id");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        users.add(map(rs));
      }
      c.close();
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }

    return users;
  }

  public boolean create(User u) {
    try {
      Connection c = ds.getConnection();
      PreparedStatement ps = c.prepareStatement("insert into users (fname, lname, email, password) values (?,?,?,?)");
      ps.setString(1, u.getFname());
      ps.setString(2, u.getLname());
      ps.setString(3, u.getEmail());
      ps.setString(4, u.getPassword());
      ps.executeUpdate();
      c.close();
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }

    return true;
  }

  public User find(int id) {
    User u = null;
    try {
      Connection c = ds.getConnection();
      PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        u = map(rs);
      }
      c.close();
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }

    return u;
  }

  public boolean save(User u) {
    try {
      Connection c = ds.getConnection();
      PreparedStatement ps = c.prepareStatement("update users set fname = ?, lname = ?, email = ?" + (u.getPassword() == null ? "" : ", password = ?") + " where id = ?");
      ps.setString(1, u.getFname());
      ps.setString(2, u.getLname());
      ps.setString(3, u.getEmail());
      if (u.getPassword() == null) {
        ps.setInt(4, u.getId());
      } else {
        ps.setString(4, u.getPassword());
        ps.setInt(5, u.getId());
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
      PreparedStatement ps = c.prepareStatement("delete from users where id = ?");
      ps.setInt(1, id);
      ps.executeUpdate();
      c.close();
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }

    return true;
  }

  private User map(ResultSet rs) {
    User u = new User();
    try {
      u.setId(rs.getInt("id"));
      u.setFname(rs.getString("fname"));
      u.setLname(rs.getString("lname"));
      u.setEmail(rs.getString("email"));
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    return u;
  }
}