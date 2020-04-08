package com.bigcat.app.dao;

import com.bigcat.app.pojo.DictType;
import com.bigcat.app.pojo.DictTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictTypeMapper {
    long countByExample(DictTypeExample example);

    int deleteByExample(DictTypeExample example);

    int deleteByPrimaryKey(String id);

    int insert(DictType record);

    int insertSelective(DictType record);

    List<DictType> selectByExample(DictTypeExample example);

    DictType selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DictType record, @Param("example") DictTypeExample example);

    int updateByExample(@Param("record") DictType record, @Param("example") DictTypeExample example);

    int updateByPrimaryKeySelective(DictType record);

    int updateByPrimaryKey(DictType record);
}