package main.java.game.entities.drawingObjects;

import java.awt.Color;
//Java-Imports
import java.awt.Graphics2D;
import java.util.ArrayList;

//Custom-Defined Imports

public abstract class DrawnObject 
{
    private static ArrayList<DrawnObject> allDrawnObjects = new ArrayList<DrawnObject>();
    private float xpos;
    private float ypos;
    private float xsize;
    private float ysize;
    private boolean renderFlag;
    private int layer;
    private String name;
    
    private Color color;
    private Color outlineColor;
    private int outlineWidth;
    private boolean outline = false;

   
    public DrawnObject (float _xpos, float _ypos, float _xsize, float _ysize, boolean _renderFlag)
    {
        allDrawnObjects.add(this);
        this.xsize = _xsize;
        this.ysize = _ysize;
        setXPos(_xpos);
        setYPos(_ypos);
        this.renderFlag = _renderFlag;
    }
    public float getXPos()
    {
        return xpos;
    }
    public float getYPos()
    {
        return ypos;
    }
    public float getXSize()
    {
        return xsize;
    }
    public float getYSize()
    {
        return ysize;
    }
    public void setXPos(float _XPos)
    {
        xpos = _XPos - xsize/2;
    }
    public void setYPos(float _YPos)
    {
        ypos = _YPos - ysize/2;
    }
    public void setRenderFlag(boolean _renderFlag)
    {
        this.renderFlag = _renderFlag;
    }
    public boolean getRenderFlag()
    {
        return renderFlag;
    }
    public static ArrayList<DrawnObject> getAllDrawnObjects()
    {
        return allDrawnObjects;
    }
    public boolean isOutline()
    {
        return outline;
    }
    public void setOuline(int _outlineWidth, Color _outlineColor)
    {
        outline = true;
        this.outlineWidth = _outlineWidth;
        this.outlineColor = _outlineColor;
    }
    public void setColor(Color _color)
    {
        this.color = _color;
    }
    public Color getColor()
    {
        return color;
    }
    
    public Color getOutlineColor()
    {
        return outlineColor;
    }
    public int getOutlineWidth()
    {
        return outlineWidth;
    }
    public abstract void render(Graphics2D g2D);
   
}
