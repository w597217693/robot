package com.bigcat.app.dao;

import com.bigcat.app.pojo.Game;
import com.bigcat.app.pojo.GameExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GameMapper {
    long countByExample(GameExample example);

    int deleteByExample(GameExample example);

    int deleteByPrimaryKey(String id);

    int insert(Game record);

    int insertSelective(Game record);

    List<Game> selectByExample(GameExample example);

    Game selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Game record, @Param("example") GameExample example);

    int updateByExample(@Param("record") Game record, @Param("example") GameExample example);

    int updateByPrimaryKeySelective(Game record);

    int updateByPrimaryKey(Game record);
}