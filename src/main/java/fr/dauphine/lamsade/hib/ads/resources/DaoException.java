package main.java.fr.dauphine.lamsade.hib.ads.resources;

/**
 * 
 * @author Cedric Inaki Mathias Yassine 
 *
 */
public class DaoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DaoException(String msg){
		super(msg);
	}
}
