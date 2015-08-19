/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.entities;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author firok
 */
@Entity
@Table(name = "DROIT")
public class ProfilMenuItem extends BaseAdminEntity {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer iddroit;
    
    @Column(name = "DROIT")
    private String droit;
    
    @Column(name = "ACTIVE")
    private String active;
    
    @JoinColumn(name = "PROFIL_ID", referencedColumnName = "PROFIL_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Profil profil;
    
    @JoinColumn(name = "MENU_ITEM_ID", referencedColumnName = "MENU_ITEM_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MenuItem menuItem;

    public ProfilMenuItem() {
    }

    public Integer getIddroit() {
        return iddroit;
    }

    public void setIddroit(Integer iddroit) {
        this.iddroit = iddroit;
    }

  

    
    

    public String getDroit() {
        return droit;
    }

    public void setDroit(String droit) {
        this.droit = droit;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.iddroit);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProfilMenuItem other = (ProfilMenuItem) obj;
        if (!Objects.equals(this.iddroit, other.iddroit)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProfilMenuItem{" + "iddroit=" + iddroit + ", droit=" + droit + ", active=" + active + ", profil=" + profil + ", menuItem=" + menuItem + '}';
    }

 



   
}
