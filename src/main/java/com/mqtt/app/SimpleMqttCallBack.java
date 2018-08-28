/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mqtt.app;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * This class is responsible for managing the callback sent to the client by the server.
 * @author andremury
 */
public class SimpleMqttCallBack implements MqttCallback{
    /**
     * @var client This is the client instance of the MQTT.
     */
    MqttClient client;
    /**
     * @var msg This is the message that will be published.
     */
    MqttMessage msg;
    /**
     * @var serverURI This is the URI to the server connection wanted.
     */
    private String serverURI = "tcp://localhost:4444";
    /**
     * @var cliendId This will be the unique ID generated for the client connection.
     */
    private String clientId = MqttClient.generateClientId();
    
    /**
     * This is the class constructor that will initialize every dependency and parts needed
     * to the class.
     * @throws MqttException 
     */
    public SimpleMqttCallBack() throws MqttException{
        client = new MqttClient(serverURI, clientId);
        msg    = new MqttMessage();
        msg.setPayload("Hello World from MQTT!".getBytes());
        client.publish("iot_data", msg);
        client.disconnect();
    }
    
    /**
     * This function is responsible to set a message when the server can't be reached
     * and the connection isn't successful.
     * @param thrwbl Exception generated by the MQTT exception class.
     */
    public void connectionLost(Throwable thrwbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This function is responsible for return a message to the client when its
     * message arrives successfully.
     * @param string
     * @param mm
     * @throws Exception 
     */
    public void messageArrived(String string, MqttMessage mm) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This function is responsible for showing a message to the client when everything went right
     * and the message was processed completely.
     * @param imdt Message token generated by the server.
     */
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}