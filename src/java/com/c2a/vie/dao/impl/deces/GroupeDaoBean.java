package com.c2a.vie.dao.impl.deces;

import com.c2a.vie.dao.deces.GroupeDaoBeanLocal;
import com.c2a.vie.dao.impl.BaseDaoBean;
import com.c2a.vie.entities.Groupe;
import javax.ejb.Stateless;

/**
 *
 * @author K.M.A
 */
@Stateless
public class GroupeDaoBean extends BaseDaoBean<Groupe,Integer> implements GroupeDaoBeanLocal {

    public GroupeDaoBean() {
        super(Groupe.class);
    }

    
}
