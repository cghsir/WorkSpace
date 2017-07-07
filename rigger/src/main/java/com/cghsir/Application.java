package com.cghsir;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 项目运行主入口
 * Created by cghsir on 2017/7/6.
 */
@MapperScan("com.cghsir.mapper")//扫描mybatis mpper文件
@SpringBootApplication
@ServletComponentScan//扫描主类下的Servlet
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
