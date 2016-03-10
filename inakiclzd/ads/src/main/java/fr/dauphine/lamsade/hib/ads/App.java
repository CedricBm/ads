package fr.dauphine.lamsade.hib.ads;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class App 
{

	static Logger log = Logger.getLogger("fr.dauphine.lamsade.hib.ads.App");
    public static void main( String[] args )
    {
    		log.log(Level.INFO, "Démarrage");
    	
            try {
				Connection c = DriverManager.getConnection("jdbc:h2:~/test","sa","");
				Driver d = DriverManager.getDriver("jdbc:h2:~/test");
				System.out.println("Driver name :"+d.getClass().getName());
				System.out.println("Major version :"+d.getMajorVersion());
				System.out.println("Minor version :"+d.getMinorVersion());
				c.close();
	            
			} catch (SQLException e) {
				e.printStackTrace();
			}
            
            
    }
}
