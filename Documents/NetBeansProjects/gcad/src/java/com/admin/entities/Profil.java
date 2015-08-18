/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.entities;

import com.c2a.vie.entities.Producteur;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author firok
 */
@Entity
@Table(name = "PROFIL")
public class Profil extends BaseAdminEntity {

      @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROFIL_ID")
    private Integer profilId;
    
    @Column(name = "PROFIL_DESC")
    private String profilDesc;
    
    @Column(name = "ACTIVE")
    private String active;
    
   
   // @OneToMany(fetch= FetchType.LAZY, mappedBy = "profil")
   // private List<ProfilMenuItem> profilMenuItems;
    
    @OneToMany(fetch= FetchType.LAZY, mappedBy = "profil")
    private List<Producteur> producteurs;

    public Profil() {
    }

    public Integer getProfilId() {
        return profilId;
    }

    public void setProfilId(Integer profilId) {
        this.profilId = profilId;
    }

  

    public String getProfilDesc() {
        return profilDesc;
    }

    public void setProfilDesc(String profilDesc) {
        this.profilDesc = profilDesc;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public List<Producteur> getProducteurs() {
        return producteurs;
    }

    public void setProducteurs(List<Producteur> producteurs) {
        this.producteurs = producteurs;
    }
    



    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (this.profilId != null ? this.profilId.hashCode() : 0);
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
        final Profil other = (Profil) obj;
        if ((this.profilId == null) ? (other.profilId != null) : !this.profilId.equals(other.profilId)) {
            return false;
        }
        return true;
    }
@Override
    public String toString() {
        return "Profil{" + "profilId=" + profilId + ", profilDesc=" + profilDesc + ", active=" + active + ", producteurs=" + producteurs + '}';
    }


    
}
