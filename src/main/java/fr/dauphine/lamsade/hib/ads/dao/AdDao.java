package main.java.fr.dauphine.lamsade.hib.ads.dao;

import java.sql.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import main.java.fr.dauphine.lamsade.hib.ads.entities.Ad;
import main.java.fr.dauphine.lamsade.hib.ads.resources.DaoException;

/**
 * @author inaki calzada
 */

@Stateless
public class AdDao {

  @PersistenceContext(name = "ads")
  private EntityManager em;

  public AdDao() {
  }

  public List<Ad> all() {
    TypedQuery<Ad> query = em.createNamedQuery("Ad.all", Ad.class);
    return query.getResultList();
  }

  public void create(Ad a) {
    try {
      em.persist(a);
    } catch (Exception e) {
      throw new DaoException("Error while trying to create an ad: " + e);
    }
  }

  public Ad find(int id) {
    return em.find(Ad.class, id);
  }

  public List<Ad> findMultiple(String titre, float prix, String desc, Date date) {
    TypedQuery<Ad> query = em.createNamedQuery("Ad.search", Ad.class);
    query.setParameter("title", "%" + titre + "%");
    query.setParameter("price", prix);
    query.setParameter("description", "%" + desc + "%");
    query.setParameter("availableAt", date);
    return query.getResultList();
  }

  public void save(Ad a) {
    try {
      em.merge(a);
    } catch (Exception e) {
      throw new DaoException("Error while trying to save an ad: " + e);
    }
  }

  public void delete(int id) {
    Ad a = em.getReference(Ad.class, id);
    if (a != null) {
      em.remove(a);
    }
  }
}
