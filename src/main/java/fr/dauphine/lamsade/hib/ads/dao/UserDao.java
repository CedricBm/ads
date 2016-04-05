package main.java.fr.dauphine.lamsade.hib.ads.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import main.java.fr.dauphine.lamsade.hib.ads.entities.User;
import main.java.fr.dauphine.lamsade.hib.ads.resources.DaoException;

/**
 * @author cedric beaumont
 */

@Stateless
public class UserDao {
  @PersistenceContext(name = "ads")
  private EntityManager em;
  
  public UserDao() {
  }
  
  public List<User> all() {
    TypedQuery<User> query = em.createNamedQuery("User.all", User.class);
    return query.getResultList();
  }
  
  public void create(User u) {
    try {
      em.persist(u);
    } catch (Exception e) {
      throw new DaoException("Error while trying to create a user: " + e);
    }
  }
  
  public User find(int id) {
    return em.find(User.class, id);
  }
  
  public void save(User u) {
    try {
      em.merge(u);
    } catch (Exception e) {
      throw new DaoException("Error while trying to save a user: " + e);
    }
  }
  
  public void delete(int id) {
    User u = em.getReference(User.class, id);
    if (u != null) {
      em.remove(u);
    }
  }
}
