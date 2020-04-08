package com.bigcat.app.dao;

import com.bigcat.app.pojo.PlayerIn;
import com.bigcat.app.pojo.PlayerInExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlayerInMapper {
    long countByExample(PlayerInExample example);

    int deleteByExample(PlayerInExample example);

    int insert(PlayerIn record);

    int insertSelective(PlayerIn record);

    List<PlayerIn> selectByExample(PlayerInExample example);

    int updateByExampleSelective(@Param("record") PlayerIn record, @Param("example") PlayerInExample example);

    int updateByExample(@Param("record") PlayerIn record, @Param("example") PlayerInExample example);
}