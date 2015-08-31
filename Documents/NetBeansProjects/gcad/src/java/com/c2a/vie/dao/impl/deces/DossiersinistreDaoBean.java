package com.c2a.vie.dao.impl.deces;

import com.c2a.vie.dao.deces.DossiersinistreDaoBeanLocal;
import com.c2a.vie.dao.impl.BaseDaoBean;
import com.c2a.vie.entities.Dossiersinistre;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author K.M.A
 */
@Stateless
public class DossiersinistreDaoBean extends BaseDaoBean<Dossiersinistre,Integer> implements DossiersinistreDaoBeanLocal {

    public DossiersinistreDaoBean() {
        super(Dossiersinistre.class);
    }

    @Override
    public List<Dossiersinistre> dossiernontraite() {
        Query q = this.em.createQuery("select d from Dossiersinistre d where d.etatdossiersin=:valeur and d.dateemisschec is null ");
           q.setParameter("valeur","actif" );
           return q.getResultList();
    }

    @Override
    public List<Dossiersinistre> dossiertraite() {
        Query q = this.em.createQuery("select d from Dossiersinistre d where d.etatdossiersin=:valeur and d.dateemisschec is not null ");
           q.setParameter("valeur","actif" );
           return q.getResultList();
    }

    
}
