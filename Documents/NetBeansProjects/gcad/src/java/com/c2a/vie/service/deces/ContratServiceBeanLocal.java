package com.c2a.vie.service.deces;

import com.c2a.vie.entities.Apporteur;
import javax.ejb.Local;
import com.c2a.vie.entities.Contrat;
import com.c2a.vie.entities.Garantie;
import com.c2a.vie.entities.Groupe;
import com.c2a.vie.entities.Typecontrat;
import com.c2a.vie.service.BaseServiceBeanLocal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Local
public interface ContratServiceBeanLocal extends BaseServiceBeanLocal<Contrat, Integer> {

    List<Contrat> contratall();

    List<Contrat> contratentreprise();

    List<Contrat> contratresilie();

    List<Contrat> assurecontratgroupe(Groupe gr);

    List<Contrat> autregroupe();

    List<Contrat> autredetailcontrat(int i);

    List<Contrat> contratentreprise(int i);

    public List<Contrat> contratreassurance(double capit, int idtypecontrat);

    public List<Contrat> contratassuregentreprise(int idgroupe, int idassure);
    
 List<Contrat> contraresilieall(Date deb,Date fin,Typecontrat typecont);
    List<Contrat> contratactifall(Date deb,Date fin,Typecontrat typecont);
    List<Contrat> contratexpireall(Date deb,Date fin,Typecontrat typecont);
    List<Contrat> contratcoassurance(Apporteur app,Typecontrat tycont,Garantie garant);
    
    List<Contrat> contratexpire();
    
    

    List<Contrat> contratactif();

    Double sommecapitale();

    Double sommeprime();
}
