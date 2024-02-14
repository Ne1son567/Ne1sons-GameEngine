package main.java.game.entities.drawingObjects;


import java.awt.BasicStroke;
//Java-Imports
import java.awt.Graphics2D;

//Custom-Defined Imports

public class Ellipse extends DrawnObject
{
    public Ellipse (float _xpos, float _ypos, float _xsize, float _ysize, boolean _renderFlag, String _name)
    {
        super(_xpos,_ypos,_xsize,_ysize, _renderFlag, _name);
    }
    
    public void render(Graphics2D g2D)
    {
        
        g2D.setColor(getColor());
        g2D.fillOval((int)getXPos(), (int)getYPos(), (int)getXSize(), (int)getYSize());
        if(isOutline() ==  true)
        {
            g2D.setColor(getOutlineColor());
            g2D.setStroke(new BasicStroke(getOutlineWidth()));
            g2D.drawOval((int)getXPos(), (int)getYPos(), (int)getXSize(), (int)getYSize());
        }
    }
    
    
}
