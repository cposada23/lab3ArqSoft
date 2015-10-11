/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.entities.Film;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cposa
 */
@Stateless
@LocalBean
public class FilmManager {
    @PersistenceContext(unitName = "Lab3ArqSoft-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public List<Film> getAllFilms() {
        return em.createNamedQuery("Film.findAll").getResultList();
    }

    public Film update(Film film) {
        return em.merge(film);
    }
    
    
}
