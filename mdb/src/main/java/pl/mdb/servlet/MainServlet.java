package pl.mdb.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.mdb.producer.MailService;
import pl.mdb.wrapper.MessageWrapper;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/mail")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private MailService mailService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("=========================");
		String recipient = request.getParameter("recipient");
		String message = request.getParameter("message");
		System.out.println(recipient);
		System.out.println(message);
		MessageWrapper msg = new MessageWrapper(recipient, message);
		mailService.sendMessage(msg);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
