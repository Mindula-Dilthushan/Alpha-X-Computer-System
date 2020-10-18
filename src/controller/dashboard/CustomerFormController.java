//Alpha-X-Computer-System
//Software Design Alpha X Software Solution
//10-18-20
package controller.dashboard;

import bo.BOFactory;
import bo.custom.CustomerBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.CustomerDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.textfield.TextFields;
import util.UtilImpl;
import view.tm.CustomerTM;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class CustomerFormController implements Initializable {

    //Label-Detail-----------------------
    public Label lblTotCust;

    //TextField-Detail-------------------
    public JFXTextField txtCid,txtCName,txtCAdd,txtCCont,txtCEmail;
    public TextField txtSeaCont;

    //Button-Detail----------------------
    public JFXButton btnSave,btnUpdate,btnDelete;

    //Table-Detail-----------------------
    public TableView <CustomerTM> tblCustomer;
    public TableColumn colID,colName,colAdd,colCont,colEmail;

    //Property-Injection-----------------
    private CustomerBO customerBO = BOFactory.getInstance().getBO(BOFactory.BOType.CUSTOMER);
    UtilImpl util = new UtilImpl();

    //Other----------------------------------
    private ArrayList<String> cusArr;
    private ArrayList<CustomerDTO> cussearch;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //table-lord--------------------------------
        colID.setCellValueFactory(new PropertyValueFactory("custId"));
        colName.setCellValueFactory(new PropertyValueFactory("custName"));
        colAdd.setCellValueFactory(new PropertyValueFactory("custAdd"));
        colCont.setCellValueFactory(new PropertyValueFactory("custCont"));
        colEmail.setCellValueFactory(new PropertyValueFactory("custEmail"));

        tblCustomer.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> { setTableToData(newValue);
                });

        try {
            loadCustomer();
            loadId();
            sumCust();
        } catch (Exception e) {
        }
        getCustSearching();
        searchCont();
        setCustId();
    }
    //lord-table-data===============================================================================
    private void loadCustomer() throws Exception {
        try {
            ObservableList<CustomerTM> customerTMObservableList = FXCollections.observableArrayList();
            List<CustomerDTO> customerDTOList= customerBO.getAllCustomer();
            for (CustomerDTO customerDTO : customerDTOList) {
                CustomerTM tm = new CustomerTM(
                        customerDTO.getCid(),
                        customerDTO.getCname(),
                        customerDTO.getCaddress(),
                        customerDTO.getCcontact(),
                        customerDTO.getCemail()
                );
                customerTMObservableList.add(tm);
                tblCustomer.setItems(customerTMObservableList);
        }
        }catch (Exception e){
        }
    }
    //set Listener------------------------------------------------------------------------
    private void setTableToData(CustomerTM customerTM) {
        txtCid.setText(customerTM.getCustId());
        txtCName.setText(customerTM.getCustName());
        txtCAdd.setText(customerTM.getCustAdd());
        txtCCont.setText(customerTM.getCustCont()+"");
        txtCEmail.setText(customerTM.getCustEmail());
    }
    private void loadId() throws Exception {
        String id = customerBO.getListener();
        txtCid.setText(id);
    }
    //Crud-Operation =======================================================================================
    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String customerID = txtCid.getText();
        String customerName = txtCName.getText();
        String customerAdd = txtCAdd.getText();
        String customerCont = txtCCont.getText();
        String customerEmail = txtCEmail.getText();

        if(customerID.isEmpty()
                || customerName.isEmpty()
                || customerAdd.isEmpty()
                || customerCont.isEmpty()
                || customerEmail.isEmpty()){
            util.ImgNotification("asserts/worrning.png","Empty Field","Please fill the data");
        }
        else if(!(customerID.matches("^[C]\\d{3}$"))){
            util.ImgNotification("asserts/regex.png","Invalid","Customer id format");
            try {
                util.textFocusColor(txtCid);
            } catch (Exception e) {
            }
        }else if (!(customerName.matches("[A-z 0-9]+"))){
            util.ImgNotification("asserts/regex.png","Invalid","Customer name format");
            try {
                util.textFocusColor(txtCName);
            } catch (Exception e) {
            }
        }else if (!(customerAdd.matches("[A-z 0-9,]+"))){
            util.ImgNotification("asserts/regex.png","Invalid","Customer address format");
            try {
                util.textFocusColor(txtCAdd);
            } catch (Exception e) {
            }
        }else if (!(customerCont.matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]"))){
            util.ImgNotification("asserts/regex.png","Invalid","Customer contact format");
            try {
                util.textFocusColor(txtCCont);
            } catch (Exception e) {
            }
        }else if (!(customerEmail.matches("^(.+)@(.+)$"))){
            util.ImgNotification("asserts/regex.png","Invalid","Customer email format");
            try {
                util.textFocusColor(txtCEmail);
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
                        if (customerBO.deleteCustomer(txtCid.getText())) {
                            util.ImgNotification("asserts/ok.png", "Success", "Customer deleted");
                            loadCustomer();
                            ClearTxt();
                            sumCust();
                            return;
                        }
                        util.ImgNotification("asserts/wrong.png", "UnSuccess", "Customer not deleted");
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
        String customerID = txtCid.getText();
        String customerName = txtCName.getText();
        String customerAdd = txtCAdd.getText();
        String customerCont = txtCCont.getText();
        String customerEmail = txtCEmail.getText();

        if(customerID.isEmpty()
                || customerName.isEmpty()
                || customerAdd.isEmpty()
                || customerCont.isEmpty()
                || customerEmail.isEmpty()){
            util.ImgNotification("asserts/worrning.png","Empty Field","Please fill the data");
        }
        else if(!(customerID.matches("^[C]\\d{3}$"))){
            util.ImgNotification("asserts/regex.png","Invalid","Customer id format");
            try {
                util.textFocusColor(txtCid);
            } catch (Exception e) {
            }
        }else if (!(customerName.matches("[A-z 0-9]+"))){
            util.ImgNotification("asserts/regex.png","Invalid","Customer name format");
            try {
                util.textFocusColor(txtCName);
            } catch (Exception e) {
            }
        }else if (!(customerAdd.matches("[A-z 0-9,]+"))){
            util.ImgNotification("asserts/regex.png","Invalid","Customer address format");
            try {
                util.textFocusColor(txtCAdd);
            } catch (Exception e) {
            }
        }else if (!(customerCont.matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]"))){
            util.ImgNotification("asserts/regex.png","Invalid","Customer contact format");
            try {
                util.textFocusColor(txtCCont);
            } catch (Exception e) {
            }
        }else if (!(customerEmail.matches("^(.+)@(.+)$"))){
            util.ImgNotification("asserts/regex.png","Invalid","Customer email format");
            try {
                util.textFocusColor(txtCEmail);
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
                        if (customerBO.updateCustomer(
                                new CustomerDTO(
                                        txtCid.getText(),
                                        txtCName.getText(),
                                        txtCAdd.getText(),
                                        Integer.parseInt(txtCCont.getText()),
                                        txtCEmail.getText()
                                )
                        )
                        ) util.ImgNotification("asserts/ok.png", "Success", "Customer Updated");

                        try{
                            loadCustomer();
                        }catch (Exception e){
                        }
                        sumCust();
                        ClearTxt();
                        return;
                    }else{
                        //no
                    }
                } catch (Exception e) {
                }
            } catch (Exception e) {
            }
        }
    }
    public void btnSaveOnAction(ActionEvent actionEvent) {
        String customerID = txtCid.getText();
        String customerName = txtCName.getText();
        String customerAdd = txtCAdd.getText();
        String customerCont = txtCCont.getText();
        String customerEmail = txtCEmail.getText();

        if(customerID.isEmpty()
                || customerName.isEmpty()
                || customerAdd.isEmpty()
                || customerCont.isEmpty()
                || customerEmail.isEmpty()){
            util.ImgNotification("asserts/worrning.png","Empty Field","Please fill the data");
        }
        else if(!(customerID.matches("^[C]\\d{3}$"))){
            util.ImgNotification("asserts/regex.png","Invalid","Customer id format");
            try {
                util.textFocusColor(txtCid);
            } catch (Exception e) {
            }
        }else if (!(customerName.matches("[A-z 0-9]+"))){
            util.ImgNotification("asserts/regex.png","Invalid","Customer name format");
            try {
                util.textFocusColor(txtCName);
            } catch (Exception e) {
            }
        }else if (!(customerAdd.matches("[A-z 0-9,]+"))){
            util.ImgNotification("asserts/regex.png","Invalid","Customer address format");
            try {
                util.textFocusColor(txtCAdd);
            } catch (Exception e) {
            }
        }else if (!(customerCont.matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]"))){
            util.ImgNotification("asserts/regex.png","Invalid","Customer contact format");
            try {
                util.textFocusColor(txtCCont);
            } catch (Exception e) {
            }
        }else if (!(customerEmail.matches("^(.+)@(.+)$"))){
            util.ImgNotification("asserts/regex.png","Invalid","Customer email format");
            try {
                util.textFocusColor(txtCEmail);
            } catch (Exception e) {
            }
        }else {
            try {
                boolean isSupplierSaved = customerBO.saveCustomer(
                        new CustomerDTO(
                                txtCid.getText(),
                                txtCName.getText(),
                                txtCAdd.getText(),
                                Integer.parseInt(txtCCont.getText()),
                                txtCEmail.getText()
                        )
                );
                if (isSupplierSaved==true){
                    util.ImgNotification("asserts/ok.png", "Success", "Customer Saved");
                }else {
                    System.out.println("no");
                }
                ClearTxt();
                loadCustomer();
                sumCust();
            } catch (Exception e) {
            }
        }
    }
    //Searching =======================================================================================
    private void getCustSearching() {
        try {
            cusArr = new ArrayList<>();
            cussearch = customerBO.getAllCustomer();
            for (CustomerDTO customerDTO : cussearch) {
                cusArr.add(customerDTO.getCcontact()+"");
            }
        } catch (Exception e) {
        }
    }
    private void searchCont() {
        TextFields.bindAutoCompletion(txtSeaCont, cusArr);
    }
    public void txtSeaContOnAction(ActionEvent actionEvent) {
        try {
            CustomerDTO customerDTO = customerBO.getCustCont(txtSeaCont.getText());
            if (customerDTO != null) {
                txtCid.setText(customerDTO.getCid());
                txtCName.setText(customerDTO.getCname());
                txtCAdd.setText(customerDTO.getCaddress());
                txtCCont.setText(customerDTO.getCcontact()+"");
                txtCEmail.setText(customerDTO.getCemail());
            }
        } catch (Exception e) {
        }
    }
    public void txtCIdOnAction(ActionEvent actionEvent) {
        try {
            CustomerDTO customerDTO = customerBO.searchCustomer(txtCid.getText());
            if (customerDTO != null) {
                txtCid.setText(customerDTO.getCid());
                txtCName.setText(customerDTO.getCname());
                txtCAdd.setText(customerDTO.getCaddress());
                txtCCont.setText(customerDTO.getCcontact()+"");
                txtCEmail.setText(customerDTO.getCemail());
            }
        } catch (Exception e) {
        }
    }
    //Clear-data===============================================================================
    public void ClearTxt(){
        txtCid.setText(null);
        txtCName.setText(null);
        txtCAdd.setText(null);
        txtCCont.setText(null);
        txtCEmail.setText(null);
        txtSeaCont.setText(null);
    }
    //Set-Product-Id===============================================================================
    public void setCustId() {
        try {
            int CustID = customerBO.getCustCount();
            if (CustID==0){
                txtCid.setText("C001");
            }
            if (CustID>0 && CustID<=8){
                txtCid.setText("C00"+(CustID+1));
            }
            if (CustID>=9 && CustID<=98){
                txtCid.setText("C0"+(CustID+1));
            }
            if (CustID>=99){
                txtCid.setText("C"+(CustID+1));
            }
        } catch (Exception e) {
        }
    }
    //Sum-Count--------------------------------------------------------
    public void sumCust() throws Exception {
        int tot = customerBO.getCustCount();
        lblTotCust.setText(String.valueOf(tot));
    }
}
