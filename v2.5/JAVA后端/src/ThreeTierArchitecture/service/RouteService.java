package ThreeTierArchitecture.service;

import ThreeTierArchitecture.dao.RouteDao;
import ThreeTierArchitecture.entity.Route;
import ThreeTierArchitecture.service.SendMail_method;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RouteService {
    private String username,userphone,userlocal,usershoe;
    private RouteDao rd = new RouteDao();
    private SendMail_method sm = new SendMail_method();



    public boolean findAllRoutes(Map<String, String[]> map)  {

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
        if (rd.findAllRoutes(username,userphone,userlocal,usershoe)) {
            return true;
        }else {
            return false;
        }
    }
    }
