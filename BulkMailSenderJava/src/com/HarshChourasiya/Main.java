package com.HarshChourasiya;

import com.sun.org.apache.xalan.internal.xsltc.trax.XSLTCSource;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class Main {
//jexfkkzkomdjdrfu
    public static void main(String[] args) throws Exception {
        ArrayList<InternetAddress> emails = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Your Email Address : ");
        String from = scan.next();
        System.out.println("Enter Your password : ");
        String password = scan.next();
        System.out.println("Email list path here : ");
        String path = scan.next();
        System.out.println("Enter Subject for mail : ");
        String subject = scan.nextLine();
        scan.next();
        System.out.println("Enter Context for mail : ");
        String mailContent = scan.nextLine();
        scan.nextLine();
        scan.nextLine();
        scan.next();
        String Host = "smtp.gmail.com";
        File file = new File(path);
        System.out.println(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line=reader.readLine())!=null){
            String email = line.trim();
            emails.add(new InternetAddress(email));
        }
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", Host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = (Session) Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        session.setDebug(true);
        for (int i = 0; i < emails.size(); i++) {
            try {
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));
                message.setRecipient(Message.RecipientType.TO, emails.get(i));
                message.setSubject(subject);
                message.setText(mailContent);
                Transport.send(message);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Some Thing went wrong!");
            }
        }
    }
}
