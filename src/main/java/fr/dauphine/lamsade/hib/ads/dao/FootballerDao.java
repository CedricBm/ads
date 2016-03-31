
package main.java.fr.dauphine.lamsade.hib.ads.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import main.java.fr.dauphine.lamsade.hib.ads.beans.Footballer;
import main.java.fr.dauphine.lamsade.hib.ads.resources.DaoException;

/**
 * @author yassine ramrami
 */

@Stateless
public class FootballerDao {
  @PersistenceContext(name = "ads")
  private EntityManager em;
  private static final Logger LOGGER = Logger.getLogger(FootballerDao.class.getCanonicalName());
  
  public FootballerDao() {
  }
  
  @SuppressWarnings("unchecked")
  public List<Footballer> all() {
    Query query = em.createNamedQuery("Footballer.all");
    return (List<Footballer>) query.getResultList();
  }
  
  public boolean create(Footballer f) {
    try {
      em.persist(f);
      em.flush();
    } catch (Exception e) {
      throw new DaoException("Error while trying to create an footballer: " + e);
    }
    
    return true;
  }
  
  public Footballer find(int id) {
    return em.find(Footballer.class, id);
  }
  
  public boolean save(Footballer f) {
    try {
      em.merge(f);
    } catch (Exception e) {
      LOGGER.severe("Error while trying to save an footballer: " + e);
      return false;
    }
    return true;
  }
  
  public boolean delete(int id) {
    Footballer f = find(id);
    if (f != null) {
      em.remove(f);
      return true;
    }
    return false;
  }
}
