package util;

/**
 * Created by ko4 on 04.06.2014.
 */

import javax.mail.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadingEmail {
    //public static void main(String[] args) {
    public static Message getLastEmail(String login, String password) {
        Message msg = null;
        try {
            Properties props = new Properties();
            props.setProperty("mail.store.protocol", "imaps");
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            //store.connect("imap.mail.ru", "test276@mail.ru", "qwerasd");
            //String domainName = login.substring(login.indexOf("@"),login.length());

            if (login.contains("@mail.ru")) {
                store.connect("imap.mail.ru", login, password);
            } else {
                if (login.contains("@yandex.ru")) {
                    store.connect("imap.yandex.ru", login, password);
                } else {
                    throw new IllegalArgumentException("Unknown email provider or bad email address");
                }
            }

            //store.connect("imap.mail.ru", login, password);
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            msg = inbox.getMessage(inbox.getMessageCount());
            Address[] in = msg.getFrom();
            for (Address address : in) {
                System.out.println("FROM:" + address.toString());
            }
            Multipart mp = (Multipart) msg.getContent();
            BodyPart bp = mp.getBodyPart(1);
/*            System.out.println("SENT DATE:" + msg.getSentDate());
            System.out.println("SUBJECT:" + msg.getSubject());
            System.out.println("CONTENT:" + bp.getContent());*/


        } catch (Exception mex) {
            mex.printStackTrace();
        }
        return msg;

    }

    private static ArrayList pullLinks(String text) {
        ArrayList links = new ArrayList();

        String regex = "\\(?\\b(http://|www[.])[-A-Za-z0-9+&@#/%?=~_()|!:,.;]*[-A-Za-z0-9+&@#/%=~_()|]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        while (m.find()) {
            String urlStr = m.group();
            if (urlStr.startsWith("(") && urlStr.endsWith(")")) {
                urlStr = urlStr.substring(1, urlStr.length() - 1);
            }
            links.add(urlStr);
        }
        return links;
    }

    public static ArrayList getLinksFromLastLastEmail(String login, String password) {
        ArrayList urlList = null;
        Message msg = getLastEmail(login, password);
        try {
            urlList = pullLinks((String) ((Multipart)msg.getContent()).getBodyPart(1).getContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return urlList;
    }



}
