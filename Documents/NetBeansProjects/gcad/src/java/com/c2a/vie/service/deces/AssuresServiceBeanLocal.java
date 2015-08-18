package com.c2a.vie.service.deces;

import javax.ejb.Local;
import com.c2a.vie.entities.Assures;
import com.c2a.vie.service.BaseServiceBeanLocal;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Local
public interface AssuresServiceBeanLocal extends BaseServiceBeanLocal<Assures, Integer> {
    List<Assures> assureall();
     List<Assures> assureentreprise();
    Integer moyenneage();
    List<Assures> assurepartypecontrat();
}