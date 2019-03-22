package com.cloud.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public class TestCaseUtils {

	public final static void SendEmail(String mailenabled) {

		if(mailenabled.equals("1")){
		 final String username = "hiltonuatautomationreport@gmail.com";
		 final String password = "Hilton@1234";
		 Properties props = new Properties();
		 props.put("mail.smtp.auth", true);
		 props.put("mail.smtp.starttls.enable", true);
		 props.put("mail.smtp.host", "smtp.gmail.com");
		 props.put("mail.smtp.port", "587");
		
		 javax.mail.Session session = Session.getInstance(props,
		 new javax.mail.Authenticator() {
		 protected PasswordAuthentication getPasswordAuthentication() {
		 return new PasswordAuthentication(username, password);
		 }
		 });
		
		 try {
		
		 Message message = (Message) new MimeMessage(session);
		 message.setFrom(new InternetAddress(username));
		
		 // message.setRecipients(Message.RecipientType.TO,
		 // InternetAddress.parse(
		 //
		 //"Ratnesh.Kumar.contractor@hilton.com,Ratna.Adusumilli@hilton.com,Ramana.Kunapuli.contractor@hilton.com,Neelima.Chalamalasetty.contractor@hilton.com,Sridevi.Aiely.contractor@hilton.com,Preeti.Joshi.contractor@hilton.com,Chetan.Babu.contractor@hilton.com,Dan.Willis.contractor@hilton.com,Adeep.Kota.contractor@hilton.com,Jimmee.Fullerton@hilton.com,Charles.Humphrey@hilton.com,Rachana.Dixit@hilton.com,"));
		 message.setRecipients(Message.RecipientType.TO,
		 InternetAddress.parse("Ratnesh.Kumar.contractor@hilton.com"));
		 //,Ratna.Adusumilli@hilton.com,Ramana.Kunapuli.contractor@hilton.com,Neelima.Chalamalasetty.contractor@hilton.com,Sridevi.Aiely.contractor@hilton.com,Preeti.Joshi.contractor@hilton.com,Chetan.Babu.contractor@hilton.com,Dan.Willis.contractor@hilton.com,Adeep.Kota.contractor@hilton.com,Jimmee.Fullerton@hilton.com,Charles.Humphrey@hilton.com,Sangeetha.Ravindran@hilton.com,Rachana.Dixit@hilton.com,"));
		
		 Date date = new Date();
		 String DATE_FORMAT = "MM/dd/yyyy";
		 SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		 message.setSubject("Automation Execution Report - "+
		 sdf.format(date));
		 message.setText("PFA");
		 MimeBodyPart messageBodyPart = new MimeBodyPart();
		 Multipart multipart = new MimeMultipart();
		 messageBodyPart = new MimeBodyPart();
		 String file =
		 "/Users/abinai/Documents/HiltonPOM/Hilton/report/TestExecutionReport.html";
		 String fileName = "TestExecutionReport.html";
		 DataSource source = new FileDataSource(file);
		 messageBodyPart.setDataHandler(new DataHandler(source));
		 messageBodyPart.setFileName(fileName);
		 multipart.addBodyPart(messageBodyPart);
		 message.setContent(multipart);
		 System.out.println("Sending Email");
		 Transport.send(message);
		
		 System.out.println("Successfully sent mail to recepients.");
		
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		}
		else
		{
			System.out.println("Email is not enabled.");
		}
	}

	public final static String randomNumber() {
		return DateTimeFormat.forPattern("MMddyyyy_HHmmss").print(new DateTime());
	}

	public final static String futureDate(int addNoOfDays) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, addNoOfDays); // Adding 5 days
		String output = sdf.format(c.getTime());
		System.out.println(output);
		return output;
	}

	public static Integer LastOfMonth() {

		Date today = new Date();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);

		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DATE, -1);

		// Date lastDayOfMonth = calendar.getTime();
		// lastDayOfMonth.
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// System.out.println("Today : " + );
		String lastday = sdf.format(today);
		int len = lastday.length();
		lastday = lastday.substring(len - 2, len - 1);

		return Integer.parseInt(lastday);
	}

	public final static void assertEquals() {

	}

	public final static double roundToCents(double d) {
		d = 100.0;
		return d;
	}
}
