package cn.crm.service.impl;

import cn.crm.mapper.BaseDictMapper;
import cn.crm.pojo.BaseDict;
import cn.crm.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseDictServiceImpl implements BaseDictService {
    @Autowired
    private BaseDictMapper baseDictMapper;
    public List<BaseDict> findBaseDict(String base_dict_code) {
        List<BaseDict> list = baseDictMapper.findBaseDict(base_dict_code);
        return list;
    }
}
