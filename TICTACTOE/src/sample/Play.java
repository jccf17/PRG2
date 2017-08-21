package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class Play
{
 @FXML
    Button A1;
 @FXML
    Button A2;
 @FXML
    Button A3;
 @FXML
    Button B1;
 @FXML
    Button B2;
 @FXML
    Button B3;
 @FXML
    Button C1;
 @FXML
    Button C2;
 @FXML
    Button C3;

     public void A1 (ActionEvent event) {
        if (A1.getText().toString().equals("")) {
             A1.setText("X");
             if (!A3.getText().equals(""))
                 A2.setText("0");
             else if (!C3.getText().equals(""))
                 B2.setText("0");
             else if (!C1.getText().equals(""))
                 B1.setText("0");
             else
                 A3.setText("0");
         }

     }


    public void B2(ActionEvent event) {
        if (B2.getText().toString().equals("")) {
            B2.setText("X");
            if (!B2.getText().equals(""))
                B2.setText("0");
            if (!A3.getText().equals(""))
                C3.setText("0");
            else if (!C3.getText().equals(""))
                A1.setText("0");
            else if (!C1.getText().equals(""))
                A3.setText("0");
            else if (!A1.getText().equals(""))
                C3.setText("0");
            else C3.setText("0");
        }
    }

    public void B1(ActionEvent event) {
        if (B1.getText().toString().equals("")) {
            B1.setText("X");
            if (!B2.getText().equals(""))
                B2.setText("0");
            if (!A3.getText().equals(""))
                C2.setText("0");
            else if (!A1.getText().equals(""))
                C1.setText("0");
            else if (!C1.getText().equals(""))
                A3.setText("0");
            else if (!A1.getText().equals(""))
                C3.setText("0");
            else C3.setText("0");}
    }

    public void A2(ActionEvent event) {
         if (A2.getText().toString().equals("")) {
            A2.setText("X");
             if (!B2.getText().equals(""))
                 B2.setText("0");
            if (!A3.getText().equals(""))
                C3.setText("0");
            else if (!A1.getText().equals(""))
                C1.setText("0");
            else if (!C1.getText().equals(""))
                A3.setText("0");
            else if (!A1.getText().equals(""))
                C3.setText("0");
            else C3.setText("0");}
    }

    public void C3(ActionEvent event) {
        if (C3.getText().toString().equals("")) {
            C3.setText("X");
            if (!A3.getText().equals(""))
                B3.setText("0");
            if (!C1.getText().equals(""))
                C2.setText("0");
            else if (!B3.getText().equals(""))
                A1.setText("0");
            else if (!C2.getText().equals(""))
                C1.setText("0");
            else if (!B2.getText().equals(""))
                A1.setText("0");
            else C3.setText("0");}
    }

    public void C2(ActionEvent event) {
        if (C2.getText().toString().equals("")) {
            C2.setText("X");
            if (!A2.getText().equals(""))
                B2.setText("0");
            if (!A1.getText().equals(""))
                B1.setText("0");
            else if (!C3.getText().equals(""))
                C1.setText("0");
            else if (!C2.getText().equals(""))
                C1.setText("0");
            else if (!A2.getText().equals(""))
                B2.setText("0");
            else C3.setText("0");}
    }

    public void C1(ActionEvent event) {
        if (C1.getText().toString().equals("")) {
            C1.setText("X");
            if (!A1.getText().equals(""))
                B1.setText("0");
            if (!B1.getText().equals(""))
                A1.setText("0");
            else if (!A3.getText().equals(""))
                B2.setText("0");
            else if (!C2.getText().equals(""))
                C3.setText("0");
            else if (!C3.getText().equals(""))
                C2.setText("0");
            else C3.setText("0");}
    }

    public void B3(ActionEvent event) {
        if (B3.getText().toString().equals("")) {
            B3.setText("X");
            if (!A3.getText().equals(""))
                C3.setText("0");
            if (!B2.getText().equals(""))
                B1.setText("0");
            else if (!A3.getText().equals(""))
                B2.setText("0");
            else if (!C2.getText().equals(""))
                C3.setText("0");
            else if (!C3.getText().equals(""))
                C2.setText("0");
            else C3.setText("0");}
    }

    public void A3(ActionEvent event) {
        if (A3.getText().toString().equals("")) {
            A3.setText("X");
            if (!A1.getText().equals(""))
                A2.setText("0");
            if (!A2.getText().equals(""))
                A1.setText("0");
            else if (!C3.getText().equals(""))
                B2.setText("0");
            else if (!C1.getText().equals(""))
                B2.setText("0");
            else if (!B3.getText().equals(""))
                C3.setText("0");
            else C3.setText("0");}
    }

    public void New(ActionEvent event) {
        A1.setText("");
        A2.setText("");
        A3.setText("");
        B1.setText("");
        B2.setText("");
        B3.setText("");
        C1.setText("");
        C2.setText("");
        C3.setText("");


    }

    public void Salir(ActionEvent event) {
        Platform.exit();
    }
}
