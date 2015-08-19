package com.c2a.vie.service.impl.deces;

import com.c2a.vie.service.impl.BaseServiceBean;
import com.c2a.vie.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.c2a.vie.service.deces.ModepayementServiceBeanLocal;
import com.c2a.vie.dao.deces.ModepayementDaoBeanLocal;
import com.c2a.vie.entities.Modepayement;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Stateless
public class ModepayementServiceBean extends BaseServiceBean<Modepayement, Integer> implements ModepayementServiceBeanLocal {

@EJB
private ModepayementDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Modepayement, Integer> getDAO() {
        return this.dao;
    }

    @Override
    public List<Modepayement> listmodepayementall() {
        return this.dao.listmodepayementall();
    }
}