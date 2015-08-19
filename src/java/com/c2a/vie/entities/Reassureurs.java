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
    @NamedQuery(name = "Reassureurs.findAll", query = "SELECT r FROM Reassureurs r"),
    @NamedQuery(name = "Reassureurs.findByIdreass", query = "SELECT r FROM Reassureurs r WHERE r.idreass = :idreass"),
    @NamedQuery(name = "Reassureurs.findByAdressreass", query = "SELECT r FROM Reassureurs r WHERE r.adressreass = :adressreass"),
    @NamedQuery(name = "Reassureurs.findByCategorireass", query = "SELECT r FROM Reassureurs r WHERE r.categorireass = :categorireass"),
    @NamedQuery(name = "Reassureurs.findByEmailreass", query = "SELECT r FROM Reassureurs r WHERE r.emailreass = :emailreass"),
    @NamedQuery(name = "Reassureurs.findByNomreass", query = "SELECT r FROM Reassureurs r WHERE r.nomreass = :nomreass"),
    @NamedQuery(name = "Reassureurs.findByStatutreass", query = "SELECT r FROM Reassureurs r WHERE r.statutreass = :statutreass"),
    @NamedQuery(name = "Reassureurs.findByTelreass", query = "SELECT r FROM Reassureurs r WHERE r.telreass = :telreass")})
public class Reassureurs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer idreass;
    @Size(max = 255)
    @Column(length = 255)
    private String adressreass;
    @Size(max = 255)
    @Column(length = 255)
    private String categorireass;
    @Size(max = 255)
    @Column(length = 255)
    private String emailreass;
    @Size(max = 255)
    @Column(length = 255)
    private String nomreass;
    @Size(max = 255)
    @Column(length = 255)
    private String statutreass;
    @Size(max = 255)
    @Column(length = 255)
    private String telreass;
    @OneToMany(mappedBy = "idreass", fetch = FetchType.LAZY)
    private List<Reassurance> reassuranceList;

    public Reassureurs() {
    }

    public Reassureurs(Integer idreass) {
        this.idreass = idreass;
    }

    public Integer getIdreass() {
        return idreass;
    }

    public void setIdreass(Integer idreass) {
        this.idreass = idreass;
    }

    public String getAdressreass() {
        return adressreass;
    }

    public void setAdressreass(String adressreass) {
        this.adressreass = adressreass;
    }

    public String getCategorireass() {
        return categorireass;
    }

    public void setCategorireass(String categorireass) {
        this.categorireass = categorireass;
    }

    public String getEmailreass() {
        return emailreass;
    }

    public void setEmailreass(String emailreass) {
        this.emailreass = emailreass;
    }

    public String getNomreass() {
        return nomreass;
    }

    public void setNomreass(String nomreass) {
        this.nomreass = nomreass;
    }

    public String getStatutreass() {
        return statutreass;
    }

    public void setStatutreass(String statutreass) {
        this.statutreass = statutreass;
    }

    public String getTelreass() {
        return telreass;
    }

    public void setTelreass(String telreass) {
        this.telreass = telreass;
    }

    @XmlTransient
    public List<Reassurance> getReassuranceList() {
        return reassuranceList;
    }

    public void setReassuranceList(List<Reassurance> reassuranceList) {
        this.reassuranceList = reassuranceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreass != null ? idreass.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reassureurs)) {
            return false;
        }
        Reassureurs other = (Reassureurs) object;
        if ((this.idreass == null && other.idreass != null) || (this.idreass != null && !this.idreass.equals(other.idreass))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.c2a.vie.entities.Reassureurs[ idreass=" + idreass + " ]";
    }
    
}
