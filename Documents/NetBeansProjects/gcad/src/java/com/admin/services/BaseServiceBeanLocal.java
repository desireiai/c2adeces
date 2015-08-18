/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.services;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author komilo
 */
public interface BaseServiceBeanLocal<T extends Serializable, K> {
    
    List<T> selectionnerTout();
    
    List<T> selectionnerTout(String proprieteTri, boolean triAscendant);
    
    List<T> selectionnerTout(int debut, int total);
    
    List<T> selectionnerTout(int debut, int total, String proprieteTri, boolean triAscendant);
    
    T selectionner(K k);
    
    void ajouter(final T t);
    
    void ajouter(final Collection<T> ts);
    
    void modifier(final T t);
    
    void supprimer(final K k);
    
    void supprimer(final T t);
    
    void supprimer(final Collection<T> ts);
    
    void supprimerTout();
}
