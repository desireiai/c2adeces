/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2a.vie.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Assures.findAll", query = "SELECT a FROM Assures a"),
    @NamedQuery(name = "Assures.findByCodassure", query = "SELECT a FROM Assures a WHERE a.codassure = :codassure"),
    @NamedQuery(name = "Assures.findByAgeassur", query = "SELECT a FROM Assures a WHERE a.ageassur = :ageassur"),
    @NamedQuery(name = "Assures.findByDatnaisassure", query = "SELECT a FROM Assures a WHERE a.datnaisassure = :datnaisassure"),
    @NamedQuery(name = "Assures.findByNomasusure", query = "SELECT a FROM Assures a WHERE a.nomasusure = :nomasusure"),
    @NamedQuery(name = "Assures.findByPrenassure", query = "SELECT a FROM Assures a WHERE a.prenassure = :prenassure"),
    @NamedQuery(name = "Assures.findByStatutassur", query = "SELECT a FROM Assures a WHERE a.statutassur = :statutassur"),
    @NamedQuery(name = "Assures.findByTelassure", query = "SELECT a FROM Assures a WHERE a.telassure = :telassure")})
public class Assures implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer codassure;
    private Integer ageassur;
    @Temporal(TemporalType.DATE)
    private Date datnaisassure;
    @Size(max = 255)
    @Column(length = 255)
    private String nomasusure;
    @Size(max = 255)
    @Column(length = 255)
    private String prenassure;
    @Size(max = 255)
    @Column(length = 255)
    private String statutassur;
     @Size(max = 255)
    @Column(length = 255)
    private String gentreprise;
    @Size(max = 255)
    @Column(length = 255)
    private String telassure;
      @Size(max = 255)
    @Column(length = 255)
    private String emailassure;
      @Size(max = 255)
    @Column(length = 255)
    private String adresseassure;
        @Size(max = 255)
    @Column(length = 255)
    private String professionassure;
     @Size(max = 255)
    @Column(length = 255)
    private String codeassure;
    @OneToMany(mappedBy = "codassure", fetch = FetchType.LAZY)
    private List<Contrat> contratList;
    @JoinColumn(name = "codsous", referencedColumnName = "codsous")
    @ManyToOne(fetch = FetchType.LAZY)
    private Souscripteur codsous;

    public Assures() {
    }

    public Assures(Integer codassure) {
        this.codassure = codassure;
    }

    public Integer getCodassure() {
        return codassure;
    }

    public void setCodassure(Integer codassure) {
        this.codassure = codassure;
    }

    public Integer getAgeassur() {
        return ageassur;
    }

    public void setAgeassur(Integer ageassur) {
        this.ageassur = ageassur;
    }

    public Date getDatnaisassure() {
        return datnaisassure;
    }

    public void setDatnaisassure(Date datnaisassure) {
        this.datnaisassure = datnaisassure;
    }

    public String getNomasusure() {
        return nomasusure;
    }

    public void setNomasusure(String nomasusure) {
        this.nomasusure = nomasusure;
    }

    public String getPrenassure() {
        return prenassure;
    }

    public void setPrenassure(String prenassure) {
        this.prenassure = prenassure;
    }

    public String getStatutassur() {
        return statutassur;
    }

    public void setStatutassur(String statutassur) {
        this.statutassur = statutassur;
    }

    public String getTelassure() {
        return telassure;
    }

    public void setTelassure(String telassure) {
        this.telassure = telassure;
    }

    @XmlTransient
    public List<Contrat> getContratList() {
        return contratList;
    }

    public void setContratList(List<Contrat> contratList) {
        this.contratList = contratList;
    }

    public Souscripteur getCodsous() {
        return codsous;
    }

    public void setCodsous(Souscripteur codsous) {
        this.codsous = codsous;
    }

    public String getGentreprise() {
        return gentreprise;
    }

    public void setGentreprise(String gentreprise) {
        this.gentreprise = gentreprise;
    }

    public String getEmailassure() {
        return emailassure;
    }

    public void setEmailassure(String emailassure) {
        this.emailassure = emailassure;
    }

    public String getAdresseassure() {
        return adresseassure;
    }

    public void setAdresseassure(String adresseassure) {
        this.adresseassure = adresseassure;
    }

    public String getProfessionassure() {
        return professionassure;
    }

    public void setProfessionassure(String professionassure) {
        this.professionassure = professionassure;
    }

    public String getCodeassure() {
        return codeassure;
    }

    public void setCodeassure(String codeassure) {
        this.codeassure = codeassure;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codassure != null ? codassure.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assures)) {
            return false;
        }
        Assures other = (Assures) object;
        if ((this.codassure == null && other.codassure != null) || (this.codassure != null && !this.codassure.equals(other.codassure))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.c2a.vie.entities.Assures[ codassure=" + codassure + " ]";
    }
    
}
