package com.c2a.vie.service.deces;

import javax.ejb.Local;
import com.c2a.vie.entities.Groupe;
import com.c2a.vie.service.BaseServiceBeanLocal;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Local
public interface GroupeServiceBeanLocal extends BaseServiceBeanLocal<Groupe, Integer> {
    List<Groupe> groupeall();
    List<Groupe> groupenewcontrat();
    List<Groupe> groupeavoircontrat();
}