package com.c2a.vie.dao.impl.deces;

import com.c2a.vie.dao.deces.ReassuranceDaoBeanLocal;
import com.c2a.vie.dao.impl.BaseDaoBean;
import com.c2a.vie.entities.Reassurance;
import javax.ejb.Stateless;

/**
 *
 * @author K.M.A
 */
@Stateless
public class ReassuranceDaoBean extends BaseDaoBean<Reassurance,Integer> implements ReassuranceDaoBeanLocal {

    public ReassuranceDaoBean() {
        super(Reassurance.class);
    }

    
}
