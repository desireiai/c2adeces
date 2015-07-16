package com.c2a.vie.service.impl.deces;

import com.c2a.vie.service.impl.BaseServiceBean;
import com.c2a.vie.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.c2a.vie.service.deces.CoassuranceServiceBeanLocal;
import com.c2a.vie.dao.deces.CoassuranceDaoBeanLocal;
import com.c2a.vie.entities.Coassurance;

/**
 *
 * @author K.M.A
 */
@Stateless
public class CoassuranceServiceBean extends BaseServiceBean<Coassurance, Integer> implements CoassuranceServiceBeanLocal {

@EJB
private CoassuranceDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Coassurance, Integer> getDAO() {
        return this.dao;
    }
}