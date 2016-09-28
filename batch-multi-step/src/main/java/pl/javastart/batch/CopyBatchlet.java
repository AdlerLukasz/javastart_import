package pl.javastart.batch;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.batch.api.AbstractBatchlet;
import javax.inject.Named;

@Named
public class CopyBatchlet extends AbstractBatchlet {
    public static final String DIR_FROM_PATH = "C:/start";
    public static final String DIR_TO_PATH = "C:/end";
    
    @Override
    public String process() throws Exception {
        try {
            Files
                .list(Paths.get(DIR_FROM_PATH))
                .forEach( path -> {
                    try {
                        Files.move(path, Paths.get(DIR_TO_PATH, path.getFileName().toFile().getName()));
                    } catch(IOException e) {
                        throw new UncheckedIOException(e);
                    }
                });
        } catch(UncheckedIOException e) {
            System.out.println("CopyBatchlet Failed");
            return "MOVE_FAILED";
        }
        System.out.println("CopyBatchlet Success");
        return "MOVE_SUCCESS";
    }

}
