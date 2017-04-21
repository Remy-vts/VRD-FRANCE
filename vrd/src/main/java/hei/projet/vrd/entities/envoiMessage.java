package hei.projet.vrd.entities;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;



public class envoiMessage{
	
	public static void main(String mail, String message, String prenom, String nom, String telephone){
		
		String to = "vrdfrance@gmail.com";
	    String from =  mail;
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

	         mess.setText(message+"\n\n"+prenom+" "+nom+"\n"+mail+"\n"+telephone);

	         Transport trans = session.getTransport("smtp");
	         trans.connect("smtp.gmail.com", 587, "vrdfrance@gmail.com", "VRD.france.59");
	         trans.sendMessage(mess, mess.getAllRecipients());

	         System.out.println("Message Sent!");

	     } catch (MessagingException mex) {
	         mex.printStackTrace();
	     }
	   
	}
			
		 
}