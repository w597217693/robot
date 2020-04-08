package com.bigcat.app.dao;

import com.bigcat.app.pojo.OpenRecord;
import com.bigcat.app.pojo.OpenRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpenRecordMapper {
    long countByExample(OpenRecordExample example);

    int deleteByExample(OpenRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(OpenRecord record);

    int insertSelective(OpenRecord record);

    List<OpenRecord> selectByExample(OpenRecordExample example);

    OpenRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OpenRecord record, @Param("example") OpenRecordExample example);

    int updateByExample(@Param("record") OpenRecord record, @Param("example") OpenRecordExample example);

    int updateByPrimaryKeySelective(OpenRecord record);

    int updateByPrimaryKey(OpenRecord record);
}