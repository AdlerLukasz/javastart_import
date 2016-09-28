package pl.javastart.chunk;

import java.util.StringTokenizer;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

import pl.javastart.model.UserData;

@Named
public class CsvProcessor implements ItemProcessor {
    
    @Override
    public Object processItem(Object item) throws Exception {
        System.out.println("Processing: " + item);
        String data = (String) item;
        UserData userData = createUserData(data);
        return userData;
    }
    
    private UserData createUserData(String data) {
        StringTokenizer tokenizer = new StringTokenizer(data, ",");
        UserData userData = new UserData();
        userData.setFirstName(tokenizer.nextToken());
        userData.setLastName(tokenizer.nextToken());
        userData.setEmail(tokenizer.nextToken());
        userData.setGender(tokenizer.nextToken());
        userData.setCompany(tokenizer.nextToken());
        userData.setCountry(tokenizer.nextToken());
        return userData;
    }
}