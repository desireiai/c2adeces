/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2a.vie.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author desire.mensah
 */
@Entity
public class Parametrecoassapporteur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(precision = 13)
    private Float tauxcoass;
    
     @JoinColumn(name = "codecoass", referencedColumnName = "codecoass")
    @ManyToOne(fetch = FetchType.LAZY)
    private Coassureurs codecoass;
    @JoinColumn(name = "codeapp", referencedColumnName = "codeapp")
    @ManyToOne(fetch = FetchType.LAZY)
    private Apporteur codeapp;

    public Parametrecoassapporteur() {
    }

    public Parametrecoassapporteur(Integer id) {
        this.id = id;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Coassureurs getCodecoass() {
        return codecoass;
    }

    public void setCodecoass(Coassureurs codecoass) {
        this.codecoass = codecoass;
    }

    public Apporteur getCodeapp() {
        return codeapp;
    }

    public void setCodeapp(Apporteur codeapp) {
        this.codeapp = codeapp;
    }

 
    

    public Float getTauxcoass() {
        return tauxcoass;
    }

    public void setTauxcoass(Float tauxcoass) {
        this.tauxcoass = tauxcoass;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametrecoassapporteur)) {
            return false;
        }
        Parametrecoassapporteur other = (Parametrecoassapporteur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.c2a.vie.entities.Parametrecoassapporteur[ id=" + id + " ]";
    }
    
}
