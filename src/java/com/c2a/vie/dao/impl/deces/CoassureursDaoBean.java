package com.c2a.vie.dao.impl.deces;

import com.c2a.vie.dao.deces.CoassureursDaoBeanLocal;
import com.c2a.vie.dao.impl.BaseDaoBean;
import com.c2a.vie.entities.Coassureurs;
import javax.ejb.Stateless;

/**
 *
 * @author K.M.A
 */
@Stateless
public class CoassureursDaoBean extends BaseDaoBean<Coassureurs,Integer> implements CoassureursDaoBeanLocal {

    public CoassureursDaoBean() {
        super(Coassureurs.class);
    }

    
}
