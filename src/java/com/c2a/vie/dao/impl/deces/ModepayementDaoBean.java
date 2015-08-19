package com.c2a.vie.dao.impl.deces;

import com.c2a.vie.dao.deces.ModepayementDaoBeanLocal;
import com.c2a.vie.dao.impl.BaseDaoBean;
import com.c2a.vie.entities.Modepayement;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;


/**
 *
 * @author K.M.A
 */
@Stateless
public class ModepayementDaoBean extends BaseDaoBean<Modepayement,Integer> implements ModepayementDaoBeanLocal {

    public ModepayementDaoBean() {
        super(Modepayement.class);
    }

    @Override
    public List<Modepayement> listmodepayementall() {
        Query q=this.em.createQuery("SELECT m from Modepayement m WHERE m.statutmodpaye=:valeur");
        q.setParameter("valeur", "actif");
        return q.getResultList();
    }

    
}
