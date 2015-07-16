package com.c2a.vie.dao.impl.deces;

import com.c2a.vie.dao.deces.SouscripteurDaoBeanLocal;
import com.c2a.vie.dao.impl.BaseDaoBean;
import com.c2a.vie.entities.Souscripteur;
import javax.ejb.Stateless;

/**
 *
 * @author K.M.A
 */
@Stateless
public class SouscripteurDaoBean extends BaseDaoBean<Souscripteur,Integer> implements SouscripteurDaoBeanLocal {

    public SouscripteurDaoBean() {
        super(Souscripteur.class);
    }

    
}
