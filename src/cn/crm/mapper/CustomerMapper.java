package cn.crm.mapper;

import cn.crm.pojo.Customer;
import cn.crm.pojo.QueryVo;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomerMapper {
    //select * from customer c where c.cust_name like '%黑%' and c.cust_source='6' and c.cust_industry='1' and c.cust_level='22'
    List<Customer>findCustomer(QueryVo queryVo);
    //select count(*) from customer c where c.cust_name like '%黑%' and c.cust_source='6' and c.cust_industry='1' and c.cust_level='22'
    public int findTotalCount(QueryVo queryVo);

    Customer findById(long id);

    void updateCustomer(Customer customer);

    void deleteCustomer(long id);
}
