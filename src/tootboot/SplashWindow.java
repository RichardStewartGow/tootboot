package tootboot;

import java.awt.Graphics;
import java.awt.SplashScreen;
import java.awt.image.BufferedImage;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.JWindow;
import javax.swing.Timer;

public final class SplashWindow extends JWindow implements ActionListener{
    SplashScreen splash;
    BufferedImage bufferedImage;
    volatile boolean firstPaint = true;
    Timer timer;

    SplashWindow(SplashScreen splash) {
        super((Window) null);
        this.splash = splash;
        try {
            bufferedImage = ImageIO.read(splash.getImageURL());
        } catch (Exception e) {
            System.out.println("Failed to load image from splash screen");
            splash.close();
        }
        setBounds(splash.getBounds());
        setAlwaysOnTop(true);
        setVisible(true);
    }

    public void paint(Graphics graphics) {
            
            graphics.drawImage(bufferedImage,0,0,null);

            if(firstPaint && isShowing()) {
                try {
                    splash.close();
                } catch(Exception e) {
                    System.out.println("Failed to close splash screen");
                }

                firstPaint = false;
                timer = new Timer(50, this);
                timer.start();
            }
    }

    public void actionPerformed(ActionEvent event) {
        float opacity = getOpacity();
        opacity -= 0.05f;
        if(opacity <= 0.0f) {
            this.setVisible(false);
            timer.stop();
        } else {
            setOpacity(opacity);
            repaint();
        }
    }
}
