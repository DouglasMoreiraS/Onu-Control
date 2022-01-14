package br.com.planet.util;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;

public class TrayIconDemo {

    public void displayTray(String title, String message, Image image) throws AWTException {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        //Alternative (if the icon is on the classpath):
        //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));
        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("System tray icon demo");
        tray.add(trayIcon);

        new Thread(() -> {
            try {
                trayIcon.displayMessage(title, message, TrayIcon.MessageType.INFO);
                Thread.sleep(5000);
                tray.remove(trayIcon);
            } catch (InterruptedException e) {
            }
        }).start();
    }
}


