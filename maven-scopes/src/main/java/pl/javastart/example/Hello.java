package pl.javastart.example;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class Hello {

    public String sayHello(){
        HttpClient client = HttpClientBuilder.create().build();
        return "hello";
    }
    
    public static void main(String[] args) {
        HttpClient client = HttpClientBuilder.create().build();
        System.out.println(client.toString());
    }
    
}
