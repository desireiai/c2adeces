/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2a.vie.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author MANU
 * @param <T>
 * @param <K>
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
    
    int compter();
    
     T selectionner(String propriete,String valeur);
     
     T selectionmigrer(String id,String prop,String val);
     
     T selectionMirgerIt(String id,String prop,Integer val);
    
     List<T> selectionnerTouts(String objet,String propriete,String valeur);
     
      List<T> selectionnerToutregle(String objet,String propriete,float valeur);
      
      List<T> selectionnerParLettre(String propriete);
     
      List<T> selectionnerrecherche(String propriete,String valeur);
}
