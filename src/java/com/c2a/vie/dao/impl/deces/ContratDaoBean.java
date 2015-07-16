package com.c2a.vie.dao.impl.deces;

import com.c2a.vie.dao.deces.ContratDaoBeanLocal;
import com.c2a.vie.dao.impl.BaseDaoBean;
import com.c2a.vie.entities.Contrat;
import javax.ejb.Stateless;

/**
 *
 * @author K.M.A
 */
@Stateless
public class ContratDaoBean extends BaseDaoBean<Contrat,Integer> implements ContratDaoBeanLocal {

    public ContratDaoBean() {
        super(Contrat.class);
    }

    
}
