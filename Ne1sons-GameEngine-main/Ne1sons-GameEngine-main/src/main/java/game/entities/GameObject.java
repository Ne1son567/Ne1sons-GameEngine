package main.java.game.entities;

import java.util.ArrayList;
import java.awt.Graphics2D;
import main.java.game.entities.drawingObjects.DrawnObject;

public class GameObject 
{
    private float xpos;
    private float ypos;
    private float xsize;
    private float ysize;
    private String name;
    private int layer;
    private ArrayList <DrawnObject> GameObjectEntities = new ArrayList <DrawnObject>();
    public GameObject (int _layer, String _name, float _xpos, float _ypos, float _xsize, float _ysize)
    {
        this.layer = _layer;
        this.name = _name;
        this.xpos = _xpos;
        this.ypos = _ypos;
        this.xsize = _xsize;
        this.ysize = _ysize;
    }
    public void renderAllGameObjectEntities(Graphics2D g2D)
    {
        for(int i = 0; i < GameObjectEntities.size(); i++)
        {
            GameObjectEntities.get(i).render(g2D);
        }
    }
    public void addEntitie(DrawnObject drawnObject)
    {
        GameObjectEntities.add(drawnObject);
    }
    public void setPosition(float _XPos, float _YPos)
    {
        for(int i = 0; i < GameObjectEntities.size(); i++)
        {
            GameObjectEntities.get(i).setXPos(_XPos);
            GameObjectEntities.get(i).setYPos(_YPos);
        }
    }
    
}
