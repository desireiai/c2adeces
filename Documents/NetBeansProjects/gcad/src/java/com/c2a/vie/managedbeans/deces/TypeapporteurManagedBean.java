package com.c2a.vie.managedbeans.deces;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.c2a.vie.entities.Typeapporteur;
import com.c2a.vie.service.deces.TypeapporteurServiceBeanLocal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author K.M.A
 */
@ManagedBean(name = "typeapporteurManagedBean")
@ViewScoped
public class TypeapporteurManagedBean implements Serializable {

    @EJB
    private TypeapporteurServiceBeanLocal typeapporteurService;
    private Typeapporteur formTypeapporteur = new Typeapporteur();
    private Typeapporteur selectedTypeapporteur;
    private String selectoneradio;
    private List<Typeapporteur> dataListTypeapporteur;

    private Boolean desactiverlibelle = false;
    private Boolean desactiversuppr = true;
    private int index;

    /**
     * Creates a new instance of TypeapporteurManagedBean
     */
    public TypeapporteurManagedBean() {
        formTypeapporteur = new Typeapporteur();
        selectedTypeapporteur = new Typeapporteur();
        dataListTypeapporteur = new ArrayList<>();
    }

    private void gridloadDB() {
        selectedTypeapporteur = null;
        try {
            dataListTypeapporteur = typeapporteurService.typeapporteurall();
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage("notification", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Chargement échoué: ", e.getMessage()));
            Logger.getLogger(Typeapporteur.class.getName()).log(Level.SEVERE, null, e);
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Chargement OK: ", dataListTypeapporteur.size() + " enregistrements chargés. (timestamp = " + (new SimpleDateFormat("dd/MM/yy kk:mm:ss")).format(new Date()) + ")");
        FacesContext.getCurrentInstance().addMessage("notif", msg);
    }

    /**
     * Raffraîchit la grille depuis la BD
     */
    public void refreshGrid() {
        gridloadDB();
    }

    public void nouveau() {
        this.desactiverlibelle = false;
        this.formTypeapporteur = new Typeapporteur();
        this.desactiversuppr = true;

    }

    public void libelleradio() {
        desactiverlibelle = true;
        formTypeapporteur.setLibtypeapporteur(selectoneradio);
    }

    public void desactiver() {
        if (selectedTypeapporteur != null) {
            selectedTypeapporteur.setStatuttypeapporteur("inactif");
            typeapporteurService.modifier(selectedTypeapporteur);
        }
        this.formTypeapporteur = new Typeapporteur();
    }

    public void enregistrer() {
        List<Typeapporteur> l = new ArrayList<>();
        int i = 0;
        MessageBean m = new MessageBean();

        l = typeapporteurService.typeapporteurall();
        if (formTypeapporteur.getLibtypeapporteur().trim().isEmpty()) {
            m.addMessageWarn("veuillez renseigner le libelle");
        } else {
            if (selectedTypeapporteur != null) {
                typeapporteurService.modifier(formTypeapporteur);
            } else {
                i = l.stream().filter((list1) -> (list1.getLibtypeapporteur()).equals(formTypeapporteur.getLibtypeapporteur())).map((_item) -> 1).reduce(i, Integer::sum);

                if (i == 0) {

                    formTypeapporteur.setStatuttypeapporteur("actif");
                    typeapporteurService.ajouter(formTypeapporteur);
                    m.addMessageInfo("enregistrement effectué avec succès");
                } else {
                    m.addMessageWarn("type apporteur dejà enregsitré");

                }

            }

            formTypeapporteur = new Typeapporteur();
            this.desactiversuppr = true;
            selectedTypeapporteur=null;
        }

    }

    public void effacer() {
        this.desactiversuppr = true;
        this.desactiverlibelle = false;
        formTypeapporteur = new Typeapporteur();
        selectedTypeapporteur =new  Typeapporteur();
        selectedTypeapporteur=null;
    }

    public void supprimer() {
        if (selectedTypeapporteur != null) {
            typeapporteurService.supprimer(selectedTypeapporteur);
        }
    }

    public void rowSelected() {
        formTypeapporteur = selectedTypeapporteur;
        this.index = this.dataListTypeapporteur.indexOf(this.selectedTypeapporteur);
        this.desactiversuppr = false;
        this.desactiverlibelle = false;
    }

    public Typeapporteur getFormTypeapporteur() {
        return formTypeapporteur;
    }

    public void setFormTypeapporteur(Typeapporteur formTypeapporteur) {
        this.formTypeapporteur = formTypeapporteur;
    }

    public Typeapporteur getSelectedTypeapporteur() {
        return selectedTypeapporteur;
    }

    public void setSelectedTypeapporteur(Typeapporteur selectedTypeapporteur) {
        this.selectedTypeapporteur = selectedTypeapporteur;
    }

    public List<Typeapporteur> getDataListTypeapporteur() {
        dataListTypeapporteur = typeapporteurService.typeapporteurall();
        return dataListTypeapporteur;
    }

    public void setDataListTypeapporteur(List<Typeapporteur> dataListTypeapporteur) {
        this.dataListTypeapporteur = dataListTypeapporteur;
    }

    public TypeapporteurServiceBeanLocal getTypeapporteurService() {
        return typeapporteurService;
    }

    public void setTypeapporteurService(TypeapporteurServiceBeanLocal typeapporteurService) {
        this.typeapporteurService = typeapporteurService;
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
