package servlet;

import org.springframework.jdbc.core.JdbcTemplate;

public class Test7 {
    public Test7(String username) {
        System.out.println("connected mysql succees");
        // 1.创建JdbcTemplate对象，需要注入参数DataSource
        JdbcTemplate jt = new JdbcTemplate(dataSourceUtils.getDatasource());
        // 2.自定义SQL语句
        String sql = "insert into test_text values(?,?)";
        // 3.调用JdbcTemplate的update()方法 ，给SQL语句中的问号赋值
        //4.得到执行结果
        int i = jt.update(sql,  null,username);
        System.out.println("insert message :" + i);
    }




}
