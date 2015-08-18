/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.entities;

import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author firok
 */
@Entity
@Table(name = "SOUS_MENU")
public class MenuItem extends BaseAdminEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MENU_ITEM_ID")
    private Integer menuItemId;
    
    @Column(name = "MENU_ITEM_DESC")
    private String menuItemDesc;
    
    @Column(name = "ICON_CLS")
    private String iconCls;
    
    @Column(name = "DATE_CREATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    
    @Column(name = "ACTIVE")
    private String active;
    
    @Column(name = "FILTER_FIELD")
    private String filterField;
    
    @Column(name = "FILTER_VALUE")
    private String filterValue;
    
    @Column(name = "NUM_ORDRE")
    private Integer numOrdre;
    
    @OneToMany(fetch= FetchType.LAZY, mappedBy = "menuItem")
    private List<ProfilMenuItem> profilMenuItems=new LinkedList<ProfilMenuItem>();
    
    @JoinColumn(name = "MENU_ID", referencedColumnName = "MENU_ID")
    @ManyToOne(optional=false)
    private Menu menu;

    public MenuItem() {
    }

    public MenuItem(Integer menuItemId) {
        this.menuItemId = menuItemId;
    }

    public Integer getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(Integer menuItemId) {
        this.menuItemId = menuItemId;
    }

    public String getMenuItemDesc() {
        return menuItemDesc;
    }

    public void setMenuItemDesc(String menuItemDesc) {
        this.menuItemDesc = menuItemDesc;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getFilterField() {
        return filterField;
    }

    public void setFilterField(String filterField) {
        this.filterField = filterField;
    }

    public String getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }

    public Integer getNumOrdre() {
        return numOrdre;
    }

    public void setNumOrdre(Integer numOrdre) {
        this.numOrdre = numOrdre;
    }

    public List<ProfilMenuItem> getProfilMenuItems() {
        return profilMenuItems;
    }

    public void setProfilMenuItems(List<ProfilMenuItem> profilMenuItems) {
        this.profilMenuItems = profilMenuItems;
    }



    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuItemId != null ? menuItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuItem)) {
            return false;
        }
        MenuItem other = (MenuItem) object;
        if ((this.menuItemId == null && other.menuItemId != null) || (this.menuItemId != null && !this.menuItemId.equals(other.menuItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MenuItem{" + "menuItemDesc=" + menuItemDesc + '}';
    }

    
}
