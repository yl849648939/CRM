package cn.crm.service;

import cn.crm.pojo.BaseDict;

import java.util.List;

public interface BaseDictService {
    List<BaseDict> findBaseDict(String base_dict_code);
}
