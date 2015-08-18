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
    @NamedQuery(name = "Souscripteur.findAll", query = "SELECT s FROM Souscripteur s"),
    @NamedQuery(name = "Souscripteur.findByCodsous", query = "SELECT s FROM Souscripteur s WHERE s.codsous = :codsous"),
    @NamedQuery(name = "Souscripteur.findByAdrsous", query = "SELECT s FROM Souscripteur s WHERE s.adrsous = :adrsous"),
    @NamedQuery(name = "Souscripteur.findByNomsous", query = "SELECT s FROM Souscripteur s WHERE s.nomsous = :nomsous"),
    @NamedQuery(name = "Souscripteur.findByPrensous", query = "SELECT s FROM Souscripteur s WHERE s.prensous = :prensous"),
    @NamedQuery(name = "Souscripteur.findByStatutsous", query = "SELECT s FROM Souscripteur s WHERE s.statutsous = :statutsous")})
public class Souscripteur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer codsous;
    @Size(max = 255)
    @Column(length = 255)
    private String adrsous;
    @Size(max = 255)
    @Column(length = 255)
    private String nomsous;
    @Size(max = 255)
    @Column(length = 255)
    private String prensous;
      @Size(max = 255)
    @Column(length = 255)
    private String telsous;
     @Size(max = 255)
    @Column(length = 255)
    private String emailsous;
        @Size(max = 255)
    @Column(length = 255)
    private String professionsous;
    @Size(max = 255)
    @Column(length = 255)
    private String statutsous;
    @OneToMany(mappedBy = "codsous", fetch = FetchType.LAZY)
    private List<Assures> assuresList;

    public Souscripteur() {
    }

    public Souscripteur(Integer codsous) {
        this.codsous = codsous;
    }

    public Integer getCodsous() {
        return codsous;
    }

    public void setCodsous(Integer codsous) {
        this.codsous = codsous;
    }

    public String getAdrsous() {
        return adrsous;
    }

    public void setAdrsous(String adrsous) {
        this.adrsous = adrsous;
    }

    public String getNomsous() {
        return nomsous;
    }

    public String getEmailsous() {
        return emailsous;
    }

    public void setEmailsous(String emailsous) {
        this.emailsous = emailsous;
    }
    
    
    public void setNomsous(String nomsous) {
        this.nomsous = nomsous;
    }

    public String getPrensous() {
        return prensous;
    }

    public void setPrensous(String prensous) {
        this.prensous = prensous;
    }

    public String getStatutsous() {
        return statutsous;
    }

    public void setStatutsous(String statutsous) {
        this.statutsous = statutsous;
    }

    public String getTelsous() {
        return telsous;
    }

    public void setTelsous(String telsous) {
        this.telsous = telsous;
    }

    public String getProfessionsous() {
        return professionsous;
    }

    public void setProfessionsous(String professionsous) {
        this.professionsous = professionsous;
    }
    
    

    @XmlTransient
    public List<Assures> getAssuresList() {
        return assuresList;
    }

    public void setAssuresList(List<Assures> assuresList) {
        this.assuresList = assuresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codsous != null ? codsous.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Souscripteur)) {
            return false;
        }
        Souscripteur other = (Souscripteur) object;
        if ((this.codsous == null && other.codsous != null) || (this.codsous != null && !this.codsous.equals(other.codsous))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.c2a.vie.entities.Souscripteur[ codsous=" + codsous + " ]";
    }
    
}
