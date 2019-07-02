package cn.crm.service.impl;

import cn.crm.mapper.CustomerMapper;
import cn.crm.pojo.Customer;
import cn.crm.pojo.QueryVo;
import cn.crm.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.List;


public interface CustomerService {
    PageBean findCustomer(QueryVo queryVo);

    Customer findById(long id);

    void updateCustomer(Customer customer);

    void deleteCustomer(long id);
}
