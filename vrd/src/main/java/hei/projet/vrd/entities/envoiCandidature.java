package hei.projet.vrd.entities;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class envoiCandidature {
	
public static void main(String nom, String prenom, String mail, String telephone, String cv, String lm, String Ref, String nomOffre){
		
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

	         mess.setSubject("Candidature Spontanée du site");

	         mess.setText("CV : "+"https://s3.eu-west-2.amazonaws.com/vrdfrance/"+cv+"\n"+"Lettre de motivation : "+"https://s3.eu-west-2.amazonaws.com/vrdfrance/"+lm+"\n"+prenom+" "+nom+"\n"+mail+"\n"+telephone);

	         Transport trans = session.getTransport("smtp");
	         trans.connect("smtp.gmail.com", 587, "vrdfrance@gmail.com", "VRDFrance59");
	         trans.sendMessage(mess, mess.getAllRecipients());

	         System.out.println("Message Sent!");

	     } catch (MessagingException mex) {
	         mex.printStackTrace();
	     }
	   
	}

}
