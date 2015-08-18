
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2a.vie.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author desire.mensah
 */
@Entity
@Table(catalog = "c2a", schema = "dbo")
@XmlRootElement
public class Typeapporteur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer idtypeapporteur;
    
    @Size(max = 255)
    @Column(length = 255)
    private String libtypeapporteur;
    @Size(max = 255)
    @Column(length = 255)
    private String statuttypeapporteur;
    @OneToMany(mappedBy = "idtypeapporteur", fetch = FetchType.LAZY)
    private List<Apporteur> apporteurList;

    public Typeapporteur() {
    }

    public Typeapporteur(Integer idtypeapporteur) {
        this.idtypeapporteur = idtypeapporteur;
    }

    public Integer getIdtypeapporteur() {
        return idtypeapporteur;
    }

    public void setIdtypeapporteur(Integer idtypeapporteur) {
        this.idtypeapporteur = idtypeapporteur;
    }

    public String getLibtypeapporteur() {
        return libtypeapporteur;
    }

    public void setLibtypeapporteur(String libtypeapporteur) {
        this.libtypeapporteur = libtypeapporteur;
    }

    public String getStatuttypeapporteur() {
        return statuttypeapporteur;
    }

    public void setStatuttypeapporteur(String statuttypeapporteur) {
        this.statuttypeapporteur = statuttypeapporteur;
    }



    @XmlTransient
         public List<Apporteur> getApporteurList() {
        return apporteurList;
    }

    public void setApporteurList(List<Apporteur> apporteurList) {
        this.apporteurList = apporteurList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtypeapporteur != null ? idtypeapporteur.hashCode() : 0);
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
        final Typeapporteur other = (Typeapporteur) obj;
        if (!Objects.equals(this.idtypeapporteur, other.idtypeapporteur)) {
            return false;
        }
        return true;
    }

    


    @Override
    public String toString() {
        return "com.c2a.vie.entities.Typecontrat[ idtypecontrat=" + idtypeapporteur + " ]";
    }
    
}
