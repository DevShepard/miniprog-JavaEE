package ThreeTierArchitecture.dao;

import ThreeTierArchitecture.entity.Route;
import ThreeTierArchitecture.util.DataSourceUtils;
import com.mysql.jdbc.exceptions.jdbc4.MySQLTimeoutException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;

public class RouteDao {
    private String userName,userPhone,userLocal;
    public boolean findAllRoutes(String username,String userphone,String userlocal) {
        this.userName = username;
        this.userPhone = userphone;
        this.userLocal = userlocal;
        System.out.println("数据库连接成功！");
        // 1.创建JdbcTemplate对象，需要注入参数DataSource
        JdbcTemplate jt = new JdbcTemplate(DataSourceUtils.getDatasource());
        // 2.自定义SQL语句
        String sql = "insert into tab_route values(?,?,?,?)";
        // 3.调用JdbcTemplate的update()方法 ，给SQL语句中的问号赋值
        //4.得到执行结果
        try {
            // 链接数据库的代码
            jt.update(sql,null,userName,userPhone,userLocal);

        }catch (Exception e) {
            if (e instanceof MySQLTimeoutException) {
                System.out.println("数据库连接超时");
            }
        }

        System.out.println("succeed");
        return true;

    }

}
