/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2a.vie.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author desire.mensah
 */
@Entity
@Table(catalog = "c2a", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dossiersinistre.findAll", query = "SELECT d FROM Dossiersinistre d"),
    @NamedQuery(name = "Dossiersinistre.findByNumdossiersin", query = "SELECT d FROM Dossiersinistre d WHERE d.numdossiersin = :numdossiersin"),
    @NamedQuery(name = "Dossiersinistre.findByDatedecessin", query = "SELECT d FROM Dossiersinistre d WHERE d.datedecessin = :datedecessin"),
    @NamedQuery(name = "Dossiersinistre.findByDatedeclarsin", query = "SELECT d FROM Dossiersinistre d WHERE d.datedeclarsin = :datedeclarsin"),
    @NamedQuery(name = "Dossiersinistre.findByDateemisschec", query = "SELECT d FROM Dossiersinistre d WHERE d.dateemisschec = :dateemisschec"),
    @NamedQuery(name = "Dossiersinistre.findByEtatdossiersin", query = "SELECT d FROM Dossiersinistre d WHERE d.etatdossiersin = :etatdossiersin"),
    @NamedQuery(name = "Dossiersinistre.findByMontantsin", query = "SELECT d FROM Dossiersinistre d WHERE d.montantsin = :montantsin"),
    @NamedQuery(name = "Dossiersinistre.findByMotifsin", query = "SELECT d FROM Dossiersinistre d WHERE d.motifsin = :motifsin"),
    @NamedQuery(name = "Dossiersinistre.findByPartcoass", query = "SELECT d FROM Dossiersinistre d WHERE d.partcoass = :partcoass"),
    @NamedQuery(name = "Dossiersinistre.findByPartreass", query = "SELECT d FROM Dossiersinistre d WHERE d.partreass = :partreass"),
    @NamedQuery(name = "Dossiersinistre.findBySaisipar", query = "SELECT d FROM Dossiersinistre d WHERE d.saisipar = :saisipar")})
public class Dossiersinistre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer numdossiersin;
    @Temporal(TemporalType.DATE)
    private Date datedecessin;
    @Temporal(TemporalType.DATE)
    private Date datedeclarsin;
    @Temporal(TemporalType.DATE)
    private Date dateemisschec;
    @Size(max = 255)
    @Column(length = 255)
    private String etatdossiersin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 53)
    private Double montantsin;
    @Size(max = 255)
    @Column(length = 255)
    private String motifsin;
    private Double partcoass;
    private Double partreass;
    @Size(max = 255)
    @Column(length = 255)
    private String saisipar;
    @JoinColumn(name = "numpolice", referencedColumnName = "numpolice")
    @ManyToOne(fetch = FetchType.LAZY)
    private Contrat numpolice;

    public Dossiersinistre() {
    }

    public Dossiersinistre(Integer numdossiersin) {
        this.numdossiersin = numdossiersin;
    }

    public Integer getNumdossiersin() {
        return numdossiersin;
    }

    public void setNumdossiersin(Integer numdossiersin) {
        this.numdossiersin = numdossiersin;
    }

    public Date getDatedecessin() {
        return datedecessin;
    }

    public void setDatedecessin(Date datedecessin) {
        this.datedecessin = datedecessin;
    }

    public Date getDatedeclarsin() {
        return datedeclarsin;
    }

    public void setDatedeclarsin(Date datedeclarsin) {
        this.datedeclarsin = datedeclarsin;
    }

    public Date getDateemisschec() {
        return dateemisschec;
    }

    public void setDateemisschec(Date dateemisschec) {
        this.dateemisschec = dateemisschec;
    }

    public String getEtatdossiersin() {
        return etatdossiersin;
    }

    public void setEtatdossiersin(String etatdossiersin) {
        this.etatdossiersin = etatdossiersin;
    }

    public Double getMontantsin() {
        return montantsin;
    }

    public void setMontantsin(Double montantsin) {
        this.montantsin = montantsin;
    }

    public String getMotifsin() {
        return motifsin;
    }

    public void setMotifsin(String motifsin) {
        this.motifsin = motifsin;
    }

    public Double getPartcoass() {
        return partcoass;
    }

    public void setPartcoass(Double partcoass) {
        this.partcoass = partcoass;
    }

    public Double getPartreass() {
        return partreass;
    }

    public void setPartreass(Double partreass) {
        this.partreass = partreass;
    }



    public String getSaisipar() {
        return saisipar;
    }

    public void setSaisipar(String saisipar) {
        this.saisipar = saisipar;
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
        hash += (numdossiersin != null ? numdossiersin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dossiersinistre)) {
            return false;
        }
        Dossiersinistre other = (Dossiersinistre) object;
        if ((this.numdossiersin == null && other.numdossiersin != null) || (this.numdossiersin != null && !this.numdossiersin.equals(other.numdossiersin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.c2a.vie.entities.Dossiersinistre[ numdossiersin=" + numdossiersin + " ]";
    }
    
}
