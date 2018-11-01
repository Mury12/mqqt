package com.mqtt.app;

import com.mqtt.app.controller.PublishController;
import com.mqtt.app.controller.SensorController;
import com.mqtt.app.controller.SubThread;
import java.util.Scanner;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 *
 * @author andremury
 */
public class Start {

    public static SensorController sc = new SensorController();

    public static void main(String[] args) throws InterruptedException, MqttException {
        System.out.println(System.getProperty("os.name"));
        PublishController pc;
//        GUI.go(args);
        Scanner s = new Scanner(System.in);
        if (Config.getLocation() == null) {
            System.out.println("Set the Localtion Name\n**Make Sure this is unique**: ");
            Config.setLocation(s.next());
        }
        if (Config.getMachineName() == null) {
            System.out.println("Set the machine Name\n**Make Sure this is unique in this room**: ");
            Config.setMachineName(s.next());
        }
        String topic = Config.getLocation() + "/" + Config.getMachineName() + "/temp";

        SubThread st = new SubThread();
        st.watch();
        while (true) {

            pc = new PublishController(Double.toString(sc.getCpuTemp()), topic);

            Thread.sleep(10000);

        }

    }

}