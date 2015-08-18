/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author firok
 * @param <T>
 * @param <K>
 */
@Local
public interface BaseDAOBeanLocal<T extends Serializable, K> {
  
    List<T>  selectionnerTout();
    
    T selectionner(K k);
    
    void ajouter(final T t);
    
    void modifier(final T t);
    
    void supprimer(final K k);
    
    void supprimer(final T t);
    
    void supprimerTout();
    
    int compter();
    
    void ajouter(final Collection<T> ts);
    
    
}
