package com.bigcat.app.service.impl;

import com.bigcat.app.pojo.Way;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WayService {

    public BigDecimal getOdds(Integer resultSum, Way way , Integer oddsLoc){

        BigDecimal odds = null;

        if(resultSum.equals(22)){
            odds = getOdds(way.getOdds22(), oddsLoc, way.getOdds());
        }else if(resultSum.equals(23)){
            odds = getOdds(way.getOdds23(), oddsLoc, way.getOdds());
        }else{
            odds = getOdds(way.getOdds(), oddsLoc, way.getOdds());
        }

        return odds;
    }


    public BigDecimal getOdds(String odds22RO23,Integer oddsLoc,String odds){
        String[] array = odds22RO23.split("|");
        try{
            return new BigDecimal(array[oddsLoc-1]);
        }catch (Exception e){
            String s = odds.split("|")[oddsLoc];
            return new BigDecimal(s);
        }
    }

}
