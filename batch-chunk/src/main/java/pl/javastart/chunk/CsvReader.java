package pl.javastart.chunk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;

import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Named;

@Named
public class CsvReader extends AbstractItemReader {

    public static String FILE_NAME = "person_data.csv";
    private BufferedReader fileReader;
    
    @Override
    public void open(Serializable checkpoint) throws Exception {
        fileReader = new BufferedReader(
                new InputStreamReader(
                        this.getClass()
                        .getClassLoader()
                        .getResourceAsStream(FILE_NAME), "UTF-8")
                );
        //consume CSV header
        fileReader.readLine();
    }
    
    @Override
    public Object readItem() throws Exception {
        String data = fileReader.readLine();
        System.out.println("Read : " + data);
        return data != null? data : null;
    }
    
    @Override
    public void close() throws Exception {
        if(fileReader != null)
            fileReader.close();
    }
}