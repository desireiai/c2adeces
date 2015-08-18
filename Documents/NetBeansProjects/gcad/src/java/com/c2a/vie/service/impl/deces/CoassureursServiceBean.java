package com.c2a.vie.service.impl.deces;

import com.c2a.vie.service.impl.BaseServiceBean;
import com.c2a.vie.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.c2a.vie.service.deces.CoassureursServiceBeanLocal;
import com.c2a.vie.dao.deces.CoassureursDaoBeanLocal;
import com.c2a.vie.entities.Coassureurs;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Stateless
public class CoassureursServiceBean extends BaseServiceBean<Coassureurs, Integer> implements CoassureursServiceBeanLocal {

@EJB
private CoassureursDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Coassureurs, Integer> getDAO() {
        return this.dao;
    }

    @Override
    public List<Coassureurs> coassureurall() {
        return this.dao.coassureurall();
    }
}