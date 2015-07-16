package com.c2a.vie.service.impl.deces;

import com.c2a.vie.service.impl.BaseServiceBean;
import com.c2a.vie.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.c2a.vie.service.deces.ContratServiceBeanLocal;
import com.c2a.vie.dao.deces.ContratDaoBeanLocal;
import com.c2a.vie.entities.Contrat;

/**
 *
 * @author K.M.A
 */
@Stateless
public class ContratServiceBean extends BaseServiceBean<Contrat,Integer> implements ContratServiceBeanLocal {

@EJB
private ContratDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Contrat, Integer> getDAO() {
        return this.dao;
    }
}