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
    @NamedQuery(name = "Garantie.findAll", query = "SELECT g FROM Garantie g"),
    @NamedQuery(name = "Garantie.findByIdgarantie", query = "SELECT g FROM Garantie g WHERE g.idgarantie = :idgarantie"),
    @NamedQuery(name = "Garantie.findByLibgarantie", query = "SELECT g FROM Garantie g WHERE g.libgarantie = :libgarantie"),
    @NamedQuery(name = "Garantie.findByStatutgarantie", query = "SELECT g FROM Garantie g WHERE g.statutgarantie = :statutgarantie")})
public class Garantie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer idgarantie;
    @Size(max = 255)
    @Column(length = 255)
    private String libgarantie;
    @Size(max = 255)
    @Column(length = 255)
    private String statutgarantie;
    @OneToMany(mappedBy = "idgarantie", fetch = FetchType.LAZY)
    private List<Contrat> contratList;

    public Garantie() {
    }

    public Garantie(Integer idgarantie) {
        this.idgarantie = idgarantie;
    }

    public Integer getIdgarantie() {
        return idgarantie;
    }

    public void setIdgarantie(Integer idgarantie) {
        this.idgarantie = idgarantie;
    }

    public String getLibgarantie() {
        return libgarantie;
    }

    public void setLibgarantie(String libgarantie) {
        this.libgarantie = libgarantie;
    }

    public String getStatutgarantie() {
        return statutgarantie;
    }

    public void setStatutgarantie(String statutgarantie) {
        this.statutgarantie = statutgarantie;
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
        hash += (idgarantie != null ? idgarantie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Garantie)) {
            return false;
        }
        Garantie other = (Garantie) object;
        if ((this.idgarantie == null && other.idgarantie != null) || (this.idgarantie != null && !this.idgarantie.equals(other.idgarantie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.c2a.vie.entities.Garantie[ idgarantie=" + idgarantie + " ]";
    }
    
}
