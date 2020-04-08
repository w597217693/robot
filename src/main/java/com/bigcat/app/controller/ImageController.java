package com.bigcat.app.controller;

import com.bigcat.app.pojo.Images;
import com.bigcat.app.pojo.ImagesExample;
import com.bigcat.app.pojo.Settings;
import com.bigcat.app.pojo.SettingsExample;
import com.bigcat.app.utils.AppUtils;
import com.bigcat.app.utils.RestResult;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/image")
public class ImageController {

    @PostMapping("/upload")
    public RestResult uploadImage(@RequestParam("file") MultipartFile file){

        Images image = AppUtils.support.getImageService().storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/image/downloadFile/")
                .path(image.getDiskPath())
                .toUriString();

        return RestResult.build().map()
                .put("fileName",image.getDiskPath())
                .put("fileDownloadUri",fileDownloadUri)
                .put("fileType",file.getContentType())
                .put("size",file.getSize());
    }

    @GetMapping("/all")
    public RestResult findAll(){
        List<Images> images = AppUtils.support.getImagesMapper().selectByExample(new ImagesExample());

        List array = new ArrayList();
        for(Images it : images){

            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/image/downloadFile/")
                    .path(it.getDiskPath())
                    .toUriString();

            Map<String,Object> data = new HashMap<>();
            data.put("fileName",it.getDiskPath());
            data.put("fileDownloadUri",fileDownloadUri);
            data.put("fileType",it.getType());
            data.put("size",it.getSize());
            array.add(data);
        }

        return RestResult.build().array()
                .add(array);
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = AppUtils.support.getImageService().loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            System.out.println("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }


    @GetMapping("/del/{fileName:.+}")
    public RestResult delImage(@PathVariable String fileName){

        ImagesExample example = new ImagesExample();
        ImagesExample.Criteria criteria = example.createCriteria();
        criteria.andDiskPathEqualTo(fileName);
        List<Images> images = AppUtils.support.getImagesMapper().selectByExample(example);

        if(images == null || images.size() == 0)
            throw new RuntimeException("删除的图片不存在!");

        Images image = images.get(0);

        AppUtils.support.getImageService().delImage(image);
        return RestResult.build();
    }

}
