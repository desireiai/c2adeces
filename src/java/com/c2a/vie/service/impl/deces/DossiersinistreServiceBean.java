package com.c2a.vie.service.impl.deces;

import com.c2a.vie.service.impl.BaseServiceBean;
import com.c2a.vie.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.c2a.vie.service.deces.DossiersinistreServiceBeanLocal;
import com.c2a.vie.dao.deces.DossiersinistreDaoBeanLocal;
import com.c2a.vie.entities.Dossiersinistre;

/**
 *
 * @author K.M.A
 */
@Stateless
public class DossiersinistreServiceBean extends BaseServiceBean<Dossiersinistre, Integer> implements DossiersinistreServiceBeanLocal {

@EJB
private DossiersinistreDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Dossiersinistre, Integer> getDAO() {
        return this.dao;
    }
}