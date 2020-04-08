package com.bigcat.app.service.impl;

import com.bigcat.app.config.FileProperties;
import com.bigcat.app.pojo.Images;
import com.bigcat.app.pojo.Settings;
import com.bigcat.app.pojo.SettingsExample;
import com.bigcat.app.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
public class ImageService {

    private final Path fileStorageLocation; // 文件在本地存储的地址

    @Autowired
    public ImageService(FileProperties fileProperties) {
        this.fileStorageLocation = Paths.get(fileProperties.getUploadDir()).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {

        }
    }

    public Images storeFile(MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new RuntimeException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);



            Images image = new Images();
            image.setId(UUID.randomUUID().toString());
            image.setImageName(fileName);
            image.setDiskPath(image.getId().replace("-","")+"."+suffix);
            image.setAccountPath("/downloadFile/"+image.getDiskPath());
            image.setType(file.getContentType());
            image.setSize(file.getSize());

            AppUtils.support.getImagesMapper().insert(image);


            Path targetLocation = this.fileStorageLocation.resolve(image.getDiskPath());
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return image;
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new RuntimeException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new RuntimeException("File not found " + fileName, ex);
        }
    }

    public void delImage(Images image){

        SettingsExample settingsExample = new SettingsExample();
        SettingsExample.Criteria settingsCriteria = settingsExample.createCriteria();
        settingsCriteria.andTemplateImageEqualTo(image.getId());
        List<Settings> settings = AppUtils.support.getSettingsMapper().selectByExample(settingsExample);
        if(settings != null && settings.size() > 0){
            String str = "[";
            int i = 0;
            for(Settings it : settings){

                if(i == settings.size()-1){
                    str+=it.getTitle();
                }else{
                    str+=it.getTitle()+",";
                }
                i++;
            }
            str+="]";
            throw new RuntimeException("该图片在"+str+"有引用不能删除!");
        }
        AppUtils.support.getImagesMapper().deleteByPrimaryKey(image.getId());

        Path filePath = this.fileStorageLocation.resolve(image.getDiskPath()).normalize();
        try {
            Files.delete(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String imageToBase64(String imageName){

        Path filePath = this.fileStorageLocation.resolve(imageName).normalize();
        try {
            byte[] bytes = Files.readAllBytes(filePath);
            BASE64Encoder encoder = new BASE64Encoder();
            String png_base64 =  encoder.encodeBuffer(bytes).trim();//转换成base64串
            return png_base64.replaceAll("\n", "").replaceAll("\r", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
