package tootboot;

import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SplashScreen;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


public class TootBoot {
    JFrame mainWindow;
    CreateButton createButton = new CreateButton();

    public static void main(String[] args) {

        handleStartup();

        final TootBoot tootboot = new TootBoot();

        try {
            SwingUtilities.invokeAndWait(() -> tootboot.createUI());
        } catch (Exception e) {
            e.printStackTrace();
        }

       
    }

    public void createUI() {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Error set look and feel");
        }

        mainWindow = new JFrame("TootBoot");
        GridBagLayout mainLayout = createGridBagLayout();
        GridBagConstraints mainGBCons = createGridBagConstraintsMain();
        mainWindow.setLayout(mainLayout);

        
        JToolBar toolBar = createToolBar();

        mainLayout.setConstraints(toolBar, mainGBCons);
        mainWindow.add(toolBar);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true);
        GridBagConstraints gbconsSplit = createGridBagContraintsSplit();

        mainLayout.setConstraints(splitPane, gbconsSplit);

        mainWindow.add(splitPane);

        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.pack();
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);
    }

    private GridBagLayout createGridBagLayout() {
        GridBagLayout gBagLayout = new GridBagLayout();
        
        return gBagLayout;
    }

    //@todo factory method for window condig
    private GridBagConstraints createGridBagConstraintsMain() {
        GridBagConstraints gbcons = new GridBagConstraints();

        gbcons.fill = GridBagConstraints.HORIZONTAL;
        gbcons.gridwidth = GridBagConstraints.REMAINDER;


        return gbcons;
    }

    private GridBagConstraints createGridBagContraintsSplit() {
        GridBagConstraints gbcons = new GridBagConstraints();
        gbcons.gridwidth = GridBagConstraints.REMAINDER;
        gbcons.gridheight = GridBagConstraints.REMAINDER;
        gbcons.fill = GridBagConstraints.BOTH;
        gbcons.weightx = 1;
        gbcons.weighty = 1;

        return gbcons;
    }

    private JToolBar createToolBar() {
        JToolBar toolBar = new JToolBar("tootboot.TootBoot Toolbar");
        toolBar.setMargin(new Insets(5, 5, 5, 5));
        toolBar.setFloatable(false);

        JButton refreshButton = this.createButton.execute("images/refresh.png", 16, null, "Refresh");
        refreshButton.setToolTipText("Refresh");

        return toolBar;
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