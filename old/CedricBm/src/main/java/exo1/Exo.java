package exo1;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exo {
	private static Logger logger = Logger.getLogger("exo1.exo");

	public static void main(String[] args) {
		logger.log(Level.INFO, "Démarrage");
		try {
			Driver d = DriverManager.getDriver("jdbc:h2:~/test");
			System.out.println("Major version: " + d.getMajorVersion());
			System.out.println("Minor version: " + d.getMinorVersion());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
