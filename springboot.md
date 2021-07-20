# Spring Boot
> 简化Spring应用开发
> 整个Spring技术栈的一个大整合
> J2EE开发的一站式解决方案
## Spring Boot的优点
- 快速创建独立运行的Spring项目以及与主流框架集成
- 使用嵌入式的Servlet容器，应用无需打成war包
- starter自动依赖与版本控制
- 大量的自动配置，简化开发，也可修改默认值
- 无需配置XML，无代码生成，开箱即用
- 准生产环境的运行时应用监控
- 与云计算的天然集成
- 缺点：入门容易，精通难

## 准备：
- 掌握Spring框架的使用
- 熟练使用Maven进行项目构建和依赖管理
- 熟练使用Eclipse或者IDEA

### helloworld项目通过lifecycle中的package打包成jar包运行

## 项目文件
### pom文件
#### 1. 父项目
```xml
<parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.5.2</version>
        <relativePath/> <!-- lookup parent from repository -->
</parent>
他的父项目：
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-dependencies</artifactId>
    <version>2.5.2</version>
</parent>
这一项才是真正管理Spring Boot应用里面的所有依赖版本；
```

Spring Boot的版本仲裁中心：
以后我们导入依赖默认是不需要写版本，（没有在dependencies里面管理的依赖需要声明版本号）

#### 2. 导入的依赖
```xml
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
##### spring-boot-starter-web:
spring-boot-starter-web:spring-boot场景启动器；帮我们导入了web模块正常运行所依赖的组件；

Spring Boot将所有的功能场景都抽取出来，做成一个个的starter启动器，只需要在项目里面引入这些starter相关场景的所有依赖都会导入进来。要用什么功能就导入什么场景的启动器。