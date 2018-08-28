/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mqtt.app;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author andremury
 */
public class Subscriber {

    /**
     * @var client This is the client instance of the MQTT.
     */
    MqttClient client;
    /**
     * @var msg This is the message that will be published.
     */
    private String serverURI = "tcp://localhost:4444";
    /**
     * @var cliendId This will be the unique ID generated for the client
     * connection.
     */
    private String clientId = MqttClient.generateClientId();

    /**
     * This is the class constructor that will initialize every dependency and
     * parts needed to the class.
     *
     * @throws MqttException
     */
    public Subscriber() throws MqttException {
        client = new MqttClient(serverURI, clientId);
        client.connect();
    }
}
