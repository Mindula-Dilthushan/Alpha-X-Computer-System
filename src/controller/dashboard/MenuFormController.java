package controller.dashboard;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuFormController implements Initializable {

    public Label lblTodayCustOrd;
    public Label lblTodayProdu;
    public Label lblTodaySupOrde;
    public BorderPane borderPane0;
    public LineChart lineChart;
    public BorderPane borderPane1;
    public PieChart pieChart;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setPieChart();
        setLineChart();
    }
    private void setPieChart(){
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Employee", 5),
                        new PieChart.Data("Supplier", 10),
                        new PieChart.Data("Customer", 15),
                        new PieChart.Data("Product", 70)
                );
        pieChart.setData(pieChartData);
        pieChart.setLegendSide(Side.LEFT);

        final Label caption = new Label("");
        caption.setTextFill(Color.DARKORANGE);
        caption.setStyle("-fx-font: 24 arial;");

        for (final PieChart.Data data : pieChart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                    new EventHandler<MouseEvent>() {
                        @Override public void handle(MouseEvent e) {
                            caption.setTranslateX(e.getSceneX());
                            caption.setTranslateY(e.getSceneY());
                            caption.setText(String.valueOf(data.getPieValue()) + "%");
                        }
                    });
        }
    }
    private void setLineChart() {
        XYChart.Series s = new XYChart.Series<>();
        s.setName("Products Sell");
        s.getData().add(new XYChart.Data<>("1", 10));
        s.getData().add(new XYChart.Data<>("2", 4));
        s.getData().add(new XYChart.Data<>("3", 16));
        s.getData().add(new XYChart.Data<>("4", 20));
        s.getData().add(new XYChart.Data<>("5", 30));
        s.getData().add(new XYChart.Data<>("6", 24));
        s.getData().add(new XYChart.Data<>("7", 15));

        lineChart.getData().addAll(s);
    }
}

