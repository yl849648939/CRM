package cn.crm.mapper;

import cn.crm.pojo.BaseDict;

import java.util.List;

public interface BaseDictMapper {
   List<BaseDict> findBaseDict(String base_dict_code);
}
