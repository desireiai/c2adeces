package com.c2a.vie.service.impl.deces;

import com.c2a.vie.service.impl.BaseServiceBean;
import com.c2a.vie.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.c2a.vie.service.deces.AssuresServiceBeanLocal;
import com.c2a.vie.dao.deces.AssuresDaoBeanLocal;
import com.c2a.vie.entities.Assures;

/**
 *
 * @author K.M.A
 */
@Stateless
public class AssuresServiceBean extends BaseServiceBean<Assures, Integer> implements AssuresServiceBeanLocal {

@EJB
private AssuresDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Assures, Integer> getDAO() {
        return this.dao;
    }
}