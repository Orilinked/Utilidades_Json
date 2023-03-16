package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainTest {
    public static void main(String[] args) {
        Path p = Paths.get("prova1.json");
        JSONULT js = new JSONULT();
        js.Crea_escriu_Fitxer_JSON(p);

    }
}