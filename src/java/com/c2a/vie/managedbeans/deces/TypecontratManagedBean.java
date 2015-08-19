package com.c2a.vie.managedbeans.deces;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.c2a.vie.entities.Typecontrat;
import com.c2a.vie.service.deces.TypecontratServiceBeanLocal;
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
@ManagedBean(name = "typecontratManagedBean")
@ViewScoped
public class TypecontratManagedBean  implements Serializable{

    @EJB
    private TypecontratServiceBeanLocal typecontratService;
    private Typecontrat formTypecontrat = new Typecontrat();
    private Typecontrat selectedTypecontrat;
    private String selectoneradio;
    private List<Typecontrat> dataListTypecontrat;
    private List<Typecontrat> dataList;
private Boolean desactiverBoutonSuppr = true, desactiverCode;
    private Boolean desactiverlibelle=false;
    private Boolean desactiversuppr=true;
    private int index;
    /**
     * Creates a new instance of TypecontratManagedBean
     */
    public TypecontratManagedBean() {
     formTypecontrat = new Typecontrat();
     selectedTypecontrat = new Typecontrat();
    dataListTypecontrat = new ArrayList<Typecontrat>();
    }
  public void nouveau(){
      this.desactiverlibelle=false;
      this.formTypecontrat=new Typecontrat();
      this.desactiverBoutonSuppr=true;
     
  }
    
    private void gridloadDB(){
        selectedTypecontrat=null;
        try{
            dataListTypecontrat=typecontratService.typecontratall();
        }
        catch(Exception e){
            
            FacesContext.getCurrentInstance().addMessage("notification", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Chargement échoué: ", e.getMessage()));
            Logger.getLogger(Typecontrat.class.getName()).log(Level.SEVERE, null, e);
        }
          FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Chargement OK: ", dataListTypecontrat.size() + " enregistrements chargés. (timestamp = "+(new SimpleDateFormat("dd/MM/yy kk:mm:ss")).format(new Date())+")");
        FacesContext.getCurrentInstance().addMessage("notif", msg);
    }
    
    /**
     * Raffraîchit la grille depuis la BD
     */
    public void refreshGrid() {
        gridloadDB();
    }
    public void desactiver(){
        if(selectedTypecontrat!=null){
            selectedTypecontrat.setStatuttypecontrat("inactif");
            typecontratService.modifier(selectedTypecontrat);
        }
        this.formTypecontrat=new Typecontrat();
    }
    
    public void enregistrer(){
         List<Typecontrat> list=new ArrayList<>();
       list=typecontratService.typecontratall();
        int i=0;
        MessageBean m=new MessageBean();
        if(selectedTypecontrat != null){
            typecontratService.modifier(formTypecontrat);
        }else{
            for (Typecontrat list1 : list) {
                if(list1.getLibtypecontrat().equals(formTypecontrat.getLibtypecontrat())){
                    i++;
                }
                
            }
            if(i==0){
                
      formTypecontrat.setStatuttypecontrat("actif");
            typecontratService.ajouter(formTypecontrat); 
                m.addMessageInfo("enregistré");
            }
            else{
                m.addMessageWarn("libelle deja existant");
            }
          
            }
     formTypecontrat=new Typecontrat();
        this.desactiversuppr=true;
    }
    
    public String effacer(){
        this.desactiverlibelle=false;
        this.desactiverBoutonSuppr=true;
        formTypecontrat = new Typecontrat();
        selectedTypecontrat = null;
        return "typecontrat?faces-redirect=true"; 
    }
    
    public void supprimer(){
        if(selectedTypecontrat != null){
            typecontratService.supprimer(selectedTypecontrat);
        }
    }
    public void libelleradio(){
        desactiverlibelle=true;
        formTypecontrat.setLibtypecontrat(selectoneradio);
    }

 public void rowSelected() {
        formTypecontrat = selectedTypecontrat;
        this.desactiverCode = true;
        this.index = this.dataListTypecontrat.indexOf(this.selectedTypecontrat);
        this.desactiversuppr= false;
        this.desactiverlibelle=false;
    }
 public Typecontrat getFormTypecontrat() {
        return formTypecontrat;
    }

    public void setFormTypecontrat(Typecontrat formTypecontrat) {
        this.formTypecontrat = formTypecontrat;
    }

    public Typecontrat getSelectedTypecontrat() {
        return selectedTypecontrat;
    }

    public void setSelectedTypecontrat(Typecontrat selectedTypecontrat) {
        this.selectedTypecontrat = selectedTypecontrat;
    }

    public List<Typecontrat> getDataListTypecontrat() {
        dataListTypecontrat=typecontratService.typecontratall();
        return dataListTypecontrat;
    }

    public void setDataListTypecontrat(List<Typecontrat> dataListTypecontrat) {
        this.dataListTypecontrat = dataListTypecontrat;
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

    public TypecontratServiceBeanLocal getTypecontratService() {
        return typecontratService;
    }

    public void setTypecontratService(TypecontratServiceBeanLocal typecontratService) {
        this.typecontratService = typecontratService;
    }

    public String getSelectoneradio() {
        return selectoneradio;
    }

    public void setSelectoneradio(String selectoneradio) {
        this.selectoneradio = selectoneradio;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Boolean getDesactiverlibelle() {
        return desactiverlibelle;
    }

    public void setDesactiverlibelle(Boolean desactiverlibelle) {
        this.desactiverlibelle = desactiverlibelle;
    }

    public List<Typecontrat> getDataList() {
        return dataList;
    }

    public void setDataList(List<Typecontrat> dataList) {
        this.dataList = dataList;
    }

    public Boolean getDesactiversuppr() {
        return desactiversuppr;
    }

    public void setDesactiversuppr(Boolean desactiversuppr) {
        this.desactiversuppr = desactiversuppr;
    }
    
    
    
    
}
