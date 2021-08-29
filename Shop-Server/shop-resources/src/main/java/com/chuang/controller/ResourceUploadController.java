package com.chuang.controller;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @program: Shop-Server
 * @description: 上传文件
 * @author: chuang
 * @create: 2021-06-16 19:53
 */
@RestController
@RequestMapping("/reController")
public class ResourceUploadController {
    @Autowired
    private FastFileStorageClient fastFileStorageClient;
    @Value("${fasthome}")
    private String dfsHost;
    @RequestMapping("/uploadPng")
    public String uploadJPG(MultipartFile file){
        //把文件上传到fastdfs
        try {
            //获取文件后缀
            String fileExname = FilenameUtils.getExtension(file.getOriginalFilename());
            //把文件传送到fastdfs
            StorePath storePath = fastFileStorageClient.uploadImageAndCrtThumbImage(file.getInputStream(), file.getSize(), fileExname, null);
            //获取文件上传路径
            String fullPath = storePath.getFullPath();
            System.out.println(fullPath);
            return dfsHost+fullPath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

}
