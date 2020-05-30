package ThreeTierArchitecture.dao;

import ThreeTierArchitecture.entity.Route;
import ThreeTierArchitecture.service.SendMail_method;
import ThreeTierArchitecture.util.DataSourceUtils;
import com.mysql.jdbc.exceptions.jdbc4.MySQLTimeoutException;
import com.sun.mail.smtp.SMTPSSLTransport;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Timer;

import static java.lang.System.*;

public class RouteDao {
    private String userName,userPhone,userLocal,usershoe;
    public boolean findAllRoutes(String username,String userphone,String userlocal,String usershoe)  {

        this.userName = username;
        this.userPhone = userphone;
        this.userLocal = userlocal;
        this.usershoe = usershoe;



        out.println("数据库连接成功！");
        // 1.创建JdbcTemplate对象，需要注入参数DataSource
        JdbcTemplate jt = new JdbcTemplate(DataSourceUtils.getDatasource());
        // 2.自定义SQL语句
        String sql = "insert into tab_route values(?,?,?,?,?,?)";
        //String sql2 = "insert into tab_user_phone values(?,?)";
        // 3.调用JdbcTemplate的update()方法 ，给SQL语句中的问号赋值
        //4.得到执行结果
        Date date = new Date();
        String time = date.toString();
        out.println("insert sueecss");
        out.println(time);
        try {
            // 链接数据库的代码

            jt.update(sql,null,userName,userPhone,userLocal,usershoe,time);



        }catch (Exception e) {
            if (e instanceof MySQLTimeoutException) {
                out.println("数据库连接超时");
                return false;
            }
        }

        return true;

    }

}
