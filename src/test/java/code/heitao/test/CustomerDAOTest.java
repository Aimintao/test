package code.heitao.test;

import code.heitao.small.framework.base.BaseDAO;
import code.heitao.small.framework.base.BaseDAOImpl;
import code.heitao.test.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aimin
 * @Title: CustomerDAOTest
 * @ProjectName lightFrame架构
 * @Description: 客户单元接口测试
 * @date 2018/6/13 18:49
 */
@Slf4j
public class CustomerDAOTest extends BaseDAOImpl<Customer> {

    @Before
    public void init() throws Exception {
        executeSqlFile("sql/customer_init.sql");
        System.out.println("=====begin====init====");
    }

    @Test
    public void getCustomerListTest() throws Exception {
        log.info("=====begin====Test====");
        System.out.println("=====begin====Test====");
        String sql = "SELECT * FROM customer";
        List<Customer> customerList = this.queryEntityList(Customer.class,sql);
        for (Customer customer :
                customerList) {
            System.out.println("=====customerList====name====" + customer.getName());
        }

        Assert.assertEquals(2, customerList.size());
    }


}
