package pl.mdb.consumer;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import pl.mdb.wrapper.MessageWrapper;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/Emails"), })
public class MailSendingService implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			MessageWrapper msg = message.getBody(MessageWrapper.class);
			System.out.println("Wysyłam maila do: " + msg.getRecipient());
			System.out.println("Treść: " + msg.getMessage());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
