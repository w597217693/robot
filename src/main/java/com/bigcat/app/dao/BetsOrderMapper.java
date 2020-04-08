package com.bigcat.app.dao;

import com.bigcat.app.pojo.BetsOrder;
import com.bigcat.app.pojo.BetsOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BetsOrderMapper {
    long countByExample(BetsOrderExample example);

    int deleteByExample(BetsOrderExample example);

    int insert(BetsOrder record);

    int insertSelective(BetsOrder record);

    List<BetsOrder> selectByExampleWithBLOBs(BetsOrderExample example);

    List<BetsOrder> selectByExample(BetsOrderExample example);

    int updateByExampleSelective(@Param("record") BetsOrder record, @Param("example") BetsOrderExample example);

    int updateByExampleWithBLOBs(@Param("record") BetsOrder record, @Param("example") BetsOrderExample example);

    int updateByExample(@Param("record") BetsOrder record, @Param("example") BetsOrderExample example);
}