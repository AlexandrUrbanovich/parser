package dao;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;


public class PropertieFileReader {
    private static final Logger log = Logger.getLogger(String.valueOf(PropertieFileReader.class));

    private String parserType;

    public PropertieFileReader() {
        readFile();
    }
    public String getParserType() {
        return parserType;
    }
    public void setParserType(String parserType) {
        this.parserType = parserType;
    }


    public void readFile() {
        Properties prop = new Properties();
        try {
            log.info("File read from resources folder");
            InputStream input = new FileInputStream("src/main/resources/app.propertie");
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String type = prop.getProperty("parse.type");
        log.info("Parser Type -> " + type);
        this.setParserType(type);
    }
}
