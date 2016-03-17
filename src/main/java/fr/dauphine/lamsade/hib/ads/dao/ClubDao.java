package main.java.fr.dauphine.lamsade.hib.ads.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import main.java.fr.dauphine.lamsade.hib.ads.beans.Club;

public class ClubDao {
	 DataSource ds;

	  public ClubDao(DataSource ds) {
	    this.ds = ds;
	  }

	  public ArrayList<Club> all() {
	    ArrayList<Club> clubs = new ArrayList<>();
	    try {
	      Connection c = ds.getConnection();
	      PreparedStatement ps = c.prepareStatement("select * from club order by id");
	      ResultSet rs = ps.executeQuery();
	      while (rs.next()) {
	        clubs.add(map(rs));
	      }
	      c.close();
	    } catch (SQLException e) {
	      e.printStackTrace();
	      return null;
	    }

	    return clubs;
	  }

	  public boolean create(Club club) {
	    try {
	      Connection c = ds.getConnection();
	      PreparedStatement ps = c.prepareStatement("insert into clubs (name, creation_date, website, nb_trophies, address, country, manager_id) values (?,?,?,?,?,?,?)");
	      ps.setString(1, club.getName());
	      ps.setDate(2, club.getCreationDate());
	      ps.setString(3, club.getWebsite());
	      ps.setInt(4, club.getNbTrophies());
	      ps.setString(5, club.getAddress());
	      ps.setString(6, club.getCountry());
	      ps.setInt(7, club.getManagerId());
	      ps.executeUpdate();
	      c.close();
	    } catch (SQLException e) {
	      e.printStackTrace();
	      return false;
	    }

	    return true;
	  }

	  public Club find(int id) {
	    Club club = null;
	    try {
	      Connection c = ds.getConnection();
	      PreparedStatement ps = c.prepareStatement("select * from clubs where id = ?");
	      ps.setInt(1, id);
	      ResultSet rs = ps.executeQuery();
	      if (rs.next()) {
	        club = map(rs);
	      }
	      c.close();
	    } catch (SQLException e) {
	      e.printStackTrace();
	      return null;
	    }
	    return club;
	  }

	  public boolean save(Club club) {
	    try {
	      Connection c = ds.getConnection();
	      PreparedStatement ps = c.prepareStatement("update clubs set name = ?, creation_date = ?, website = ?, nb_trophies = ?, address = ?, country = ?, manager_id = ? where id = ?");
	      ps.setString(1, club.getName());
	      ps.setDate(1, club.getCreationDate());
	      ps.setString(3, club.getWebsite());
	      ps.setInt(4, club.getNbTrophies());
	      ps.setString(5, club.getAddress());
	      ps.setString(6,club.getCountry());
	      ps.setInt(7,club.getManagerId());
	      ps.setInt(8, club.getId());
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
	      PreparedStatement ps = c.prepareStatement("delete from clubs where id = ?");
	      ps.setInt(1, id);
	      ps.executeUpdate();
	      c.close();
	    } catch (SQLException e) {
	      e.printStackTrace();
	      return false;
	    }

	    return true;
	  }

	  private Club map(ResultSet rs) {
	    Club c = new Club();
	    try {
	    c.setId(rs.getInt("id"));
	    c.setName(rs.getString(rs.getInt("name")));
	    c.setCreationDate(rs.getDate("creation_date"));
	    c.setWebsite(rs.getString("website"));
	    c.setNbTrophies(rs.getInt("nb_trophies"));
	    c.setAddress(rs.getString("address"));
	    c.setCountry(rs.getString("country"));
	    c.setManagerId(rs.getInt("manager_id"));
	    } catch (SQLException e) {
	      e.printStackTrace();
	      return null;
	    }
	    return c;
	  }
}
