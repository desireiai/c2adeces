package com.c2a.vie.dao.impl.deces;

import com.c2a.vie.dao.deces.AssuresDaoBeanLocal;
import com.c2a.vie.dao.impl.BaseDaoBean;
import com.c2a.vie.entities.Assures;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author K.M.A
 */
@Stateless
public class AssuresDaoBean extends BaseDaoBean<Assures,Integer> implements AssuresDaoBeanLocal {

    public AssuresDaoBean() {
        super(Assures.class);
    }

    @Override
    public List<Assures> assureall() {
        Query q=this.em.createQuery("SELECT a from Assures a WHERE a.statutassur=:valeur");
        q.setParameter("valeur", "actif");
        return q.getResultList();
    }

  

    @Override
    public Integer moyenneage() {
        Query q=this.em.createQuery("SELECT AVG(a.ageassur) FROM Assures a where a.codsous IS NULL ");
        return (Integer) q.getSingleResult();
    }

    @Override
    public List<Assures> assureentreprise() {
        Query q=this.em.createNativeQuery("{call assuresansgroupe()}",Assures.class);
        return q.getResultList();
    }

    @Override
    public List<Assures> assurepartypecontrat() {
        Query q=this.em.createNativeQuery("{call assurepolicerech(?,?)}",Assures.class);
        q.setParameter(1, "actif");
        q.setParameter(2, "groupe entreprise");
        return q.getResultList();
    }

    
}
