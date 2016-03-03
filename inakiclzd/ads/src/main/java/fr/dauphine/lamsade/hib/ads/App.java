package fr.dauphine.lamsade.hib.ads;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class App 
{
    public static void main( String[] args )
    {
    	
            try {
				Connection c = DriverManager.getConnection("jdbc:h2:~/test","sa","");
				Driver d = DriverManager.getDriver("jdbc:h2:~/test");
				System.out.println("Driver name :"+d.getClass().getName());
				System.out.println("Major version :"+d.getMajorVersion());
				System.out.println("Minor version :"+d.getMinorVersion());
				c.close();
	            
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        
    }
}
