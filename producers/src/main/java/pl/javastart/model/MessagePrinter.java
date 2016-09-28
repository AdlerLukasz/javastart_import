package pl.javastart.model;

import javax.inject.Inject;

import pl.javastart.qualifiers.Message;
import pl.javastart.qualifiers.Message.MessageType;

public class MessagePrinter {

    @Inject @Message(type = MessageType.FILE)
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
