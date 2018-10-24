/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mqttdashboard;

import com.mqtt.app.Config;
import com.mqtt.app.controller.SubscribeController;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import mqttdashboard.services.ListViewUpdater;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 *
 * @author andremury
 */
public class DashboardController implements Initializable {

    @FXML
    Label options, low_temps, high_temps;
    @FXML
    Button exit, generalOverview, resetPanes;
    @FXML
    SplitPane mainPane;
    @FXML
    AnchorPane rightPane;
    @FXML
    ListView temps;
    ListViewUpdater lvu;
    public static SubscribeController sc;

    @FXML
    private void resetPanes(ActionEvent e) {
        lvu.reset();
        this.temps.getItems().clear();
    }

    @FXML
    private void generalOverview(ActionEvent e) throws MqttException {
        
        this.temps = lvu.updateListView();
        
    }

    @FXML
    private void exit(ActionEvent e) {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            sc = new SubscribeController();
            sc.connect();
        } catch (MqttException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

        lvu = new ListViewUpdater(this.temps);

        this.temps = lvu.updateListView();
    }



}
