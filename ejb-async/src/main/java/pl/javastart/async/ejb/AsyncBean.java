package pl.javastart.async.ejb;

import java.time.LocalTime;
import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

@Stateless
public class AsyncBean {

    // @Asynchronous
    // public void longRunningMethod() {
    //
    // }

    @Asynchronous
    public Future<String> longRunningMethodAsync() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<String>("Async response " + LocalTime.now());
    }
    
    public void longRunningMethod() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
