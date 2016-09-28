package pl.javastart.model;

import java.io.IOException;
import java.util.Properties;

import javax.enterprise.inject.Produces;

import pl.javastart.qualifiers.FileName;

public class Config {

    public static final String CONFIG_FILE = "/config.properties";

    // @Produces @FileName
    // private String fileName = "/message.txt";
    
    @Produces @FileName
    public String getFileName() {
        Properties config = new Properties();
        try {
            config.load(getClass().getResourceAsStream(CONFIG_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fileName = config.getProperty("fileName");
        return fileName;
    }
}
