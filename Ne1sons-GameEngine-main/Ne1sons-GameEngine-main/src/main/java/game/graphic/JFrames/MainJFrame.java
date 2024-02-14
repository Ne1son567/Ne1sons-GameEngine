package main.java.game.graphic.JFrames;

//Java-Imports
import javax.swing.JFrame;

//Custom-Defined Imports
import main.java.game.graphic.JPanels.GameJPanel;

public class MainJFrame extends JFrame
{
   
    private static GameJPanel gameJPanel1;
    public MainJFrame()
    {
        setTitle("mainJFrame");
        setSize(1400,1000); 
        setLayout(null);
        //setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameJPanel1 = new GameJPanel(1400,1000);
        add(gameJPanel1);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
       
    }
    
    public JFrame getmainJFrame()
    {
        return this;
    }
    public static GameJPanel getGameJPanel1()
    {
        return gameJPanel1;
    }
}
