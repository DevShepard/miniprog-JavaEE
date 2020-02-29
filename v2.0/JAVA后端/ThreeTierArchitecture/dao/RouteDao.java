package ThreeTierArchitecture.dao;

import ThreeTierArchitecture.entity.Route;
import ThreeTierArchitecture.util.DataSourceUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;

public class RouteDao {
    private JdbcTemplate jt = new JdbcTemplate(DataSourceUtils.getDatasource());
    public boolean findAllRoutes(String test_text) {

        System.out.println("connected mysql succees");
        // 1.创建JdbcTemplate对象，需要注入参数DataSource
        JdbcTemplate jt = new JdbcTemplate(DataSourceUtils.getDatasource());
        // 2.自定义SQL语句
        String sql = "insert into test_text values(?,?)";
        // 3.调用JdbcTemplate的update()方法 ，给SQL语句中的问号赋值
        //4.得到执行结果
        int i = jt.update(sql,null,test_text);
        return true;

    }

}
