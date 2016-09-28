package pl.javastart.timer;

import java.time.LocalTime;

import javax.ejb.Schedule;
import javax.ejb.Singleton;

@Singleton
public class SimpleTimer {
    
    @Schedule(second = "0", minute = "1", hour = "*", persistent = false)
    public void sendMonthlyNewsletter() {
        System.out.println("Notifications sent at " + LocalTime.now());
    }
    
}
