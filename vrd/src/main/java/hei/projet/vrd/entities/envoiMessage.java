package hei.projet.vrd.entities;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import hei.projet.vrd.servlets.contactServlet;

public class envoiMessage{
	
	public static void main(String message){
		
		String to = "dimitri59290@hotmail.fr";
	    String from =  "vrdfrance@gmail.com";

	     Properties props = new Properties();
	     props.setProperty("mail.transport.protocol", "smtp");
	     props.setProperty("mail.host", "smtp.gmail.com");
	     props.put("mail.smtp.starttls.enable", "true");
	     props.put("mail.smtp.auth", "true");
	     props.put("mail.smtp.starttls.enable", "true");


	     Session session = Session.getDefaultInstance(props);
	     session.setDebug(true);

	     try {
	         MimeMessage mess = new MimeMessage(session);

	         mess.setFrom(new InternetAddress(from));

	         mess.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	         mess.setSubject("Message de contact du site");

	         mess.setText(message);

	         Transport trans = session.getTransport("smtp");
	         trans.connect("smtp.gmail.com", 587, "vrdfrance@gmail.com", "VRDFrance59");
	         trans.sendMessage(mess, mess.getAllRecipients());

	         System.out.println("Message Sent!");

	     } catch (MessagingException mex) {
	         mex.printStackTrace();
	     }
	   
	}
			
		 
}