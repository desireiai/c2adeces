package com.c2a.vie.dao.impl.deces;

import com.c2a.vie.dao.deces.ContratDaoBeanLocal;
import com.c2a.vie.dao.impl.BaseDaoBean;
import com.c2a.vie.entities.Contrat;
import com.c2a.vie.entities.Groupe;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author K.M.A
 */
@Stateless
public class ContratDaoBean extends BaseDaoBean<Contrat,Integer> implements ContratDaoBeanLocal {

    public ContratDaoBean() {
        super(Contrat.class);
    }

    @Override
    public List<Contrat> contratall() {
        Query q=this.em.createQuery("SELECT c from Contrat c WHERE c.etatcontrat=:valeur AND c.dateexp>CURRENT_TIMESTAMP");
        q.setParameter("valeur", "actif");
        return q.getResultList();
    }

    @Override
    public List<Contrat> contratentreprise() {
        Query q=this.em.createQuery("SELECT SUM(c.capitgarantitotale),c.idgarantie from Contrat c GROUP BY c.idgarantie ");
        return q.getResultList();
       
    }


    @Override
    public List<Contrat> contratresilie() {
        Query q=this.em.createQuery("SELECT c FROM Contrat c WHERE c.etatcontrat=:valeur");
        q.setParameter("valeur", "inactif");
        return q.getResultList();
    }

    @Override
    public Double sommecapitale() {
 Query q = em.createQuery("SELECT SUM(c.capitgarantitotale) FROM Contrat c WHERE c.codeapp  IS NULL");
        return (Double) q.getSingleResult();
    }
    

    @Override
    public Double sommeprime() {
        Query q=this.em.createQuery("SELECT SUM(c.primemontant) FROM Contrat c WHERE c.codeapp IS NULL");
        return (Double) q.getSingleResult();
    }

    @Override
    public List<Contrat> assurecontratgroupe(Groupe gr) {
        Query q=this.em.createQuery("SELECT c FROM Contrat c WHERE c.idgroupe=:valeur");
        q.setParameter("valeur", gr);
        return q.getResultList();
    }
    

    @Override
    public List<Contrat> autregroupe() {
        Query q=this.em.createQuery("SELECT DISTINCT c FROM Contrat c  WHERE c.idtypecontrat.libtypecontrat<>:valeur AND c.etatcontrat=:valeur2 AND c.dateexp>CURRENT_TIMESTAMP ");
        q.setParameter("valeur", "groupe entreprise");
        q.setParameter("valeur2", "actif");
        return q.getResultList();
    }

    @Override
    public List<Contrat> autredetailcontrat(int i) {
        Query q=this.em.createQuery("SELECT c FROM Contrat c WHERE c.codassure.codassure=:id AND c.idtypecontrat.libtypecontrat<>:valeur1 AND c.etatcontrat=:valeur2 AND c.dateexp>CURRENT_TIMESTAMP");
        q.setParameter("valeur1", "groupe entreprise");
        q.setParameter("valeur2", "actif");
        q.setParameter("id", i);
        return q.getResultList();
    }

    @Override
    public List<Contrat> contratreassurance( double capit,int idtypecontrat) {
        Query q=this.em.createNativeQuery("{call reassurea(?,?,?)}",Contrat.class);
        q.setParameter(1, capit);
        q.setParameter(2, "actif");
        q.setParameter(3, (int)idtypecontrat);
        return q.getResultList();
    }

    @Override
    public List<Contrat> contratactif() {
        Query q=this.em.createQuery("SELECT c from Contrat c where c.etatcontrat=:valeur1 and c.dateexp>CURRENT_TIMESTAMP");
        q.setParameter("valeur1", "actif");
        return q.getResultList();
    }

    @Override
    public List<Contrat> contratentreprise(int i) {
        Query q=this.em.createQuery("SELECT C FROM Contrat C WHERE C.dateexp>CURRENT_TIMESTAMP AND c.etatcontrat=:valeur AND c.idtypecontrat.libtypecontrat=:valeur2 AND c.idgroupe.idgroupe=:valeur3");
        q.setParameter("valeur", "actif");
        q.setParameter("valeur2", "groupe entreprise");
        q.setParameter("valeur3", i);
        return q.getResultList();
    }

    
}
