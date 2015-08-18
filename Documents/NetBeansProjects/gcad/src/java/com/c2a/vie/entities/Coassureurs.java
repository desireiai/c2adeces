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
    @NamedQuery(name = "Coassureurs.findAll", query = "SELECT c FROM Coassureurs c"),
    @NamedQuery(name = "Coassureurs.findByCodecoass", query = "SELECT c FROM Coassureurs c WHERE c.codecoass = :codecoass"),
    @NamedQuery(name = "Coassureurs.findByAdressecoass", query = "SELECT c FROM Coassureurs c WHERE c.adressecoass = :adressecoass"),
    @NamedQuery(name = "Coassureurs.findByEmailcoass", query = "SELECT c FROM Coassureurs c WHERE c.emailcoass = :emailcoass"),
    @NamedQuery(name = "Coassureurs.findByNomcoass", query = "SELECT c FROM Coassureurs c WHERE c.nomcoass = :nomcoass"),
    @NamedQuery(name = "Coassureurs.findByStatutcoass", query = "SELECT c FROM Coassureurs c WHERE c.statutcoass = :statutcoass"),
    @NamedQuery(name = "Coassureurs.findByTelcoass", query = "SELECT c FROM Coassureurs c WHERE c.telcoass = :telcoass")})
public class Coassureurs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer codecoass;
    @Size(max = 255)
    @Column(length = 255)
    private String adressecoass;
    @Size(max = 255)
    @Column(length = 255)
    private String emailcoass;
    @Size(max = 255)
    @Column(length = 255)
    private String nomcoass;
    @Size(max = 255)
    @Column(length = 255)
    private String statutcoass;
    @Size(max = 255)
    @Column(length = 255)
    private String telcoass;
    @OneToMany(mappedBy = "codecoass", fetch = FetchType.LAZY)
    private List<Coassurance> coassuranceList;

    public Coassureurs() {
    }

    public Coassureurs(Integer codecoass) {
        this.codecoass = codecoass;
    }

    public Integer getCodecoass() {
        return codecoass;
    }

    public void setCodecoass(Integer codecoass) {
        this.codecoass = codecoass;
    }

    public String getAdressecoass() {
        return adressecoass;
    }

    public void setAdressecoass(String adressecoass) {
        this.adressecoass = adressecoass;
    }

    public String getEmailcoass() {
        return emailcoass;
    }

    public void setEmailcoass(String emailcoass) {
        this.emailcoass = emailcoass;
    }

    public String getNomcoass() {
        return nomcoass;
    }

    public void setNomcoass(String nomcoass) {
        this.nomcoass = nomcoass;
    }

    public String getStatutcoass() {
        return statutcoass;
    }

    public void setStatutcoass(String statutcoass) {
        this.statutcoass = statutcoass;
    }

    public String getTelcoass() {
        return telcoass;
    }

    public void setTelcoass(String telcoass) {
        this.telcoass = telcoass;
    }

    @XmlTransient
    public List<Coassurance> getCoassuranceList() {
        return coassuranceList;
    }

    public void setCoassuranceList(List<Coassurance> coassuranceList) {
        this.coassuranceList = coassuranceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codecoass != null ? codecoass.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coassureurs)) {
            return false;
        }
        Coassureurs other = (Coassureurs) object;
        if ((this.codecoass == null && other.codecoass != null) || (this.codecoass != null && !this.codecoass.equals(other.codecoass))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.c2a.vie.entities.Coassureurs[ codecoass=" + codecoass + " ]";
    }
    
}
