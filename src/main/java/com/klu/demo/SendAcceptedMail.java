package com.klu.demo;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class SendAcceptedMail {
  
    @Autowired
    private JavaMailSender sender;

 
    public void sendMail(String role,String email,String org) {
      
      try
      {
      
       MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
             helper.setTo(email);
            helper.setText("Hello! Hope you are doing great."+"\n"+"\n"+"This mail is from "+org+".We are glad to inform you that your request is accepted for the role:"+role);
            helper.setSubject("Mail From Scout Ninja");
            sender.send(message);
           // return str1;
        } 
      catch (MessagingException e) 
        {
            e.printStackTrace();
           // return "Error while sending mail ..";
        }
    }
    
}