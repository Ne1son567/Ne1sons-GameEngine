package main.java.game.graphic.JPanels;
//Java-Imports
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JPanel;


//Custom-Defined Imports
import main.java.game.entities.drawingObjects.Rectangle;
import main.java.game.entities.GameObject;
import main.java.game.entities.drawingObjects.DrawnObject;
import main.java.game.entities.drawingObjects.Ellipse;



public class GameJPanel extends JPanel
{
    private float gameJPanelXSize;
    private float gameJPanelYSize;
    
    private ArrayList<Object> allGameObjects = new ArrayList<Object>();//gameobjekte -> Ellipsen und Rechtecke
    
    public GameJPanel (float _gameJPanelXSize, float _gameJPanelYSize)
    {
        this.gameJPanelXSize = _gameJPanelXSize;
        this.gameJPanelYSize = _gameJPanelYSize;
        setLayout(null);
        
        setBounds(0,0,(int)gameJPanelXSize,(int)gameJPanelYSize);
        setBackground(Color.GRAY);
        setOpaque(false);
        //setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.red), BorderFactory.createEmptyBorder(10,10,10,10)));
        
        //new Rectangle(101, 101, 200, 200, true);
        //new Rectangle(51, 51, 100, 100, true);
        //new Ellipse(51,51,100,100, true);
        //new Ellipse(101,101,200,200, true);
        //new Ellipse(51,151,100,100, true);
        //GameObject gameobject = new GameObject(2, "Player",);
        //gameobject.addEntitie(new Rectangle(10,10,10,10,true));
        //gameobject.addEntitie(new Ellipse(20,10,10,10,true));
        //allGameObjects.add(gameobject);
        

    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = ((Graphics2D) (g));
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2D.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2D.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
       
        renderAllObjects(g2D);
    }
    public void renderAllObjects(Graphics2D g2D)
    {
        
        for(int i = 0; i < allGameObjects.size(); i++)
        {
           
            if(allGameObjects.get(i) instanceof DrawnObject)
            {
                ((DrawnObject) allGameObjects.get(i)).render(g2D);
            }
            if(allGameObjects.get(i) instanceof GameObject)
            {
                ((GameObject) allGameObjects.get(i)).render(g2D);
            }
            
            
        }
        
    }

    public ArrayList<Object> getAllGameObjects()
    {
        return allGameObjects;
    }
    public void addToAllGameObjects(Object _obj)
    {
        allGameObjects.add(_obj);
    }
}
