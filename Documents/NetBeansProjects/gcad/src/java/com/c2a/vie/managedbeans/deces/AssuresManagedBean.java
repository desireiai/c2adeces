package com.c2a.vie.managedbeans.deces;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import com.c2a.vie.entities.Assures;
import com.c2a.vie.entities.Typecontrat;
import com.c2a.vie.service.deces.AssuresServiceBeanLocal;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author K.M.A
 */
@ManagedBean(name = "assuresManagedBean")
@ViewScoped
public class AssuresManagedBean implements Serializable {

    @EJB
    private AssuresServiceBeanLocal assuresService;
    private Assures formAssures = new Assures();
    private Assures selectedAssures;
    private Assures chargerassures = new Assures();
    private List<Assures> dataListAssures;
    private List<Assures> datalistfiltre;
    private List<Assures> dataassuresentreise;
    private UploadedFile fileassure;
    private Exception e;
    private XSSFRow row = null;

    private Boolean desactiversuppr = true, desactiverCode;
    private int index;

    /**
     * Creates a new instance of AssuresManagedBean
     */
    public AssuresManagedBean() {
        formAssures = new Assures();
        selectedAssures = new Assures();
        dataListAssures = new ArrayList<Assures>();
        chargerassures = new Assures();
    }

    public void active() {
        this.desactiversuppr = false;
    }

    private void gridloadDB() {
        selectedAssures = null;
        try {
            dataListAssures = assuresService.assureall();
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage("notification", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Chargement échoué: ", e.getMessage()));
            Logger.getLogger(Typecontrat.class.getName()).log(Level.SEVERE, null, e);
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Chargement OK: ", dataListAssures.size() + " enregistrements chargés. (timestamp = " + (new SimpleDateFormat("dd/MM/yy kk:mm:ss")).format(new Date()) + ")");
        FacesContext.getCurrentInstance().addMessage("notif", msg);
    }

    /**
     * Raffraîchit la grille depuis la BD
     */
    public void refreshGrid() {
        gridloadDB();
    }

    public void charger(FileUploadEvent event) throws IOException {

        InputStream file;
        MessageBean m = new MessageBean();
        String test = null;
        List<Assures> list = assuresService.assureall();
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
                    chargerassures.setNomasusure(ligne.getCell(0).toString());
                    chargerassures.setPrenassure(ligne.getCell(1).toString());
                    chargerassures.setEmailassure("pas d'email");
                    chargerassures.setGentreprise("oui");
                    chargerassures.setStatutassur("actif");
                    chargerassures.setTelassure(ligne.getCell(5).toString());
                    chargerassures.setAdresseassure(ligne.getCell(4).toString());
                    chargerassures.setProfessionassure(ligne.getCell(3).toString());
                    chargerassures.setDatnaisassure(ligne.getCell(2).getDateCellValue());

                }

                System.out.println();
                 for (Assures list1 : list) {
                if (chargerassures.getNomasusure().equals(list1.getNomasusure()) && chargerassures.getPrenassure().equals(list1.getPrenassure())) {
                    i = i + 1;
                }
            }
                 if(i==0){
                     assuresService.ajouter(chargerassures);
                     chargerassures = new Assures();
                     test="ok";
                 }
                 else{
                     test="erreur";
                     }
               
            }
            if("ok".equals(test)){
               m.addMessage("fichier chargé avec succès");
            }
            else{
                m.addMessageWarn("doublons détectés fichier non chargés");
            }

        }
    }

    public void enregistrer() {
        MessageBean m = new MessageBean();
        List<Assures> list = assuresService.assureall();
        int i = 0;

        if (formAssures.getEmailassure().trim().isEmpty()) {
            formAssures.setEmailassure("pas d'email");
        }

        if (formAssures.getTelassure().trim().isEmpty()) {
            formAssures.setTelassure(formAssures.getCodsous().getTelsous());

        }

        if (formAssures.getNomasusure().trim().isEmpty() || formAssures.getPrenassure().trim().isEmpty() || formAssures.getDatnaisassure() == null) {
            m.addMessageWarn("veuillez renseigner les champs");
        } else {
            for (Assures list1 : list) {
                if (formAssures.getNomasusure().equals(list1.getNomasusure()) && formAssures.getPrenassure().equals(list1.getPrenassure())
                        && formAssures.getDatnaisassure() == list1.getDatnaisassure() && formAssures.getTelassure().equals(list1.getTelassure())) {
                    i = i + 1;
                }
            }
            if (i == 0) {

                formAssures.setStatutassur("actif");
                assuresService.ajouter(formAssures);
                formAssures = new Assures();
                m.addMessageInfo("enregistré");
            } else {
                m.addMessageWarn("assuré dejà enregistré");
            }

        }

    }

    public void modifier() {
        MessageBean m = new MessageBean();
        if (selectedAssures != null) {
            assuresService.modifier(formAssures);
            m.addMessageInfo("modifié");
            formAssures = new Assures();
            selectedAssures = null;
            this.desactiversuppr = true;
        }
    }

    public int ageassure() {
        Calendar calendar = new GregorianCalendar();
        LocalDate aujourdui = new LocalDate();
        calendar.setTime(formAssures.getDatnaisassure());
        int annee = calendar.get(Calendar.YEAR);
        int mois = calendar.get(Calendar.MONTH);
        int jours = calendar.get(Calendar.DAY_OF_MONTH);
        LocalDate naissance = new LocalDate(annee, mois, jours);
        Period p = new Period(naissance, aujourdui, PeriodType.yearMonthDay());
        return p.getYears();
    }

    public void effacer() {
        formAssures = new Assures();
        selectedAssures = null;
    }

    public void supprimer() {
        if (selectedAssures != null) {
            assuresService.supprimer(selectedAssures);
        }
    }

    public void rowSelected() {
        this.formAssures = this.selectedAssures;
        this.desactiverCode = true;
        this.index = this.dataListAssures.indexOf(this.selectedAssures);
        this.desactiversuppr = false;
    }

    public Assures getFormAssures() {
        return formAssures;
    }

    public void setFormAssures(Assures formAssures) {
        this.formAssures = formAssures;
    }

    public Assures getSelectedAssures() {
        return selectedAssures;
    }

    public void setSelectedAssures(Assures selectedAssures) {
        this.selectedAssures = selectedAssures;
    }

    public List<Assures> getDataListAssures() {
        dataListAssures = assuresService.assureall();
        return dataListAssures;
    }

    public void setDataListAssures(List<Assures> dataListAssures) {
        this.dataListAssures = dataListAssures;
    }

    public Boolean getDesactiversuppr() {
        return desactiversuppr;
    }

    public void setDesactiversuppr(Boolean desactiversuppr) {
        this.desactiversuppr = desactiversuppr;
    }

    public Boolean isDesactiverCode() {
        return desactiverCode;
    }

    public void setDesactiverCode(Boolean desactiverCode) {
        this.desactiverCode = desactiverCode;
    }

    public AssuresServiceBeanLocal getAssuresService() {
        return assuresService;
    }

    public void setAssuresService(AssuresServiceBeanLocal assuresService) {
        this.assuresService = assuresService;
    }

    public List<Assures> getDatalistfiltre() {
        return datalistfiltre;
    }

    public void setDatalistfiltre(List<Assures> datalistfiltre) {
        this.datalistfiltre = datalistfiltre;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<Assures> getDataassuresentreise() {
        dataassuresentreise = assuresService.assureentreprise();
        return dataassuresentreise;
    }

    public void setDataassuresentreise(List<Assures> dataassuresentreise) {
        this.dataassuresentreise = dataassuresentreise;
    }

    public UploadedFile getFileassure() {
        return fileassure;
    }

    public void setFileassure(UploadedFile fileassure) {
        this.fileassure = fileassure;
    }

    public XSSFRow getRow() {
        return row;
    }

    public void setRow(XSSFRow row) {
        this.row = row;
    }

    public Assures getChargerassures() {
        return chargerassures;
    }

    public void setChargerassures(Assures chargerassures) {
        this.chargerassures = chargerassures;
    }

}
