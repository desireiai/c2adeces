package com.c2a.vie.dao.impl.deces;

import com.c2a.vie.dao.deces.SouscripteurDaoBeanLocal;
import com.c2a.vie.dao.impl.BaseDaoBean;
import com.c2a.vie.entities.Souscripteur;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author K.M.A
 */
@Stateless
public class SouscripteurDaoBean extends BaseDaoBean<Souscripteur,Integer> implements SouscripteurDaoBeanLocal {

    public SouscripteurDaoBean() {
        super(Souscripteur.class);
    }

    @Override
    public List<Souscripteur> souscripteurall() {
        Query q=this.em.createQuery("SELECT s from Souscripteur s WHERE s.statutsous=:valeur");
        q.setParameter("valeur", "actif");
        return q.getResultList();
    }

    
}
