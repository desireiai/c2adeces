/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.web.beans;

import com.admin.entities.MenuItem;
import com.admin.entities.ProfilMenuItem;
import com.admin.services.MenuItemServiceBeanLocal;
import com.admin.services.ProfilMenuItemServiceBeanLocal;
import com.c2a.vie.entities.Typecontrat;
import com.c2a.vie.managedbeans.deces.MessageBean;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.DualListModel;

/**
 *
 * @author desire.mensah
 */
@ManagedBean
@ViewScoped
public class DroitBean implements Serializable{
    @EJB
    private ProfilMenuItemServiceBeanLocal droitService;
    
    private ProfilMenuItem formdroit = new ProfilMenuItem();
    private ProfilMenuItem selectdroit;
    private String keyWord;
    private List<ProfilMenuItem> dataListdroit;
    private List<ProfilMenuItem> datalistfiltre;
   
    private Boolean desactiversuppr = true;
    private int index;
    @EJB
    private MenuItemServiceBeanLocal sousmenuItemService;
     private DualListModel<MenuItem> sousmenulist;
    /**
     * Creates a new instance of DroitBean
     */
     
    public DroitBean() {
        formdroit=new ProfilMenuItem();
        selectdroit=new ProfilMenuItem();
        dataListdroit=new ArrayList<>();
   }
    @PostConstruct
    public void init(){
        List<MenuItem> droitSource =sousmenuItemService.sousmenusdroit();
        List<MenuItem> droitTarget = new ArrayList<MenuItem>();
        sousmenulist=new DualListModel<>(droitSource, droitTarget);
    }
    
     public void desactiver() {
        if (selectdroit != null) {
            selectdroit.setActive("inactif");
            selectdroit.setDroit("pas d'accès");
          droitService.modifier(selectdroit);
        }
        this.formdroit= new ProfilMenuItem();
        selectdroit=null;
        selectdroit=new ProfilMenuItem();
    }
     private void gridloadDB() {
        selectdroit = null;
        try {
            dataListdroit = droitService.selectionnerTout();
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage("notification", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Chargement échoué: ", e.getMessage()));
            Logger.getLogger(Typecontrat.class.getName()).log(Level.SEVERE, null, e);
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Chargement OK: ", dataListdroit.size() + " sous-menus dans l'application. (timestamp = " + (new SimpleDateFormat("dd/MM/yy kk:mm:ss")).format(new Date()) + ")");
        FacesContext.getCurrentInstance().addMessage("notif", msg);
    }

    /**
     * Raffraîchit la grille depuis la BD
     */
    public void refreshGrid() {
        gridloadDB();
    }
   public void effacer(){
        formdroit = new ProfilMenuItem();
        selectdroit= null;
        this.desactiversuppr=true;
    }
       public void rowSelected() {
        formdroit = selectdroit;
        this.index = this.dataListdroit.indexOf(this.selectdroit);
        this.desactiversuppr = false;
    }
       
       public void enregistrer(){
           MessageBean m=new MessageBean();
           String ok=null;
           for (MenuItem smenu : sousmenulist.getTarget()) {
               formdroit.setActive("actif");
               formdroit.setMenuItem(sousmenuItemService.selectionner(smenu.getMenuItemId()));
               formdroit.setDroit("lecture & ecriture");
              droitService.ajouter(formdroit);
              ok="les droits sont bien affectés au profil "+formdroit.getProfil().getProfilDesc();
              formdroit=new ProfilMenuItem();
           }
           if(ok!=null){
           m.addMessageInfo(ok);
       }
       }
    public ProfilMenuItemServiceBeanLocal getDroitService() {
        return droitService;
    }

    public void setDroitService(ProfilMenuItemServiceBeanLocal droitService) {
        this.droitService = droitService;
    }

    public ProfilMenuItem getFormdroit() {
        return formdroit;
    }

    public void setFormdroit(ProfilMenuItem formdroit) {
        this.formdroit = formdroit;
    }

    public ProfilMenuItem getSelectdroit() {
        return selectdroit;
    }

    public void setSelectdroit(ProfilMenuItem selectdroit) {
        this.selectdroit = selectdroit;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public List<ProfilMenuItem> getDataListdroit() {
        return dataListdroit;
    }

    public void setDataListdroit(List<ProfilMenuItem> dataListdroit) {
        this.dataListdroit = dataListdroit;
    }

    public List<ProfilMenuItem> getDatalistfiltre() {
        return datalistfiltre;
    }

    public void setDatalistfiltre(List<ProfilMenuItem> datalistfiltre) {
        this.datalistfiltre = datalistfiltre;
    }

   

    public Boolean getDesactiversuppr() {
        return desactiversuppr;
    }

    public void setDesactiversuppr(Boolean desactiversuppr) {
        this.desactiversuppr = desactiversuppr;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public MenuItemServiceBeanLocal getSousmenuItemService() {
        return sousmenuItemService;
    }

    public void setSousmenuItemService(MenuItemServiceBeanLocal sousmenuItemService) {
        this.sousmenuItemService = sousmenuItemService;
    }

    public DualListModel<MenuItem> getSousmenulist() {
        return sousmenulist;
    }

    public void setSousmenulist(DualListModel<MenuItem> sousmenulist) {
        this.sousmenulist = sousmenulist;
    }
    
    
}
