package tootboot;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class LoadIconImage {
    ImageIcon icon = null;

    public Icon execute(String image, int targetSize) {
        if (image != null) {
            URL imgURL = getClass().getResource("/images/" + image);
            if (imgURL != null) {
                icon = new ImageIcon(imgURL);
                if (icon.getIconWidth() != targetSize || icon.getIconHeight() != targetSize) {
                    java.awt.Image scaledImage = icon.getImage().getScaledInstance(targetSize, targetSize, java.awt.Image.SCALE_SMOOTH);
                    icon = new ImageIcon(scaledImage);
                }
            } else {
                System.out.println("Couldn't find file: " + image);
            }
        }

        return icon;
    }
}
