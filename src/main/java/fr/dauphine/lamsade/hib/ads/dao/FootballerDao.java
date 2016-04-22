
package main.java.fr.dauphine.lamsade.hib.ads.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import main.java.fr.dauphine.lamsade.hib.ads.entities.Club;
import main.java.fr.dauphine.lamsade.hib.ads.entities.Footballer;
import main.java.fr.dauphine.lamsade.hib.ads.resources.DaoException;

/**
 * @author yassine ramrami
 */

@Stateless
public class FootballerDao {
  @PersistenceContext(name = "ads")
  private EntityManager em;
  
  public FootballerDao() {
  }
  
  public List<Footballer> all() {
    TypedQuery<Footballer> query = em.createNamedQuery("Footballer.all", Footballer.class);
    return query.getResultList();
  }
  
  public void create(Footballer f) {
    try {
      em.persist(f);
    } catch (Exception e) {
      throw new DaoException("Error while trying to create an footballer: " + e);
    }
  }
  
  public Footballer find(int id) {
    return em.find(Footballer.class, id);
  }
  
  public void save(Footballer f) {
    try {
      em.merge(f);
    } catch (Exception e) {
      throw new DaoException("Error while trying to save an footballer: " + e);
    }
  }
  
  public void delete(int id) {
    Footballer f = em.getReference(Footballer.class, id);
    if (f != null) {
      em.remove(f);
    }
  }
  
  public void changeClub(int id, Club club) {
    Footballer f = em.find(Footballer.class, id);
    f.setClub(club);
    save(f);
  }
}
