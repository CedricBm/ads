package main.java.fr.dauphine.lamsade.hib.ads.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import main.java.fr.dauphine.lamsade.hib.ads.beans.Club;
import main.java.fr.dauphine.lamsade.hib.ads.beans.User;
import main.java.fr.dauphine.lamsade.hib.ads.resources.MappingException;

/**
 * @author cedric beaumont
 */
// Default transaction isolation level is READ_COMMITED
public class UserDao {
  private static final Logger LOGGER = Logger.getLogger(UserDao.class.getCanonicalName());
  
  private DataSource ds;
  
  public UserDao(DataSource ds) {
    this.ds = ds;
  }
  
  public List<User> all() {
    List<User> users = new ArrayList<>();
    try {
      Connection c = ds.getConnection();
      PreparedStatement ps = c.prepareStatement(
          "select u.*, c.id as club_id, c.name from users as u left join clubs as c on u.id = c.manager_id order by id");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        users.add(map(rs));
      }
      c.close();
    } catch (SQLException e) {
      LOGGER.severe("Error while trying to fetch every users: " + e);
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
      LOGGER.severe("Error while trying to create a user: " + e);
      return false;
    }
    
    return true;
  }
  
  public User find(int id) {
    User u = null;
    try {
      Connection c = ds.getConnection();
      c.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
      PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        u = map(rs);
      }
      c.close();
    } catch (SQLException e) {
      LOGGER.severe("Error while trying to find a user: " + e);
      return null;
    }
    
    return u;
  }
  
  public boolean save(User u) {
    try {
      Connection c = ds.getConnection();
      c.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
      PreparedStatement ps = c.prepareStatement("update users set fname = ?, lname = ?, email = ?"
          + (u.getPassword() == null ? "" : ", password = ?") + " where id = ?");
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
      LOGGER.severe("Error while trying to update a user: " + e);
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
      LOGGER.severe("Error while trying to delete a user: " + e);
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
      if (rs.getString("club_id") != null) {
        Club c = new Club();
        c.setId(rs.getInt("club_id"));
        c.setName(rs.getString("name"));
        u.setClub(c);
      }
    } catch (SQLException e) {
      throw new MappingException("Error while trying to map the resultset into an user: " + e);
    }
    return u;
  }
  
}
