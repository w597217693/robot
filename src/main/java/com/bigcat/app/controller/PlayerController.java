package com.bigcat.app.controller;

import com.bigcat.app.pojo.Player;
import com.bigcat.app.utils.AppUtils;
import com.bigcat.app.utils.RestResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/player")
public class PlayerController extends BaseController{


    /**
     * 上传玩家收款二维码
     * @param file
     * @param id
     * @return
     */
    @PostMapping("/upload/qrcode")
    @ResponseBody
    public RestResult setPay(@RequestParam("file") MultipartFile file ,String id,Integer choice){
        return null;
    }

    /**
     * 上传玩家银行卡信息
     * @param id
     * @param holderCard
     * @param bankName
     * @param cardNum
     * @return
     */
    @PostMapping("/upload/bank")
    public RestResult setBank(String id,String holderCard,String bankName,String cardNum){

        Player player = AppUtils.support.getUtils().validPlayer(id);
        player.setHolderCard(holderCard);
        player.setBankName(bankName);
        player.setCardNum(cardNum);

        AppUtils.support.getPlayerMapper().updateByPrimaryKeySelective(player);
        return RestResult.ok(null);
    }





}
