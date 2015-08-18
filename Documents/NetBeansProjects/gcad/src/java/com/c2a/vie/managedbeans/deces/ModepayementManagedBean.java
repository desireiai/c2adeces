package com.c2a.vie.managedbeans.deces;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.c2a.vie.entities.Modepayement;
import com.c2a.vie.entities.Typecontrat;
import com.c2a.vie.service.deces.ModepayementServiceBeanLocal;
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
@ManagedBean(name = "modepayementManagedBean")
@ViewScoped
public class ModepayementManagedBean implements Serializable {

    @EJB
    private ModepayementServiceBeanLocal modepayementService;
    private Modepayement formModepayement = new Modepayement();
    private Modepayement selectedModepayement;
    private List<Modepayement> dataListModepayement;
    private Boolean desactiversuppr = true;
    private Boolean desactiverBoutonSuppr = true, desactiverCode;
    private int index;

    /**
     * Creates a new instance of ModepayementManagedBean
     */
    public ModepayementManagedBean() {
        formModepayement = new Modepayement();
        selectedModepayement = new Modepayement();
        dataListModepayement = new ArrayList<Modepayement>();
    }

    private void gridloadDB() {
        selectedModepayement = null;
        try {
            dataListModepayement = modepayementService.listmodepayementall();
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage("notification", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Chargement échoué: ", e.getMessage()));
            Logger.getLogger(Typecontrat.class.getName()).log(Level.SEVERE, null, e);
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Chargement OK: ", dataListModepayement.size() + " enregistrements chargés. (timestamp = " + (new SimpleDateFormat("dd/MM/yy kk:mm:ss")).format(new Date()) + ")");
        FacesContext.getCurrentInstance().addMessage("notif", msg);
    }

    /**
     * Raffraîchit la grille depuis la BD
     */
    public void refreshGrid() {
        gridloadDB();
    }

    public void desactiver() {
        if (selectedModepayement != null) {
            selectedModepayement.setStatutmodpaye("inactif");
            modepayementService.modifier(selectedModepayement);
        }
        this.formModepayement = new Modepayement();
    }

    public void enregistrer() {
        List<Modepayement> list = new ArrayList<>();
        int i = 0;
        MessageBean m = new MessageBean();
        list = modepayementService.listmodepayementall();
        if (formModepayement.getLibmodpayement().trim().isEmpty()) {
            m.addMessageWarn("veuillez renseigner le libellé");

        } else {
            if (selectedModepayement != null) {
                modepayementService.modifier(formModepayement);
            } else {
                i = list.stream().filter((list1) -> (list1.getLibmodpayement().equals(formModepayement.getLibmodpayement()))).map((_item) -> 1).reduce(i, Integer::sum);

                if (i == 0) {

                    formModepayement.setStatutmodpaye("actif");
                    modepayementService.ajouter(formModepayement);
                    m.addMessage("enregistré");
                } else {
                    m.addMessageWarn("mode payement deja enregistré");
                }
            }
            formModepayement = new Modepayement();
            this.desactiversuppr = true;

        }

    }

    public void effacer() {
        this.desactiversuppr=true;
        formModepayement = new Modepayement();
        selectedModepayement =new Modepayement();
        selectedModepayement=null;
    }

    public void supprimer() {
        if (selectedModepayement != null) {
            modepayementService.supprimer(selectedModepayement);
        }
    }

    public void rowSelected() {
        formModepayement = selectedModepayement;
        this.desactiverCode = true;
        this.index = this.dataListModepayement.indexOf(this.selectedModepayement);
        this.desactiversuppr = false;
    }

    public Modepayement getFormModepayement() {
        return formModepayement;
    }

    public void setFormModepayement(Modepayement formModepayement) {
        this.formModepayement = formModepayement;
    }

    public Modepayement getSelectedModepayement() {
        return selectedModepayement;
    }

    public void setSelectedModepayement(Modepayement selectedModepayement) {
        this.selectedModepayement = selectedModepayement;
    }

    public List<Modepayement> getDataListModepayement() {
        dataListModepayement = modepayementService.listmodepayementall();
        return dataListModepayement;
    }

    public void setDataListModepayement(List<Modepayement> dataListModepayement) {
        this.dataListModepayement = dataListModepayement;
    }

    public Boolean isDesactiverBoutonSuppr() {
        return desactiverBoutonSuppr;
    }

    public void setDesactiverBoutonSuppr(Boolean desactiverBoutonSuppr) {
        this.desactiverBoutonSuppr = desactiverBoutonSuppr;
    }

    public Boolean isDesactiverCode() {
        return desactiverCode;
    }

    public void setDesactiverCode(Boolean desactiverCode) {
        this.desactiverCode = desactiverCode;
    }

    public ModepayementServiceBeanLocal getModepayementService() {
        return modepayementService;
    }

    public void setModepayementService(ModepayementServiceBeanLocal modepayementService) {
        this.modepayementService = modepayementService;
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
