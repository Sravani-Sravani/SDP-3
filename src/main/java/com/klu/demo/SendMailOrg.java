package com.klu.demo;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class SendMailOrg {
  
    @Autowired
    private JavaMailSender sender;

 
    public String sendMail(Organization org) {
      System.out.println("Helo");
      try
      {
      String str= "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+ "0123456789"+ "abcdefghijklmnopqrstuvxyz";
      StringBuilder sb = new StringBuilder(9);
      
      System.out.println("Hii2");
      String email=org.getEmail();
      System.out.print("HIIIII");
      System.out.println(email);
      for (int i = 0; i < 9; i++) 
      {
        int index= (int)(str.length()* Math.random());
        sb.append(str.charAt(index));
      }
      String str1=sb.toString();
       MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setTo(email);
            helper.setText("Hello! Hope you are doing great."+"\n"+"\n"+"Please use Below credentials to Login into our website."+"\n"+"\n"+"Username: "+email+"\n"+"Password: "+str1);
            helper.setSubject("Mail From Scout Ninja");
            sender.send(message);
            return str1;
        } 
      catch (MessagingException e) 
        {
            e.printStackTrace();
            return "Error while sending mail ..";
        }
    }
    
}