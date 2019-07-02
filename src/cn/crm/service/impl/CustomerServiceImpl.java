package cn.crm.service.impl;

import cn.crm.mapper.CustomerMapper;
import cn.crm.pojo.Customer;
import cn.crm.pojo.QueryVo;
import cn.crm.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
   private CustomerMapper customerMapper;
    public PageBean findCustomer(QueryVo queryVo) {
        PageBean pageBean=new PageBean<Customer>();
        List<Customer> customer = customerMapper.findCustomer(queryVo);
        int totalCount = customerMapper.findTotalCount(queryVo);
        pageBean.setList(customer);
        pageBean.setPageSize(queryVo.getPageSize());
        pageBean.setTotalCount(totalCount);
        pageBean.setCurrentPage(queryVo.getCurrentPage());
        return pageBean;
    }

    public Customer findById(long id) {
        Customer customer = customerMapper.findById(id);
        return  customer;
    }

    public void updateCustomer(Customer customer) {
        customerMapper.updateCustomer(customer);
    }

    public void deleteCustomer(long id) {
        customerMapper.deleteCustomer(id);
    }
}
