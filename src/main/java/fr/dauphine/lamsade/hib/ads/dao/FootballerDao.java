
	package main.java.fr.dauphine.lamsade.hib.ads.dao;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;

	import javax.sql.DataSource;

	import main.java.fr.dauphine.lamsade.hib.ads.beans.Footballer;


	public class FootballerDao {
		 DataSource ds;

		  public FootballerDao(DataSource ds) {
		    this.ds = ds;
		  }

		  public ArrayList<Footballer> all() {
		    ArrayList<Footballer> footballers = new ArrayList<>();
		    try {
		      Connection c = ds.getConnection();
		      PreparedStatement ps = c.prepareStatement("select * from footballer order by id");
		      ResultSet rs = ps.executeQuery();
		      while (rs.next()) {
		        footballers.add(map(rs));
		      }
		      c.close();
		    } catch (SQLException e) {
		      e.printStackTrace();
		      return null;
		    }

		    return footballers;
		  }

		  public boolean create(Footballer f) {
		    try {
		      Connection c = ds.getConnection();
		      PreparedStatement ps = c.prepareStatement("insert into footballers ( fname, lname, position, nationality, size, weigh, nb_goals, nb_games, birthdate, nb_games_international, strong_foot, club_id) values (?,?,?,?,?,?,?,?,?,?,?,?)");
		      ps.setString(1, f.getFname());
		      ps.setString(2, f.getLname());
		      ps.setString(3, f.getPosition());
		      ps.setString(4, f.getNationality());
		      ps.setFloat(5, f.getSize());
		      ps.setFloat(6, f.getWeigh());
		      ps.setInt(7, f.getNbGoals());
		      ps.setInt(8, f.getNbGames());
		      ps.setDate(9, f.getBirthdate());
		      ps.setInt(10, f.getNbGamesInternational());
		      ps.setString(11, f.getStrongFoot());
		      ps.setInt(12, f.getClubId());
		      
		      ps.executeUpdate();
		      c.close();
		    } catch (SQLException e) {
		      e.printStackTrace();
		      return false;
		    }

		    return true;
		  }

		  public Footballer find(int id) {
			  Footballer footballer = null;
		    try {
		      Connection c = ds.getConnection();
		      PreparedStatement ps = c.prepareStatement("select * from footballers where id = ?");
		      ps.setInt(1, id);
		      ResultSet rs = ps.executeQuery();
		      if (rs.next()) {
		    	  footballer = map(rs);
		      }
		      c.close();
		    } catch (SQLException e) {
		      e.printStackTrace();
		      return null;
		    }
		    return footballer;
		  }

		  public boolean save(Footballer f) {
		    try {
		      Connection c = ds.getConnection();
		      PreparedStatement ps = c.prepareStatement("update footballers set fname = ?, lname = ?, position = ?, nationality = ?, size = ?, weigh = ?, nb_goals = ?, nb_games = ?, birthdate = ?, nb_games_international = ?, strong_foot = ?, club_id = ? where id = ?");
		      ps.setString(1, f.getFname());
		      ps.setString(2, f.getLname());
		      ps.setString(3, f.getPosition());
		      ps.setString(4, f.getNationality());
		      ps.setFloat(5, f.getSize());
		      ps.setFloat(6, f.getWeigh());
		      ps.setInt(7, f.getNbGoals());
		      ps.setInt(8, f.getNbGames());
		      ps.setDate(9, f.getBirthdate());
		      ps.setInt(10, f.getNbGamesInternational());
		      ps.setString(11, f.getStrongFoot());
		      ps.setInt(12, f.getClubId());
		      ps.setInt(13, f.getId());
		      
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
		      PreparedStatement ps = c.prepareStatement("delete from footballers where id = ?");
		      ps.setInt(1, id);
		      ps.executeUpdate();
		      c.close();
		    } catch (SQLException e) {
		      e.printStackTrace();
		      return false;
		    }

		    return true;
		  }

		  private Footballer map(ResultSet rs) {
			  Footballer f = new Footballer();
		    try {
		    f.setId(rs.getInt("id"));
		    f.setFname(rs.getString(rs.getInt("fname")));
		    f.setLname(rs.getString(rs.getInt("lname")));
		    f.setPosition(rs.getString(rs.getInt("position")));
		    f.setNationality(rs.getString("nationality"));
		    f.setSize(rs.getFloat("size"));
		    f.setWeigh(rs.getFloat("weigh"));
		    f.setNbGoals(rs.getInt("nb_goals"));
		    f.setNbGames(rs.getInt("nb_games"));
		    f.setBirthdate(rs.getDate("birthdate"));
		    f.setNbGamesInternational(rs.getInt("nb_games_international"));
		    f.setStrongFoot(rs.getString("strong_foot"));	    
		    f.setClubId(rs.getInt("club_id"));
		    } catch (SQLException e) {
		      e.printStackTrace();
		      return null;
		    }
		    return f;
		  }
}


