/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mqtt.app;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * This class is responsible for managing the callback sent to the client by the server.
 * @author andremury
 */
public class SimpleMqttCallBack implements MqttCallback{
    
    /**
     * This function is responsible to set a message when the server can't be reached
     * and the connection isn't successful.
     * @param thrwbl Exception generated by the MQTT exception class.
     */
    public void connectionLost(Throwable thrwbl) {
        System.out.println("Connection lost. Trying to reconnect..");
        //reconnect()
    }

    /**
     * This function is responsible for return a message to the client when its
     * message arrives successfully.
     * @param string
     * @param mm
     * @throws Exception 
     */
    public void messageArrived(String string, MqttMessage mm) throws Exception {
        System.out.println("Message received:\n\t"+ new String(mm.getPayload()) );
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
