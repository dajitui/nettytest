package com.dream.springbootframe.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 所有的@RequestMapping("")最后只返回一个页面的都可以写在这里
 * 继承WebMvcConfigurerAdapter 重写addViewControllers
 * 注:springboot2开始再WebMvcConfigurer接口内方法都加了default
 *    所以直接实现WebMvcConfigurer 而可以不用再继承WebMvcConfigurerAdapter
 */
@Configuration
public class WebMvcPage implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //UserController
        registry.addViewController("/user/list/page").setViewName("listpage");
        registry.addViewController("/user/login/page").setViewName("login");

        //FckController
        registry.addViewController("/fck/page").setViewName("fck");

        //广播页面 一个发送 一个接收
        registry.addViewController("wsout").setViewName("websocketout");
        registry.addViewController("wss").setViewName("websocketbroadcast");

    }
}
