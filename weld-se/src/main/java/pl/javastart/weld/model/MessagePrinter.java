package pl.javastart.weld.model;

import javax.inject.Inject;

public class MessagePrinter {
	
	@Inject @StandardMessage
	private MessageProducer messageProducer;
	
	public void printMessage() {
		System.out.println(messageProducer.getMessage());
	}
	
}
