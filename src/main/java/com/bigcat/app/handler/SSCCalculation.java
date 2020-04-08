package com.bigcat.app.handler;

import com.bigcat.app.dao.WayMapper;
import com.bigcat.app.dto.Flag;
import com.bigcat.app.pojo.Way;
import com.bigcat.app.service.impl.TemplateService;
import com.bigcat.app.service.impl.WayService;
import com.bigcat.app.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SSCCalculation {

    @Autowired
    private WayMapper wayMapper;

    @Autowired
    private TemplateService templateService;

    @Autowired
    private WayService wayService;

    public GameResult da(int sum){
        GameResult gameResult = new GameResult();
        if (sum > 23) {
            gameResult.setWin(true);
        }
        if(sum == 23){
            // 判断是否开启23为和
            Flag is23He = templateService.flag("f8ec5e36-68e3-11ea-8753-0242ac110002");
            if(is23He.isOpen()){
                Flag is23Da = templateService.flag("ed462117-68e3-11ea-8753-0242ac110002");
                gameResult.setWin(is23Da.isOpen());
            }
        }
        Way way = wayMapper.selectByPrimaryKey("5b856dde-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way, 0);
        gameResult.setOdds(odds);
        return gameResult;
    }

    public GameResult xiao(int sum){

        GameResult gameResult = new GameResult();

        if(sum < 22){
            gameResult.setWin(true);
        }
        if(sum == 22){
            // 判断是否开启22为和
            Flag is22He = AppUtils.support.getTemplateService().flag("eb293c27-68e3-11ea-8753-0242ac110002");
            if(is22He.isOpen()){
                Flag is22Xiao = templateService.flag("729d037e-68e4-11ea-8753-0242ac110002");
                gameResult.setWin(true);
            }
        }

        Way way = wayMapper.selectByPrimaryKey("5b856e12-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way, 0);
        gameResult.setOdds(odds);
        return gameResult;
    }

    public GameResult he(int sum){

        GameResult gameResult = new GameResult();

        if(sum == 22){
            Flag is22He = AppUtils.support.getTemplateService().flag("eb293c27-68e3-11ea-8753-0242ac110002");
            if(is22He.isOpen()){
                gameResult.setWin(true);
            }
        }

        if(sum == 23){
            Flag is23He = templateService.flag("f8ec5e36-68e3-11ea-8753-0242ac110002");
            if(is23He.isOpen()){
                gameResult.setWin(true);
            }
        }
        Way way = wayMapper.selectByPrimaryKey("5b856e44-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way, 0);
        gameResult.setOdds(odds);

        return gameResult;
    }


    public GameResult dan(int sum){
        GameResult gameResult = new GameResult();
        gameResult.setWin(sum % 2 != 0);

        Way way = wayMapper.selectByPrimaryKey("5b856e7b-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way, 0);
        gameResult.setOdds(odds);
        return gameResult;
    }

    public GameResult shuang(int sum){
        GameResult gameResult = new GameResult();
        gameResult.setWin(sum % 2 == 0);

        Way way = wayMapper.selectByPrimaryKey("5b856eb8-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way, 0);
        gameResult.setOdds(odds);
        return gameResult;
    }

    public GameResult lon(int sum ,  List<Integer> results){
        GameResult gameResult = new GameResult();
        if(results.get(0).intValue() > results.get(results.size()-1).intValue()){
            gameResult.setWin(true);
        }

        Way way = wayMapper.selectByPrimaryKey("5b8566b5-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way, 0);
        gameResult.setOdds(odds);
        return gameResult;
    }

    public GameResult hu(int sum ,  List<Integer> results){
        GameResult gameResult = new GameResult();
        if(results.get(0).intValue() < results.get(results.size()-1).intValue()){
            gameResult.setWin(true);
        }

        Way way = wayMapper.selectByPrimaryKey("5b856afa-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way, 0);
        gameResult.setOdds(odds);
        return gameResult;
    }

    public GameResult he(int sum ,  List<Integer> results){
        GameResult gameResult = new GameResult();
        if(results.get(0).intValue() == results.get(results.size()-1).intValue()){
            gameResult.setWin(true);
        }

        Way way = wayMapper.selectByPrimaryKey("5b856afa-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way, 0);
        gameResult.setOdds(odds);
        return gameResult;
    }


    public GameResult daDan(int sum){
        GameResult gameResult = new GameResult();
        gameResult.setWin(dan(sum).isWin() == da(sum).isWin());

        Way way = wayMapper.selectByPrimaryKey("5b8568a7-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way, 0);
        gameResult.setOdds(odds);
        return gameResult;
    }

    public GameResult daShuang(int sum){
        GameResult gameResult = new GameResult();
        gameResult.setWin(shuang(sum).isWin() == da(sum).isWin());

        Way way = wayMapper.selectByPrimaryKey("5b8568a7-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way, 0);
        gameResult.setOdds(odds);
        return gameResult;
    }

    public GameResult xiaoDan(int sum){
        GameResult gameResult = new GameResult();
        gameResult.setWin(dan(sum).isWin() == xiao(sum).isWin());

        Way way = wayMapper.selectByPrimaryKey("5b8569e6-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way, 0);
        gameResult.setOdds(odds);
        return gameResult;
    }

    public GameResult xiaoShuang(int sum){
        GameResult gameResult = new GameResult();
        gameResult.setWin(shuang(sum).isWin() == xiao(sum).isWin());

        Way way = wayMapper.selectByPrimaryKey("5b8569e6-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way, 0);
        gameResult.setOdds(odds);
        return gameResult;
    }

    public GameResult daDanLong(int sum ,  List<Integer> results){
        GameResult gameResult = new GameResult();
        gameResult.setWin(da(sum).isWin()==dan(sum).isWin()==lon(sum,results).isWin());
        Way way = wayMapper.selectByPrimaryKey("5b856a4f-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way, 0);
        gameResult.setOdds(odds);
        return gameResult;
    }
    public GameResult daDanHu(int sum ,  List<Integer> results){
        GameResult gameResult = new GameResult();
        gameResult.setWin(da(sum).isWin()==dan(sum).isWin()==hu(sum,results).isWin());
        Way way = wayMapper.selectByPrimaryKey("5b856a4f-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way, 1);
        gameResult.setOdds(odds);
        return gameResult;
    }
    public GameResult daShuangLong(int sum ,  List<Integer> results){
        GameResult gameResult = new GameResult();
        gameResult.setWin(da(sum).isWin()==shuang(sum).isWin()==lon(sum,results).isWin());
        Way way = wayMapper.selectByPrimaryKey("5b856a4f-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way, 2);
        gameResult.setOdds(odds);
        return gameResult;
    }

    public GameResult daShuangHu(int sum ,  List<Integer> results){
        GameResult gameResult = new GameResult();
        gameResult.setWin(da(sum).isWin()==shuang(sum).isWin()==hu(sum,results).isWin());
        Way way = wayMapper.selectByPrimaryKey("5b856a4f-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way, 3);
        gameResult.setOdds(odds);
        return gameResult;
    }
    public GameResult xiaoDanLong(int sum ,  List<Integer> results){
        GameResult gameResult = new GameResult();
        gameResult.setWin(xiao(sum).isWin()==dan(sum).isWin()==lon(sum,results).isWin());
        Way way = wayMapper.selectByPrimaryKey("5b856a4f-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way, 4);
        gameResult.setOdds(odds);
        return gameResult;
    }
    public GameResult xiaoDanhu(int sum ,  List<Integer> results){
        GameResult gameResult = new GameResult();
        gameResult.setWin(xiao(sum).isWin()==dan(sum).isWin()==lon(sum,results).isWin());
        Way way = wayMapper.selectByPrimaryKey("5b856a4f-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way, 5);
        gameResult.setOdds(odds);
        return gameResult;
    }
    public GameResult xiaoShuangLong(int sum ,  List<Integer> results){
        GameResult gameResult = new GameResult();
        gameResult.setWin(xiao(sum).isWin()==shuang(sum).isWin()==lon(sum,results).isWin());
        Way way = wayMapper.selectByPrimaryKey("5b856a4f-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way, 6);
        gameResult.setOdds(odds);
        return gameResult;
    }
    public GameResult xiaoShuangHu(int sum ,  List<Integer> results){
        GameResult gameResult = new GameResult();
        gameResult.setWin(xiao(sum).isWin()==shuang(sum).isWin()==hu(sum,results).isWin());
        Way way = wayMapper.selectByPrimaryKey("5b856a4f-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way, 7);
        gameResult.setOdds(odds);
        return gameResult;
    }
    public GameResult daLon(int sum , List<Integer> results){
        GameResult gameResult = new GameResult();
        gameResult.setWin(da(sum).isWin() == lon(sum,results).isWin());
        Way way = wayMapper.selectByPrimaryKey("5b856a8b-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way, 0);
        gameResult.setOdds(odds);
        return gameResult;
    }
    public GameResult daHu(int sum , List<Integer> results){
        GameResult gameResult = new GameResult();
        gameResult.setWin(da(sum).isWin() == hu(sum,results).isWin());
        Way way = wayMapper.selectByPrimaryKey("5b856a8b-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way, 1);
        gameResult.setOdds(odds);
        return gameResult;
    }
    public GameResult xiaoLon(int sum , List<Integer> results){
        GameResult gameResult = new GameResult();
        gameResult.setWin(xiao(sum).isWin() == lon(sum,results).isWin());
        Way way = wayMapper.selectByPrimaryKey("5b856a8b-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way, 2);
        gameResult.setOdds(odds);
        return gameResult;
    }
    public GameResult xiaoHu(int sum , List<Integer> results){
        GameResult gameResult = new GameResult();
        gameResult.setWin(xiao(sum).isWin() == hu(sum,results).isWin());
        Way way = wayMapper.selectByPrimaryKey("5b856a8b-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way, 3);
        gameResult.setOdds(odds);
        return gameResult;
    }
    public GameResult danLon(int sum , List<Integer> results){
        GameResult gameResult = new GameResult();
        gameResult.setWin(dan(sum).isWin() == lon(sum,results).isWin());
        Way way = wayMapper.selectByPrimaryKey("5b856a8b-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way, 4);
        gameResult.setOdds(odds);
        return gameResult;
    }
    public GameResult danHu(int sum , List<Integer> results){
        GameResult gameResult = new GameResult();
        gameResult.setWin(dan(sum).isWin() == hu(sum,results).isWin());
        Way way = wayMapper.selectByPrimaryKey("5b856a8b-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way, 5);
        gameResult.setOdds(odds);
        return gameResult;
    }

    public GameResult shuangLong(int sum , List<Integer> results){
        GameResult gameResult = new GameResult();
        gameResult.setWin(shuang(sum).isWin() == lon(sum,results).isWin());
        Way way = wayMapper.selectByPrimaryKey("5b856a8b-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way, 6);
        gameResult.setOdds(odds);
        return gameResult;
    }

    public GameResult shuangHu(int sum , List<Integer> results){
        GameResult gameResult = new GameResult();
        gameResult.setWin(shuang(sum).isWin() == hu(sum,results).isWin());
        Way way = wayMapper.selectByPrimaryKey("5b856a8b-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way,7);
        gameResult.setOdds(odds);
        return gameResult;
    }

    public GameResult danMa(int number , int sum , List<Integer> results){
        GameResult result = new GameResult();
        List<Integer> list = results.stream()
                .filter(ele -> ele.intValue() == number).collect(Collectors.toList());

        if(list.size() > 0){
            result.setWin(true);
        }
        Way way = wayMapper.selectByPrimaryKey("5b856eef-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way, list.size());
        result.setOdds(odds);
        return result;
    }
    public GameResult san(int sum , List<Integer> results){
        GameResult result = new GameResult();
        Set<Integer> collect = results.stream().collect(Collectors.toSet());
        Way way = wayMapper.selectByPrimaryKey("31154976-6a61-11ea-8753-0242ac110002");
        if(results.size() == 5){
            result.setWin(true);
        }

        BigDecimal odds = wayService.getOdds(sum, way,0);
        result.setOdds(odds);
        return result;
    }
    public GameResult chong(int sum , List<Integer> results){
        GameResult result = new GameResult();
        Set<Integer> collect = results.stream().collect(Collectors.toSet());
        Way way = wayMapper.selectByPrimaryKey("31154976-6a61-11ea-8753-0242ac110002");
        if(results.size() != 5){
            result.setWin(true);
        }

        BigDecimal odds = wayService.getOdds(sum, way,1);
        result.setOdds(odds);
        return result;
    }
    public GameResult lianMa(int sum , List<Integer> results , List<Integer> numbers){
        GameResult result = new GameResult();
        result.setWin(results.containsAll(numbers));
        Way way = wayMapper.selectByPrimaryKey("5b8567d7-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way,numbers.size()-1);
        result.setOdds(odds);
        return result;
    }
    public GameResult dingWeiHaoMa(int index,int number,int sum,List<Integer> results){

        GameResult result = new GameResult();
        if(results.get(index-1).intValue() == number){
            result.setWin(true);
        }
        Way way = wayMapper.selectByPrimaryKey("5b856833-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way,0);
        result.setOdds(odds);
        return result;
    }

    public GameResult dingWeiDa(int index,int sum,List<Integer> results){
        GameResult result = new GameResult();

        if(results.get(index) > 4 && results.get(index) < 10){
            result.setWin(true);
        }

        Way way = wayMapper.selectByPrimaryKey("5b856872-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way,0);
        result.setOdds(odds);
        return result;
    }

    public GameResult dingWeiXiao(int index,int sum,List<Integer> results){
        GameResult result = new GameResult();

        if(results.get(index) >= 0 && results.get(index) < 5){
            result.setWin(true);
        }

        Way way = wayMapper.selectByPrimaryKey("5b856872-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way,0);
        result.setOdds(odds);
        return result;
    }

    public GameResult dingWeiDan(int number,int sum,List<Integer> results){
        GameResult result = new GameResult();

        if(number > 0 && number < 10){
            result.setWin(number % 2 != 0);
        }

        Way way = wayMapper.selectByPrimaryKey("5b856872-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way,0);
        result.setOdds(odds);
        return result;
    }

    public GameResult dingWeiShuang(int number,int sum,List<Integer> results){
        GameResult result = new GameResult();

        if(number > 0 && number < 10){
            result.setWin(number % 2 == 0);
        }

        Way way = wayMapper.selectByPrimaryKey("5b856872-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way,0);
        result.setOdds(odds);
        return result;
    }

    public GameResult dingWeiLon(int index1,int index2,int sum,List<Integer> results){
        GameResult result = new GameResult();

        int[] arr = {index1,index2};
        int[] ints = Arrays.stream(arr).sorted().toArray();

        if(results.get(ints[0]).intValue() > results.get(ints[1]).intValue()){
            result.setWin(true);
        }

        Way way = wayMapper.selectByPrimaryKey("5b856d12-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way,0);
        result.setOdds(odds);
        return result;
    }
    public GameResult dingWeiHu(int index1,int index2,int sum,List<Integer> results){
        GameResult result = new GameResult();

        int[] arr = {index1,index2};
        int[] ints = Arrays.stream(arr).sorted().toArray();

        if(results.get(ints[0]).intValue() < results.get(ints[1]).intValue()){
            result.setWin(true);
        }

        Way way = wayMapper.selectByPrimaryKey("5b856d44-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way,0);
        result.setOdds(odds);
        return result;
    }
    public GameResult dingWeiHe(int index1,int index2,int sum,List<Integer> results){
        GameResult result = new GameResult();

        int[] arr = {index1,index2};
        int[] ints = Arrays.stream(arr).sorted().toArray();

        if(results.get(ints[0]).intValue() == results.get(ints[1]).intValue()){
            result.setWin(true);
        }

        Way way = wayMapper.selectByPrimaryKey("5b856dab-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way,0);
        result.setOdds(odds);
        return result;
    }

    public GameResult jiDa(int sum){
        GameResult result = new GameResult();
        Flag jiDa = AppUtils.support.getTemplateService().flag("7568ac25-74a8-11ea-8fbb-b42e99846016");
        Integer value = jiDa.getValue();
        if(sum >= value.intValue()){
            result.setWin(true);
        }

        Way way = wayMapper.selectByPrimaryKey("5b856cab-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way,0);
        result.setOdds(odds);
        return result;
    }

    public GameResult jiXiao(int sum){
        GameResult result = new GameResult();
        Flag jiDa = AppUtils.support.getTemplateService().flag("7568ac25-74a8-11ea-8fbb-b42e99846016");
        Integer value = jiDa.getValue();
        if(sum >= value.intValue()){
            result.setWin(true);
        }

        Way way = wayMapper.selectByPrimaryKey("5b856cde-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way,0);
        result.setOdds(odds);
        return result;
    }
    public GameResult teMaHeZhi(int sum , int number){
        GameResult result = new GameResult();
        result.setWin(sum == number);

        Way way = wayMapper.selectByPrimaryKey("5b856c76-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way,0);
        result.setOdds(odds);
        return result;
    }

    public GameResult baoZi(int sum,int num1 ,int num2 ,int num3,int oddsLoc){
        GameResult result = new GameResult();

        if(num1 ==num2 && num1 == num3){
            result.setWin(true);
        }
        Way way = wayMapper.selectByPrimaryKey("5b856ac3-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way,oddsLoc);
        result.setOdds(odds);
        return result;
    }

    public GameResult shunZi(int sum , int num1 , int num2 , int num3 , int oddsLoc){
        GameResult result = new GameResult();

        List<Integer> array = Arrays.asList(num1,num2,num3);

        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(0,1,2));
        list.add(Arrays.asList(1,2,3));
        list.add(Arrays.asList(2,3,4));
        list.add(Arrays.asList(3,4,5));
        list.add(Arrays.asList(4,5,6));
        list.add(Arrays.asList(5,6,7));
        list.add(Arrays.asList(6,7,8));
        list.add(Arrays.asList(7,8,9));

        list.add(Arrays.asList(8,9,0));
        list.add(Arrays.asList(9,0,1));

        boolean flag = false;
        for(List<Integer> items : list){
            if(array.containsAll(items)){
                flag = true;
                break;
            }
        }
        result.setWin(flag);
        Way way = wayMapper.selectByPrimaryKey("5b856b2d-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way,oddsLoc);
        result.setOdds(odds);
        return result;
    }

    public GameResult duiZi(int sum , int num1 , int num2 , int num3 , int oddsLoc){

        GameResult result = new GameResult();

        if((num1 == num2) || (num2 == num3) || (num3 == num1)){
            result.setWin(true);
        }

        Way way = wayMapper.selectByPrimaryKey("5b856bb2-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way,oddsLoc);
        result.setOdds(odds);
        return result;
    }

    public GameResult banShun(int sum , int num1 , int num2 , int num3 , int oddsLoc){

        GameResult result = new GameResult();

        List<Integer> array = Arrays.asList(num1,num2,num3);

        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(0,1));
        list.add(Arrays.asList(1,2));
        list.add(Arrays.asList(2,3));
        list.add(Arrays.asList(3,4));
        list.add(Arrays.asList(4,5));
        list.add(Arrays.asList(5,6));
        list.add(Arrays.asList(7,8));
        list.add(Arrays.asList(8,9));

        list.add(Arrays.asList(9,0));

        boolean flag = false;
        for(List<Integer> items : list){
            if(array.containsAll(items)){
                flag = true;
                break;
            }
        }

        Way way = wayMapper.selectByPrimaryKey("5b856bb2-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way,oddsLoc);
        result.setOdds(odds);
        return result;
    }

    public GameResult zaLiu(int sum , int num1 , int num2 , int num3 ,int oddsLoc){
        GameResult result = new GameResult();

        if(!duiZi(sum,num1,num2,num3,oddsLoc).isWin() &&
            baoZi(sum,num1,num2,num3,oddsLoc).isWin() &&
            shunZi(sum,num1,num2,num3,oddsLoc).isWin() &&
            banShun(sum,num1,num2,num3,oddsLoc).isWin()){
            result.setWin(true);
        }

        Way way = wayMapper.selectByPrimaryKey("5b856bec-611c-11ea-8c24-0242ac110002");
        BigDecimal odds = wayService.getOdds(sum, way,oddsLoc);
        result.setOdds(odds);
        return result;
    }

}
