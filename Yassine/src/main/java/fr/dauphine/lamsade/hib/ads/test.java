package fr.dauphine.lamsade.hib.ads;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test {

	public static void main(String[] args) throws Exception {
		
		Class.forName("org.h2.Driver");
		Connection connection = DriverManager.getConnection("jdbc:h2:~/test","sa"," ");
		Driver d = DriverManager.getDriver("jdbc:h2:~/test");
		System.out.println(" "+ d.getClass().getName()+" "+d.getMajorVersion()+" "+d.getMinorVersion());
		connection.close();
	}
	
	
}
