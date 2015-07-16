package com.c2a.vie.dao.impl.deces;

import com.c2a.vie.dao.deces.ProducteurDaoBeanLocal;
import com.c2a.vie.dao.impl.BaseDaoBean;
import com.c2a.vie.entities.Producteur;
import javax.ejb.Stateless;

/**
 *
 * @author K.M.A
 */
@Stateless
public class ProducteurDaoBean extends BaseDaoBean<Producteur,Integer> implements ProducteurDaoBeanLocal {

    public ProducteurDaoBean() {
        super(Producteur.class);
    }

    
}
