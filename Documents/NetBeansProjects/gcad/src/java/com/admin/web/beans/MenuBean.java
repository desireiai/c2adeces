/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.web.beans;

import com.admin.entities.Menu;
import com.admin.services.MenuServiceBeanLocal;
import com.c2a.vie.entities.Typeapporteur;
import com.c2a.vie.managedbeans.deces.MessageBean;
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

/**
 *
 * @author desire.mensah
 */
@ManagedBean
@RequestScoped
public class MenuBean {
    @EJB
    private MenuServiceBeanLocal menuService;
    private Menu formMenu;
    private Menu selectMenu;
    private List<Menu> dataListMenu;
   private Boolean desactiversuppr = true;
    private int index;

    /**
     * Creates a new instance of MenuBean
     */
    public MenuBean() {
        formMenu=new Menu();
        selectMenu=new Menu();
        dataListMenu=new ArrayList<>();
    }
    
      private void gridloadDB() {
        
        try {
            dataListMenu =menuService.selectionnerTout();
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage("notification", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Chargement échoué: ", e.getMessage()));
            Logger.getLogger(Typeapporteur.class.getName()).log(Level.SEVERE, null, e);
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Chargement OK: ", dataListMenu.size() + " menus dans l'application. (timestamp = " + (new SimpleDateFormat("dd/MM/yy kk:mm:ss")).format(new Date()) + ")");
        FacesContext.getCurrentInstance().addMessage("notif", msg);
    }

    /**
     * Raffraîchit la grille depuis la BD
     */
    public void refreshGrid() {
        gridloadDB();
    }
    
      public void desactiver() {
        if (selectMenu != null) {
            selectMenu.setActive("inactif");
            menuService.modifier(selectMenu);
        }
        this.formMenu = new Menu();
    }
      
       public void enregistrer() {
        List<Menu> l = menuService.selectionnerTout();
        int i = 0;
        MessageBean m = new MessageBean();

        l = menuService.selectionnerTout();
        if (formMenu.getMenuDesc().trim().isEmpty()) {
            m.addMessageWarn("veuillez renseigner le libelle");
        } else {
            if (selectMenu!= null) {
                         menuService.modifier(formMenu);
            } else {
                          i = l.stream().filter((list1) -> (list1.getMenuDesc()).equals(formMenu.getMenuDesc())).map((_item) -> 1).reduce(i, Integer::sum);

                             
                if (i == 0) {

                    formMenu.setActive("actif");
                    menuService.ajouter(formMenu);
                    m.addMessageInfo("enregistrement effectué avec succès");
                } else {
                    m.addMessageWarn("Menu deja enregistré dejà enregsitré");

                }

            }

            formMenu = new Menu();
            this.desactiversuppr = true;
            selectMenu=null;
                
                
                 

           }
        
        
        
       }
       
       
       
       
       
         public void effacer() {
        this.desactiversuppr = true;
        formMenu= new Menu();
        selectMenu =new  Menu();
        selectMenu=null;
    }
         
            public void rowSelected() {
        formMenu = selectMenu;
        this.index = this.dataListMenu.indexOf(this.selectMenu);
        this.desactiversuppr = false;
    }


    public MenuServiceBeanLocal getMenuService() {
        return menuService;
    }

    public void setMenuService(MenuServiceBeanLocal menuService) {
        this.menuService = menuService;
    }

    public Menu getFormMenu() {
        return formMenu;
    }

    public void setFormMenu(Menu formMenu) {
        this.formMenu = formMenu;
    }

    public Menu getSelectMenu() {
        return selectMenu;
    }

    public void setSelectMenu(Menu selectMenu) {
        this.selectMenu = selectMenu;
    }

    public List<Menu> getDataListMenu() {
        dataListMenu=menuService.selectionnerTout();
        return dataListMenu;
    }

    public void setDataListMenu(List<Menu> dataListMenu) {
        this.dataListMenu = dataListMenu;
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
    
}
