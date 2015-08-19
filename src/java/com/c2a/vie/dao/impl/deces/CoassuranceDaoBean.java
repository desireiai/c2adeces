package com.c2a.vie.dao.impl.deces;

import com.c2a.vie.dao.deces.CoassuranceDaoBeanLocal;
import com.c2a.vie.dao.impl.BaseDaoBean;
import com.c2a.vie.entities.Coassurance;
import javax.ejb.Stateless;

/**
 *
 * @author K.M.A
 */
@Stateless
public class CoassuranceDaoBean extends BaseDaoBean<Coassurance,Integer> implements CoassuranceDaoBeanLocal {

    public CoassuranceDaoBean() {
        super(Coassurance.class);
    }

    
}
