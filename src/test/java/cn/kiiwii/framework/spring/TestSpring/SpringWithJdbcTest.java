package cn.kiiwii.framework.spring.TestSpring;

import cn.kiiwii.framework.spring.TestSpring.springwithhibernate.model.Account;
import cn.kiiwii.framework.spring.TestSpring.springwithjdbc.dynamicdatasource.DatabaseContextHolder;
import cn.kiiwii.framework.spring.TestSpring.springwithjdbc.service.ITestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContextwithjdbc.xml")
public class SpringWithJdbcTest {
    @Resource(name = "testService")
    private ITestService testService;

    @Test
    public void init() {
        for (int i = 0; i < 5; i++) {
            Account account = new Account();
            account.setMoney(1000);
            account.setName("zhonglin");
        }
    }

    @Test
    public void testTransation() {
        boolean b;
        try {
            b = testService.transfer(200, 1, 2);
            if (b) {
                System.out.println("转账成功");
            } else {
                System.out.println("转账失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("转账失败");
        }
    }

    @Test
    public void testFind() {
        try {
            DatabaseContextHolder.setDataSourceOne();
            Map<String, Object> map = testService.findById(1);
            System.out.println("one>>" + map);
            DatabaseContextHolder.setDataSourceTwo();
            Map<String, Object> map1 = testService.findById(1);
            System.out.println("two>>" + map1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
