package com.c2a.vie.dao.impl.deces;

import com.c2a.vie.dao.deces.TypeapporteurDaoBeanLocal;
import com.c2a.vie.dao.impl.BaseDaoBean;
import com.c2a.vie.entities.Typeapporteur;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author K.M.A
 */
@Stateless
public class TypeapporteurDaoBean extends BaseDaoBean<Typeapporteur,Integer> implements TypeapporteurDaoBeanLocal {

    public TypeapporteurDaoBean() {
        super(Typeapporteur.class);
    }

    @Override
    public List<Typeapporteur> typeapporteurall() {
        Query list=this.em.createQuery("SELECT t FROM Typeapporteur t WHERE t.statuttypeapporteur=:valeur");
          list.setParameter("valeur", "actif");
          return list.getResultList();
    }

    
}
