package ThreeTierArchitecture.web;

import ThreeTierArchitecture.dao.Email_last;
import ThreeTierArchitecture.entity.Route;
import ThreeTierArchitecture.service.RouteService;
import ThreeTierArchitecture.service.SendMail_method;
import com.sun.mail.smtp.SMTPSSLTransport;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.security.GeneralSecurityException;
import java.util.*;

@WebServlet(name = "RouteServlet" ,urlPatterns = "/regist")
public class RouteServlet extends HttpServlet {
    private String username,userphone,userlocal,usershoe;
    private RouteService rs = new RouteService();
    private SendMail_method sm  = new SendMail_method();
    Email_last el = new Email_last();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String[]> map = request.getParameterMap();

        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            if((entry.getKey()).equals("username") ){
                this.username = Arrays.toString(entry.getValue());
            }
            else if((entry.getKey()).equals("userphone") ){
                this.userphone = Arrays.toString(entry.getValue());
            }
            else if((entry.getKey()).equals("userlocal") ){
                this.userlocal = Arrays.toString(entry.getValue());
            }
            else if((entry.getKey()).equals("usershoe") ){
                this.usershoe = Arrays.toString(entry.getValue());
            }
        }
        
        
        if (rs.findAllRoutes(map)) {

            Writer out = response.getWriter();
            out.write("1");
            out.flush();

        } else {
            System.out.println("fail");
        }
        Email email = new SimpleEmail();
        email.setHostName("smtp.qq.com");
        email.setAuthentication("********", "********");
        email.setSslSmtpPort("465");
        try {
            Session session = email.getMailSession();
            MimeMessage message = new MimeMessage(session);
            InternetAddress from = new InternetAddress("********");
            message.setFrom(from);
            InternetAddress to = new InternetAddress("*******");
            message.setRecipient(MimeMessage.RecipientType.TO, to);
            message.setSubject("您有新的订单啦！！！");
            message.setSentDate(new Date());
            message.setContent("昵称:"+username+" "+"电话:"+userphone+" "+"地址:"+userlocal+" "+"数量:"+usershoe+" ", "text/html;charset=UTF-8");

            Transport transport = new SMTPSSLTransport(session, null);
            transport.connect("smtp.qq.com","********","**********");
            transport.sendMessage(message, message.getAllRecipients());

        } catch (EmailException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (AddressException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GET ONE MESSAGE");
        response.setContentType("text/html;charset=utf-8");
        /*设置响应头允许ajax跨域访问*/
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET");
        /*传入变量*/
        doPost(request,response);
 



    }

    }

