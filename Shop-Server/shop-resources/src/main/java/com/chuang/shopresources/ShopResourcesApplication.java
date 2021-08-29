package com.chuang.shopresources;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

/**
 * @program: Shop-Server
 * @description: 启动
 * @author: chuang
 * @create: 2021-06-08 10:43
 */

@SpringBootApplication(scanBasePackages = "com.chuang")
@EnableEurekaClient
@Import(FdfsClientConfig.class)
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class ShopResourcesApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopResourcesApplication.class,args);
    }
}
