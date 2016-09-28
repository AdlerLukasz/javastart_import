package pl.javastart.batch.decider;

import java.io.File;

import javax.batch.api.Decider;
import javax.batch.runtime.StepExecution;
import javax.inject.Named;

import pl.javastart.batch.CopyBatchlet;

@Named
public class JobDecider implements Decider {

    @Override
    public String decide(StepExecution[] executions) throws Exception {
        File file = new File(CopyBatchlet.DIR_TO_PATH);
        if(file.list().length == 0) {
            System.out.println("NO_FILES");
            return "NO_FILES";
        } else {
            System.out.println("IMPORT_DATA");
            return "IMPORT_DATA";
        }
    }

}