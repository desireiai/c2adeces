package com.c2a.vie.dao.impl.deces;

import com.c2a.vie.dao.deces.ReassureursDaoBeanLocal;
import com.c2a.vie.dao.impl.BaseDaoBean;
import com.c2a.vie.entities.Reassureurs;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author K.M.A
 */
@Stateless
public class ReassureursDaoBean extends BaseDaoBean<Reassureurs,Integer> implements ReassureursDaoBeanLocal {

    public ReassureursDaoBean() {
        super(Reassureurs.class);
    }

    @Override
    public List<Reassureurs> reassureurall() {
        
        Query q=this.em.createQuery("SELECT r FROM Reassureurs r WHERE r.statutreass=:valeur");
        q.setParameter("valeur", "actif");
        return q.getResultList();
    }

    @Override
    public List<Reassureurs> recherchereassureurnom(String nom) {
        Query q=this.em.createQuery("SELECT r FROM Reassureurs r WHERE r.nomreass LIKE :valeur");
        q.setParameter("valeur", nom+"%");
        return q.getResultList();
    }

    
}
