/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.entities;

import com.c2a.vie.entities.Producteur;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import com.admin.entities.TypeOper;

/**
 *
 * @author firok
 */
@Entity
@Table(name = "SYS_LOG")
public class SysLog extends BaseAdminEntity{
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LOG_ID")
    private Integer logId;
    
    @Basic(optional = false)
    @Column(name = "LOG_DESC")
    private String logDesc;
    
    @Basic(optional = false)
    @Column(name = "LOG_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logDate;
    
    @JoinColumn(name = "TYPE_OPER_ID", referencedColumnName = "TYPE_OPER_ID")
    @ManyToOne(optional = false)
    private TypeOper typeOper;
    
    @JoinColumn(name = "idproducteur", referencedColumnName = "idproducteur")
    @ManyToOne(optional = false)
    private Producteur idproducteur;

    public SysLog() {
    }

    public SysLog(Integer logId) {
        this.logId = logId;
    }

    public SysLog(Integer logId, String logDesc, Date logDate) {
        this.logId = logId;
        this.logDesc = logDesc;
        this.logDate = logDate;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getLogDesc() {
        return logDesc;
    }

    public void setLogDesc(String logDesc) {
        this.logDesc = logDesc;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public Producteur getIdproducteur() {
        return idproducteur;
    }

    public void setIdproducteur(Producteur idproducteur) {
        this.idproducteur = idproducteur;
    }

    public TypeOper getTypeOper() {
        return typeOper;
    }

    public void setTypeOper(TypeOper typeOper) {
        this.typeOper = typeOper;
    }


 @Override
    public int hashCode() {
        int hash = 0;
        hash += (logId != null ? logId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysLog)) {
            return false;
        }
        SysLog other = (SysLog) object;
        if ((this.logId == null && other.logId != null) || (this.logId != null && !this.logId.equals(other.logId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return logDesc;
    }

   

    
    
}
