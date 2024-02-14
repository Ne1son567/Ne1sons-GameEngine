package main.java.testProgramms;

import javax.swing.*;
import java.awt.*;

public class ZeichenPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        String formTyp = "Viereck";  // Hier den gewünschten Formtyp angeben: "Viereck" oder "Ellipse"

        if (formTyp.equals("Viereck")) {
            zeichneViereck(g, 50, 50, 100, 80);  // x, y, Breite, Höhe des Vierecks
        } else if (formTyp.equals("Ellipse")) {
            zeichneEllipse(g, 50, 50, 100, 80);  // x, y, Breite, Höhe der Ellipse
        }
    }

    private void zeichneViereck(Graphics g, int x, int y, int breite, int hoehe) {
        g.drawRect(x, y, breite, hoehe);
    }

    private void zeichneEllipse(Graphics g, int x, int y, int breite, int hoehe) {
        g.drawOval(x, y, breite, hoehe);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Formen zeichnen");
        ZeichenPanel panel = new ZeichenPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}