package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;


public class JSONULT {
    public void Crea_escriu_Fitxer_JSON(Path p){
        JSONObject joan = new JSONObject();
        joan.put("nom", "Joan");
        joan.put("cognom","Ferrés");
        joan.put("edad",20);

        JSONObject kevin = new JSONObject();
        kevin.put("nom","Kevin");
        kevin.put("cognom","Louis");
        kevin.put("edad",22);

        Map m = new LinkedHashMap();
        m.put("type","home");
        m.put("number","212 555-1234");

        joan.put("Dirreció",m);

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(joan);
        jsonArray.add(kevin);

        try {
            if (!Files.exists(p)) {
                Files.createFile(p);
                Files.write(p,jsonArray.toJSONString().getBytes());
            }else {
                System.err.println("Ja existeix el Fitxer :(");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Retorna un objecte JSONArray amb tot el contingut del fitxer JSON
     *
     * @param fitxer nom del fitxer
     * @return JSONArray amb el contingut de tol el fiter JSON
     * @throws IOException    Excepció d'I/O
     * @throws ParseException Excepció de Parser
     */
    public JSONArray retornaFitxerJson(String fitxer){
        JSONParser jp = new JSONParser();
        try {
            Object obj = jp.parse(new FileReader(fitxer));
            JSONArray jsonArray = (JSONArray) obj;
            return jsonArray;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Escriu un String ja amb format json a un fitxer Json
     * @param rutaDesti Ruta del fitxer destí
     * @param contingut contingut de l'String amb format json
     * @throws IOException excepció d'E/S
     */
    public void escriuStringJsonAFitxerJson(String rutaDesti,String contingut){
        Path p = Paths.get(rutaDesti);
        try {
            Files.write(p, contingut.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
