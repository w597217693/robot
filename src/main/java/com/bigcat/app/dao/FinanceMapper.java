package com.bigcat.app.dao;

import com.bigcat.app.dto.WinTemplateBean;
import com.bigcat.app.pojo.Finance;
import com.bigcat.app.pojo.FinanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FinanceMapper {
    long countByExample(FinanceExample example);

    int deleteByExample(FinanceExample example);

    int deleteByPrimaryKey(String id);

    int insert(Finance record);

    int insertSelective(Finance record);

    List<Finance> selectByExample(FinanceExample example);

    Finance selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Finance record, @Param("example") FinanceExample example);

    int updateByExample(@Param("record") Finance record, @Param("example") FinanceExample example);

    int updateByPrimaryKeySelective(Finance record);

    int updateByPrimaryKey(Finance record);

    /**
     * 根据游戏id和期号获取，该期中奖名单body中所需属性
     * @param gameId
     * @param period
     * @return
     */
    List<WinTemplateBean> getWinBillBody(String gameId,Long period);
}