package GUI;

import connectors.EventListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelButton extends JPanel {

    private JButton debutJButton = new JButton("|<");
    private JButton finJButton = new JButton(">|");
    private JButton precedentJButton = new JButton("<");
    private JButton suivantJButton = new JButton(">");
    private DBFrame dbFrame;

    PanelButton(DBFrame dbFrame) {
        super(new GridLayout(1, 4, 10, 10));
        this.dbFrame = dbFrame;
        this.add(debutJButton);
        this.add(finJButton);
        this.add(precedentJButton);
        this.add(suivantJButton);
        ActionListener actionListener = new EventListener(this);
        this.debutJButton.addActionListener(actionListener);
        this.finJButton.addActionListener(actionListener);
        this.precedentJButton.addActionListener(actionListener);
        this.suivantJButton.addActionListener(actionListener);
    }

    public JButton getDebutJButton() {
        return debutJButton;
    }

    public JButton getFinJButton() {
        return finJButton;
    }

    public JButton getPrecedentJButton() {
        return precedentJButton;
    }

    public JButton getSuivantJButton() {
        return suivantJButton;
    }

    public DBFrame getDbFrame() {
        return dbFrame;
    }
}
