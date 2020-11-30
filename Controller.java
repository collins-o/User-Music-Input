package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Controller {

    @FXML
    private GridPane gridPaneInfo;
    @FXML
    private TextField nameField;

    @FXML
    private TextField streetField;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField stateTextField;

    @FXML
    private TextField zipTextField;

    @FXML
    private Label choiceLabel;

    @FXML
    private ChoiceBox chooseOne;

    @FXML
    private CheckBox appCheckBox;

    @FXML
    private CheckBox musicCheckBox;

    @FXML
    private Label radioLabel;

    @FXML
    private RadioButton gameRadioButton;

    @FXML
    private RadioButton productivityRadioButton;

    @FXML
    private RadioButton educationRadioButton;

    @FXML
    private ToggleGroup colorToggleGroup;

    @FXML
    private TextField titleTextField;

    @FXML
    private DatePicker deadlinePicker;

    @FXML
    private TextField accountTextField;

    @FXML
    private Button submitButton;

    @FXML
    private Button finishButton;

    @FXML
    private Label requiredLabel;

    Path path2 = Paths.get(filename2);
    Path path = Paths.get(filename);
    private static String filename2 = "music.txt";
    private static String filename = "app.txt";

    @FXML
    public void appButtonClicked() {

        if (appCheckBox.isSelected()) {
            chooseOne.setDisable(true);
            choiceLabel.setDisable(true);
        }
        else if (!appCheckBox.isSelected()) {
            chooseOne.setDisable(false);
            choiceLabel.setDisable(false);
        }

    }
    @FXML
    public void musicButtonClicked() {

        if (musicCheckBox.isSelected()) {
            appCheckBox.setDisable(true);
            radioLabel.setDisable(true);
            gameRadioButton.setDisable(true);
            productivityRadioButton.setDisable(true);
            educationRadioButton.setDisable(true);

        }
        else if (!musicCheckBox.isSelected()) {
            appCheckBox.setDisable(false);
            radioLabel.setDisable(false);
            gameRadioButton.setDisable(false);
            productivityRadioButton.setDisable(false);
            educationRadioButton.setDisable(false);
        }
    }

    @FXML
    public void submitButtonClicked(ActionEvent e) throws IOException {

        if (appCheckBox.isSelected()) {

            File file = new File("app.txt");
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fr);
            RadioButton rb = (RadioButton) colorToggleGroup.getSelectedToggle();

            if (nameField.getText().trim().isEmpty()){
                nameField.requestFocus();
            }
            if (streetField.getText().trim().isEmpty()){
                streetField.requestFocus();
            }
            if (cityTextField.getText().trim().isEmpty()){
                cityTextField.requestFocus();
            }
            if (stateTextField.getText().trim().isEmpty()){
                stateTextField.requestFocus();
            }
            if (zipTextField.getText().trim().isEmpty()){
                zipTextField.requestFocus();
            }
            /*if (rb.getText().trim().isEmpty()){
                radioLabel.requestFocus();
            }*/
            if (colorToggleGroup.getSelectedToggle().equals(null)){

                radioLabel.requestFocus();
            }
            if (titleTextField.getText().trim().isEmpty()){
                titleTextField.requestFocus();
            }
            if (deadlinePicker.getValue()==null){
                deadlinePicker.requestFocus();
                //dateLabel.setTextFill(Paint.valueOf("red"));
            }

            if (accountTextField.getText().trim().isEmpty()){
                accountTextField.requestFocus();

            }

            if (!nameField.getText().trim().isEmpty() && !streetField.getText().trim().isEmpty() &&
                    !cityTextField.getText().trim().isEmpty() && !stateTextField.getText().trim().isEmpty()
                    && !zipTextField.getText().trim().isEmpty() && !titleTextField.getText().trim().isEmpty()
                    && !colorToggleGroup.getSelectedToggle().toString().trim().isEmpty() && deadlinePicker.getValue()!=null
                    && !accountTextField.getText().trim().isEmpty()){

                bw.write(String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s",nameField.getText().trim(),
                        streetField.getText(), cityTextField.getText(),stateTextField.getText(),
                        zipTextField.getText(), rb.getText(), titleTextField.getText(),
                        deadlinePicker.getValue(),accountTextField.getText()));
                bw.newLine();
                bw.close();
                fr.close();
                nameField.clear();
                streetField.clear();
                cityTextField.clear();
                stateTextField.clear();
                zipTextField.clear();
                titleTextField.clear();
                deadlinePicker.setValue(null);
                accountTextField.clear();
                appCheckBox.setSelected(false);
                rb.setSelected(false);
                productivityRadioButton.setSelected(false);
                gameRadioButton.setSelected(false);
                educationRadioButton.setSelected(false);
                musicCheckBox.setDisable(false);

            }
            else {
                Runnable task = new Runnable() {
                    @Override
                    public void run() {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                requiredLabel.setText("*required fields");
                                chooseOne.setDisable(true);
                                choiceLabel.setDisable(true);
                            }
                        });
                    }
                };
                new Thread(task).start();
            }
            if (nameField.getText().trim().isEmpty()){
                nameField.requestFocus();
                requiredLabel.setText("");
                chooseOne.setDisable(false);
                choiceLabel.setDisable(false);
            }

        }

        else if (musicCheckBox.isSelected()) {
            File file = new File("music.txt");
            FileWriter fr2 = new FileWriter(file, true);
            BufferedWriter bw2 = new BufferedWriter(fr2);
            if (nameField.getText().trim().isEmpty()){
                nameField.requestFocus();
            }
            if (streetField.getText().trim().isEmpty()){
                streetField.requestFocus();
            }
            if (cityTextField.getText().trim().isEmpty()){
                cityTextField.requestFocus();
            }
            if (stateTextField.getText().trim().isEmpty()){
                stateTextField.requestFocus();
            }
            if (zipTextField.getText().trim().isEmpty()){
                zipTextField.requestFocus();
            }
            if (chooseOne.getValue().toString().trim().startsWith("C")){
                chooseOne.requestFocus();
            }
            if (titleTextField.getText().trim().isEmpty()){
                titleTextField.requestFocus();
            }
            if (deadlinePicker.getValue()==null){
                deadlinePicker.requestFocus();
            }
            if (accountTextField.getText().trim().isEmpty()){
                accountTextField.requestFocus();
            }
            if (!nameField.getText().trim().isEmpty() && !streetField.getText().trim().isEmpty() &&
                    !cityTextField.getText().trim().isEmpty() && !stateTextField.getText().trim().isEmpty()
                    && !zipTextField.getText().trim().isEmpty() && !titleTextField.getText().trim().isEmpty()
                    && !chooseOne.getValue().toString().trim().startsWith("C") && deadlinePicker.getValue()!=null
                    && !accountTextField.getText().trim().isEmpty()){

                bw2.write(String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s",nameField.getText(),streetField.getText(),
                        cityTextField.getText(),stateTextField.getText(),zipTextField.getText(), chooseOne.getValue().toString(),
                        titleTextField.getText(), deadlinePicker.getValue(),accountTextField.getText()));
                bw2.newLine();
                bw2.close();
                fr2.close();
                nameField.clear();
                streetField.clear();
                cityTextField.clear();
                stateTextField.clear();
                zipTextField.clear();
                titleTextField.clear();
                deadlinePicker.setValue(null);
                accountTextField.clear();
                musicCheckBox.setSelected(false);
                appCheckBox.setDisable(false);

            }
            else {
                Runnable task = new Runnable() {
                    @Override
                    public void run() {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                requiredLabel.setText("*required fields");
                                appCheckBox.setDisable(true);
                                radioLabel.setDisable(true);
                                gameRadioButton.setDisable(true);
                                productivityRadioButton.setDisable(true);
                                educationRadioButton.setDisable(true);
                            }
                        });
                    }
                };
                new Thread(task).start();
            }
            if (nameField.getText().trim().isEmpty()){
                nameField.requestFocus();
                requiredLabel.setText("");
                appCheckBox.setDisable(false);
                radioLabel.setDisable(false);
                gameRadioButton.setDisable(false);
                productivityRadioButton.setDisable(false);
                educationRadioButton.setDisable(false);
            }
        }
    }

    @FXML
    public void finishButtonClicked() {
        Stage stage = (Stage) finishButton.getScene().getWindow();
        stage.close();
    }
}
