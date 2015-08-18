package com.c2a.vie.managedbeans.deces;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.c2a.vie.entities.Apporteur;
import com.c2a.vie.entities.Typeapporteur;
import com.c2a.vie.entities.Typecontrat;
import com.c2a.vie.service.deces.ApporteurServiceBeanLocal;
import com.c2a.vie.service.deces.TypeapporteurServiceBeanLocal;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.format.CellDateFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author K.M.A
 */
@ManagedBean(name = "apporteurManagedBean")
@ViewScoped
public class ApporteurManagedBean  implements Serializable{

    @EJB
    private ApporteurServiceBeanLocal apporteurService;
    private Apporteur formApporteur = new Apporteur();
    private Apporteur selectedApporteur;
    private List<Apporteur> dataListApporteur;
    private Apporteur chargerapporteur;
 
    
    @EJB
    private TypeapporteurServiceBeanLocal typeapporteurService;
    private List<Typeapporteur> datalisttype;
 
    private Integer idtypeaporteur;
    
private String keyWord;   
private Boolean desactiversuppr = true, desactiverCode;
    private int index;
    /**
     * Creates a new instance of ApporteurManagedBean
     */
    public ApporteurManagedBean() {
     formApporteur = new Apporteur();
     selectedApporteur = new Apporteur();
    dataListApporteur = new ArrayList<Apporteur>();
    chargerapporteur=new Apporteur();
    }
    public  void  init(){
        datalisttype=typeapporteurService.typeapporteurall();
    }
    
    
     public void search() {
        if (keyWord == null || keyWord.length() == 0) {
            FacesContext.getCurrentInstance().addMessage("notif", new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention: ", "Veuillez saisir un mot-clé à rechercher!"));
        } else {
            try {
                dataListApporteur = apporteurService.recherchenom(keyWord);
                FacesContext.getCurrentInstance().addMessage("notif", new FacesMessage(FacesMessage.SEVERITY_INFO, "Recherche Terminée: ", dataListApporteur.size() + " ligne(s) trouvée(s)."));
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage("notif", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Recherche Echouée: ", e.getMessage()));
            }
        }
    }
    
         
    private void gridloadDB(){
        selectedApporteur=null;
        try{
            dataListApporteur=apporteurService.apporteurall();
            datalisttype=typeapporteurService.typeapporteurall();
            
          FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Chargement OK: ", dataListApporteur.size() + " enregistrements chargés. (timestamp = "+(new SimpleDateFormat("dd/MM/yy kk:mm:ss")).format(new Date())+")");
          FacesContext.getCurrentInstance().addMessage("notif", msg);
        }
        catch(Exception e){
          FacesContext.getCurrentInstance().addMessage("notification", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Chargement échoué: ", e.getMessage()));
            Logger.getLogger(Typecontrat.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    /**
     * Raffraîchit la grille depuis la BD
     */
    public void refreshGrid() {
        gridloadDB();
    }
    public void enregistrer(){
        List<Apporteur> list=apporteurService.apporteurall();
        MessageBean m=new MessageBean();
        int i=0;
        if(formApporteur.getIdtypeapporteur()==null || formApporteur.getNomapp().trim().isEmpty() ||
                formApporteur.getCommissionapp().intValue()==0 || formApporteur.getAdresseapp().trim().isEmpty() || formApporteur.getTelapp().trim().isEmpty()){
            m.addMessageWarn("veuilllez renseigner les champs");
        }
        else{
            if(selectedApporteur != null){
            apporteurService.modifier(formApporteur);
            
        }else{
    i = list.stream().filter((list1) -> (list1.getNomapp().equals(formApporteur.getNomapp()))).map((_item) -> 1).reduce(i, Integer::sum);
                      if(i==0){
            formApporteur.setStatutapp("actif");
            formApporteur.setMontantapp(0.0);
            apporteurService.ajouter(formApporteur);
            m.addMessageInfo("enregistré");
             this.desactiversuppr = true;
                              }
                              else{
                                  m.addMessageWarn("deja enregisrté");
                              }
        }
         formApporteur=new Apporteur();
        this.desactiversuppr=true;
        }
        
        
    }
    
       public void desactiver(){
        if(selectedApporteur!=null){
            selectedApporteur.setStatutapp("inactif");
           apporteurService.modifier(selectedApporteur);
        }
        this.formApporteur=new Apporteur();
    }
    
    public void effacer(){
        formApporteur = new Apporteur();
        selectedApporteur = null;
        selectedApporteur=new Apporteur();
    }
    
    public void supprimer(){
        if(selectedApporteur != null){
            apporteurService.supprimer(selectedApporteur);
        }
    }

 public void rowSelected() {
        formApporteur = selectedApporteur;
        this.desactiverCode = true;
        this.index = this.dataListApporteur.indexOf(this.selectedApporteur);
        this.desactiversuppr = false;
    }    public Apporteur getFormApporteur() {
        return formApporteur;
    }
public void charger(FileUploadEvent event) throws IOException {

        InputStream file;
        MessageBean m = new MessageBean();
        String test = null;
        List<Apporteur> list = apporteurService.apporteurall();
        List<Typeapporteur> list1=typeapporteurService.typeapporteurall();
        int idtypeapporterur=0;
        int i=0;
        if (event.getFile() == null) {
            m.addMessage("fichier null");
        } else {
            file = event.getFile().getInputstream();
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);
            FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();

            for (Row ligne : sheet) {//parcourir les lignes
                for (Cell cell : ligne) {//parcourir les colonnes
                    //évaluer le type de la cellule
                    switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {

                        case Cell.CELL_TYPE_NUMERIC:

                            CellValue cValue = formulaEvaluator.evaluate(cell);
                            double dv = cValue.getNumberValue();
                            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                Date date = HSSFDateUtil.getJavaDate(dv);
                                String dateFmt = cell.getCellStyle().getDataFormatString();
                                String strValue = new CellDateFormatter(dateFmt).format(date);
                                System.out.println(strValue);
                            } else {
                                System.out.print(cell.getNumericCellValue() + "\t\t");
                            }
                            break;
                        case Cell.CELL_TYPE_STRING:
                            if(cell.getCellType()==cell.CELL_TYPE_NUMERIC){
                                int testphone = (int)cell.getNumericCellValue(); 
                                String strCellValue = String.valueOf(testphone);
                                System.out.println(strCellValue);
                                
                            }else{
                               System.out.print(cell.getStringCellValue() + "\t");
                            }

                            break;
                        default:

                    }
            
                   chargerapporteur.setAdresseapp("lomé");
                   chargerapporteur.setNomapp(ligne.getCell(2).toString());
                   chargerapporteur.setEmailapp("pas encore d'email");
                   chargerapporteur.setMontantapp(0.0);
                   chargerapporteur.setCommissionapp(Float.valueOf(10));
                   chargerapporteur.setStatutapp("actif");
                   chargerapporteur.setTelapp("pas de numero");
                    for (Typeapporteur l : list1) {
                        if("entreprise".equals(l.getLibtypeapporteur())){
                            idtypeapporterur=l.getIdtypeapporteur();
                        }
                    }
                    chargerapporteur.setIdtypeapporteur(typeapporteurService.selectionner(idtypeapporterur));
                   
                }

                System.out.println();
               apporteurService.ajouter(chargerapporteur);
               chargerapporteur=new Apporteur();
               
            }
            if("ok".equals(test)){
               m.addMessage("fichier chargé avec succès");
            }
            else{
                m.addMessageWarn("doublons détectés fichier non chargés");
            }

        }
    }

    public void setFormApporteur(Apporteur formApporteur) {
        this.formApporteur = formApporteur;
    }

    public Apporteur getSelectedApporteur() {
        return selectedApporteur;
    }

    public void setSelectedApporteur(Apporteur selectedApporteur) {
        this.selectedApporteur = selectedApporteur;
    }

    public List<Apporteur> getDataListApporteur() {
        dataListApporteur=apporteurService.apporteurall();
        return dataListApporteur;
    }

    public void setDataListApporteur(List<Apporteur> dataListApporteur) {
        this.dataListApporteur = dataListApporteur;
    }

    public ApporteurServiceBeanLocal getApporteurService() {
        return apporteurService;
    }

    public void setApporteurService(ApporteurServiceBeanLocal apporteurService) {
        this.apporteurService = apporteurService;
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
    


    public Boolean isDesactiverCode() {
        return desactiverCode;
    }

    public void setDesactiverCode(Boolean desactiverCode) {
        this.desactiverCode = desactiverCode;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public TypeapporteurServiceBeanLocal getTypeapporteurService() {
        return typeapporteurService;
    }

    public void setTypeapporteurService(TypeapporteurServiceBeanLocal typeapporteurService) {
        this.typeapporteurService = typeapporteurService;
    }



    public Integer getIdtypeaporteur() {
        return idtypeaporteur;
    }

    public void setIdtypeaporteur(Integer idtypeaporteur) {
        this.idtypeaporteur = idtypeaporteur;
    }

    public List<Typeapporteur> getDatalisttype() {
        datalisttype=typeapporteurService.selectionnerTout();
        return datalisttype;
    }

    public void setDatalisttype(List<Typeapporteur> datalisttype) {
        this.datalisttype = datalisttype;
    }

    public Apporteur getChargerapporteur() {
        return chargerapporteur;
    }

    public void setChargerapporteur(Apporteur chargerapporteur) {
        this.chargerapporteur = chargerapporteur;
    }

  
    
    
    
}
