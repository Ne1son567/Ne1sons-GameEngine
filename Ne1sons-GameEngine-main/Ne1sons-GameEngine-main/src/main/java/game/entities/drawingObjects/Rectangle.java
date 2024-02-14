package main.java.game.entities.drawingObjects;

//Java-Imports
import java.awt.Graphics2D;

//Custom-Defined Imports

public class Rectangle extends DrawnObject 
{
    public Rectangle (float _xpos, float _ypos, float _xsize, float _ysize, boolean _renderFlag)
    {
        super(_xpos,_ypos,_xsize,_ysize, _renderFlag);
    }

    public void render(Graphics2D g2D)
    {
        g2D.setColor(getColor());
        g2D.fillRect((int)getXPos(), (int)getYPos(), (int)getXSize(), (int)getYSize());
        if(isOutline() ==  true)
        {
            g2D.setColor(getOutlineColor());
            g2D.drawRect((int)getXPos(), (int)getYPos(), (int)getXSize(), (int)getYSize());
        }
    }
    
}
