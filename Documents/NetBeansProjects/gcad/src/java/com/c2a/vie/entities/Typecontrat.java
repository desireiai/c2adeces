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
    @NamedQuery(name = "Typecontrat.findAll", query = "SELECT t FROM Typecontrat t"),
    @NamedQuery(name = "Typecontrat.findByIdtypecontrat", query = "SELECT t FROM Typecontrat t WHERE t.idtypecontrat = :idtypecontrat"),
    @NamedQuery(name = "Typecontrat.findByAccessoires", query = "SELECT t FROM Typecontrat t WHERE t.accessoires = :accessoires"),
    @NamedQuery(name = "Typecontrat.findByLibtypecontrat", query = "SELECT t FROM Typecontrat t WHERE t.libtypecontrat = :libtypecontrat"),
    @NamedQuery(name = "Typecontrat.findByStatuttypecontrat", query = "SELECT t FROM Typecontrat t WHERE t.statuttypecontrat = :statuttypecontrat")})
public class Typecontrat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer idtypecontrat;
    private Double accessoires;
    private Float taxe;
    @Size(max = 255)
    @Column(length = 255)
    private String libtypecontrat;
    @Size(max = 255)
    @Column(length = 255)
    private String statuttypecontrat;
    @OneToMany(mappedBy = "idtypecontrat", fetch = FetchType.LAZY)
    private List<Contrat> contratList;

    public Typecontrat() {
    }

    public Typecontrat(Integer idtypecontrat) {
        this.idtypecontrat = idtypecontrat;
    }

    public Integer getIdtypecontrat() {
        return idtypecontrat;
    }

    public void setIdtypecontrat(Integer idtypecontrat) {
        this.idtypecontrat = idtypecontrat;
    }

    public Double getAccessoires() {
        return accessoires;
    }

    public void setAccessoires(Double accessoires) {
        this.accessoires = accessoires;
    }



    public String getLibtypecontrat() {
        return libtypecontrat;
    }

    public void setLibtypecontrat(String libtypecontrat) {
        this.libtypecontrat = libtypecontrat;
    }

    public String getStatuttypecontrat() {
        return statuttypecontrat;
    }

    public void setStatuttypecontrat(String statuttypecontrat) {
        this.statuttypecontrat = statuttypecontrat;
    }

    public Float getTaxe() {
        return taxe;
    }

    public void setTaxe(Float taxe) {
        this.taxe = taxe;
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
        hash += (idtypecontrat != null ? idtypecontrat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typecontrat)) {
            return false;
        }
        Typecontrat other = (Typecontrat) object;
        if ((this.idtypecontrat == null && other.idtypecontrat != null) || (this.idtypecontrat != null && !this.idtypecontrat.equals(other.idtypecontrat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.c2a.vie.entities.Typecontrat[ idtypecontrat=" + idtypecontrat + " ]";
    }
    
}
