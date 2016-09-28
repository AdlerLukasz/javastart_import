package pl.javastart.model;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import javax.inject.Inject;

import pl.javastart.qualifiers.FileName;
import pl.javastart.qualifiers.Message;
import pl.javastart.qualifiers.Message.MessageType;

@Message(type = MessageType.FILE)
public class FileMessageProducer implements MessageProducer {

    @Inject @FileName
    private String fileName;
    
    @Override
    public String getMessage() {
        List<String> lines = null;
        try {
            Path path = new File(getClass().getResource(fileName).toURI()).toPath();
            lines = Files.readAllLines(path);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        String result = "";
        if (lines != null)
            result = lines.stream().reduce(result, (a, b) -> a + b);
        return result;
    }
}
