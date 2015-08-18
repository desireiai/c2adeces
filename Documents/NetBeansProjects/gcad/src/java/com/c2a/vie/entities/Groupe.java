/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2a.vie.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @NamedQuery(name = "Groupe.findAll", query = "SELECT g FROM Groupe g"),
    @NamedQuery(name = "Groupe.findByIdgroupe", query = "SELECT g FROM Groupe g WHERE g.idgroupe = :idgroupe"),
    @NamedQuery(name = "Groupe.findByLibgroupe", query = "SELECT g FROM Groupe g WHERE g.libgroupe = :libgroupe"),
    @NamedQuery(name = "Groupe.findByPrimegroup", query = "SELECT g FROM Groupe g WHERE g.primegroup = :primegroup"),
    @NamedQuery(name = "Groupe.findBySituationgroup", query = "SELECT g FROM Groupe g WHERE g.situationgroup = :situationgroup"),
    @NamedQuery(name = "Groupe.findByStatutgroup", query = "SELECT g FROM Groupe g WHERE g.statutgroup = :statutgroup"),
    @NamedQuery(name = "Groupe.findByTelgroup", query = "SELECT g FROM Groupe g WHERE g.telgroup = :telgroup")})
public class Groupe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer idgroupe;
    @Size(max = 255)
    @Column(length = 255)
    private String libgroupe;
    private Double primegroup;
    private Double situationgroup;
    private Double primettcgroupe;
    private Float tauxremisegroupe;
    @Size(max = 255)
    @Column(length = 255)
    private String statutgroup;
    @Size(max = 255)
    @Column(length = 255)
    private String telgroup;
      @Size(max = 255)
    @Column(length = 255)
    private String emailgroup;
    @OneToMany(mappedBy = "idgroupe", fetch = FetchType.LAZY)
    private List<Contrat> contratList;

    public Groupe() {
    }

    public Groupe(Integer idgroupe) {
        this.idgroupe = idgroupe;
    }

    public Integer getIdgroupe() {
        return idgroupe;
    }

    public void setIdgroupe(Integer idgroupe) {
        this.idgroupe = idgroupe;
    }

    public String getLibgroupe() {
        return libgroupe;
    }

    public void setLibgroupe(String libgroupe) {
        this.libgroupe = libgroupe;
    }

    public Double getPrimegroup() {
        return primegroup;
    }

    public void setPrimegroup(Double primegroup) {
        this.primegroup = primegroup;
    }

    public Double getSituationgroup() {
        return situationgroup;
    }

    public void setSituationgroup(Double situationgroup) {
        this.situationgroup = situationgroup;
    }


 

    public String getEmailgroup() {
        return emailgroup;
    }

    public void setEmailgroup(String emailgroup) {
        this.emailgroup = emailgroup;
    }
    

    public String getStatutgroup() {
        return statutgroup;
    }

    public void setStatutgroup(String statutgroup) {
        this.statutgroup = statutgroup;
    }

    public String getTelgroup() {
        return telgroup;
    }

    public void setTelgroup(String telgroup) {
        this.telgroup = telgroup;
    }

    public Double getPrimettcgroupe() {
        return primettcgroupe;
    }

    public void setPrimettcgroupe(Double primettcgroupe) {
        this.primettcgroupe = primettcgroupe;
    }

    public Float getTauxremisegroupe() {
        return tauxremisegroupe;
    }

    public void setTauxremisegroupe(Float tauxremisegroupe) {
        this.tauxremisegroupe = tauxremisegroupe;
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
        hash += (idgroupe != null ? idgroupe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupe)) {
            return false;
        }
        Groupe other = (Groupe) object;
        if ((this.idgroupe == null && other.idgroupe != null) || (this.idgroupe != null && !this.idgroupe.equals(other.idgroupe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.c2a.vie.entities.Groupe[ idgroupe=" + idgroupe + " ]";
    }
    
}
