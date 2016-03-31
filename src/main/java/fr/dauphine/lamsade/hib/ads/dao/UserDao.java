package main.java.fr.dauphine.lamsade.hib.ads.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import main.java.fr.dauphine.lamsade.hib.ads.beans.User;
import main.java.fr.dauphine.lamsade.hib.ads.resources.DaoException;

/**
 * @author cedric beaumont
 */

@Stateless
public class UserDao {
  @PersistenceContext(name = "ads")
  private EntityManager em;
  private static final Logger LOGGER = Logger.getLogger(UserDao.class.getCanonicalName());
  
  public UserDao() {
  }
  
  @SuppressWarnings("unchecked")
  public List<User> all() {
    Query query = em.createNamedQuery("User.all");
    return (List<User>) query.getResultList();
  }
  
  public boolean create(User u) {
    try {
      em.persist(u);
      em.flush();
    } catch (Exception e) {
      throw new DaoException("Error while trying to create an user: " + e);
    }
    
    return true;
  }
  
  public User find(int id) {
    return em.find(User.class, id);
  }
  
  public boolean save(User u) {
    try {
      em.merge(u);
    } catch (Exception e) {
      LOGGER.severe("Error while trying to save an user: " + e);
      return false;
    }
    return true;
  }
  
  public boolean delete(int id) {
    User u = find(id);
    if (u != null) {
      em.remove(u);
      return true;
    }
    return false;
  }
  
}
