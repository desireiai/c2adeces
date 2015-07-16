package com.c2a.vie.service.impl.deces;

import com.c2a.vie.service.impl.BaseServiceBean;
import com.c2a.vie.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.c2a.vie.service.deces.SouscripteurServiceBeanLocal;
import com.c2a.vie.dao.deces.SouscripteurDaoBeanLocal;
import com.c2a.vie.entities.Souscripteur;

/**
 *
 * @author K.M.A
 */
@Stateless
public class SouscripteurServiceBean extends BaseServiceBean<Souscripteur, Integer> implements SouscripteurServiceBeanLocal {

@EJB
private SouscripteurDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Souscripteur, Integer> getDAO() {
        return this.dao;
    }
}