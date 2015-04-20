package sk.revolone.eduidea.utils;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import sk.revolone.eduidea.data.entity.User;

public class CustomMailSender {
	
	private JavaMailSender mailSender;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void sendMail(String from, String to, String subject, String msg) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		mailSender.send(message);
	}

	public void sendActivationEmail(UUID uuid, User user, HttpServletRequest request) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("accountactivation@eduideac.com");
		message.setTo(user.getEmail());
		message.setSubject("EduIdea Account Activation - " + user.getUsername());
		message.setText("Thank you for your registration on EduIdea. If you want to activate your account please click on the following link - "
		+ request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + 
		request.getContextPath() + "/activation?key=" + uuid);
		
		mailSender.send(message);
	}
}
