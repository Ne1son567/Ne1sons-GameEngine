package main.java.game.mainProgramms;
//Java-Imports

import java.io.File;

//Custom-Defined Imports
import main.java.game.graphic.JFrames.MainJFrame;

public class GameProgramm 
{
    public static void main(String [] args)
    { 
        new MainJFrame();
        GameLoop gameLoop = new GameLoop();
        JsonLoader jsonLoader = new JsonLoader();
        jsonLoader.LoadJsonDatei(new File("Ne1sons-GameEngine-main\\Ne1sons-GameEngine-main\\src\\main\\json\\JsonData.json"));
        jsonLoader.creatObjects();
        gameLoop.start();
        
        
        
    }
   
}
