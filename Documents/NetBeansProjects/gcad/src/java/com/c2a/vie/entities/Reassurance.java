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
    @NamedQuery(name = "Reassurance.findAll", query = "SELECT r FROM Reassurance r"),
    @NamedQuery(name = "Reassurance.findByIdreassur", query = "SELECT r FROM Reassurance r WHERE r.idreassur = :idreassur"),
    @NamedQuery(name = "Reassurance.findByTauxcommisreas", query = "SELECT r FROM Reassurance r WHERE r.tauxcommisreas = :tauxcommisreas"),
    @NamedQuery(name = "Reassurance.findByTauxreass", query = "SELECT r FROM Reassurance r WHERE r.tauxreass = :tauxreass")})
public class Reassurance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer idreassur;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 53)
    private Float tauxcommisreas;
    @Column(precision = 53)
    private Float tauxreass;
    private Double partreass;
    @JoinColumn(name = "numpolice", referencedColumnName = "numpolice")
    @ManyToOne(fetch = FetchType.LAZY)
    private Contrat numpolice;
    @JoinColumn(name = "idreass", referencedColumnName = "idreass")
    @ManyToOne(fetch = FetchType.LAZY)
    private Reassureurs idreass;

    public Reassurance() {
    }

    public Reassurance(Integer idreassur) {
        this.idreassur = idreassur;
    }

    public Integer getIdreassur() {
        return idreassur;
    }

    public void setIdreassur(Integer idreassur) {
        this.idreassur = idreassur;
    }

    public Float getTauxcommisreas() {
        return tauxcommisreas;
    }

    public void setTauxcommisreas(Float tauxcommisreas) {
        this.tauxcommisreas = tauxcommisreas;
    }

    public Float getTauxreass() {
        return tauxreass;
    }

    public void setTauxreass(Float tauxreass) {
        this.tauxreass = tauxreass;
    }

  

    public Contrat getNumpolice() {
        return numpolice;
    }

    public void setNumpolice(Contrat numpolice) {
        this.numpolice = numpolice;
    }

    public Double getPartreass() {
        return partreass;
    }

    public void setPartreass(Double partreass) {
        this.partreass = partreass;
    }
    

    public Reassureurs getIdreass() {
        return idreass;
    }

    public void setIdreass(Reassureurs idreass) {
        this.idreass = idreass;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreassur != null ? idreassur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reassurance)) {
            return false;
        }
        Reassurance other = (Reassurance) object;
        if ((this.idreassur == null && other.idreassur != null) || (this.idreassur != null && !this.idreassur.equals(other.idreassur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.c2a.vie.entities.Reassurance[ idreassur=" + idreassur + " ]";
    }
    
}
