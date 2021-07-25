# Web开发
[toc]
## SpringBoot对静态资源的映射规则
1. 所有/webjars/**，都去classpath:/META-INF/resources/webjars/找资源
2. webjars: 以jar包的方式引入静态资源；www.webjars.org
3. 只需要在pom.xml中添加webjars对应的依赖
localhost:8080/webjars/jquery/3.5.1/jquery.js js静态文件

1. “/**”访问当前项目的任何资源，(静态资源文件夹下)
```java
"classpath:/META-INF/resources/",
"classpath:/resources/",
"classpath:/static/",
"classpath:/public/",
"/"  //当前项目的根路径，静态资源的文件夹
```
localhost:8080/xxx.css ==默认去静态资源文件夹里面找xxx.css

2. 欢迎页：静态资源文件夹下所有的index.html "/**"
localhost:8080/
3. 网页图标：静态资源文件夹下找："/favicon.ico"
4. 通过application.properties文件修改静态文件的映射路径：
```yml
spring.resources.static-locations=classpath:/hello/,classpath:/raiuny/
```
## 模板引擎
JSP、Velocity、Freemarker、Thymeleaf
1. 添加thymeleaf依赖
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```
2. themeleaf语法
```html

```
3. 热部署
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.5.2</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.raiuny</groupId>
    <artifactId>web01crud</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>web01crud</name>
    <description>Demo project for Spring Boot</description>
    <properties>
        <java.version>11</java.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>jquery</artifactId>
            <version>3.5.1</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
        </dependency>
        <!-- 引入对应依赖 -->
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <version>2.5.2</version>
                <configuration>
                    <fork>true</fork> 
                    <!-- 设置允许派生 -->
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>

```
  - 配置springboot 的更新策略：更新类和资源
## 请求参数处理
1. 请求映射
```java

```