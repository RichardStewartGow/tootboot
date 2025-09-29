package tootboot;

import javax.swing.JButton;
import javax.swing.JToolBar;

public final class AddToToolbar {
    public JToolBar execute(JToolBar toolBar, JButton[] buttons) {
        if (buttons.length == 0) {
            return toolBar;
        }

        for(JButton button : buttons) {
            toolBar.add(button);
        }

        return toolBar;
    }

}
