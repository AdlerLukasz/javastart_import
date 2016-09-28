package pl.javastart;

import javax.inject.Inject;

public class MessagePrinter {

    @Inject @FileMessage
    private MessageProducer messageProducer;

    // @Inject
    // public void setMessageProducer(@FileMessage MessageProducer
    // messageProducer) {
    // this.messageProducer = messageProducer;
    // }
    //
    // @Inject
    // public MessagePrinter(@FileMessage MessageProducer messageProducer) {
    // this.messageProducer = messageProducer;
    // }

    public void printMessage() {
        String message = messageProducer.getMessage();
        System.out.println(message);
    }
}
