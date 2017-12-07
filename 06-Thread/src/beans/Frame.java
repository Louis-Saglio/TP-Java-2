package beans;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {

    private JButton[][] cases;
    private int nbrLignes, nbrColonnes;
    private int nbrCochees = 0;

    public Frame(int nbrLignes, int nbrColonnes) throws HeadlessException {
        this.setSize(255, 255);
        this.setTitle("Morpion");

        JPanel panel = new JPanel(new GridLayout(4, 4, 10, 10));
        this.nbrLignes = nbrLignes;
        this.nbrColonnes = nbrColonnes;
        this.cases = new JButton[this.nbrColonnes][this.nbrLignes];
        for (int i=0; i<this.nbrColonnes; i++) {
            for (int n=0; n<this.nbrLignes; n++) {
                cases[i][n] = new JButton("O");
                cases[i][n].addActionListener(this);
                panel.add(cases[i][n]);
            }
        }
        this.add(panel);
        new Thread(new ThreadGagna(this)).start();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton button = (JButton) actionEvent.getSource();
        if (button.getText().equals("O")){
            button.setText("X");
            this.nbrCochees += 1;
        } else {
            button.setText("O");
            this.nbrCochees -= 1;
        }
        this.setTitle(String.valueOf(nbrCochees));
    }

    public int getNbrCochees() {
        return nbrCochees;
    }

    private boolean colonne_is_full(int numCol) {
        System.out.println("Colonne");
        for (int i=0; i<this.nbrLignes; i++) {
            System.out.println(numCol + " " + i + " " + this.cases[numCol][i].getText());
            if (!this.cases[numCol][i].getText().equals("X")){
                return false;
            }
        }
        System.out.println(true);
        return true;
    }

    private boolean ligne_is_full(int numLigne) {
        for (int i=0; i<this.nbrColonnes; i++) {
            if (!this.cases[i][numLigne].getText().equals("X")){
                return false;
            }
        }
        return true;
    }

    public boolean aGagne() {
        for (int i=0; i<nbrColonnes; i++) {
            if (this.colonne_is_full(i)) {
                return true;
            }
        }
        for (int i=0; i<nbrLignes; i++) {
            if (!this.ligne_is_full(i)) {
                return true;
            }
        }
        return false;
    }
}
