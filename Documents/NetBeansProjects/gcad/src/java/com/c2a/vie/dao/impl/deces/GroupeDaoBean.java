package com.c2a.vie.dao.impl.deces;

import com.c2a.vie.dao.deces.GroupeDaoBeanLocal;
import com.c2a.vie.dao.impl.BaseDaoBean;
import com.c2a.vie.entities.Groupe;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author K.M.A
 */
@Stateless
public class GroupeDaoBean extends BaseDaoBean<Groupe,Integer> implements GroupeDaoBeanLocal {

    public GroupeDaoBean() {
        super(Groupe.class);
    }

    @Override
    public List<Groupe> groupeall() {
        Query q=this.em.createQuery("SELECT g from Groupe g WHERE g.statutgroup=:valeur");
        q.setParameter("valeur", "actif");
        return q.getResultList();
    }

    @Override
    public List<Groupe> groupenewcontrat() {
        Query q=this.em.createQuery("SELECT g FROM Groupe g WHERE g.primettcgroupe=:valeur");
        q.setParameter("valeur", 0.0);
        return q.getResultList();
    }

    @Override
    public List<Groupe> groupeavoircontrat() {
        Query q=this.em.createQuery("SELECT g FROM Groupe g WHERE g.primettcgroupe<>:valeur");
        q.setParameter("valeur", 0.0);
        return q.getResultList();
    }

    
}
