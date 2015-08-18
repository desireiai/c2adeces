package com.c2a.vie.dao.impl.deces;

import com.c2a.vie.dao.deces.CoassureursDaoBeanLocal;
import com.c2a.vie.dao.impl.BaseDaoBean;
import com.c2a.vie.entities.Coassureurs;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author K.M.A
 */
@Stateless
public class CoassureursDaoBean extends BaseDaoBean<Coassureurs, Integer> implements CoassureursDaoBeanLocal {

    public CoassureursDaoBean() {
        super(Coassureurs.class);
    }

    @Override
    public List<Coassureurs> coassureurall() {
        Query q = this.em.createQuery("SELECT c from Coassureurs c WHERE c.statutcoass=:valeur");
        q.setParameter("valeur", "actif");
        return q.getResultList();

    }

}
