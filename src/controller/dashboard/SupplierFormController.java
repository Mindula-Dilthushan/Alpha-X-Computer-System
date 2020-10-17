//Alpha-X-Computer-System
//Software Design Alpha X Software Solution
//10-17-20
package controller.dashboard;

import bo.BOFactory;
import bo.custom.SupplierBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.SupplierDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.textfield.TextFields;
import util.UtilImpl;
import view.tm.SupplierTM;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class SupplierFormController implements Initializable {

    //Label-Detail-----------------------
    public Label lblTotalSup;

    //TextField-Detail-------------------
    public JFXTextField txtsId,txtSupName,txtSupAdd,txtSupCont,txtSupEmail;
    public TextField txtSeaCont;

    //Button-Detail----------------------
    public JFXButton btnSave,btnUpdate,btnDelete;

    //Table-Detail-----------------------
    public TableView <SupplierTM>tblSupplier;
    public TableColumn colId,colName,colAdd,colCont,colEmail;

    //Property-Injection-----------------
    private SupplierBO supplierBO = BOFactory.getInstance().getBO(BOFactory.BOType.SUPPLIER);
    UtilImpl util = new UtilImpl();

    //Other----------------------------------
    private ArrayList<String> supArr;
    private ArrayList<SupplierDTO> supsearch;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //table-lord--------------------------------
        colId.setCellValueFactory(new PropertyValueFactory("supID"));
        colName.setCellValueFactory(new PropertyValueFactory("supName"));
        colAdd.setCellValueFactory(new PropertyValueFactory("supAdd"));
        colCont.setCellValueFactory(new PropertyValueFactory("supCont"));
        colEmail.setCellValueFactory(new PropertyValueFactory("supEmail"));

        tblSupplier.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    setTableToData(newValue);
                });

        try {
            loadSupplier();
            loadId();
            sumSup();
        } catch (Exception e) {
            e.printStackTrace();
        }
        getProductSearching();
        searchCont();
        setSupId();

    }
    //lord-table-data===============================================================================
    private void loadSupplier() throws Exception {
        ObservableList<SupplierTM> supplierTMObservableList = FXCollections.observableArrayList();
        List<SupplierDTO> supplierDTOList= supplierBO.getAllSupplier();
        for (SupplierDTO supplierDTO : supplierDTOList) {
            SupplierTM tm = new SupplierTM(
                    supplierDTO.getSid(),
                    supplierDTO.getSname(),
                    supplierDTO.getSaddress(),
                    supplierDTO.getScontact(),
                    supplierDTO.getSemail()
            );
            supplierTMObservableList.add(tm);
            tblSupplier.setItems(supplierTMObservableList);
        }
    }
    //set Listener------------------------------------------------------------------------
    private void setTableToData(SupplierTM supplierTM) {
        txtsId.setText(supplierTM.getSupID());
        txtSupName.setText(supplierTM.getSupName());
        txtSupAdd.setText(supplierTM.getSupAdd());
        txtSupCont.setText(supplierTM.getSupCont()+"");
        txtSupEmail.setText(supplierTM.getSupEmail());
    }
    private void loadId() throws Exception {
        String id = supplierBO.getListener();
        txtsId.setText(id);
    }
    //Crud-Operation =======================================================================================
    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String supplierID = txtsId.getText();
        String supplierName = txtSupName.getText();
        String supplierAdd = txtSupAdd.getText();
        String supplierCont = txtSupCont.getText();
        String supplierEmail = txtSupEmail.getText();

        if(supplierID.isEmpty()
                || supplierName.isEmpty()
                || supplierAdd.isEmpty()
                || supplierCont.isEmpty()
                || supplierEmail.isEmpty()){
            util.ImgNotification("asserts/worrning.png","Empty Field","Please fill the data");
        }
        else if(!(supplierID.matches("^[S]\\d{3}$"))){
            util.ImgNotification("asserts/regex.png","Invalid","Supplier id format");
            try {
                util.textFocusColor(txtsId);
            } catch (Exception e) {
            }
        }else if (!(supplierName.matches("[A-z 0-9]+"))){
            util.ImgNotification("asserts/regex.png","Invalid","Supplier name format");
            try {
                util.textFocusColor(txtSupName);
            } catch (Exception e) {
            }
        }else if (!(supplierAdd.matches("[A-z 0-9,]+"))){
            util.ImgNotification("asserts/regex.png","Invalid","Supplier address format");
            try {
                util.textFocusColor(txtSupAdd);
            } catch (Exception e) {
            }
        }else if (!(supplierCont.matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]"))){
            util.ImgNotification("asserts/regex.png","Invalid","Supplier contact format");
            try {
                util.textFocusColor(txtSupCont);
            } catch (Exception e) {
            }
        }else if (!(supplierEmail.matches("^(.+)@(.+)$"))){
            util.ImgNotification("asserts/regex.png","Invalid","Supplier email format");
            try {
                util.textFocusColor(txtSupEmail);
            } catch (Exception e) {
            }
        }else {
            try {
                try {
                    ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                    ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure ?", ok, no);
                        Optional<ButtonType> result = alert.showAndWait();
                            if (result.orElse(no) == ok) {
                                if (supplierBO.deleteSupplier(txtsId.getText())) {
                                    util.ImgNotification("asserts/ok.png", "Success", "Supplier deleted");
                                    loadSupplier();
                                    ClearTxt();
                                    sumSup();
                                    return;
                                }
                                util.ImgNotification("asserts/wrong.png", "UnSuccess", "Supplier not deleted");
                            } else {
                                //no
                            }
                    } catch (Exception e) {
                    }
            } catch (Exception e) {
            }
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String supplierID = txtsId.getText();
        String supplierName = txtSupName.getText();
        String supplierAdd = txtSupAdd.getText();
        String supplierCont = txtSupCont.getText();
        String supplierEmail = txtSupEmail.getText();

        if(supplierID.isEmpty()
                || supplierName.isEmpty()
                || supplierAdd.isEmpty()
                || supplierCont.isEmpty()
                || supplierEmail.isEmpty()){
            util.ImgNotification("asserts/worrning.png","Empty Field","Please fill the data");
        }
        else if(!(supplierID.matches("^[S]\\d{3}$"))){
            util.ImgNotification("asserts/regex.png","Invalid","Supplier id format");
            try {
                util.textFocusColor(txtsId);
            } catch (Exception e) {
            }
        }else if (!(supplierName.matches("[A-z 0-9]+"))){
            util.ImgNotification("asserts/regex.png","Invalid","Supplier name format");
            try {
                util.textFocusColor(txtSupName);
            } catch (Exception e) {
            }
        }else if (!(supplierAdd.matches("[A-z 0-9,]+"))){
            util.ImgNotification("asserts/regex.png","Invalid","Supplier address format");
            try {
                util.textFocusColor(txtSupAdd);
            } catch (Exception e) {
            }
        }else if (!(supplierCont.matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]"))){
            util.ImgNotification("asserts/regex.png","Invalid","Supplier contact format");
            try {
                util.textFocusColor(txtSupCont);
            } catch (Exception e) {
            }
        }else if (!(supplierEmail.matches("^(.+)@(.+)$"))){
            util.ImgNotification("asserts/regex.png","Invalid","Supplier email format");
            try {
                util.textFocusColor(txtSupEmail);
            } catch (Exception e) {
            }
        }else {
            try {
                ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure ?", ok, no);
                    Optional<ButtonType> result = alert.showAndWait();
                        if (result.orElse(no) == ok) {
                            if (supplierBO.updateSupplier(
                                    new SupplierDTO(
                                            txtsId.getText(),
                                            txtSupName.getText(),
                                            txtSupAdd.getText(),
                                            Integer.parseInt(txtSupCont.getText()),
                                            txtSupEmail.getText()
                                    )
                            )
                            ) util.ImgNotification("asserts/ok.png", "Success", "Supplier Updated");
                            ClearTxt();
                            loadSupplier();
                            sumSup();
                            return;
                        }else{
                        }
                } catch (Exception e) {
                }
        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String supplierID = txtsId.getText();
        String supplierName = txtSupName.getText();
        String supplierAdd = txtSupAdd.getText();
        String supplierCont = txtSupCont.getText();
        String supplierEmail = txtSupEmail.getText();

        if(supplierID.isEmpty()
                || supplierName.isEmpty()
                || supplierAdd.isEmpty()
                || supplierCont.isEmpty()
                || supplierEmail.isEmpty()){
            util.ImgNotification("asserts/worrning.png","Empty Field","Please fill the data");
        }
        else if(!(supplierID.matches("^[S]\\d{3}$"))){
            util.ImgNotification("asserts/regex.png","Invalid","Supplier id format");
            try {
                util.textFocusColor(txtsId);
            } catch (Exception e) {
            }
        }else if (!(supplierName.matches("[A-z 0-9]+"))){
            util.ImgNotification("asserts/regex.png","Invalid","Supplier name format");
            try {
                util.textFocusColor(txtSupName);
            } catch (Exception e) {
            }
        }else if (!(supplierAdd.matches("[A-z 0-9,]+"))){
            util.ImgNotification("asserts/regex.png","Invalid","Supplier address format");
            try {
                util.textFocusColor(txtSupAdd);
            } catch (Exception e) {
            }
        }else if (!(supplierCont.matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]"))){
            util.ImgNotification("asserts/regex.png","Invalid","Supplier contact format");
            try {
                util.textFocusColor(txtSupCont);
            } catch (Exception e) {
            }
        }else if (!(supplierEmail.matches("^(.+)@(.+)$"))){
            util.ImgNotification("asserts/regex.png","Invalid","Supplier email format");
            try {
                util.textFocusColor(txtSupEmail);
            } catch (Exception e) {
            }
        }else {
            try {
                boolean isSupplierSaved = supplierBO.saveSupplier(
                        new SupplierDTO(
                                txtsId.getText(),
                                txtSupName.getText(),
                                txtSupAdd.getText(),
                                Integer.parseInt(txtSupCont.getText()),
                                txtSupEmail.getText()
                        )
                );
                if (isSupplierSaved==true){
                    util.ImgNotification("asserts/ok.png", "Success", "Supplier Saved");
                }else {
                    System.out.println("no");
                }
                ClearTxt();
                loadSupplier();
                sumSup();
            } catch (Exception e) {
            }
        }
    }
    //Searching =======================================================================================
    private void getProductSearching() {
        try {
            supArr = new ArrayList<>();
            supsearch = supplierBO.getAllSupplier();
            for (SupplierDTO supplierDTO : supsearch) {
                supArr.add(supplierDTO.getScontact()+"");
            }
        } catch (Exception e) {
        }
    }
    private void searchCont() {
        TextFields.bindAutoCompletion(txtSeaCont, supArr);
    }
    public void txtSeaContOnAction(ActionEvent actionEvent) {
        try {
            SupplierDTO supplierDTO = supplierBO.getSupCont(txtSeaCont.getText());
            if (supplierDTO != null) {
                txtsId.setText(supplierDTO.getSid());
                txtSupName.setText(supplierDTO.getSname());
                txtSupAdd.setText(supplierDTO.getSaddress());
                txtSupCont.setText(supplierDTO.getScontact()+"");
                txtSupEmail.setText(supplierDTO.getSemail());
            }
        } catch (Exception e) {
        }
    }
    public void txtSupIdOnAction(ActionEvent actionEvent) {
        try {
            SupplierDTO supplierDTO = supplierBO.searchSupplier(txtsId.getText());
            if (supplierDTO != null) {
                txtsId.setText(supplierDTO.getSid());
                txtSupName.setText(supplierDTO.getSname());
                txtSupAdd.setText(supplierDTO.getSaddress());
                txtSupCont.setText(supplierDTO.getScontact()+"");
                txtSupEmail.setText(supplierDTO.getSemail());
            }
        } catch (Exception e) {
        }
    }
    //Clear-data===============================================================================
    public void ClearTxt(){
        txtsId.setText(null);
        txtSupName.setText(null);
        txtSupAdd.setText(null);
        txtSupCont.setText(null);
        txtSupEmail.setText(null);
        txtSeaCont.setText(null);
    }
    //Set-Product-Id===============================================================================
    public void setSupId() {
        try {
            int SupID = supplierBO.getSupCount();
            if (SupID==0){
                txtsId.setText("S001");
            }
            if (SupID>0 && SupID<=8){
                txtsId.setText("S00"+(SupID+1));
            }
            if (SupID>=9 && SupID<=98){
                txtsId.setText("S0"+(SupID+1));
            }
            if (SupID>=99){
                txtsId.setText("S"+(SupID+1));
            }
        } catch (Exception e) {
        }
    }
    //Sum-Count--------------------------------------------------------
    public void sumSup() throws Exception {
        int tot = supplierBO.getSupCount();
        lblTotalSup.setText(String.valueOf(tot));
    }
}
