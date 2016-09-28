package pl.javastart.weld.main;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import pl.javastart.weld.model.MessagePrinter;

public class Main {
	public static void main(String[] args) {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();

		MessagePrinter messagePrinter = container.instance().select(MessagePrinter.class).get();

		messagePrinter.printMessage();

		weld.shutdown();
	}
}
