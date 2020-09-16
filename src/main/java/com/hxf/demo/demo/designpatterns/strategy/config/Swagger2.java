package com.hxf.demo.demo.designpatterns.strategy.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author wubo
 * @ClassName: swagger2配置
 * @Description: TODO
 * @date 2020年2月10日
 */

@Configuration
public class Swagger2 {

    /**
     * 通过 createRestApi函数来构建一个DocketBean
     * 函数名,可以随意命名,喜欢什么命名就什么命名
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hxf.demo.demo.designpatterns.strategy.web"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("Spring Boot Swagger2 构建RESTful API")
                //条款地址
                .termsOfServiceUrl("http://despairyoke.github.io/")
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }

}
