package clarkstore;

import com.sun.deploy.association.Action;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

public class Pago implements Initializable {
    @FXML
    Label txCliente;
    @FXML
    Label factura;
    @FXML
    Label modelo;
    @FXML
    Label cantidad;
    @FXML
    Label subtotal;
    @FXML
    Label itbms;
    @FXML
    Label total;
    @FXML
    Label cambio;
    @FXML
    Label efectivo;
    @FXML
    Button btncompra;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void total(double tot) {
        total.setText(String.valueOf(tot));
    }

    public void subtotal(double st) {
        subtotal.setText(String.valueOf (st));
    }

    public void itbms(double itbm) { itbms.setText(String.valueOf(itbm)); }

    public void modelo(String model) {modelo.setText(String.valueOf(model)); }

    public void cantidad(int cant) {cantidad.setText(String.valueOf(cant)); }

    public void txCliente(TextField txtCliente) {txCliente.setText(String.valueOf(txtCliente)); }

    public void compra (ActionEvent actionEvent) throws IOException {
            Stage stage = (Stage) btncompra.getScene().getWindow();
            FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Tienda.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Tienda controller = fxmlLoader.getController();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

    public void efectivo(double mont) {efectivo.setText(String.valueOf(mont));
    }

    public void cambio(double vuelto) {cambio.setText(String.valueOf(vuelto));
    }
    public void salir(ActionEvent actionEvent) {
        Platform.exit();
    }
}





