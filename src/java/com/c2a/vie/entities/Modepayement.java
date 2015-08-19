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
    @NamedQuery(name = "Modepayement.findAll", query = "SELECT m FROM Modepayement m"),
    @NamedQuery(name = "Modepayement.findByIdmodeayement", query = "SELECT m FROM Modepayement m WHERE m.idmodeayement = :idmodeayement"),
    @NamedQuery(name = "Modepayement.findByLibmodpayement", query = "SELECT m FROM Modepayement m WHERE m.libmodpayement = :libmodpayement"),
    @NamedQuery(name = "Modepayement.findByStatutmodpaye", query = "SELECT m FROM Modepayement m WHERE m.statutmodpaye = :statutmodpaye")})
public class Modepayement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer idmodeayement;
    @Size(max = 255)
    @Column(length = 255)
    private String libmodpayement;
    @Size(max = 255)
    @Column(length = 255)
    private String statutmodpaye;
    @OneToMany(mappedBy = "idmodeayement", fetch = FetchType.LAZY)
    private List<Contrat> contratList;

    public Modepayement() {
    }

    public Modepayement(Integer idmodeayement) {
        this.idmodeayement = idmodeayement;
    }

    public Integer getIdmodeayement() {
        return idmodeayement;
    }

    public void setIdmodeayement(Integer idmodeayement) {
        this.idmodeayement = idmodeayement;
    }

    public String getLibmodpayement() {
        return libmodpayement;
    }

    public void setLibmodpayement(String libmodpayement) {
        this.libmodpayement = libmodpayement;
    }

    public String getStatutmodpaye() {
        return statutmodpaye;
    }

    public void setStatutmodpaye(String statutmodpaye) {
        this.statutmodpaye = statutmodpaye;
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
        hash += (idmodeayement != null ? idmodeayement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modepayement)) {
            return false;
        }
        Modepayement other = (Modepayement) object;
        if ((this.idmodeayement == null && other.idmodeayement != null) || (this.idmodeayement != null && !this.idmodeayement.equals(other.idmodeayement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.c2a.vie.entities.Modepayement[ idmodeayement=" + idmodeayement + " ]";
    }
    
}
