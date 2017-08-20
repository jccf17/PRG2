package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class Inicio {
    @FXML
    TextField cantidad;
    @FXML
    TextField precio_unitario;
    @FXML
    TextField subtotal;
    @FXML
    Button btnEnviar;

    int cant = -1;
    double preuni = -1.0, subt;

    public void validarCantidad(KeyEvent keyEvent) {
        try {
            cant = Integer.parseInt(cantidad.getText());
        } catch (Exception e) {
            cantidad.setText("");
            cant = -1;
        }

        if (cant != -1 && preuni != -1) {
            subtotal.setText(String.valueOf(cant*preuni));
        }
    }

    public void validarPrecio(KeyEvent keyEvent) {
        try {
            preuni = Double.parseDouble(precio_unitario.getText());
        } catch (Exception e1) {
            try {
                preuni = Double.parseDouble(precio_unitario.getText()+"0");
            } catch (Exception e2) {
                precio_unitario.setText("");
                preuni = -1;
            }
        }

        if (cant != -1 && preuni != -1) {
            subtotal.setText(String.valueOf(cant*preuni));
        }
    }

    public void enviar(ActionEvent actionEvent) throws IOException {
        subt = Double.parseDouble(subtotal.getText());
        if (!cantidad.getText().isEmpty() &&
                !precio_unitario.getText().isEmpty() &&
                !subtotal.getText().isEmpty()) {
            Stage stage = (Stage) btnEnviar.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Final.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Final controller = fxmlLoader.<Final>getController();
            controller.calcularTotal(subt);
            controller.enviarDatos(cant, preuni, subt);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void limpiar(ActionEvent actionEvent) {
        cantidad.setText("");
        precio_unitario.setText("");
        subtotal.setText("0.0");
    }

    public void salir(ActionEvent actionEvent) {
        Platform.exit();
    }
}
