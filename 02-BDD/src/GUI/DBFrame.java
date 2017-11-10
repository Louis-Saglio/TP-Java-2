package GUI;

import beans.CollCategories;

import javax.swing.*;
import java.awt.*;

public class DBFrame extends JFrame {

    private PanelData panelData = new PanelData();
    private PanelButton panelButton = new PanelButton(this);
    private CollCategories collCategories = new CollCategories();
    private String title = collCategories.infoCurseur();

    public DBFrame() {
        this.setSize(300, 100);
        this.setTitle(title);
        this.add(panelData);
        this.add(panelButton, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.panelButton.getDebutJButton().doClick();
    }

    public PanelData getPanelData() {
        return panelData;
    }

    public CollCategories getCollCategories() {
        return collCategories;
    }
}
