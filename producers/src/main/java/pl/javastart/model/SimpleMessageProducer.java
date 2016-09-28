package pl.javastart.model;

public class SimpleMessageProducer implements MessageProducer {

	@Override
	public String getMessage()  {
		return "Example message " + System.currentTimeMillis();
	}
}
