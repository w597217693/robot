package com.bigcat.app.controller;

import com.bigcat.app.dao.BetsOrderMapper;
import com.bigcat.app.dao.OpenRecordMapper;
import com.bigcat.app.dto.TemplateResponse;
import com.bigcat.app.pojo.OpenRecord;
import com.bigcat.app.pojo.OpenRecordExample;
import com.bigcat.app.service.impl.BetsOrderService;
import com.bigcat.app.service.impl.ImageService;
import com.bigcat.app.service.impl.TemplateService;
import com.bigcat.app.utils.RestResult;
import gui.ava.html.Html2Image;
import gui.ava.html.renderer.ImageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TemplateService templateService;
    @Autowired
    private BetsOrderMapper orderMapper;
    @Autowired
    private BetsOrderService orderService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private ImageService imageService;
    @Autowired
    private OpenRecordMapper recordMapper;


    @GetMapping("/test")
    public RestResult test01(@RequestParam(defaultValue = "0") Long period){


        TemplateResponse billTemplate = new TemplateResponse();//

        //billTemplate = templateService.getBillTemplate(null);

        //billTemplate = templateService.getPlayerBill(period,"547247ba-6108-11ea-8c24-0242ac110002",null);

        //billTemplate = templateService.getBetsCheckTemplate(period,"547247ba-6108-11ea-8c24-0242ac110002",null);


        OpenRecordExample example = new OpenRecordExample();
        example.createCriteria().andPeriodEqualTo(Long.parseLong("20200404133"));
        List<OpenRecord> openRecords = recordMapper.selectByExample(example);
        orderService.settlementOrder(openRecords.get(0),"/SSC/");


//        List<Settings> list = templateService.sendCountDownText(30L);
//        if(list.size()>0){
//            Template template = templateService.buildTemplate(list.get(0), null);
//            billTemplate.setTemplate(template);
//        }


        return RestResult.build().map().put("template",billTemplate);
    }

    @GetMapping("/test2")
    public RestResult test2() throws IOException {
        Context context=new Context();
        context.setVariable("username","wedjg");

        File file= ResourceUtils.getFile("classpath:templates/table1.html");
        String trend = templateEngine.process(new String(Files.readAllBytes(file.toPath())), context);


        Html2Image html2Image = Html2Image.fromFile(file, null);
        ImageRenderer imageRenderer = html2Image.getImageRenderer();
        imageRenderer.setWidth(1024);

        BufferedImage bufferedImage = imageRenderer.getBufferedImage();


        ByteArrayOutputStream baos = new ByteArrayOutputStream();//io流
        ImageIO.write(bufferedImage, "png", baos);//写入流中
        byte[] bytes = baos.toByteArray();//转换成字节
        BASE64Encoder encoder = new BASE64Encoder();
        String png_base64 = encoder.encodeBuffer(bytes).trim();//转换成base64串
        png_base64 = png_base64.replaceAll("\n", "").replaceAll("\r", "");//删除 \r\n

        //        ImageIO.write(bufferedImage, "png", new File("D:/qrcode1.png"));
        System.out.println("值为："+"data:image/jpg;base64,"+png_base64);
        return RestResult.build().map().put("image","data:image/jpg;base64,"+png_base64);
    }

    public static void main(String[] args) throws IOException {
        String s = saveSnapshot("D:\\Program Files\\projects\\robot-app\\src\\main\\resources\\templates\\table1.html");
        System.out.println(s);
    }

    /**
     * 保存快照
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static String saveSnapshot(String url) throws IOException {
        Runtime rt = Runtime.getRuntime();
        //window下的位置,linux下需改动
        Process p = rt.exec("D:\\itsoftware\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe D:\\itsoftware\\phantomjs\\test.js " + url);
        InputStream is = p.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuffer sbf = new StringBuffer();
        String tmp = "";
        while ((tmp = br.readLine()) != null) {
            sbf.append(tmp);
        }
        return sbf.toString();
//
//        BufferedImage bufferedImage = ImageIO.read(is);
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();//io流
//        ImageIO.write(bufferedImage, "png", baos);//写入流中
//        byte[] bytes = baos.toByteArray();//转换成字节
//        BASE64Encoder encoder = new BASE64Encoder();
//        String png_base64 = encoder.encodeBuffer(bytes).trim();//转换成base64串
//        png_base64 = png_base64.replaceAll("\n", "").replaceAll("\r", "");//删除 \r\n
//        return png_base64;
    }


}
