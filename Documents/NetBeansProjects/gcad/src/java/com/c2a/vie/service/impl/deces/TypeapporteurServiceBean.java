package com.c2a.vie.service.impl.deces;

import com.c2a.vie.service.impl.BaseServiceBean;
import com.c2a.vie.dao.BaseDaoBeanLocal;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import com.c2a.vie.service.deces.TypeapporteurServiceBeanLocal;
import com.c2a.vie.dao.deces.TypeapporteurDaoBeanLocal;
import com.c2a.vie.entities.Typeapporteur;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Stateless
public class TypeapporteurServiceBean extends BaseServiceBean<Typeapporteur, Integer> implements TypeapporteurServiceBeanLocal {

@EJB
private TypeapporteurDaoBeanLocal dao;
    
      @Override
    protected BaseDaoBeanLocal<Typeapporteur, Integer> getDAO() {
        return this.dao;
    }

    @Override
    public List<Typeapporteur> typeapporteurall() {
        return this.dao.typeapporteurall();
    }
}