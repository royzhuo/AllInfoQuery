import com.controller.LogionController;
import com.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring.xml"})
public class testSpring {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private LoginService loginService;

    @Test
    public void testDataSource(){
        System.out.println("数据源:"+dataSource);

        try {
            System.out.println("数据源链接:"+dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("用户名:"+loginService.getUsername());
    }
}
