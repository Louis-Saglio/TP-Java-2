package beans;

import javax.swing.*;

public class ThreadGagna implements Runnable {

    private Frame papa;

    public ThreadGagna(Frame papa) {
        this.papa = papa;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
            if (this.papa.aGagne()) {
                JOptionPane.showMessageDialog(papa, "Gagné!");
                System.exit(0);
            }
        }
    }
}
