package hei.projet.vrd.entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;

public class envoiCandidature {
	
public static void main(String nom, String prenom, String mail, String telephone, String cv, String message, String RefNom, String typeCandidature) throws URISyntaxException, IOException{
		
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

	         mess.setSubject(typeCandidature+" - "+nom+" - "+prenom);
	         
	      // Create the message part
	         BodyPart messageBodyPart = new MimeBodyPart();

	         // Now set the actual message
	         messageBodyPart.setText(message+"\n\n"+prenom+" "+nom+"\n"+mail+"\n"+telephone);

	         // Create a multipart message
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);
	         
	         
	         String urlString = "https://s3.eu-west-2.amazonaws.com/vrdfrance/";
	        
	         /*URL url = new URL(urlString);
	         System.out.println("URL is: " + url.toString());
	         
	         URI uri = url.toURI();
	         System.out.println("URI is: " + uri.toString());

	         if(uri.getAuthority() != null && uri.getAuthority().length() > 0) {
	             // Hack for UNC Path
	             uri = (new URL("file:/" + urlString.substring("file:".length()))).toURI();
	         }

	         File file = new File(uri);*/
	         
	         URL url;

	 		
	 			// get URL content
	 			url = new URL(urlString);
	 			URLConnection conn = url.openConnection();

	 			// open the stream and put it into BufferedReader
	 			BufferedReader br = new BufferedReader(
	                                new InputStreamReader(conn.getInputStream()));

	 			String inputLine;

	 			//save to this filename
	 			String fileName = cv;
	 			File file = new File(fileName);

	 			if (!file.exists()) {
	 				file.createNewFile();
	 			}

	 			//use FileWriter to write file
	 			FileWriter fw = new FileWriter(file.getAbsoluteFile());
	 			BufferedWriter bw = new BufferedWriter(fw);

	 			while ((inputLine = br.readLine()) != null) {
	 				bw.write(inputLine);
	 			}

	 			bw.close();
	 			br.close();

	         
	         System.out.println("File is: " + file);


	         // Part two is attachment
	         messageBodyPart = new MimeBodyPart();
	         
	         DataSource source = new FileDataSource(file);
	         System.out.println("Source is: " + source);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(file.toString());
	         multipart.addBodyPart(messageBodyPart);
	         
	      // Send the complete message parts
	         mess.setContent(multipart);
	         
	         Transport trans = session.getTransport("smtp");
	         trans.connect("smtp.gmail.com", 587, "vrdfrance@gmail.com", "VRD.france.59");
	         trans.sendMessage(mess, mess.getAllRecipients());

	         System.out.println("Message Sent!");

	     } catch (MessagingException mex) {
	         mex.printStackTrace();
	     }
	   
	}

}
