package com.c2a.vie.service.impl.deces;

import com.c2a.vie.service.impl.BaseServiceBean;
import com.c2a.vie.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.c2a.vie.service.deces.ProducteurServiceBeanLocal;
import com.c2a.vie.dao.deces.ProducteurDaoBeanLocal;
import com.c2a.vie.entities.Producteur;

/**
 *
 * @author K.M.A
 */
@Stateless
public class ProducteurServiceBean extends BaseServiceBean<Producteur, Integer> implements ProducteurServiceBeanLocal {

@EJB
private ProducteurDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Producteur, Integer> getDAO() {
        return this.dao;
    }
}