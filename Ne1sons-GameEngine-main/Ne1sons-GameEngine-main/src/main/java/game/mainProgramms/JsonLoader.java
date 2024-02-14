package main.java.game.mainProgramms;
import java.awt.Color;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import main.java.game.entities.drawingObjects.Rectangle;
import main.java.game.graphic.JFrames.MainJFrame;
import main.java.game.entities.GameObject;
import main.java.game.entities.drawingObjects.DrawnObject;
import main.java.game.entities.drawingObjects.Ellipse;
public class JsonLoader 
{
    private File JsonFile;
    private JSONObject jsonObject; 

    public void creatObjects()
    {
        if (jsonObject == null) {
            System.err.println("!----------------------JSON-Objekt nicht erkannt-------------------!");
            return;
        }
        //DrawnObjects
        JSONArray JsonObjects = (JSONArray) jsonObject.get("DrawnObjects");
        
        for(int j = 1; j <= 3; j++)
        {
            for (int i = 0; i < JsonObjects.size(); i++) {
                JSONObject objData =  (JSONObject) JsonObjects.get(i);
                int layer = Integer.parseInt(objData.get("layer").toString());
                if(layer == j)
                {
                    try {
                        String name = (String) objData.get("name");
                        String type = (String) objData.get("type");
                        boolean renderFlag =  (boolean) objData.get("renderFlag");
                        JSONArray data = (JSONArray) objData.get("data");
                        
                        float xpos = Float.parseFloat(((JSONObject) data.get(0)).get("xpos").toString());
                        float ypos = Float.parseFloat(((JSONObject) data.get(1)).get("ypos").toString());
                        float xsize = Float.parseFloat(((JSONObject) data.get(2)).get("xsize").toString());
                        float ysize = Float.parseFloat(((JSONObject) data.get(3)).get("ysize").toString());
                        
                        
                        Color color = hexToColor((String) objData.get("color"));
                        Color outlineColor = hexToColor((String) objData.get("outlineColor"));
                        int outlineWidth = ((Long) objData.get("outlineWidth")).intValue();
                   
                        
                        
                        DrawnObject obj = null;
                        if("Ellipse".equals(type))
                        {
                            obj = new Ellipse(xpos, ypos, xsize, ysize, renderFlag, name);
                            
                        }else
                        if("Rectangle".equals(type))
                        {
                            obj = new Rectangle(xpos, ypos, xsize, ysize, renderFlag, name);
                            
                        }
                        
                        obj.setColor(color);
                        obj.setOutline(outlineWidth, outlineColor);
                        
                    } catch (Exception e) 
                    {
                        System.out.println("Fehler in der Json Datei \n \n \n ---------------------------------");
                    }
                }
                
                
            }
        }
        System.out.println(MainJFrame.getGameJPanel1().getAllGameObjects());
        //GameObjects
        JsonObjects = (JSONArray) jsonObject.get("GameObjects");
        for(int j = 1; j <= 3; j++)
        {
            for (int i = 0; i < JsonObjects.size(); i++) {
                JSONObject objData = (JSONObject) JsonObjects.get(i);
                int layer = Integer.parseInt(objData.get("layer").toString());
                if(layer == j)
                {
                    try {
                        String name = (String) objData.get("name");
                        String type = (String) objData.get("type");
                        boolean renderFlag =  (boolean) objData.get("renderFlag");
                        JSONArray data = (JSONArray) objData.get("data");
                        
                        float xpos = Float.parseFloat(((JSONObject) data.get(0)).get("xpos").toString());
                        float ypos = Float.parseFloat(((JSONObject) data.get(1)).get("ypos").toString());
                        float xsize = Float.parseFloat(((JSONObject) data.get(2)).get("xsize").toString());
                        float ysize = Float.parseFloat(((JSONObject) data.get(3)).get("ysize").toString());
                    } catch (Exception e) 
                    {
                        System.out.println("Fehler in der Json Datei \n \n \n ---------------------------------");
                    }
                    new GameObject(layer, null, j, layer, i, i);
                }
                
                        
                
            }
        }
    }

    public static Color hexToColor(String colorHex) {
        int r = Integer.valueOf(colorHex.substring(1, 3), 16);
        int g = Integer.valueOf(colorHex.substring(3, 5), 16);
        int b = Integer.valueOf(colorHex.substring(5, 7), 16);
        return new Color(r, g, b);
    }
    public void LoadJsonDatei(File _jsonFile) 
    {
        JsonFile = _jsonFile;
        // Überprüfen, ob die Datei existiert
        if (!_jsonFile.exists()) {
            System.err.println("Die JSON-Datei existiert nicht.");
            return;
        }

        // JSON-Parser initialisieren
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(_jsonFile)) {
            // JSON-Datei parsen
            Object obj = parser.parse(reader);
            
            // JSON-Objekt erstellen
            jsonObject = (JSONObject) obj;
            
            // Verarbeitung oder Verwendung des JSON-Objekts
            
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        
    }
}

