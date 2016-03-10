package fr.dauphine.lamsade.hib.ads;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Test {
	
	private static Logger myLogger = Logger.getLogger("fr.dauphine.lamsade.hib.ads");
	
	public static void main(String[] args) throws Exception {
		myLogger.log(Level.INFO, "start");
		Class.forName("org.h2.Driver");
		Connection connection = DriverManager.getConnection("jdbc:h2:~/test","sa","");
		Driver d = DriverManager.getDriver("jdbc:h2:~/test");
		System.out.println(d.getClass().getName()+" "+d.getMajorVersion()+"."+d.getMinorVersion());
		connection.close();
		
		/*List drivers = Collections.list(DriverManager.getDrivers());
		for (int i = 0; i < drivers.size(); i++) {
			Driver driver = (Driver) drivers.get(i);
			String name = driver.getClass().getName();
			System.out.println(name+" "+driver.getMajorVersion()+"."+driver.getMinorVersion());
		}*/
	}
}