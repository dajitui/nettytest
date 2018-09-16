package com.dream.springbootframe.config.war;

/**
 * 打成war包
 * 1.修改pom.xml
 *  <packaging>jar</packaging> -> <packaging>war</packaging>
 * 2.覆盖默认的内置tomcat
 *  <dependency>
 *      <groupId>org.springframework.boot</groupId>
 *      <artifactId>spring-boot-starter-tomcat</artifactId>
 *      <scope>provided</scope>
 *  </dependency>
 */
public class ServletInitializer /*extends SpringBootServletInitializer*/ {
   /* @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(App.class);
    }*/
}
