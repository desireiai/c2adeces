package com.c2a.vie.service.deces;

import javax.ejb.Local;
import com.c2a.vie.entities.Typeapporteur;
import com.c2a.vie.service.BaseServiceBeanLocal;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Local
public interface TypeapporteurServiceBeanLocal extends BaseServiceBeanLocal<Typeapporteur, Integer> {
     List<Typeapporteur> typeapporteurall(); 
}