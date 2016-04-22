package main.java.fr.dauphine.lamsade.hib.ads.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import main.java.fr.dauphine.lamsade.hib.ads.entities.Club;
import main.java.fr.dauphine.lamsade.hib.ads.resources.DaoException;

/**
 * @author mathias pereira
 */
@Stateless
public class ClubDao {
  @PersistenceContext(name = "ads")
  private EntityManager em;
  
  public ClubDao() {
  }
  
  public List<Club> all() {
    TypedQuery<Club> query = em.createNamedQuery("Club.all", Club.class);
    return query.getResultList();
  }
  
  public void create(Club c) {
    try {
      em.persist(c);
    } catch (Exception e) {
      throw new DaoException("Error while trying to create an club: " + e);
    }
  }
  
  public Club find(int id) {
    return em.find(Club.class, id);
  }
  
  public void save(Club c) {
    try {
      em.merge(c);
    } catch (Exception e) {
      throw new DaoException("Error while trying to save an club: " + e);
    }
  }
  
  public void delete(int id) {
    Club c = em.getReference(Club.class, id);
    if (c != null) {
      em.remove(c);
    }
  }
  
  public Club getByManager(int idManager)
  {
    TypedQuery<Club> query = em.createNamedQuery("Club.getByManager", Club.class);
    query.setParameter("idManager", idManager);
    return query.getSingleResult();
  }
}
