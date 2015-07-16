package com.c2a.vie.service.impl.deces;

import com.c2a.vie.service.impl.BaseServiceBean;
import com.c2a.vie.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.c2a.vie.service.deces.ReassuranceServiceBeanLocal;
import com.c2a.vie.dao.deces.ReassuranceDaoBeanLocal;
import com.c2a.vie.entities.Reassurance;

/**
 *
 * @author K.M.A
 */
@Stateless
public class ReassuranceServiceBean extends BaseServiceBean<Reassurance, Integer> implements ReassuranceServiceBeanLocal {

@EJB
private ReassuranceDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Reassurance, Integer> getDAO() {
        return this.dao;
    }
}