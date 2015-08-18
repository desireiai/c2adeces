/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c2a.vie.entities;

import com.admin.entities.Profil;
import com.admin.entities.SysLog;
import java.io.Serializable;
import java.util.LinkedList;
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
    @NamedQuery(name = "Producteur.findAll", query = "SELECT p FROM Producteur p"),
    @NamedQuery(name = "Producteur.findByIdproducteur", query = "SELECT p FROM Producteur p WHERE p.idproducteur = :idproducteur"),
    @NamedQuery(name = "Producteur.findByAdrproducteur", query = "SELECT p FROM Producteur p WHERE p.adrproducteur = :adrproducteur"),
    @NamedQuery(name = "Producteur.findByNomproducteur", query = "SELECT p FROM Producteur p WHERE p.nomproducteur = :nomproducteur"),
    @NamedQuery(name = "Producteur.findByPrenproducteur", query = "SELECT p FROM Producteur p WHERE p.prenproducteur = :prenproducteur"),
    @NamedQuery(name = "Producteur.findByStatutproducteur", query = "SELECT p FROM Producteur p WHERE p.statutproducteur = :statutproducteur"),
    @NamedQuery(name = "Producteur.findByTelproducteur", query = "SELECT p FROM Producteur p WHERE p.telproducteur = :telproducteur")})
public class Producteur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer idproducteur;
    @Size(max = 255)
    @Column(length = 255)
    private String adrproducteur;
    @Size(max = 255)
    @Column(length = 255)
    private String nomproducteur;
    @Size(max = 255)
    @Column(length = 255)
    private String prenproducteur;
    @Size(max = 255)
    @Column(length = 255)
    private String statutproducteur;
    @Size(max = 255)
    @Column(length = 255)
    private String telproducteur;
     @Size(max = 255)
    @Column(length = 255)
    private String posteproducteur;
     @Basic(optional = false)
    @Column(name = "USER_LOGIN")
    private String userLogin;
    
    @Column(name = "USER_PASSWORD")
    private String userPassword;
    
    @Column(name = "USER_PSEUDO")
    private String userPseudo;
    
     @OneToMany(fetch= FetchType.LAZY, mappedBy = "idproducteur")
    private List<SysLog> sysLogs=new LinkedList<SysLog>();
    
    @JoinColumn(name = "PROFIL_ID", referencedColumnName = "PROFIL_ID")
    @ManyToOne(optional = false)
    private Profil profil;
    @OneToMany(mappedBy = "idproducteur", fetch = FetchType.LAZY)
    private List<Contrat> contratList;

    public Producteur() {
    }

    public Producteur(Integer idproducteur) {
        this.idproducteur = idproducteur;
    }

    public Integer getIdproducteur() {
        return idproducteur;
    }

    public void setIdproducteur(Integer idproducteur) {
        this.idproducteur = idproducteur;
    }

    public String getAdrproducteur() {
        return adrproducteur;
    }

    public void setAdrproducteur(String adrproducteur) {
        this.adrproducteur = adrproducteur;
    }

    public String getNomproducteur() {
        return nomproducteur;
    }

    public void setNomproducteur(String nomproducteur) {
        this.nomproducteur = nomproducteur;
    }

    public String getPrenproducteur() {
        return prenproducteur;
    }

    public void setPrenproducteur(String prenproducteur) {
        this.prenproducteur = prenproducteur;
    }

    public String getStatutproducteur() {
        return statutproducteur;
    }

    public void setStatutproducteur(String statutproducteur) {
        this.statutproducteur = statutproducteur;
    }

    public String getTelproducteur() {
        return telproducteur;
    }

    public String getPosteproducteur() {
        return posteproducteur;
    }

    public void setPosteproducteur(String posteproducteur) {
        this.posteproducteur = posteproducteur;
    }
    

    public void setTelproducteur(String telproducteur) {
        this.telproducteur = telproducteur;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPseudo() {
        return userPseudo;
    }

    public void setUserPseudo(String userPseudo) {
        this.userPseudo = userPseudo;
    }

    public List<SysLog> getSysLogs() {
        return sysLogs;
    }

    public void setSysLogs(List<SysLog> sysLogs) {
        this.sysLogs = sysLogs;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
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
        hash += (idproducteur != null ? idproducteur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producteur)) {
            return false;
        }
        Producteur other = (Producteur) object;
        if ((this.idproducteur == null && other.idproducteur != null) || (this.idproducteur != null && !this.idproducteur.equals(other.idproducteur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.c2a.vie.entities.Producteur[ idproducteur=" + idproducteur + " ]";
    }
    
}
