package dao;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class FileReader {

    public List<String> line = new ArrayList<>();

    public void readFile(){

        try {
            line = Files.readAllLines(Paths.get("src/main/resource/app.propertie"), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getStringRepresentation(){
        StringBuilder builder = new StringBuilder(line.size());
        for(String ch: line)
        {
            builder.append(ch);
        }
        return String.valueOf(builder);
    }

}
