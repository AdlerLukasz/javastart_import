package pl.javastart.mdb.producer;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;

import pl.javastart.mdb.dto.MessageWrapper;

public class MailService {
    
    @Inject
    private JMSContext jmsContext;
    
    @Resource(mappedName = "jms/queue/Emails")
    private Queue mailQueue;
    
    public void sendMessage(MessageWrapper message) {
        JMSProducer producer = jmsContext.createProducer();getClass();
        producer.send(mailQueue, message);
    }
}
