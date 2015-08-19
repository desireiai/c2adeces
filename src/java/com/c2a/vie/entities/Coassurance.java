/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2a.vie.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author desire.mensah
 */
@Entity
@Table(catalog = "c2a", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coassurance.findAll", query = "SELECT c FROM Coassurance c"),
    @NamedQuery(name = "Coassurance.findByIdcoassur", query = "SELECT c FROM Coassurance c WHERE c.idcoassur = :idcoassur"),
    @NamedQuery(name = "Coassurance.findByTauxcoass", query = "SELECT c FROM Coassurance c WHERE c.tauxcoass = :tauxcoass")})
public class Coassurance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer idcoassur;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 53)
    private Double tauxcoass;
    @JoinColumn(name = "codecoass", referencedColumnName = "codecoass")
    @ManyToOne(fetch = FetchType.LAZY)
    private Coassureurs codecoass;
    @JoinColumn(name = "numpolice", referencedColumnName = "numpolice")
    @ManyToOne(fetch = FetchType.LAZY)
    private Contrat numpolice;

    public Coassurance() {
    }

    public Coassurance(Integer idcoassur) {
        this.idcoassur = idcoassur;
    }

    public Integer getIdcoassur() {
        return idcoassur;
    }

    public void setIdcoassur(Integer idcoassur) {
        this.idcoassur = idcoassur;
    }

    public Double getTauxcoass() {
        return tauxcoass;
    }

    public void setTauxcoass(Double tauxcoass) {
        this.tauxcoass = tauxcoass;
    }

    public Coassureurs getCodecoass() {
        return codecoass;
    }

    public void setCodecoass(Coassureurs codecoass) {
        this.codecoass = codecoass;
    }

    public Contrat getNumpolice() {
        return numpolice;
    }

    public void setNumpolice(Contrat numpolice) {
        this.numpolice = numpolice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcoassur != null ? idcoassur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coassurance)) {
            return false;
        }
        Coassurance other = (Coassurance) object;
        if ((this.idcoassur == null && other.idcoassur != null) || (this.idcoassur != null && !this.idcoassur.equals(other.idcoassur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.c2a.vie.entities.Coassurance[ idcoassur=" + idcoassur + " ]";
    }
    
}
