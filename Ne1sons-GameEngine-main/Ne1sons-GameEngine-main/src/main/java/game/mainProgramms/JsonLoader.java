package main.java.game.mainProgramms;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import main.java.game.entities.drawingObjects.Rectangle;
import main.java.game.entities.drawingObjects.Ellipse;
public class JsonLoader 
{
    private File JsonFile;
    private JSONObject jsonObject; 

    public void creatObjects()
    {
        if (jsonObject == null) {
            System.err.println("!----------------------JSON-Objekt war null-------------------!");
            return;
        }
        //DrawnObjects
        JSONArray JsonDrawnObjects = (JSONArray) jsonObject.get("DrawnObjects");
        System.out.println(JsonDrawnObjects);

        for (int i = 0; i < JsonDrawnObjects.size(); i++) {
            JSONObject objData =  (JSONObject) JsonDrawnObjects.get(i);
            int layer = Integer.parseInt(objData.get("layer").toString());
            String name = (String) objData.get("name");
            String type = (String) objData.get("type");
            boolean renderFlag =  (boolean) objData.get("renderFlag");
            JSONArray data = (JSONArray) objData.get("data");

            float xpos = Float.parseFloat(((JSONObject) data.get(0)).get("xpos").toString());
            float ypos = Float.parseFloat(((JSONObject) data.get(1)).get("ypos").toString());
            float xsize = Float.parseFloat(((JSONObject) data.get(2)).get("xsize").toString());
            float ysize = Float.parseFloat(((JSONObject) data.get(3)).get("ysize").toString());
            
            
            if("Ellipse".equals(type))
            {
                new Ellipse(xpos, ypos, xsize, ysize, renderFlag);
            }
            if("Rectangle".equals(type))
            {
                new Rectangle(xpos, ypos, xsize, ysize, renderFlag);
            }

        }
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
            System.out.println("Geladene JSON-Objekt: " + jsonObject);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        
    }
}

