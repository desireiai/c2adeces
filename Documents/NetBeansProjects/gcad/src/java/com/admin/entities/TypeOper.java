/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.entities;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author firok
 */
@Entity
@Table(name = "TYPE_OPER")
public class TypeOper extends BaseAdminEntity{
   
    @Id
    @Basic(optional = false)
    @Column(name = "TYPE_OPER_ID")
    private String typeOperId;
    
    @Column(name = "TYPE_OPER_DESC")
    private String typeOperDesc;
    
    @OneToMany(fetch= FetchType.LAZY, mappedBy = "typeOper")
    private List<SysLog> sysLogs=new LinkedList<SysLog>();

    public TypeOper() {
    }

    public TypeOper(String typeOperId) {
        this.typeOperId = typeOperId;
    }

    public String getTypeOperId() {
        return typeOperId;
    }

    public void setTypeOperId(String typeOperId) {
        this.typeOperId = typeOperId;
    }

    public String getTypeOperDesc() {
        return typeOperDesc;
    }

    public void setTypeOperDesc(String typeOperDesc) {
        this.typeOperDesc = typeOperDesc;
    }

    public List<SysLog> getSysLogs() {
        return sysLogs;
    }

    public void setSysLogs(List<SysLog> sysLogs) {
        this.sysLogs = sysLogs;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeOperId != null ? typeOperId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeOper)) {
            return false;
        }
        TypeOper other = (TypeOper) object;
        if ((this.typeOperId == null && other.typeOperId != null) || (this.typeOperId != null && !this.typeOperId.equals(other.typeOperId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TypeOper{" + "typeOperId=" + typeOperId + ", typeOperDesc=" + typeOperDesc + ", sysLogs=" + sysLogs + '}';
    }

   
    
}
