//Alpha-X-Computer-System
//Software Design Alpha X Software Solution
//10-16-20
package controller.dashboard;

import bo.BOFactory;
import bo.custom.ProductBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.ProductDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.textfield.TextFields;
import util.UtilImpl;
import view.tm.ProductTM;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ProductFormController implements Initializable {

    //TextField-Detail-------------------
    public JFXTextField txtProId,txtProBrand,txtProName,txtProDesc,txtProQty,txtProPrice;
    public TextField txtSearchName ;

    //Button-Detail----------------------
    public JFXButton btnSave,btnUpdate,btnDelete;

    //Label-Detail-----------------------
    public Label lblProductTot;

    //Table-Detail-----------------------
    public TableView<ProductTM>tblProduct;
    public TableColumn colId,colBrand,colName,colDesc,colQty,colPrice;

    //Property-Injection-----------------
    private ProductBO productBO = BOFactory.getInstance().getBO(BOFactory.BOType.PRODUCT);
    UtilImpl util = new UtilImpl();

    //Other----------------------------------
    private ArrayList<String> proArrayList;
    private ArrayList<ProductDTO> prodtosearch;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //table-lord--------------------------------
        colId.setCellValueFactory(new PropertyValueFactory("proID"));
        colBrand.setCellValueFactory(new PropertyValueFactory("proBrand"));
        colName.setCellValueFactory(new PropertyValueFactory("proName"));
        colDesc.setCellValueFactory(new PropertyValueFactory("proDesc"));
        colQty.setCellValueFactory(new PropertyValueFactory("proQty"));
        colPrice.setCellValueFactory(new PropertyValueFactory("proPrice"));

        tblProduct.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                        setTableToData(newValue);
                });

        try {
            loadId();
            loadProduct();
            sumProductQty();
        } catch (Exception e) {
        }

        //private-method-----------------------------
        getProductSearching();
        searchBrand();
        setProductId();
    }
    //Crud-Operation =======================================================================================
    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String productID = txtProId.getText();
        String productBrand = txtProBrand.getText();
        String productName = txtProName.getText();
        String productDesc = txtProDesc.getText();
        String productQty = txtProQty.getText();
        String productPrice = txtProPrice.getText();

        if(productID.isEmpty() || productBrand.isEmpty() || productName.isEmpty() || productDesc.isEmpty() || productQty.isEmpty() || productPrice.isEmpty()){
            util.ImgNotification("asserts/worrning.png","Inform","No product select");
        }else {
            try {
                try {
                    ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                    ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure ?", ok, no);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.orElse(no) == ok) {
                        if (productBO.deleteProduct(txtProId.getText())) {
                            util.ImgNotification("asserts/ok.png", "Success", "Product deleted");
                            loadProduct();
                            ClearTxt();
                            sumProductQty();
                            return;
                        }
                        util.ImgNotification("asserts/wrong.png", "UnSuccess", "Product not deleted");
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
        String productID = txtProId.getText();
        String productBrand = txtProBrand.getText();
        String productName = txtProName.getText();
        String productDesc = txtProDesc.getText();
        String productQty = txtProQty.getText();
        String productPrice = txtProPrice.getText();

        if(productID.isEmpty() || productBrand.isEmpty() || productName.isEmpty() || productDesc.isEmpty() || productQty.isEmpty() || productPrice.isEmpty()){
            util.ImgNotification("asserts/worrning.png","Empty Field","Please fill the data");
        }
        else if(!(productID.matches("^[P]\\d{3}$"))){
            util.ImgNotification("asserts/regex.png","Invalid","Product id format");
            try {
                util.textFocusColor(txtProId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (!(productBrand.matches("[A-z 0-9]+"))){
            util.ImgNotification("asserts/regex.png","Invalid","Product brand format");
            try {
                util.textFocusColor(txtProBrand);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (!(productName.matches("[A-z 0-9]+"))){
            util.ImgNotification("asserts/regex.png","Invalid","Product name format");
            try {
                util.textFocusColor(txtProName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (!(productDesc.matches("[a-z A-Z 0-9,]+"))){
            util.ImgNotification("asserts/regex.png","Invalid","Product description format");
            try {
                util.textFocusColor(txtProDesc);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (!(productQty.matches("[0-9]+"))){
            util.ImgNotification("asserts/regex.png","Invalid","Product qty format");
            try {
                util.textFocusColor(txtProQty);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (!(productPrice.matches("\\d+(.\\d{1,2})?"))) {
            util.ImgNotification("asserts/regex.png","Invalid","Product price format");
            try {
                util.textFocusColor(txtProPrice);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
                try {
                    ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                    ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure ?", ok, no);
                    Optional<ButtonType> result = alert.showAndWait();
                        if (result.orElse(no) == ok) {
                            if (productBO.updateProduct(
                                    new ProductDTO(
                                            txtProId.getText(),
                                            txtProBrand.getText(),
                                            txtProName.getText(),
                                            txtProDesc.getText(),
                                            Integer.parseInt(txtProQty.getText()),
                                            Double.parseDouble(txtProPrice.getText())
                                    )
                            )
                            ) util.ImgNotification("asserts/ok.png", "Success", "Product Updated");
                            ClearTxt();
                            loadProduct();
                            sumProductQty();
                            return;
                        }else{
                        }
                    } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }
    public void btnSaveOnAction(ActionEvent actionEvent) {
        String productID = txtProId.getText();
        String productBrand = txtProBrand.getText();
        String productName = txtProName.getText();
        String productDesc = txtProDesc.getText();
        String productQty = txtProQty.getText();
        String productPrice = txtProPrice.getText();

        if(productID.isEmpty() || productBrand.isEmpty() || productName.isEmpty() || productDesc.isEmpty() || productQty.isEmpty() || productPrice.isEmpty()){
            util.ImgNotification("asserts/worrning.png","Empty Field","Please fill the data");
        }
            else if(!(productID.matches("^[P]\\d{3}$"))){
                util.ImgNotification("asserts/regex.png","Invalid","Product id format");
                try {
                    util.textFocusColor(txtProId);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                }else if (!(productBrand.matches("[A-z 0-9]+"))){
                    util.ImgNotification("asserts/regex.png","Invalid","Product brand format");
                    try {
                        util.textFocusColor(txtProBrand);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    }else if (!(productName.matches("[A-z 0-9]+"))){
                        util.ImgNotification("asserts/regex.png","Invalid","Product name format");
                        try {
                            util.textFocusColor(txtProName);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        }else if (!(productDesc.matches("[a-z A-Z 0-9,]+"))){
                            util.ImgNotification("asserts/regex.png","Invalid","Product description format");
                            try {
                                util.textFocusColor(txtProDesc);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            }else if (!(productQty.matches("[0-9]+"))){
                                util.ImgNotification("asserts/regex.png","Invalid","Product qty format");
                                try {
                                    util.textFocusColor(txtProQty);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                }else if (!(productPrice.matches("\\d+(.\\d{1,2})?"))) {
                                    util.ImgNotification("asserts/regex.png","Invalid","Product price format");
                                    try {
                                        util.textFocusColor(txtProPrice);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    }else {
                                            try {
                                                boolean isProductSaved = productBO.saveProduct(
                                                        new ProductDTO(
                                                                txtProId.getText(),
                                                                txtProBrand.getText(),
                                                                txtProName.getText(),
                                                                txtProDesc.getText(),
                                                                Integer.parseInt(txtProQty.getText()),
                                                                Double.parseDouble(txtProPrice.getText())
                                                        )
                                                );
                                                util.ImgNotification("asserts/ok.png", "Success", "Product Saved");
                                                ClearTxt();
                                                loadProduct();
                                                sumProductQty();
                                            } catch (Exception e) {
                                            }
                                    }
    }
    //Searching =======================================================================================
    private void getProductSearching() {
        try {
            proArrayList = new ArrayList<>();
            prodtosearch = productBO.getAllProduct();
            for (ProductDTO productDTO : prodtosearch) {
                proArrayList.add(productDTO.getPname());
            }
        } catch (Exception e) {
        }
    }
    private void searchBrand() {
        TextFields.bindAutoCompletion(txtSearchName, proArrayList);
    }
    //Searching set Data ===============================================================================
    public void txtSeaNameOnAction(ActionEvent actionEvent) {
        try {
            ProductDTO productDTO = productBO.searchProduct(txtSearchName.getText());
            if (productDTO != null) {
                txtProId.setText(productDTO.getPid());
                txtProBrand.setText(productDTO.getPbrand());
                txtProName.setText(productDTO.getPname());
                txtProDesc.setText(productDTO.getPdesc());
                txtProQty.setText(productDTO.getPqty()+"");
                txtProPrice.setText(productDTO.getPprice()+"");
            }
        } catch (Exception e) {
        }
    }
    public void txtProIdOnAction(ActionEvent actionEvent) {
        try {
            ProductDTO productDTO = productBO.getProId(txtProId.getText());
            if (productDTO != null) {
                txtProId.setText(productDTO.getPid());
                txtProBrand.setText(productDTO.getPbrand());
                txtProName.setText(productDTO.getPname());
                txtProDesc.setText(productDTO.getPdesc());
                txtProQty.setText(productDTO.getPqty()+"");
                txtProPrice.setText(productDTO.getPprice()+"");
            }
        } catch (Exception e) {
        }
    }
    //lord-table-data===============================================================================
    private void loadProduct() throws Exception {
        ObservableList<ProductTM> productTMObservableList = FXCollections.observableArrayList();
        List<ProductDTO> productDTOList= productBO.getAllProduct();
            for (ProductDTO productDTO : productDTOList) {
                ProductTM tm = new ProductTM(
                        productDTO.getPid(),
                        productDTO.getPbrand(),
                        productDTO.getPname(),
                        productDTO.getPdesc(),
                        productDTO.getPqty(),
                        productDTO.getPprice()
                );
                productTMObservableList.add(tm);
                tblProduct.setItems(productTMObservableList);
            }
    }
    //set Listener------------------------------------------------------------------------
    private void setTableToData(ProductTM productTM) {
        txtProId.setText(productTM.getProID());
        txtProBrand.setText(productTM.getProBrand());
        txtProName.setText(productTM.getProName());
        txtProDesc.setText(productTM.getProDesc());
        txtProQty.setText(productTM.getProQty()+"");
        txtProPrice.setText(productTM.getProPrice()+"");
    }
    private void loadId() throws Exception {
        String id = productBO.getListener();
        txtProId.setText(id);
    }
    //Clear-data===============================================================================
    public void ClearTxt(){
        txtProId.setText(null);
        txtProBrand.setText(null);
        txtProName.setText(null);
        txtProDesc.setText(null);
        txtProQty.setText(null);
        txtProPrice.setText(null);
        txtSearchName.setText(null);
    }
    //Set-Product-Id===============================================================================
    public void setProductId() {
        try {
            int ProductCount = productBO.getProCount();
            if (ProductCount==0){
                txtProId.setText("P001");
            }
            if (ProductCount>0 && ProductCount<=8){
                txtProId.setText("P00"+(ProductCount+1));
            }
            if (ProductCount>=9 && ProductCount<=98){
                txtProId.setText("P0"+(ProductCount+1));
            }
            if (ProductCount>=99){
                txtProId.setText("P"+(ProductCount+1));
            }
        } catch (Exception e) {
        }
    }
    //Sum-Count--------------------------------------------------------
    public void sumProductQty() throws Exception {
        int tot = productBO.sumProductQty();
        lblProductTot.setText(String.valueOf(tot));
    }
}
