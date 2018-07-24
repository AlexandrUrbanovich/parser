package dao;

import org.apache.log4j.Logger;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



public class FileReader {
    private static final Logger log = Logger.getLogger(String.valueOf(FileReader.class));

    public List<String> line = new ArrayList<>();

    public void readFile(){
        try {
            line = Files.readAllLines(Paths.get("src/main/resources/app.propertie"), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("File read from resources folder");
    }

    public String getStringRepresentation(){
        StringBuilder builder = new StringBuilder(line.size());
        for(String ch: line)
        {
            builder.append(ch);
        }
        log.info("Found propertie for parser choised");
        return String.valueOf(builder);
    }
}
