package email;

import java.util.Properties;
import java.util.Date;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import properties.ReadFromPropertiesFile;

public class SendSMTP {

    String result = "failed";
    String emailId = "";
    String password = "";

    public String sendMail(String toEmailId, String text, String subject) {
        try {

//--[ Set up the default parameters
            Properties p = new Properties();
            p.put("mail.smtp.auth", "true");
            p.put("mail.transport.protocol", "smtp");
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.put("mail.smtp.port", "587");
            p.put("mail.smtp.starttls.enable", "true");

//--[ Create the session and create a new mail message
            Authenticator auth = new SMTPAuthenticator(emailId, password);
            Session mailSession = Session.getInstance(p, auth);
            Message msg = new MimeMessage(mailSession);

//--[ Set the FROM, TO, DATE and SUBJECT fields
            msg.setFrom(new InternetAddress(emailId));
            String rec[] = toEmailId.split(";");

            int count = 1;
            //---------------------------------------------------------
//            String htmlBody = "<H1>Hello</H1><img src=\"cid:image-123\">";
//            MimeBodyPart messageBodyPart = new MimeBodyPart();
//            messageBodyPart.setContent(htmlBody, "text/html");
//
//            Multipart multipart = new MimeMultipart();
//            multipart.addBodyPart(messageBodyPart);
//            MimeBodyPart imagePart = new MimeBodyPart();
//            DataSource ds = new FileDataSource("src//email//Print.png");
//            imagePart.setDataHandler(new DataHandler(ds));
//            imagePart.setHeader("Content-ID", "image-123");
//            imagePart.setDisposition(MimeBodyPart.INLINE);
//            multipart.addBodyPart(imagePart);
//            msg.setContent(multipart);
            //---------------------------------------------------------
            //---------------------------------------------------------
//            String htmlBody = "<H1>Hello</H1><img src=\"cid:image-126\">";
//            Multipart multipart = new MimeMultipart();
//            MimeBodyPart imagePart = new MimeBodyPart();
//            imagePart.setHeader("Content-ID", "image-126");
//            imagePart.setContent(htmlBody, "text/html");
//            imagePart.attachFile("src\\email\\Print.png");
//            multipart.addBodyPart(imagePart);
//            imagePart.setDisposition(MimeBodyPart.INLINE);
//            msg.setContent(multipart);

            //---------------------------------------------------------
            //---------------------------------------------------------
//            MimeMultipart multipart = new MimeMultipart("related");
//
//            // first part (the html)
//            BodyPart messageBodyPart = new MimeBodyPart();
//            String htmlText = "<H1>Hello</H1><img src=\"cid:image\">";
//            messageBodyPart.setContent(htmlText, "text/html");
//            // add it
//            multipart.addBodyPart(messageBodyPart);
//
//            // second part (the image)
//            messageBodyPart = new MimeBodyPart();
//            DataSource fds = new FileDataSource(
//                    "src\\email\\Print.png");
//
//            messageBodyPart.setDataHandler(new DataHandler(fds));
//            messageBodyPart.setHeader("Content-ID", "image");
//
//            // add image to the multipart
//            multipart.addBodyPart(messageBodyPart);
//
//            // put everything together
//            msg.setContent(multipart);
            //---------------------------------------------------------
            //---------------------------------------------------------
//            Multipart multipart = new MimeMultipart("related");
//            StringBuffer body
//                    = new StringBuffer("<html>This message contains two inline images.<br>");
//            body.append("The first image is a chart:<br>");
//            body.append("<img src=\"cid:AbcXyz123\"/><br>");
//            body.append("End of message.");
//            body.append("</html>");
//            try {
//
//                Multipart multipart = new MimeMultipart("multipart/related");
//            String htmlMessage = "<html>Hi there,<br>";
//            htmlMessage += "See this cool pic: <img src=\"cid:AbcXyz954\" />";
//            htmlMessage += "</html>";
//                MimeBodyPart bodyPart = new MimeBodyPart();
//            bodyPart.setText(body.toString());
//            messageBodyPart.setContent(body.toString(), "text/html");
//                bodyPart.setContent(body, "text/html");
//                multipart.addBodyPart(bodyPart);
//                MimeBodyPart imagePart = new MimeBodyPart();
//                DataSource fds = new FileDataSource("src\\email\\Print.png");
//                imagePart.setDataHandler(new DataHandler(fds));
//                imagePart.setHeader("Content-ID", "cid:AbcXyz123");
//                imagePart.setDisposition(MimeBodyPart.INLINE);
//                multipart.addBodyPart(imagePart);
//                msg.setContent(multipart);
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//            String imageFilePath = "src\\email\\Print.png";
// attach the image file
//            imagePart.attachFile("Print.png");
            //---------------------------------------------------------
            //---------------------------------------------------------
            Multipart multipart = new MimeMultipart("related");
            BodyPart messageBodyPart = new MimeBodyPart();
            String htmlText = "<html><body><p style='font-size: 30px; background-color: lightblue;width: 23%;'>Dispatch Processing Unit</p><img src=\"cid:image\" /><br/>" + text + "</body></html>";
            messageBodyPart.setContent(htmlText, "text/html");
            // add it
            multipart.addBodyPart(messageBodyPart);

            messageBodyPart = new MimeBodyPart();
            DataSource fds = new FileDataSource(ReadFromPropertiesFile.imagePath + "Application-Exe.png");

            messageBodyPart.setDataHandler(new DataHandler(fds));
            messageBodyPart.setHeader("Content-ID", "<image>");
            multipart.addBodyPart(messageBodyPart);
            //---------------------------------------------------------
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(rec[0]));
            while (count < rec.length) {
                msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(rec[count]));
                count++;
            }
            msg.setSentDate(new Date());
            msg.setSubject(subject);
//            msg.setText(body.toString());
//            msg.setText(text);
            msg.setContent(multipart);

//--[ Ask the Transport class to send our mail message
            Transport trans = mailSession.getTransport();

            trans.connect();
            Address[] ad = msg.getAllRecipients();
            for (int i = 0; i < ad.length; i++) {

                try {
                    Address[] ad1 = new Address[1];
                    ad1[0] = ad[i];

                    trans.sendMessage(msg, ad1);
                    result = "sent";

                } catch (Exception e) {
                    continue;
                }
            }

        } catch (Exception E) {
            System.out.println(E);
            System.out.println("Something gone wrong while sending mail!");
            E.printStackTrace();
            return result;
        }

        return result;
    }
}
