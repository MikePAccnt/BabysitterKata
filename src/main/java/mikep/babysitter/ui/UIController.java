package mikep.babysitter.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import mikep.babysitter.babysitter.BabySitterDay;
import mikep.babysitter.time.Time;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UIController implements Initializable {

    @FXML private ComboBox<String> startPeriod;
    @FXML private ComboBox<String> startHour;
    @FXML private ComboBox<String> startMinute;
    @FXML private ComboBox<String> bedPeriod;
    @FXML private ComboBox<String> bedHour;
    @FXML private ComboBox<String> bedMinute;
    @FXML private ComboBox<String> endPeriod;
    @FXML private ComboBox<String> endHour;
    @FXML private ComboBox<String> endMinute;
    @FXML private Button payBtn;
    @FXML private Label payLabel;

    @FXML private AnchorPane header;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        header.setEffect(getDropShadow());
        initChoices();
        initPayBtn();
    }

    private void initChoices(){
        startPeriod.setItems(createPeriods());
        startHour.setItems(createHours());
        startMinute.setItems(createMinutes());
        bedPeriod.setItems(createPeriods());
        bedHour.setItems(createHours());
        bedMinute.setItems(createMinutes());
        endPeriod.setItems(createPeriods());
        endHour.setItems(createHours());
        endMinute.setItems(createMinutes());


        startPeriod.getSelectionModel().selectFirst();
        bedPeriod.getSelectionModel().selectFirst();
        endPeriod.getSelectionModel().selectFirst();

        startHour.getSelectionModel().selectFirst();
        bedHour.getSelectionModel().selectFirst();
        endHour.getSelectionModel().selectFirst();

        startMinute.getSelectionModel().selectFirst();
        bedMinute.getSelectionModel().selectFirst();
        endMinute.getSelectionModel().selectFirst();

    }

    private void initPayBtn(){
        payBtn.setOnMouseClicked(event -> {
            calculatePay();
        });
    }

    private void calculatePay(){

        String startTime =
                startHour.getSelectionModel().getSelectedItem() +
                ":" + startMinute.getSelectionModel().getSelectedItem() +
                startPeriod.getSelectionModel().getSelectedItem();

        String bedTime =
                bedHour.getSelectionModel().getSelectedItem() +
                ":" + bedMinute.getSelectionModel().getSelectedItem() +
                bedPeriod.getSelectionModel().getSelectedItem();

        String endTime =
                endHour.getSelectionModel().getSelectedItem() +
                ":" + endMinute.getSelectionModel().getSelectedItem() +
                endPeriod.getSelectionModel().getSelectedItem();

        Time time = new Time(startTime, bedTime, endTime);

        if(time.isValid()){
            BabySitterDay babySitterDay = new BabySitterDay(time);
            payLabel.setVisible(true);
            payLabel.setText("Pay: " + String.format("$%.2f",babySitterDay.getPay()));
        } else {
            payLabel.setVisible(true);
            payLabel.setText("Invalid times were given.");
        }

    }

    //Used by top right close button
    public void closeWindow(){
        System.exit(0);
    }

    private DropShadow getDropShadow(){
        DropShadow dropShadow = new DropShadow();
        dropShadow.setBlurType(BlurType.ONE_PASS_BOX);
        dropShadow.setColor(Color.valueOf("#5BC8AC"));
        dropShadow.setOffsetY(3);
        dropShadow.setSpread(0.3);
        return dropShadow;
    }

    private ObservableList<String> createPeriods(){
        return FXCollections.observableArrayList("PM", "AM");
    }

    private ObservableList<String> createHours(){
        return FXCollections.observableArrayList(
          "1","2","3","4","5","6","7","8","9","10","11","12"
        );
    }

    private ObservableList<String> createMinutes(){
        ArrayList<String> minutes = new ArrayList<>();

        for(int i = 0; i < 60; i++){
            if(i < 10) {
                minutes.add("0" + String.valueOf(i));
            } else {
                minutes.add(String.valueOf(i));
            }
        }

        return FXCollections.observableArrayList(minutes);

    }


}
