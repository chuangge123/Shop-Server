package com.chuang.shopresources;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @program: Shop-Server
 * @description: 启动
 * @author: chuang
 * @create: 2021-06-08 10:43
 */

@SpringBootTest
public class ShopResourcesApplicationTest {
    @Autowired
 private FastFileStorageClient fastFileStorageClient;
    @Test
    void fileTest() throws FileNotFoundException {
        File file = new File("C:\\Tools\\Photo\\haiseven.jpg");
        FileInputStream  filestream = new FileInputStream(file);
        StorePath storePath = fastFileStorageClient.uploadImageAndCrtThumbImage(filestream, file.length(), "jpg", null);
        System.out.println(storePath.getFullPath());

    }

}
