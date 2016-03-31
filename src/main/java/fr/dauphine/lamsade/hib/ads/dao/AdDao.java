package main.java.fr.dauphine.lamsade.hib.ads.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import main.java.fr.dauphine.lamsade.hib.ads.beans.Ad;
import main.java.fr.dauphine.lamsade.hib.ads.resources.DaoException;

/**
 * @author inaki calzada
 */

@Stateless
public class AdDao {
  
  @PersistenceContext(name = "ads")
  private EntityManager em;
  private static final Logger LOGGER = Logger.getLogger(AdDao.class.getCanonicalName());
  
  public AdDao() {
  }
  
  @SuppressWarnings("unchecked")
  public List<Ad> all() {
    Query query = em.createNamedQuery("Ad.all");
    return (List<Ad>) query.getResultList();
  }
  
  public boolean create(Ad a) {
    try {
      em.persist(a);
      em.flush();
    } catch (Exception e) {
      throw new DaoException("Error while trying to create an ad: " + e);
    }
    
    return true;
  }
  
  public Ad find(int id) {
    return em.find(Ad.class, id);
  }
  
  public boolean save(Ad a) {
    try {
      em.merge(a);
    } catch (Exception e) {
      LOGGER.severe("Error while trying to save an ad: " + e);
      return false;
    }
    return true;
  }
  
  public boolean delete(int id) {
    Ad a = find(id);
    if (a != null) {
      em.remove(a);
      return true;
    }
    return false;
  }
}
