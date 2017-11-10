package connectors;

import GUI.PanelButton;
import beans.Categorie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventListener implements ActionListener {

    private PanelButton panelButton;

    public EventListener(PanelButton panelButton) {
        this.panelButton = panelButton;
    }

    public void refresh() {
        Categorie categorie = panelButton.getDbFrame().getCollCategories().CategorieCourrante();
        panelButton.getDbFrame().getPanelData().getCodeJLabel().setText(String.valueOf(categorie.getCodeCategorie()));
        panelButton.getDbFrame().getPanelData().getNomJLable().setText(categorie.getNomCategorie());
        panelButton.getDbFrame().setTitle(panelButton.getDbFrame().getCollCategories().infoCurseur());
        if (panelButton.getDbFrame().getCollCategories().estPremier()) {
            panelButton.getDebutJButton().setEnabled(false);
            panelButton.getPrecedentJButton().setEnabled(false);
        } else {
            panelButton.getDebutJButton().setEnabled(true);
            panelButton.getPrecedentJButton().setEnabled(true);
        }
        if (panelButton.getDbFrame().getCollCategories().estDernier()) {
            panelButton.getFinJButton().setEnabled(false);
            panelButton.getSuivantJButton().setEnabled(false);
        } else {
            panelButton.getFinJButton().setEnabled(true);
            panelButton.getSuivantJButton().setEnabled(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        if (source == panelButton.getDebutJButton()){
            panelButton.getDbFrame().getCollCategories().debut();
        } else if (source == panelButton.getFinJButton()) {
            panelButton.getDbFrame().getCollCategories().fin();
        } else if (source == panelButton.getPrecedentJButton()) {
            panelButton.getDbFrame().getCollCategories().precedent();
        } else if (source == panelButton.getSuivantJButton()) {
            panelButton.getDbFrame().getCollCategories().suivant();
        }
        this.refresh();
    }
}
