package Email.EmailTest;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class CommonEmails {

	public static void main(String[] args) throws EmailException 
	{
		System.out.println("Started");
		
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("automation2018.QA@gmail.com", "automation@2018"));
		email.setSSLOnConnect(true);
		email.setFrom("");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("foo@bar.com");
		email.send();	
		
		System.out.println("End");

	}

}
