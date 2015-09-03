package com.c2a.vie.service.deces;

import javax.ejb.Local;
import com.c2a.vie.entities.Apporteur;
import com.c2a.vie.service.BaseServiceBeanLocal;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Local
public interface ApporteurServiceBeanLocal extends BaseServiceBeanLocal<Apporteur, Integer> {
    List<Apporteur> apporteurall();
    List<Apporteur> recherchenom(String nom);
    List<Apporteur> apporteurentreprise();
}