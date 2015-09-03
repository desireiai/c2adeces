package com.c2a.vie.managedbeans.deces;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.c2a.vie.entities.Coassurance;
import com.c2a.vie.entities.Contrat;
import com.c2a.vie.entities.Parametrecoassapporteur;
import com.c2a.vie.service.deces.CoassuranceServiceBeanLocal;
import com.c2a.vie.service.deces.ContratServiceBeanLocal;
import com.c2a.vie.service.deces.ParametrecoassapporteurServiceBeanLocal;
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
@ManagedBean(name = "coassuranceManagedBean")
@ViewScoped
public class CoassuranceManagedBean implements Serializable {

    @EJB
    private CoassuranceServiceBeanLocal coassuranceService;
    private Coassurance formCoassurance = new Coassurance();
    private Coassurance selectedCoassurance;
    private List<Coassurance> dataListCoassurance;
    private List<Coassurance> tampncoassurance;
    private Boolean desactiverBoutonSuppr = true, desactiverCode;
    private int index;

    @EJB
    private ContratServiceBeanLocal contratService;
    private List<Contrat> contratcoassurance;
    private Contrat selectContratcoass;
    private Double capit;
    private Contrat formcontratcoass;

    @EJB
    private ParametrecoassapporteurServiceBeanLocal parametrecoassapporteurService;
    private Parametrecoassapporteur formParametrecoassapporteur;
    private Parametrecoassapporteur selParametrecoassapporteur;
    private List<Parametrecoassapporteur> datalistparametrecoassapporteurs;
    private List<Parametrecoassapporteur> datalistfiltreparam;

    /**
     * Creates a new instance of CoassuranceManagedBean
     */
    public CoassuranceManagedBean() {
        formCoassurance = new Coassurance();
        selectedCoassurance = new Coassurance();
        dataListCoassurance = new ArrayList<Coassurance>();
        tampncoassurance = new ArrayList<>();
        formcontratcoass = new Contrat();
        contratcoassurance = new ArrayList<>();
        selectContratcoass = new Contrat();
        formCoassurance.setTauxcoass(Float.valueOf(0));
        formParametrecoassapporteur = new Parametrecoassapporteur();
        selParametrecoassapporteur = new Parametrecoassapporteur();
        datalistfiltreparam = new ArrayList<>();
        datalistparametrecoassapporteurs = new ArrayList<>();
    }

    public void rechercher() {
        MessageBean m = new MessageBean();
        try {
            contratcoassurance = contratService.contratcoassurance(formcontratcoass.getCodeapp(), formcontratcoass.getIdtypecontrat(), formcontratcoass.getIdgarantie());
            datalistfiltreparam=parametrecoassapporteurService.tauxparapporteur(formcontratcoass.getCodeapp());

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("notification", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Chargement échoué: ", e.getMessage()));
            Logger.getLogger(Contrat.class.getName()).log(Level.SEVERE, null, e);

        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Chargement OK: ", contratcoassurance.size() + " enregistrements trouvés. (timestamp = " + (new SimpleDateFormat("dd/MM/yy kk:mm:ss")).format(new Date()) + ")");
        FacesContext.getCurrentInstance().addMessage("notif", msg);
    }

    public void ajouterparam() {
        MessageBean m = new MessageBean();
        List<Parametrecoassapporteur> listverif = new ArrayList<>();
     
                    parametrecoassapporteurService.ajouter(formParametrecoassapporteur);
                    m.addMessageInfo("enrégistré");
    }

    public void rowSelectedparam() {
        formParametrecoassapporteur = selParametrecoassapporteur;
        this.index = this.datalistparametrecoassapporteurs.indexOf(this.selParametrecoassapporteur);
    }
    public  void traitement(){
        MessageBean m=new MessageBean();
        int i=0;
        for (Contrat dataListContratcoass: contratcoassurance) {
          
            for (Parametrecoassapporteur param : datalistfiltreparam) {
                formCoassurance.setCodecoass(param.getCodecoass());
                formCoassurance.setNumpolice(dataListContratcoass);
               float to=param.getTauxcoass()/100;
               double montant=dataListContratcoass.getCapitgarantitotale()*to;
               formCoassurance.setPartcoass(montant);
               coassuranceService.ajouter(formCoassurance);
               formCoassurance=new Coassurance();
               i++;
            }
            
        }
             m.addMessageInfo("    traitement réussi    "
              +i+" contrats ont été placés en coassurance");
    }

public void ajoutertampon() {
        int a = 0;
        MessageBean m = new MessageBean();

        for (Coassurance dataListtampon : tampncoassurance) {
            if (dataListtampon.getCodecoass().getCodecoass() == formCoassurance.getCodecoass().getCodecoass()) {
                a = 1;
            }
        }
        if (a == 1) {
            m.addMessageWarn("coassureur deja choisi");
        } else {
            formCoassurance.getCodecoass();
            formCoassurance.setNumpolice(selectContratcoass);
            formCoassurance.getNumpolice();
            formCoassurance.getTauxcoass();
            formCoassurance.setPartcoass((formCoassurance.getTauxcoass() / 100) * selectContratcoass.getPrimemontant());
            formCoassurance.getPartcoass();
            tampncoassurance.add(formCoassurance);
            formCoassurance = new Coassurance();
            m.addMessageInfo("enregistré");
        }
    }

    public void enregistrer() {
        if (selectedCoassurance != null) {
            coassuranceService.modifier(formCoassurance);
        } else {
            coassuranceService.ajouter(formCoassurance);
        }
    }

    public void effacer() {
        formCoassurance = new Coassurance();
        selectedCoassurance = null;
    }

    public void supprimer() {
        if (selectedCoassurance != null) {
            coassuranceService.supprimer(selectedCoassurance);
        }
    }

    public void rowSelected() {
        formCoassurance = selectedCoassurance;
        this.desactiverCode = true;
        this.index = this.dataListCoassurance.indexOf(this.selectedCoassurance);
        this.desactiverBoutonSuppr = false;
    }

    public Coassurance getFormCoassurance() {
        return formCoassurance;
    }

    public void setFormCoassurance(Coassurance formCoassurance) {
        this.formCoassurance = formCoassurance;
    }

    public Coassurance getSelectedCoassurance() {
        return selectedCoassurance;
    }

    public void setSelectedCoassurance(Coassurance selectedCoassurance) {
        this.selectedCoassurance = selectedCoassurance;
    }

    public List<Coassurance> getDataListCoassurance() {
        return dataListCoassurance;
    }

    public void setDataListCoassurance(List<Coassurance> dataListCoassurance) {
        this.dataListCoassurance = dataListCoassurance;
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

    public CoassuranceServiceBeanLocal getCoassuranceService() {
        return coassuranceService;
    }

    public void setCoassuranceService(CoassuranceServiceBeanLocal coassuranceService) {
        this.coassuranceService = coassuranceService;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ContratServiceBeanLocal getContratService() {
        return contratService;
    }

    public void setContratService(ContratServiceBeanLocal contratService) {
        this.contratService = contratService;
    }

    public List<Contrat> getContratcoassurance() {

        return contratcoassurance;
    }

    public void setContratcoassurance(List<Contrat> contratcoassurance) {
        this.contratcoassurance = contratcoassurance;
    }

    public Contrat getSelectContratcoass() {
        return selectContratcoass;
    }

    public void setSelectContratcoass(Contrat selectContratcoass) {
        this.selectContratcoass = selectContratcoass;
    }

    public Double getCapit() {
        return capit;
    }

    public void setCapit(Double capit) {
        this.capit = capit;
    }

    public Contrat getFormcontratcoass() {
        return formcontratcoass;
    }

    public void setFormcontratcoass(Contrat formcontratcoass) {
        this.formcontratcoass = formcontratcoass;
    }

    public List<Coassurance> getTampncoassurance() {
        return tampncoassurance;
    }

    public void setTampncoassurance(List<Coassurance> tampncoassurance) {
        this.tampncoassurance = tampncoassurance;
    }

    public ParametrecoassapporteurServiceBeanLocal getParametrecoassapporteurService() {
        return parametrecoassapporteurService;
    }

    public void setParametrecoassapporteurService(ParametrecoassapporteurServiceBeanLocal parametrecoassapporteurService) {
        this.parametrecoassapporteurService = parametrecoassapporteurService;
    }

    public Parametrecoassapporteur getFormParametrecoassapporteur() {
        return formParametrecoassapporteur;
    }

    public void setFormParametrecoassapporteur(Parametrecoassapporteur formParametrecoassapporteur) {
        this.formParametrecoassapporteur = formParametrecoassapporteur;
    }

    public Parametrecoassapporteur getSelParametrecoassapporteur() {
        return selParametrecoassapporteur;
    }

    public void setSelParametrecoassapporteur(Parametrecoassapporteur selParametrecoassapporteur) {
        this.selParametrecoassapporteur = selParametrecoassapporteur;
    }

    public List<Parametrecoassapporteur> getDatalistparametrecoassapporteurs() {
        datalistparametrecoassapporteurs = parametrecoassapporteurService.selectionnerTout();
        return datalistparametrecoassapporteurs;
    }

    public void setDatalistparametrecoassapporteurs(List<Parametrecoassapporteur> datalistparametrecoassapporteurs) {
        this.datalistparametrecoassapporteurs = datalistparametrecoassapporteurs;
    }

    public List<Parametrecoassapporteur> getDatalistfiltreparam() {
        return datalistfiltreparam;
    }

    public void setDatalistfiltreparam(List<Parametrecoassapporteur> datalistfiltreparam) {
        this.datalistfiltreparam = datalistfiltreparam;
    }

}
