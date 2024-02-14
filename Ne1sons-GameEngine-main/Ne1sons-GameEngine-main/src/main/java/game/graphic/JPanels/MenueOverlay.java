package main.java.game.graphic.JPanels;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenueOverlay extends JPanel
{
    public MenueOverlay()
    {
        setOpaque(false);
        this.setBackground(Color.BLACK);
        JButton exit = new JButton("E");
        this.setLayout(null);
        exit.setBounds(1340,940,50,50);
        exit.addActionListener(e -> {
            System.exit(0);
        });
        this.add(exit);
    }
}
