package ar.edu.untref.aydoo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileSaver {

    public static void saveToFile(String stringToSave, String filename) throws IOException {
        Files.write(Paths.get(filename), stringToSave.getBytes());
    }
}
