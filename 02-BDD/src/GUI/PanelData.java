package GUI;

import javax.swing.*;
import java.awt.*;

public class PanelData extends JPanel {

    private JLabel nomJLable = new JLabel("Nom : ");
    private JLabel codeJLabel = new JLabel("Code : ");

    PanelData() {
        super(new GridLayout(2, 2, 10, 10));
        this.add(new JLabel("Nom"));
        this.add(nomJLable);
        this.add(new JLabel("Code"));
        this.add(codeJLabel);
    }

    public JLabel getNomJLable() {
        return nomJLable;
    }

    public JLabel getCodeJLabel() {
        return codeJLabel;
    }
}
