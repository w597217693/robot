package com.bigcat.app.dao;

import com.bigcat.app.pojo.Way;
import com.bigcat.app.pojo.WayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WayMapper {
    long countByExample(WayExample example);

    int deleteByExample(WayExample example);

    int deleteByPrimaryKey(String id);

    int insert(Way record);

    int insertSelective(Way record);

    List<Way> selectByExample(WayExample example);

    Way selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Way record, @Param("example") WayExample example);

    int updateByExample(@Param("record") Way record, @Param("example") WayExample example);

    int updateByPrimaryKeySelective(Way record);

    int updateByPrimaryKey(Way record);
}