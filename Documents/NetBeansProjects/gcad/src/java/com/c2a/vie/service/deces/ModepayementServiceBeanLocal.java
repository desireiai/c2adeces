package com.c2a.vie.service.deces;

import javax.ejb.Local;
import com.c2a.vie.entities.Modepayement;
import com.c2a.vie.service.BaseServiceBeanLocal;
import java.util.List;

/**
 *
 * @author K.M.A
 */
@Local
public interface ModepayementServiceBeanLocal extends BaseServiceBeanLocal<Modepayement, Integer> {
    List<Modepayement> listmodepayementall();
}