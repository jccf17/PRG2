package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

public class Final {
    @FXML
    Label total;
    @FXML
    Button btnVolver;

    double tot, pu, st;
    int c;

    public void calcularTotal(double subtotal) {
        tot = subtotal*1.07;
        total.setText("$"+tot);
    }

    public void enviarDatos(int cantidad, double precio_unitario, double subtotal) {
        c = cantidad;
        pu = precio_unitario;
        st = subtotal;
    }

    public void guardar(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmacion de Accion");
        alert.setHeaderText("Salvado de Datos");
        alert.setContentText("¿Esta seguro de guardar los datos?");

        Optional<ButtonType> resultado = alert.showAndWait();
        if (resultado.get() == ButtonType.OK) {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("articulos.csv", true));
                bw.write("\n\n" + c + "," + pu + "," + st + "," + tot);
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void volver(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) btnVolver.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Inicio.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
