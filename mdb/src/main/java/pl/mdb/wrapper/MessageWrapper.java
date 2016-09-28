package pl.mdb.wrapper;

import java.io.Serializable;

public class MessageWrapper implements Serializable {


	private static final long serialVersionUID = 1L;
	private String recipient;
	private String message;

	public MessageWrapper(String recipient, String message) {
		this.recipient = recipient;
		this.message = message;
	}

	public String getRecipient() {
		return recipient;
	}

	public String getMessage() {
		return message;
	}



}
