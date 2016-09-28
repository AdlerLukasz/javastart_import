package pl.javastart;

import javax.inject.Inject;

public class MessagePrinter {

    @Inject
    private MessageProducer messageProducer;

    public MessageProducer getMessageProducer() {
        return messageProducer;
    }

    @Inject
    public void setMessageProducer(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    public void printMessage() {
        String message = getMessageProducer().getMessage();
        System.out.println(message);
    }
}
