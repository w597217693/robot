package com.bigcat.app.handler;

import com.bigcat.app.anno.RequestMessage;
import com.bigcat.app.dto.Flag;
import com.bigcat.app.pojo.*;
import com.bigcat.app.service.impl.FinanceService;
import com.bigcat.app.service.impl.TemplateService;
import com.bigcat.app.utils.AppUtils;
import com.bigcat.app.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class HNK5Calculation {

    private SSCCalculation calculation;

    public HNK5Calculation(){
        calculation = AppUtils.support.getCalculation();
    }

    @RequestMessage(Path = "/SSC/散")
    public Object san(Map<String,Object> data){
        return execute(data,(result,map)->{
            int sum = AppUtils.support.getUtils().resultSum(result).intValue();
            List<Integer> results = Arrays.stream(result.split(",")).map(ele -> Integer.parseInt(ele)).collect(Collectors.toList());
            return calculation.san(sum,results);
        });
    }
    @RequestMessage(Path = "/SSC/重")
    public Object chong(Map<String,Object> data){
        return execute(data,(result,map)->{
            int sum = AppUtils.support.getUtils().resultSum(result).intValue();
            List<Integer> results = Arrays.stream(result.split(",")).map(ele -> Integer.parseInt(ele)).collect(Collectors.toList());
            return calculation.chong(sum,results);
        });
    }

    @RequestMessage(Path = "/SSC/龙")
    public Object lon(Map<String,Object> data){
        return execute(data,(result,map)->{
            int sum = AppUtils.support.getUtils().resultSum(result).intValue();
            List<Integer> results = Arrays.stream(result.split(",")).map(ele -> Integer.parseInt(ele)).collect(Collectors.toList());
            return calculation.lon(sum,results);
        });
    }

    @RequestMessage(Path = "/SSC/连码")
    public Object lianMa(Map<String,Object> data){
        return execute(data,(result,map)->{
            int sum = AppUtils.support.getUtils().resultSum(result).intValue();
            List<Integer> results = Arrays.stream(result.split(",")).map(ele -> Integer.parseInt(ele)).collect(Collectors.toList());
            List<Integer> numbers = (List<Integer>)map.get("numbers");
            return calculation.lianMa(sum,results,numbers);
        });
    }

    @RequestMessage(Path = "/SSC/定位号码")
    public Object dingWeiHaoMa(Map<String,Object> data){
        return execute(data,(result,map)->{
            int sum = AppUtils.support.getUtils().resultSum(result).intValue();
            List<Integer> results = Arrays.stream(result.split(",")).map(ele -> Integer.parseInt(ele)).collect(Collectors.toList());
            int index = ((Integer) map.get("index")).intValue();
            int number = ((Integer) map.get("number")).intValue();
            return calculation.dingWeiHaoMa(index,number,sum,results);
        });
    }

    @RequestMessage(Path = "/SSC/定位大")
    public Object dingWeiDa(Map<String,Object> data){
        return execute(data,(result,map)->{
            int sum = AppUtils.support.getUtils().resultSum(result).intValue();
            List<Integer> results = Arrays.stream(result.split(",")).map(ele -> Integer.parseInt(ele)).collect(Collectors.toList());
            int index = ((Integer) map.get("index")).intValue();
            return calculation.dingWeiDa(index,sum,results);
        });
    }
    @RequestMessage(Path = "/SSC/定位小")
    public Object dingWeiXiao(Map<String,Object> data){
        return execute(data,(result,map)->{
            int sum = AppUtils.support.getUtils().resultSum(result).intValue();
            List<Integer> results = Arrays.stream(result.split(",")).map(ele -> Integer.parseInt(ele)).collect(Collectors.toList());
            int index = ((Integer) map.get("index")).intValue();
            return calculation.dingWeiXiao(index,sum,results);
        });
    }
    @RequestMessage(Path = "/SSC/定位单")
    public Object dingWeiDan(Map<String,Object> data){
        return execute(data,(result,map)->{
            int sum = AppUtils.support.getUtils().resultSum(result).intValue();
            List<Integer> results = Arrays.stream(result.split(",")).map(ele -> Integer.parseInt(ele)).collect(Collectors.toList());
            int index = ((Integer) map.get("index")).intValue();
            return calculation.dingWeiDan(index,sum,results);
        });
    }
    @RequestMessage(Path = "/SSC/定位双")
    public Object dingWeiShuang(Map<String,Object> data){
        return execute(data,(result,map)->{
            int sum = AppUtils.support.getUtils().resultSum(result).intValue();
            List<Integer> results = Arrays.stream(result.split(",")).map(ele -> Integer.parseInt(ele)).collect(Collectors.toList());
            int index = ((Integer) map.get("index")).intValue();
            return calculation.dingWeiShuang(index,sum,results);
        });
    }
    @RequestMessage(Path = "/SSC/大单")
    public Object daDan(Map<String,Object> data){
        return execute(data,(result,map)->{
            int sum = AppUtils.support.getUtils().resultSum(result).intValue();
            return calculation.daDan(sum);
        });
    }
    @RequestMessage(Path = "/SSC/大双")
    public Object daShuang(Map<String,Object> data){
        return execute(data,(result,map)->{
            int sum = AppUtils.support.getUtils().resultSum(result).intValue();
            return calculation.daShuang(sum);
        });
    }
    @RequestMessage(Path = "/SSC/小单")
    public Object xiaoDan(Map<String,Object> data){
        return execute(data,(result,map)->{
            int sum = AppUtils.support.getUtils().resultSum(result).intValue();
            return calculation.xiaoDan(sum);
        });
    }
    @RequestMessage(Path = "/SSC/小双")
    public Object xiaoShuang(Map<String,Object> data){
        return execute(data,(result,map)->{
            int sum = AppUtils.support.getUtils().resultSum(result).intValue();
            return calculation.xiaoDan(sum);
        });
    }


    @RequestMessage(Path = "/SSC/大")
    public Object da(Map<String,Object> data){
        return execute(data,(result,map)->{
            int sum = AppUtils.support.getUtils().resultSum(result).intValue();
            return calculation.da(sum);
        });
    }

    @RequestMessage(Path = "/SSC/小")
    public Object xiao(Map<String,Object> data){
        return execute(data,(result,map)->{
            int sum = AppUtils.support.getUtils().resultSum(result).intValue();
            return calculation.xiao(sum);
        });
    }

    @RequestMessage(Path = "/SSC/单")
    public Object dan(Map<String,Object> data){
        return execute(data,(result,map)->{
            int sum = AppUtils.support.getUtils().resultSum(result).intValue();
            return calculation.dan(sum);
        });
    }

    @RequestMessage(Path = "/SSC/双")
    public Object shuang(Map<String,Object> data){
        return execute(data,(result,map)->{
            int sum = AppUtils.support.getUtils().resultSum(result).intValue();
            return calculation.shuang(sum);
        });
    }

    @RequestMessage(Path = "/SSC/和")
    public Object he(Map<String,Object> data){
        return execute(data,(result,map)->{
            int sum = AppUtils.support.getUtils().resultSum(result).intValue();
            return calculation.he(sum);
        });
    }



    @RequestMessage(Path = "/SSC/虎")
    public Object hu(Map<String,Object> data){
        return execute(data,(result,map)->{
            int sum = AppUtils.support.getUtils().resultSum(result).intValue();
            List<Integer> results = Arrays.stream(result.split(",")).map(ele -> Integer.parseInt(ele)).collect(Collectors.toList());
            return calculation.hu(sum,results);
        });
    }

    @RequestMessage(Path = "/SSC/合")
    public Object lonHuHe(Map<String,Object> data){
        return execute(data,(result,map)->{
            int sum = AppUtils.support.getUtils().resultSum(result).intValue();
            List<Integer> results = Arrays.stream(result.split(",")).map(ele -> Integer.parseInt(ele)).collect(Collectors.toList());
            return calculation.he(sum,results);
        });
    }



    @RequestMessage(Path = "/SSC/单码")
    public Object danMa(Map<String,Object> data){
        return execute(data,(result,map)->{
            int number = ((Integer)map.get("number")).intValue();
            int sum = AppUtils.support.getUtils().resultSum(result).intValue();
            List<Integer> results = Arrays.stream(result.split(",")).map(ele -> Integer.parseInt(ele)).collect(Collectors.toList());
            return calculation.danMa(number,sum,results);
        });
    }


    private Finance execute(Map<String,Object> data , BiFunction<String,Map<String,Object>,GameResult> handler){
        String result = (String) data.get("result");
        BigDecimal money = (BigDecimal) data.get("money");
        Player player = (Player) data.get("player");
        Object o = data.get("data");
        Map<String,Object> map = null;
        if(o != null && o instanceof Map){
            map = (Map<String,Object>) o;
        }


        return sentence(money,result,player,map,handler);
    }

    private Finance sentence(BigDecimal money,String result,Player player,Map<String,Object> data,BiFunction<String,Map<String,Object>,GameResult> handler){
        GameResult gameResult = handler.apply(result,data);

        Finance finance = null;
        if(gameResult.isWin()){
            BigDecimal financeMoney = gameResult.getOdds().multiply(money.abs());
            finance = getFinanceService().add(ConstantUtils.FinanceType.Win.index,player, ConstantUtils.FinanceStatus.Examine.index,financeMoney);
        }else{
            finance = getFinanceService().add(ConstantUtils.FinanceType.Lose.index,player, ConstantUtils.FinanceStatus.Examine.index,new BigDecimal(0));
        }

        return finance;
    }


    private FinanceService getFinanceService(){
        return AppUtils.support.getFinanceService();
    }
    private TemplateService getTemplateService(){
        return AppUtils.support.getTemplateService();
    }

    public static void main(String[] args) {
    }

}
