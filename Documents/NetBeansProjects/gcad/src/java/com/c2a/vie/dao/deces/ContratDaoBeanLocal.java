package com.c2a.vie.dao.deces;

import com.c2a.vie.dao.BaseDaoBeanLocal;
import com.c2a.vie.entities.Contrat;
import com.c2a.vie.entities.Groupe;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author K.M.A
 */
@Local
public interface ContratDaoBeanLocal extends BaseDaoBeanLocal<Contrat, Integer>{
    List<Contrat> contratall();
    List<Contrat> contratentreprise();
    List<Contrat> assurecontratgroupe(Groupe gr);
    List<Contrat> contratresilie();
    List<Contrat> autregroupe();
    List<Contrat> autredetailcontrat(int i);
    List<Contrat> contratentreprise(int i);
    public List<Contrat> contratreassurance( double capit,int idtypecontrat);
    public List<Contrat> contratassuregentreprise(int idgroupe,int idassure);
    List<Contrat> contraresilieall(Date deb,Date fin);
    List<Contrat> contratactifall(Date deb,Date fin);
    List<Contrat> contratexpireall(Date deb,Date fin);
    List<Contrat> contratexpire();
    List<Contrat> contratactif();
    Double sommecapitale();
    Double sommeprime();  
}