/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.entities.Language;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cposa
 */
@Stateless
@LocalBean
public class LaguageManager {
    @PersistenceContext(unitName = "Lab3ArqSoft-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public List<Language> gelAllLanguages() {
        return em.createNamedQuery("Language.findAll").getResultList();
    }

    public Language update(Language language) {
        return em.merge(language);
    }

    public Language getLanguage(short languageId) {
        return em.find(Language.class, languageId);
    }
    
    public Language getLanguageByName(String name) {
        Query query = em.createQuery("SELECT l FROM Language l WHERE l.name = :name");
        query.setParameter("name", name);
        List<Language> l = query.getResultList();
        return l.get(0);
        
    }
    
    public void delete(Language language){
        Language l = em.merge(language);
        em.remove(l);
    }
    
    
    
    
}
