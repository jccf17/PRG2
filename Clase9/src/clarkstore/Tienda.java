package clarkstore;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Tienda implements Initializable {
    @FXML TextField txtmonto;
    @FXML ComboBox<String> cbTalla;
    @FXML Spinner<Integer> spCantidad;
    @FXML Label subtotal;
    @FXML RadioButton rbTildencap;
    @FXML RadioButton rbVanekaprom;
    @FXML RadioButton rbTunsilmid;
    @FXML RadioButton rbTrikenlace;
    @FXML Button btnpagar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbTalla.getItems().addAll(
                "SELECCIONA UNA TALLA"
        );
        cbTalla.setValue("SELECCIONA UNA TALLA");

        ObservableList<Integer> cantidad = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10);
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<Integer>(cantidad);
        valueFactory.setValue(1);
        spCantidad.setValueFactory(valueFactory);

    }
    public void limpiar(ActionEvent actionEvent) {
        subtotal.setText("Subtotal: $0.00");
        cbTalla.setValue("SELECCIONA UNA TALLA");
        txtmonto.setText("0.00");
        ObservableList<Integer> cantidad = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10);
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<Integer>(cantidad);
        valueFactory.setValue(1);
        spCantidad.setValueFactory(valueFactory);
    }

    public void pagar (ActionEvent actionEvent) throws IOException {
        int Cant=0;
        itbm=st*0.07;
        Cant=spCantidad.getValue();
        double tot = Double.parseDouble(subtotal.getText());
        if (!cbTalla.getItems().isEmpty()) {
            Stage stage = (Stage) btnpagar.getScene().getWindow();
            FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Pago.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Pago controller = fxmlLoader.getController();
            controller.total(tot);
            controller.subtotal(st);
            controller.itbms(st);
            controller.efectivo(mont);
            controller.cambio(vuelto);
            controller.modelo(model);
            controller.cantidad(Cant);
            controller.itbms(itbm);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    String model;
    double itbm=0;

    public void seleccionar_Tunsilmid(Event event) {
        model="Tunsil Mid";
        rbTunsilmid.setSelected(true);
        cbTalla.getItems().clear();
        subtotal.setText("");

        cbTalla.getItems().addAll(
                "Size 8", "Size 8 1/2", "Size 9", "Size 9 1/2", "Size 10", "Size 10 1/2", "Size 11", "Size 12"
                );
        cbTalla.setValue("SELECCIONA UNA TALLA");
        subtotal.setText("Sub-total: $85.00");
    }

    public void seleccionar_Trikenlace(Event event) {
        model="Triken Lace";
        rbTrikenlace.setSelected(true);
        cbTalla.getItems().clear();
        cbTalla.getItems().addAll(
                "Size 8", "Size 8 1/2", "Size 9", "Size 9 1/2", "Size 10", "Size 10 1/2", "Size 11", "Size 12"
        );
        cbTalla.setValue("SELECCIONA UNA TALLA");
        subtotal.setText("Sub-total: $100.00");
    }
    public void seleccionar_Vanekaprom(Event event) {
        model="Vanek Aprom";
        rbVanekaprom.setSelected(true);
        cbTalla.getItems().clear();
        subtotal.setText("");

        cbTalla.getItems().addAll(
                "Size 8", "Size 8 1/2", "Size 9", "Size 9 1/2", "Size 10", "Size 10 1/2", "Size 11", "Size 12"
        );
        cbTalla.setValue("SELECCIONA UNA TALLA");
        subtotal.setText("Sub-total: $90.00");
    }

    public void seleccionar_Tildencap(Event event) {
        model="Tilden Cap";
        rbTildencap.setSelected(true);
        cbTalla.getItems().clear();
        cbTalla.getItems().addAll(
                "Size 8", "Size 8 1/2", "Size 9", "Size 9 1/2", "Size 10", "Size 10 1/2", "Size 11", "Size 12"
        );
        cbTalla.setValue("SELECCIONA UNA TALLA");
        subtotal.setText("Sub-total: $95.00");
    }
    double mont=0;
    double vuelto=0;
    public void validarmonto(KeyEvent keyEvent) {
        try {
            mont= Double.parseDouble(txtmonto.getText());
        } catch (Exception e1) {
            try {
                mont = Double.parseDouble(txtmonto.getText() + "0");
            } catch (Exception e2) {
                txtmonto.setText("");
                mont=-1;
            }
        }


        if (mont != -1 && mont>(st*0.07))
        { vuelto= mont - (st + (st * 0.07));}
    }

    double st=0;
    public void recalcular(ActionEvent actionEvent) {
        if (rbTildencap.isSelected()) {
            switch (cbTalla.getValue()) {
                case "Size 8":
                    st = 90.00 * spCantidad.getValue();
                    break;
                case "Size 8 1/2":
                    st = 90.00 * spCantidad.getValue();
                    break;
                case "Size 9":
                    st = 90.00 * spCantidad.getValue();
                    break;
                case "Size 9 1/2":
                    st = 90.00 * spCantidad.getValue();
                    break;
                case "Size 10":
                    st = 95.00 * spCantidad.getValue();
                    break;
                case "Size 10 1/2":
                    st = 95.00 * spCantidad.getValue();
                    break;
                case "Size 11":
                    st = 95.00 * spCantidad.getValue();
                    break;
                case "Size 12":
                    st = 95.00 * spCantidad.getValue();
                    break;
                case "SELECCIONA UNA TALLA":
                    break;
            }
        }
        if (rbTunsilmid.isSelected()) {
            switch (cbTalla.getValue()) {
                case "Size 8":
                    st = 80.00 * spCantidad.getValue();
                    break;
                case "Size 8 1/2":
                    st = 80.00 * spCantidad.getValue();
                    break;
                case "Size 9":
                    st = 80.00 * spCantidad.getValue();
                    break;
                case "Size 9 1/2":
                    st = 80.00 * spCantidad.getValue();
                    break;
                case "Size 10":
                    st = 85.00 * spCantidad.getValue();
                    break;
                case "Size 10 1/2":
                    st = 85.00 * spCantidad.getValue();
                    break;
                case "Size 11":
                    st = 85.00 * spCantidad.getValue();
                    break;
                case "Size 12":
                    st = 85.00 * spCantidad.getValue();
                    break;
            }
            }
        if (rbTrikenlace.isSelected()) {
            switch (cbTalla.getValue()) {
                case "Size 8":
                    st = 95.00 * spCantidad.getValue();
                    break;
                case "Size 8 1/2":
                    st = 95.00 * spCantidad.getValue();
                    break;
                case "Size 9":
                    st = 95.00 * spCantidad.getValue();
                    break;
                case "Size 9 1/2":
                    st = 95.00 * spCantidad.getValue();
                    break;
                case "Size 10":
                    st = 100.00 * spCantidad.getValue();
                    break;
                case "Size 10 1/2":
                    st = 100.00 * spCantidad.getValue();
                    break;
                case "Size 11":
                    st = 100.00 * spCantidad.getValue();
                    break;
                case "Size 12":
                    st = 100.00 * spCantidad.getValue();
                    break;
            }
        }
        if (rbVanekaprom.isSelected()) {
            switch (cbTalla.getValue()) {
                case "Size 8":
                    st = 85.00 * spCantidad.getValue();
                    break;
                case "Size 8 1/2":
                    st = 85.00 * spCantidad.getValue();
                    break;
                case "Size 9":
                    st = 85.00 * spCantidad.getValue();
                    break;
                case "Size 9 1/2":
                    st = 85.00 * spCantidad.getValue();
                    break;
                case "Size 10":
                    st = 90.00 * spCantidad.getValue();
                    break;
                case "Size 10 1/2":
                    st = 90.00 * spCantidad.getValue();
                    break;
                case "Size 11":
                    st = 90.00 * spCantidad.getValue();
                    break;
                case "Size 12":
                    st = 90.00 * spCantidad.getValue();
                    break;
            }
        }
        subtotal.setText(String.valueOf(st+(st*0.07)));
    }
}
