package com.c2a.vie.dao.impl.deces;

import com.c2a.vie.dao.deces.AssuresDaoBeanLocal;
import com.c2a.vie.dao.impl.BaseDaoBean;
import com.c2a.vie.entities.Assures;
import javax.ejb.Stateless;

/**
 *
 * @author K.M.A
 */
@Stateless
public class AssuresDaoBean extends BaseDaoBean<Assures,Integer> implements AssuresDaoBeanLocal {

    public AssuresDaoBean() {
        super(Assures.class);
    }

    
}
