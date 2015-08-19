package com.c2a.vie.service.impl.deces;

import com.c2a.vie.service.impl.BaseServiceBean;
import com.c2a.vie.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.c2a.vie.service.deces.GarantieServiceBeanLocal;
import com.c2a.vie.dao.deces.GarantieDaoBeanLocal;
import com.c2a.vie.entities.Garantie;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Stateless
public class GarantieServiceBean extends BaseServiceBean<Garantie, Integer> implements GarantieServiceBeanLocal {

@EJB
private GarantieDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Garantie, Integer> getDAO() {
        return this.dao;
    }

    @Override
    public List<Garantie> garantieall() {
        return this.dao.garantieall();
    }
}