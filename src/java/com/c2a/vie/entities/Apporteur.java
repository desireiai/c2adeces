/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2a.vie.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
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
@NamedQueries({
    @NamedQuery(name = "Apporteur.findAll", query = "SELECT a FROM Apporteur a"),
    @NamedQuery(name = "Apporteur.findByCodeapp", query = "SELECT a FROM Apporteur a WHERE a.codeapp = :codeapp"),
    @NamedQuery(name = "Apporteur.findByAdresseapp", query = "SELECT a FROM Apporteur a WHERE a.adresseapp = :adresseapp"),
    @NamedQuery(name = "Apporteur.findByCommissionapp", query = "SELECT a FROM Apporteur a WHERE a.commissionapp = :commissionapp"),
    @NamedQuery(name = "Apporteur.findByMontantapp", query = "SELECT a FROM Apporteur a WHERE a.montantapp = :montantapp"),
    @NamedQuery(name = "Apporteur.findByNomapp", query = "SELECT a FROM Apporteur a WHERE a.nomapp = :nomapp"),
    @NamedQuery(name = "Apporteur.findByStatutapp", query = "SELECT a FROM Apporteur a WHERE a.statutapp = :statutapp"),
    @NamedQuery(name = "Apporteur.findByTelapp", query = "SELECT a FROM Apporteur a WHERE a.telapp = :telapp")})
public class Apporteur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer codeapp;
    @Size(max = 255)
    @Column(length = 255)
    private String adresseapp;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 53)
    private Double commissionapp;
    private BigInteger montantapp;
    @Size(max = 255)
    @Column(length = 255)
    private String nomapp;
    @Size(max = 255)
    @Column(length = 255)
    private String statutapp;
    @Size(max = 255)
    @Column(length = 255)
    private String telapp;
    @JoinColumn(name = "idtypeapporteur", referencedColumnName = "idtypeapporteur")
    @ManyToOne(fetch = FetchType.LAZY)
    private Typeapporteur idtypeapporteur;
    @OneToMany(mappedBy = "codeapp", fetch = FetchType.LAZY)
    private List<Contrat> contratList;

    public Apporteur() {
    }

    public Apporteur(Integer codeapp) {
        this.codeapp = codeapp;
    }

    public Integer getCodeapp() {
        return codeapp;
    }

    public void setCodeapp(Integer codeapp) {
        this.codeapp = codeapp;
    }

    public String getAdresseapp() {
        return adresseapp;
    }

    public void setAdresseapp(String adresseapp) {
        this.adresseapp = adresseapp;
    }

    public Double getCommissionapp() {
        return commissionapp;
    }

    public void setCommissionapp(Double commissionapp) {
        this.commissionapp = commissionapp;
    }

    public BigInteger getMontantapp() {
        return montantapp;
    }

    public void setMontantapp(BigInteger montantapp) {
        this.montantapp = montantapp;
    }

    public String getNomapp() {
        return nomapp;
    }

    public void setNomapp(String nomapp) {
        this.nomapp = nomapp;
    }


    public String getStatutapp() {
        return statutapp;
    }

    public void setStatutapp(String statutapp) {
        this.statutapp = statutapp;
    }

    public String getTelapp() {
        return telapp;
    }

    public void setTelapp(String telapp) {
        this.telapp = telapp;
    }

    public Typeapporteur getIdtypeapporteur() {
        return idtypeapporteur;
    }

    public void setIdtypeapporteur(Typeapporteur idtypeapporteur) {
        this.idtypeapporteur = idtypeapporteur;
    }

    @XmlTransient
    public List<Contrat> getContratList() {
        return contratList;
    }

    public void setContratList(List<Contrat> contratList) {
        this.contratList = contratList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeapp != null ? codeapp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apporteur)) {
            return false;
        }
        Apporteur other = (Apporteur) object;
        if ((this.codeapp == null && other.codeapp != null) || (this.codeapp != null && !this.codeapp.equals(other.codeapp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.c2a.vie.entities.Apporteur[ codeapp=" + codeapp + " ]";
    }
    
}
