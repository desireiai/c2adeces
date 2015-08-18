package com.c2a.vie.service.deces;

import javax.ejb.Local;
import com.c2a.vie.entities.Souscripteur;
import com.c2a.vie.service.BaseServiceBeanLocal;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Local
public interface SouscripteurServiceBeanLocal extends BaseServiceBeanLocal<Souscripteur, Integer> {
    List<Souscripteur> souscripteurall();
}