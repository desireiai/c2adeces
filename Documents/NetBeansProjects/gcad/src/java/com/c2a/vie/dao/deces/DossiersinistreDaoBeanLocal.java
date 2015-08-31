package com.c2a.vie.dao.deces;

import com.c2a.vie.dao.BaseDaoBeanLocal;
import com.c2a.vie.entities.Contrat;
import com.c2a.vie.entities.Dossiersinistre;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author K.M.A
 */
@Local
public interface DossiersinistreDaoBeanLocal extends BaseDaoBeanLocal<Dossiersinistre, Integer>{
    
     List<Dossiersinistre> dossiernontraite();
     List<Dossiersinistre> dossiertraite();
}