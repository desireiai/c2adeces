/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.web.beans;

import com.admin.entities.Profil;
import com.admin.services.ProfilServiceBeanLocal;
import com.c2a.vie.entities.Typeapporteur;
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
import javax.faces.event.ActionEvent;

import org.primefaces.event.RowEditEvent;

/**
 *
 * @author firok
 */
@ManagedBean
@ViewScoped
public class ProfilBean implements Serializable{
    
    @EJB
    private ProfilServiceBeanLocal profilService;
    private List<Profil> profils;
    private Profil profil;
    private Profil selProfil;
    private String selectoneradio;
    private Boolean desactiverlibelle = false;
    private Boolean desactiversuppr = true;
    private int index;
            
    public ProfilBean() {
        this.profil=new Profil();
        this.selProfil=new Profil();
    }
    
    @PostConstruct
    public void init(){
        this.profils=profilService.selectionnerTout();
    }
 private void gridloadDB() {
        selProfil = null;
        try {
            profils= profilService.selectionnerTout();
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage("notification", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Chargement échoué: ", e.getMessage()));
            Logger.getLogger(Typeapporteur.class.getName()).log(Level.SEVERE, null, e);
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Chargement OK: ",profils.size() + " enregistrements chargés. (timestamp = " + (new SimpleDateFormat("dd/MM/yy kk:mm:ss")).format(new Date()) + ")");
        FacesContext.getCurrentInstance().addMessage("notif", msg);
    }

    /**
     * Raffraîchit la grille depuis la BD
     */
    public void refreshGrid() {
        gridloadDB();
    }
    
    
    public void libelleradio() {
        desactiverlibelle = true;
        profil.setProfilDesc(selectoneradio);
    }

    public void desactiver() {
        if (selProfil != null) {
            selProfil.setActive("inactif");
            profilService.modifier(selProfil);
        }
        this.profil = new Profil();
    }

    public void enregistrer() {
        List<Profil> l = new ArrayList<>();
        int i = 0;
        MessageBean m = new MessageBean();

        l = profilService.selectionnerTout();
        if (profil.getProfilDesc().trim().isEmpty()) {
            m.addMessageWarn("veuillez renseigner le libelle");
        } else {
            if (selProfil != null) {
               profilService.modifier(profil);
            } else {
                i = l.stream().filter((list1) -> (list1.getProfilDesc()).equals(profil.getProfilDesc())).map((_item) -> 1).reduce(i, Integer::sum);

                if (i == 0) {

                    profil.setActive("actif");
                   profilService.ajouter(profil);
                    m.addMessageInfo("enregistrement effectué avec succès");
                } else {
                    m.addMessageWarn("type apporteur dejà enregsitré");

                }

            }

            profil = new Profil();
            this.desactiversuppr = true;
            selProfil=null;
        }

    }
    
       public void effacer() {
        this.desactiversuppr = true;
        this.desactiverlibelle = false;
       profil = new Profil();
        selProfil =new  Profil();
        selProfil=null;
    }
       
       
    public void rowSelected() {
        profil = selProfil;
        this.index = this.profils.indexOf(this.selProfil);
        this.desactiversuppr = false;
        this.desactiverlibelle = false;
    }
    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public List<Profil> getProfils() {
        profils=profilService.selectionnerTout();
        return profils;
    }

    public void setProfils(List<Profil> profils) {
        this.profils = profils;
    }

    public Profil getSelProfil() {
        return selProfil;
    }

    public void setSelProfil(Profil selProfil) {
        this.selProfil = selProfil;
    }
    
    
   
   

    public ProfilServiceBeanLocal getProfilService() {
        return profilService;
    }

    public void setProfilService(ProfilServiceBeanLocal profilService) {
        this.profilService = profilService;
    }

    public String getSelectoneradio() {
        return selectoneradio;
    }

    public void setSelectoneradio(String selectoneradio) {
        this.selectoneradio = selectoneradio;
    }

    public Boolean getDesactiverlibelle() {
        return desactiverlibelle;
    }

    public void setDesactiverlibelle(Boolean desactiverlibelle) {
        this.desactiverlibelle = desactiverlibelle;
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
