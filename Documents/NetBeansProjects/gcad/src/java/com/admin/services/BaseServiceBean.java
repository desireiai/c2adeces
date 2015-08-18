/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.services;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import com.admin.dao.BaseDAOBeanLocal;

/**
 *
 * @author komilo
 */
public abstract class BaseServiceBean<T extends Serializable, K> implements BaseServiceBeanLocal<T, K> {

    
    protected abstract BaseDAOBeanLocal<T, K> getDAO();
    
    @Override
    public List<T> selectionnerTout() {
        return this.getDAO().selectionnerTout();
    }

    @Override
    public List<T> selectionnerTout(String proprieteTri, boolean triAscendant) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<T> selectionnerTout(int debut, int total) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<T> selectionnerTout(int debut, int total, String proprieteTri, boolean triAscendant) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public T selectionner(K k) {
        return this.getDAO().selectionner(k);
    }

    @Override
    public void ajouter(T t) {
        this.getDAO().ajouter(t);
    }

    @Override
    public void ajouter(Collection<T> ts) {
        for (T t : ts) {
            this.getDAO().ajouter(t);
        }
    }

    @Override
    public void modifier(T t) {
        this.getDAO().modifier(t);
    }

    @Override
    public void supprimer(K k) {
        this.getDAO().supprimer(this.getDAO().selectionner(k));
    }

    @Override
    public void supprimer(T t) {
        this.getDAO().supprimer(t);
    }

    @Override
    public void supprimer(Collection<T> ts) {
        for (T t: ts) {
            this.getDAO().supprimer(t);
        }
    }

    @Override
    public void supprimerTout() {
        this.getDAO().supprimerTout();
    }
    
}
