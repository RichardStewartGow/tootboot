package tootboot;

import javax.swing.JButton;

public final class CreateButton {
    LoadIconImage loadIconImage;

    public CreateButton() {
        this.loadIconImage = new LoadIconImage();
    }

    public JButton execute(String image, int targetSize, String text, String tooltip) {
        JButton button = new JButton(text, this.loadIconImage.execute(image, targetSize));
        button.setToolTipText(tooltip);
        return button;
    }
}
