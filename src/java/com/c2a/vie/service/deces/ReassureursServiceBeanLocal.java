package com.c2a.vie.service.deces;

import javax.ejb.Local;
import com.c2a.vie.entities.Reassureurs;
import com.c2a.vie.service.BaseServiceBeanLocal;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Local
public interface ReassureursServiceBeanLocal extends BaseServiceBeanLocal<Reassureurs, Integer> {
    List<Reassureurs> reassureurall();
    List<Reassureurs> recherchereassureurnom(String nom);
}