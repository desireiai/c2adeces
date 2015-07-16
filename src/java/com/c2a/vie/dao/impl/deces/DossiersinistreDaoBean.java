package com.c2a.vie.dao.impl.deces;

import com.c2a.vie.dao.deces.DossiersinistreDaoBeanLocal;
import com.c2a.vie.dao.impl.BaseDaoBean;
import com.c2a.vie.entities.Dossiersinistre;
import javax.ejb.Stateless;

/**
 *
 * @author K.M.A
 */
@Stateless
public class DossiersinistreDaoBean extends BaseDaoBean<Dossiersinistre,Integer> implements DossiersinistreDaoBeanLocal {

    public DossiersinistreDaoBean() {
        super(Dossiersinistre.class);
    }

    
}
