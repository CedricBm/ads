package main.java.fr.dauphine.lamsade.hib.ads.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import main.java.fr.dauphine.lamsade.hib.ads.beans.Club;
import main.java.fr.dauphine.lamsade.hib.ads.resources.DaoException;

/**
 * @author mathias pereira
 */
@Stateless
public class ClubDao {
  @PersistenceContext(name = "ads")
  private EntityManager em;
  private static final Logger LOGGER = Logger.getLogger(ClubDao.class.getCanonicalName());
  
  public ClubDao() {
  }
  
  @SuppressWarnings("unchecked")
  public List<Club> all() {
    Query query = em.createNamedQuery("Club.all");
    return (List<Club>) query.getResultList();
  }
  
  public boolean create(Club c) {
    try {
      em.persist(c);
      em.flush();
    } catch (Exception e) {
      throw new DaoException("Error while trying to create an club: " + e);
    }
    
    return true;
  }
  
  public Club find(int id) {
    return em.find(Club.class, id);
  }
  
  public boolean save(Club c) {
    try {
      em.merge(c);
    } catch (Exception e) {
      LOGGER.severe("Error while trying to save an club: " + e);
      return false;
    }
    return true;
  }
  
  public boolean delete(int id) {
    Club c = find(id);
    if (c != null) {
      em.remove(c);
      return true;
    }
    return false;
  }
}
