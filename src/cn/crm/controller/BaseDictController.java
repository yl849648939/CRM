package cn.crm.controller;

import cn.crm.pojo.BaseDict;
import cn.crm.pojo.Customer;
import cn.crm.pojo.QueryVo;
import cn.crm.service.BaseDictService;
import cn.crm.service.impl.CustomerService;
import cn.crm.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller

public class BaseDictController {
    @Autowired
private BaseDictService baseDictService;
    @Autowired
    CustomerService customerService;
    @RequestMapping("/list")
public String findBaseDict(Model model, QueryVo queryVo){
    List<BaseDict> sourceList = baseDictService.findBaseDict("002");
    List<BaseDict> industryList = baseDictService.findBaseDict("001");
    List<BaseDict> levelList = baseDictService.findBaseDict("006");
    model.addAttribute("sourceList",sourceList);
    model.addAttribute("industryList",industryList);
    model.addAttribute("levelList",levelList);
    //分页查询
        //计算总页数 int pageCount = page.getTotalCount() / page.getPageSize();
        if(queryVo.getCurrentPage()==0){
            queryVo.setCurrentPage(1);
        }
        if(queryVo.getPageSize()==0){
            queryVo.setPageSize(5);
        }
        queryVo.setStart((queryVo.getCurrentPage()-1)*queryVo.getPageSize());
        PageBean pageBean = customerService.findCustomer(queryVo);
        //		获取分页数据
        model.addAttribute("page", pageBean);
        //数据回显
        model.addAttribute("custSource",queryVo.getCustSource());
        model.addAttribute("custName",queryVo.getCustName());
        model.addAttribute("custIndustry",queryVo.getCustIndustry());
        model.addAttribute("custLevel",queryVo.getCustLevel());
        return "customer";
}
@RequestMapping("/edit")
@ResponseBody
    public Customer findById(long id){
    Customer customer = customerService.findById(id);
    return customer;
}
@RequestMapping("/update")
    @ResponseBody
    public boolean update(Customer customer){
        try {
            customerService.updateCustomer(customer);
            return true;
        }
        catch (Exception e){
            return  false;

        }

}
    @RequestMapping("/delete")
    @ResponseBody
    public boolean delete(long id){
        try {
            customerService.deleteCustomer(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
