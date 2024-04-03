package controller;

import domain.Vector;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;

import java.util.Optional;

public class DivideConquerController {
    @javafx.fxml.FXML
    private Pane buttonsPane;
    @javafx.fxml.FXML
    private TextArea textArea;
    @javafx.fxml.FXML
    private TextField nTextField;
    private Alert alert;
    private Vector vector;

    @javafx.fxml.FXML
    public void initialize() {
        alert = util.UtilityFX.alert("Vector Algorithm", "There was an error");
        alert.setAlertType(Alert.AlertType.ERROR);
    }

    private boolean isValid() {
        return !nTextField.getText().isEmpty() && Integer.valueOf(this.nTextField.getText()) > 0;
    }

    @javafx.fxml.FXML
    public void createOnAction(ActionEvent actionEvent) {
        if (isValid()) {
            vector = new Vector(Integer.valueOf(this.nTextField.getText()));
            this.textArea.setText("The vector has been created for "
                    + Integer.valueOf(this.nTextField.getText()) + " elements");
            this.buttonsPane.setDisable(false); //habilita el panel de botones
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Please complete the info and try again...");
            alert.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void clearOnAction(ActionEvent actionEvent) {
        if (vector != null) {
            vector.clear();
            this.textArea.setText("The vector has been cleared.");
        }
    }

    @javafx.fxml.FXML
    public void fillShowOnAction(ActionEvent actionEvent) {
        if (vector != null) {
            vector.sort();
            this.textArea.setText(vector.toString());
        }
    }

    @javafx.fxml.FXML
    public void removeByIndexOnAction(ActionEvent actionEvent) {
        if (vector != null) {
            TextInputDialog dialog = util.UtilityFX.dialog("Vector - Remove by index", "Enter the index to remove");
            dialog.setTitle("Vector - Remove by Index");
            Optional<String> result = dialog.showAndWait();
            if ((result.isPresent()) && (result.get().compareTo("") != 0)) {
                int index = Integer.parseInt(result.get());
                Object removed = vector.remove(index);
                if (removed != null) {
                    this.textArea.setText("Element at index " + index + " removed: " + removed + "\n" + vector.toString());
                } else {
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText("Invalid index...");
                    alert.showAndWait();
                }
            }
        }
    }

    @javafx.fxml.FXML
    public void addByIndexOnAction(ActionEvent actionEvent) {
        if (vector != null) {
            TextInputDialog dialog = util.UtilityFX.dialog("Vector - Add by index", "Enter the index to add");
            dialog.setTitle("Vector - Add by Index");
            Optional<String> indexResult = dialog.showAndWait();
            if ((indexResult.isPresent()) && (indexResult.get().compareTo("") != 0)) {
                int index = Integer.parseInt(indexResult.get());
                dialog = util.UtilityFX.dialog("Vector - Add by index", "Enter the element to add");
                dialog.setTitle("Vector - Add by Index");
                Optional<String> valueResult = dialog.showAndWait();
                if ((valueResult.isPresent()) && (valueResult.get().compareTo("") != 0)) {
                    int value = Integer.parseInt(valueResult.get());
                    vector.add(index, value);
                    this.textArea.setText("Element " + value + " added at index " + index + ":\n" + vector.toString());
                }
            }
        }
    }

    @javafx.fxml.FXML
    public void containsOnAction(ActionEvent actionEvent) {
        if (vector != null) {
            TextInputDialog dialog = util.UtilityFX.dialog("Vector - Contains", "Enter the element to search");
            dialog.setTitle("Vector - Contains");
            Optional<String> result = dialog.showAndWait();
            if ((result.isPresent()) && (result.get().compareTo("") != 0)) {
                int value = Integer.parseInt(result.get());
                boolean contains = vector.contains(value);
                if (contains) {
                    this.textArea.setText("The vector contains the element: " + value);
                } else {
                    this.textArea.setText("The vector does not contain the element: " + value);
                }
            }
        }
    }

    @javafx.fxml.FXML
    public void removeByValueOnAction(ActionEvent actionEvent) {
        if (vector != null) {
            TextInputDialog dialog = util.UtilityFX.dialog("Vector - Remove by value", "Enter the element to remove");
            dialog.setTitle("Vector - Remove by Value");
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent() && !result.get().isEmpty()) {
                int value = Integer.parseInt(result.get());
                boolean removed = (vector.remove(value) != null); // Verifica si el elemento fue eliminado correctamente
                if (removed) {
                    this.textArea.setText("Element " + value + " removed from vector:\n" + vector.toString());
                } else {
                    this.textArea.setText("Element " + value + " not found in vector.");
                }
            }
        }
    }




    @javafx.fxml.FXML
    public void addByValueOnAction(ActionEvent actionEvent) {
        if (vector != null) {
            TextInputDialog dialog = util.UtilityFX.dialog("Vector - Add by value", "Enter the element to add");
            dialog.setTitle("Vector - Add by Value");
            Optional<String> result = dialog.showAndWait();
            if ((result.isPresent()) && (result.get().compareTo("") != 0)) {
                int value = Integer.parseInt(result.get());
                vector.add(value);
                this.textArea.setText("Element " + value + " added to vector:\n" + vector.toString());
            }
        }
    }

    @javafx.fxml.FXML
    public void sizeOnAction(ActionEvent actionEvent) {
        if (vector != null) {
            this.textArea.setText("The size of the vector is: " + vector.size());
        }
    }
}




