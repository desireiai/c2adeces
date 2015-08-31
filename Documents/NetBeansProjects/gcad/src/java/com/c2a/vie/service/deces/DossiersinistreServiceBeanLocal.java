package com.c2a.vie.service.deces;

import javax.ejb.Local;
import com.c2a.vie.entities.Dossiersinistre;
import com.c2a.vie.service.BaseServiceBeanLocal;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Local
public interface DossiersinistreServiceBeanLocal extends BaseServiceBeanLocal<Dossiersinistre,Integer> {
    List<Dossiersinistre> dossiernontraite();
    List<Dossiersinistre> dossiertraite();
}