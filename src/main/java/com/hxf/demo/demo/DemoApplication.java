package com.hxf.demo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author hxf
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableSwagger2
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
