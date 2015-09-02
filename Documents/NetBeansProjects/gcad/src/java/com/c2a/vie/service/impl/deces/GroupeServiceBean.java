package com.c2a.vie.service.impl.deces;

import com.c2a.vie.service.impl.BaseServiceBean;
import com.c2a.vie.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.c2a.vie.service.deces.GroupeServiceBeanLocal;
import com.c2a.vie.dao.deces.GroupeDaoBeanLocal;
import com.c2a.vie.entities.Groupe;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Stateless
public class GroupeServiceBean extends BaseServiceBean<Groupe, Integer> implements GroupeServiceBeanLocal {

@EJB
private GroupeDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Groupe, Integer> getDAO() {
        return this.dao;
    }

    @Override
    public List<Groupe> groupeall() {
        return this.dao.groupeall();
    }

    @Override
    public List<Groupe> groupenewcontrat() {
        return this.dao.groupenewcontrat();
    }

    @Override
    public List<Groupe> groupeavoircontrat() {
        return this.dao.groupeavoircontrat();
    }
}