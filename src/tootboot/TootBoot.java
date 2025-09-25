package tootboot;

import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.SplashScreen;


public class TootBoot {
    public static void main(String[] args) {
        handleStartup();

        System.out.println("Hello, World!!!");
    }

    static void handleStartup() {
        System.out.println("Starting TootBoot...");
        handleSplashScreen();
    }

    static void handleSplashScreen() {
        SplashScreen splash = SplashScreen.getSplashScreen();

        if(splash == null) {
            System.out.println("SplashScreen.getSplashScreen() returned null");
            return;
        }

        Graphics2D graphics2d = splash.createGraphics();
        GraphicsConfiguration graphicConfig =  graphics2d.getDeviceConfiguration();
        GraphicsDevice graphicsDevice = graphicConfig.getDevice();
        boolean transpersencySupported = graphicsDevice.isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.TRANSLUCENT);

        if (!transpersencySupported) {
            splash.close();
            return;
        }

        try {
           EventQueue.invokeAndWait(() -> new SplashWindow(splash));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}