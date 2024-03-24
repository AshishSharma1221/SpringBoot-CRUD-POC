package com.springbootCRUD.springbootcrudpoc.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class Config {

@Bean
public JavaMailSender getMailSender()
{
	JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
	javaMailSender.setHost("smtp-mail.outlook.com");
	javaMailSender.setPort(587);
	javaMailSender.setUsername("#####@outlook.com");
	javaMailSender.setPassword("#####");
	
	Properties javaMailProperties = new Properties();
	javaMailProperties.put("mail.smtp.starttls.enable", "true");
	javaMailProperties.put("mail.smtp.auth", "true");
	javaMailProperties.put("mail.transport.protocol", "smtp");
	javaMailProperties.put("mail.debug", "true");
	javaMailProperties.put("mail.smtp.ssl.trust", "*");
	
	javaMailSender.setJavaMailProperties(javaMailProperties);
	return javaMailSender;
}
}
