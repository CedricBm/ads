package exo1;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Exo {

	public static void main(String[] args) {
		try {
			Driver d = DriverManager.getDriver("jdbc:h2:~/test");
			System.out.println("Major version: " + d.getMajorVersion());
			System.out.println("Minor version: " + d.getMinorVersion());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
