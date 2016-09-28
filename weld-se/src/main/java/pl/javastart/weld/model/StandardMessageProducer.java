package pl.javastart.weld.model;

@StandardMessage
public class StandardMessageProducer implements MessageProducer {

	public String getMessage() {
		return "Standard message";
	}

}
