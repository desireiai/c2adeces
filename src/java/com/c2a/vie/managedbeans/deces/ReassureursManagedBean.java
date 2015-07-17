package com.c2a.vie.managedbeans.deces;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.c2a.vie.entities.Reassureurs;
import com.c2a.vie.entities.Typecontrat;
import com.c2a.vie.service.deces.ReassureursServiceBeanLocal;
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
@ManagedBean(name = "reassureursManagedBean")
@ViewScoped
public class ReassureursManagedBean implements Serializable {

    @EJB
    private ReassureursServiceBeanLocal reassureursService;
    private Reassureurs formReassureurs = new Reassureurs();
    private Reassureurs selectedReassureurs;
    private String keyWord;
    private List<Reassureurs> dataListReassureurs;
    private List<Reassureurs> datalistfiltre;
    private Boolean desactiversuppr = true;
    private int index;

    /**
     * Creates a new instance of ReassureursManagedBean
     */
    public ReassureursManagedBean() {
        formReassureurs = new Reassureurs();
        selectedReassureurs = new Reassureurs();
        dataListReassureurs = new ArrayList<>();
    }

    public void search() {
        if (keyWord == null || keyWord.length() == 0) {
            FacesContext.getCurrentInstance().addMessage("notif", new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention: ", "Veuillez saisir un mot-clé à rechercher!"));
        } else {
            try {
                dataListReassureurs = reassureursService.recherchereassureurnom(keyWord);
                FacesContext.getCurrentInstance().addMessage("notif", new FacesMessage(FacesMessage.SEVERITY_INFO, "Recherche Terminée: ", dataListReassureurs.size() + " ligne(s) trouvée(s)."));
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage("notif", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Recherche Echouée: ", e.getMessage()));
            }
        }
    }

    private void gridloadDB() {
        selectedReassureurs = null;
        try {
            dataListReassureurs = reassureursService.reassureurall();
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage("notification", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Chargement échoué: ", e.getMessage()));
            Logger.getLogger(Typecontrat.class.getName()).log(Level.SEVERE, null, e);
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Chargement OK: ", dataListReassureurs.size() + " enregistrements chargés. (timestamp = " + (new SimpleDateFormat("dd/MM/yy kk:mm:ss")).format(new Date()) + ")");
        FacesContext.getCurrentInstance().addMessage("notif", msg);
    }

    /**
     * Raffraîchit la grille depuis la BD
     */
    public void refreshGrid() {
        gridloadDB();
    }

    public void enregistrer() {
        MessageBean m = new MessageBean();
        if (selectedReassureurs != null) {
            reassureursService.modifier(formReassureurs);
             formReassureurs=new  Reassureurs();
        desactiversuppr=true;
        } else {
            formReassureurs.setStatutreass("actif");
            reassureursService.ajouter(formReassureurs);
            m.addMessageInfo("enregistré");
        }
        formReassureurs=new  Reassureurs();
        desactiversuppr=true;
    }

    public void effacer() {
        formReassureurs = new Reassureurs();
        selectedReassureurs = null;
        this.desactiversuppr = true;
    }

    public void supprimer() {
        if (selectedReassureurs != null) {
            reassureursService.supprimer(selectedReassureurs);
        }
    }

    public void rowSelected() {
        formReassureurs = selectedReassureurs;
        this.index = this.dataListReassureurs.indexOf(this.selectedReassureurs);
        this.desactiversuppr = false;
    }

    public Reassureurs getFormReassureurs() {
        return formReassureurs;
    }

    public void desactiver() {
        if (selectedReassureurs != null) {
            selectedReassureurs.setStatutreass("inactif");
            reassureursService.modifier(selectedReassureurs);
        }
        this.formReassureurs = new Reassureurs();
    }

    public void setFormReassureurs(Reassureurs formReassureurs) {
        this.formReassureurs = formReassureurs;
    }

    public Reassureurs getSelectedReassureurs() {
        return selectedReassureurs;
    }

    public void setSelectedReassureurs(Reassureurs selectedReassureurs) {
        this.selectedReassureurs = selectedReassureurs;
    }

    public List<Reassureurs> getDataListReassureurs() {
        dataListReassureurs = reassureursService.reassureurall();
        return dataListReassureurs;
    }

    public void setDataListReassureurs(List<Reassureurs> dataListReassureurs) {

        this.dataListReassureurs = dataListReassureurs;
    }

    public ReassureursServiceBeanLocal getReassureursService() {
        return reassureursService;
    }

    public void setReassureursService(ReassureursServiceBeanLocal reassureursService) {
        this.reassureursService = reassureursService;
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

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public List<Reassureurs> getDatalistfiltre() {
        return datalistfiltre;
    }

    public void setDatalistfiltre(List<Reassureurs> datalistfiltre) {
        this.datalistfiltre = datalistfiltre;
    }
    

}
