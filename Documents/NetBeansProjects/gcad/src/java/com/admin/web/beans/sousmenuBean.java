/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.web.beans;

import com.admin.entities.MenuItem;
import com.admin.services.MenuItemServiceBeanLocal;
import com.c2a.vie.entities.Typecontrat;
import com.c2a.vie.managedbeans.deces.MessageBean;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.DualListModel;

/**
 *
 * @author desire.mensah
 */
@ManagedBean
@RequestScoped
public class sousmenuBean implements Serializable{
       @EJB
    private MenuItemServiceBeanLocal  menuItemService;
    private MenuItem formMenuItem = new MenuItem();
    private MenuItem selectMenuItem;
    private String keyWord;
    private List<MenuItem> dataListMenuItems;
    private List<MenuItem> datalistfiltre;
    private DualListModel<String> sousmenulist;
    private Boolean desactiversuppr = true;
    private int index;

    /**
     * Creates a new instance of sousmenuBean
     */
    public sousmenuBean() {
           formMenuItem = new MenuItem();
     selectMenuItem= new MenuItem();
    dataListMenuItems= new ArrayList<>();
       List<String> sousmenusource = new ArrayList<String>();
        List<String> sousmenutarget = new ArrayList<String>();
        sousmenusource.add("CRUD ASSURES");
        sousmenusource.add("CRUD SOUSCRIPTEUR");
        sousmenusource.add("CRUD GROUPE ENTREPRISE");
        sousmenusource.add("SEARCH SOUSCRIPTEUR");
        sousmenusource.add("SEARCH GROUPE ENTREPRISE");
        sousmenusource.add("ETAT SOUSCRIPTEUR/ASSURE");
        sousmenusource.add("ETAT GROUPE/ASSURE");
        sousmenusource.add("CRUD COASSUREUR");
        sousmenusource.add("CRUD REASSUREUR");
        sousmenusource.add("CRUD APPORTEUR");
        sousmenusource.add("SEARCH ASSURE/APPORTEUR");
        sousmenusource.add("SEARCH ASSURE/APPORTEUR");
        sousmenusource.add("SEARCH ASSURE/REASSURANCE");
        sousmenusource.add("SEARCH ASSURE/COASSURANCE");
        sousmenusource.add("ETAT CESSION");
        sousmenusource.add("INCORPORATION GROUPE ENTREPRISE");
        
        sousmenulist=new DualListModel<>(sousmenusource, sousmenutarget);
    }
      public void desactiver() {
        if (selectMenuItem != null) {
            selectMenuItem.setActive("inactif");
          menuItemService.modifier(selectMenuItem);
        }
        this.formMenuItem= new MenuItem();
        selectMenuItem=null;
        selectMenuItem=new MenuItem();
    }
       private void gridloadDB() {
        selectMenuItem = null;
        try {
            dataListMenuItems = menuItemService.selectionnerTout();
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage("notification", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Chargement échoué: ", e.getMessage()));
            Logger.getLogger(Typecontrat.class.getName()).log(Level.SEVERE, null, e);
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Chargement OK: ", dataListMenuItems.size() + " sous-menus dans l'application. (timestamp = " + (new SimpleDateFormat("dd/MM/yy kk:mm:ss")).format(new Date()) + ")");
        FacesContext.getCurrentInstance().addMessage("notif", msg);
    }

    /**
     * Raffraîchit la grille depuis la BD
     */
    public void refreshGrid() {
        gridloadDB();
    }
  public void enregistrer(){
        MessageBean m=new MessageBean();
        String ok=null;
        String test=null;
        int i=0;
   List<MenuItem> list=menuItemService.selectionnerTout();
        if(formMenuItem.getMenu()==null){
            m.addMessageWarn("veuillez renseigner le menu");
        }
        else{
           if(selectMenuItem != null){
               formMenuItem.setActive("actif");
            menuItemService.modifier(formMenuItem);
             formMenuItem=new  MenuItem();
        desactiversuppr=true;
        m.addMessageInfo("activé");
        }else{
                 for (MenuItem list1 : list) {
                     for(String s:sousmenulist.getTarget()){
                         if(list1.getMenuItemDesc().equals(s)){
                             i++;
                         }
                     }
                
                 }
            if(i==0){
                  for (String s: sousmenulist.getTarget()) {
            formMenuItem.setMenuItemDesc(s);
            formMenuItem.setDateCreation(new Date());
            formMenuItem.setActive("actif");
            menuItemService.ajouter(formMenuItem);
         ok="sous menus enregistrés avec succès";
        }
        if(ok!=null){
            m.addMessageInfo(ok);
        }
            }
            else{
                m.addMessageWarn("sous-menu "+test+" dejà enregistré");
            }
           
        }
        formMenuItem=new MenuItem();
        this.desactiversuppr=true; 
        }
        
    }

      public void effacer(){
        formMenuItem = new MenuItem();
        selectMenuItem= null;
        this.desactiversuppr=true;
    }
       public void rowSelected() {
        formMenuItem = selectMenuItem;
        this.index = this.dataListMenuItems.indexOf(this.selectMenuItem);
        this.desactiversuppr = false;
    }

    public MenuItemServiceBeanLocal getMenuItemService() {
        return menuItemService;
    }

    public void setMenuItemService(MenuItemServiceBeanLocal menuItemService) {
        this.menuItemService = menuItemService;
    }

    public MenuItem getFormMenuItem() {
        return formMenuItem;
    }

    public void setFormMenuItem(MenuItem formMenuItem) {
        this.formMenuItem = formMenuItem;
    }

    public MenuItem getSelectMenuItem() {
        return selectMenuItem;
    }

    public void setSelectMenuItem(MenuItem selectMenuItem) {
        this.selectMenuItem = selectMenuItem;
    }



    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public List<MenuItem> getDataListMenuItems() {
        dataListMenuItems=menuItemService.selectionnerTout();
        return dataListMenuItems;
    }

    public void setDataListMenuItems(List<MenuItem> dataListMenuItems) {
        this.dataListMenuItems = dataListMenuItems;
    }

    public List<MenuItem> getDatalistfiltre() {
        return datalistfiltre;
    }

    public void setDatalistfiltre(List<MenuItem> datalistfiltre) {
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

    public DualListModel<String> getSousmenulist() {
        return sousmenulist;
    }

    public void setSousmenulist(DualListModel<String> sousmenulist) {
        this.sousmenulist = sousmenulist;
    }
    
    
    
    
    
}
