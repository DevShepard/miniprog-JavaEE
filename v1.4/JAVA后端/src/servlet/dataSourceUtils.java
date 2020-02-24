package servlet;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.util.Properties;

public class dataSourceUtils {
        private  static DataSource ds = null;
        static {
            Properties prop = new Properties();
            try {
                prop.load(dataSourceUtils.class.getResourceAsStream("/druid.properties"));
                ds = DruidDataSourceFactory.createDataSource(prop);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public static DataSource getDatasource() {
            return ds;
        }
    }


