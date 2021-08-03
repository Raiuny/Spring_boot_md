springboot微框架 = spring (工厂) + springMVC (控制器) controller

spring 工厂： 创建对象

1. 基于配置文件形式，创建对象

   ```xml
   <bean id = "xxx" class = "xxx.xxServiceImpl"></bean>
   ```

2. 基于注解方式创建对象

   ```java
   @Conponent 作用：在工厂中创建对象(通用)
       Controller , Service, Dao
       @Controller: 创建控制器注解
   	@Service: 创建业务层注解
   	@Repository: 创建dao层注解，mybatis
   ```



## 1. SpringBoot 中创建对象

### 1.1 使用原始Spring框架中注解创建对象：

```java
@Conponent
@Controller
@Service
@Repository 
 //这些注解只能创建单个对象
```

### 1.2 使用配置方式创建对象：

```java
@Configuration: 修饰范围：用在类上；作用：代表这个类是一个springboot中的配置类 ==> spring.xml
    @Bean：创建对象，相当于spring.xml中书写的bean标签
@Configuration
public class BeansConfig {
    @Bean
    public User user(){
        return new User();
    }
    @Bean
    public Emp emp() {
        return new Emp();
    }
    @Bean
    public Calendar calendar() {
        return Calendar.getInstance();
    }
}
//创建多个对象



@Autowired
@Qualifier(value = "xx")//不按类型链接，而是按名称链接，默认为实现类的首字母小写，也可以在实现时候指定其工厂中的名字
private DemoService demoService; //与工厂中的对象自动链接

需要在对象前面加一个注解，使得向工厂中得以注入对象
@Component/Controller/Service/Repository
```



## 2. Spring、SpringBoot属性注入

### 2.1 Spring 属性注入

SET注入，构造注入，自动注入

> SET注入更加灵活

#### 2.1.1 引用类型的属性注入

> @Autowired: Spring框架提供，默认根据类型注入
>
> @Resource: JavaEE规范，默认根据名称注入，自动根据类型注入
>
> 用在成员变量上、成员变量set方法上



#### 2.1.2 基本类型的属性注入

```xml
<bean>
	<property name = "name" value="xxx" />
    <property name = "todolist">
        <array>
        	<value>xxx</value>
        	<value>yyy</value>
        	<value>zzz</value>
        </array>
    </property>
</bean>
```



### 2.2 SpringBoot 属性注入

#### 2.2.1 使用注解，属性注入

```java
@Value注解
@Autowired注解
@Resource注解

```

```java
@Conponent
public class xxx {
    @Value("${name}")
    private String name;
    @Value("${age}")
    private Integer age;
    @Value("${sex}")
    private Boolean sex;
    @Value("${arrays}") //注入数组
    private String[] arrays;
    @Value("${lists}") //注入list
    private List<String> lists;
    @Value("#{${maps}}") //注入字典
    private Map<String, String> maps;
} // 通过@Value来属性注入，为对象属性赋初值，否则全为null。之后还需要在配置文件中将初值配置好。
```

```yml
name: 小陈
age: 23
sex: false
lists: dog, cat, xiai
maps: "{'aa':'xx','bb':'yy','cc':zz}" //json表示方法， 使用@Value注入时必须加入“#{${属性名}}”进行注入
```

#### 2.2.2 使用对象一次性注入

```java
@Component
@ConfigurationProperties("xxx") //xxx对象，为该对象赋值一定要提供set方法；
public class InjectObj {
    private String name;
    private Integer age;
    private Boolean sex;
    private String[] arrays;
    private List<String> likes;
    private Map<String, String> maps;
}
```

```yaml
obj:
  name: xiaoming
  age: 18
  likes:
    - dog
    - cat
    - bird
    - girl
  maps:
	k1: v1
	k2: v2
```



## 3. JSP 模板集成

### 3.1 引入jsp的集成jar包

```xml
<!--  让内嵌tomcat有解析jsp的功能    -->
        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
            <scope>provided</scope>
        </dependency>
<!--  引入标准标签库  -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
        </dependency>
```

**main目录下（java同级）新建webapp目录，然后再webapp 目录下存放jsp文件**

### 3.2 配置文件中配置jsp视图前后缀

```yaml
spring:
  mvc:
    view:
      prefix: /
      suffix: .jsp

server:
  port: 8090
  servlet:
    jsp:
      init-parameters:
        development: true #开启jsp页面的开发模式，修改jsp页面无需重启应用
```



## 4. 整合Mybatis框架

springboot 微框架 = spring 工厂 + springmvc 控制器

对数据库要进行访问，数据库访问框架有： hibernate、jpa、mybatis

### 4.1 Spring框架整合Mybatis

#### 4.1.1 引入依赖

- spring相关依赖
- mysql相关，驱动，数据源
- mybatis相关， mybatis核心jar，mybatis和spring框架整合
- spring.xml 
  - 开启注解扫描
  - 创建数据源对象
    - 注入 指定使用哪种数据源类型， 注入driverClassName 注入url 注入username password
  - 创建sqlSessionFactory
    - 注入数据源   注入mapper配置文件位置	注入实体别名包
  - 创建Dao对象
    - 注入SqlSessionFactory 以及 Dao接口所在的包
  - 创建事务管理器       DataSourceTrasacationManager
    - 注入数据源对象， DataSourceTransacationManager
  - 在业务层组件上加入事务注解，@Transacational
- 测试
  - 建表
  - 开发实体类
  - 开发Dao接口
  - 开发Mapper配置文件
  - 开发Service接口
  - 开发ServiceImpl实现类
  - 测试ServiceImpl



### 4.2 SpringBoot框架整合Mybatis

#### 4.2.1 引入依赖

- springboot-web
- mysql相关 mysql驱动 druid数据源
- mybatis相关的（mybatis-spring-boot-starter) 依赖{其中包含了mybatis mybatis-spring}
- 书写配置
  - 开启注解扫描 @SpringBootApplication  @ComponentScan        不用配置
  - 创建数据源
    - 指定数据源类型
    - 指定数据库驱动
    - 指定url
    - 指定username password
  - 创建SqlSessionFactory
    - 指定mapper配置文件位置
    - 指定实体所在包位置，取别名
  - 创建Dao
    - 指定Dao接口所在的包 主程序通過注解@MapperScan :用来扫描dao接口所在的包，同时将所有dao接口在工厂中创建对象
  - 创建事务管理器 开启注解式事务生效     省略
- 测试（同Spring）
  - 建表
  - 开发实体类
  - 开发Dao接口
  - 开发Mapper配置文件
  - 开发Service接口
  - 开发ServiceImpl实现类
  - 测试ServiceImpl

#### 4.2.2 具体操作

```xml
   <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

<!--        druid       -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.2.5</version>
        </dependency>
<!--        mysql       -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.49</version>
        </dependency>
<!--        mybatis       -->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.1.4</version>
        </dependency>
```



**新建User表**

```java
package com.raiuny.springboot_mybatis.entity; //在项目文件下的entity目录下新建表类pojo

public class User {
    private int id;
    private String name;
    private int age;
    private boolean gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}

```



**新建dao接口**

```java
package com.raiuny.springboot_mybatis.dao;
import com.raiuny.springboot_mybatis.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    void save(User user);
}
```



**新建dao接口对应的mapper**

UserMapper.xml文件设在classpath:com/raiuny/mapper下

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTO Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.raiuny.springboot_mybatis.dao.UserDao">
    
<!--    查询所有    -->
    <select id="findAll" resultType="User">
        select * from `database_test`
    </select>
<!--    save    -->
    <insert id="save" parameterType="User" useGeneratedKeys="true" keyProperty="id">
        insert into `database_test` values(#{id},#{name},#{age},#{gender})
    </insert>
    
</mapper>
```



**主程序上加入@MapperScan注解，将所有dao接口在工厂中创建代理对象**

```java
@SpringBootApplication
@MapperScan("com.raiuny.springboot_mybatis.dao")//修饰范围，作用在类上，用来扫描dao接口所在包，同时将所有dao接口在工厂中创建代理对象
public class SpringbootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisApplication.class, args);
    }

}
```



**配置数据源(数据连接池)、数据库（mysql驱动，url，username，password）、mybatis（mapper配置文件位置以及指定实体所在包位置，取别名）**

```yml
spring:
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://nj-cynosdbmysql-grp-2evx0i57.sql.tencentcdb.com:29672/database_learn?useUnicode=true&characterEncoding=utf8&useSSL=true
    username: root
    password: zr&zy19950310
mybatis:
  mapper-locations: classpath:com/raiuny/mapper/*.xml
  type-aliases-package: com/raiuny/springboot_mybatis/entity
#  指定mapper配置文件位置
```



**新建事务层**

UserService

```java
package com.raiuny.springboot_mybatis.service;

import com.raiuny.springboot_mybatis.entity.User;

import java.util.List;

public interface UserService {
    //查询所有
    List<User> findAll();
    void save(User user);
}
```



UserServiceImpl

```java
package com.raiuny.springboot_mybatis.service;

import com.raiuny.springboot_mybatis.dao.UserDao;
import com.raiuny.springboot_mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@Transactional //一定要加这个，该事务需要使用动态代理，通过 JDBC 的事务来进行事务控制，事务不成功则回滚
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        System.out.println("UserServiceImpl");
        return userDao.findAll();
    }

    @Override
    public void save(User user) {
       userDao.save(user);
    }
}
```

==@Transactional注解==

>@Transactional 实现原理：
>
>1) 事务开始时，通过AOP机制，生成一个代理connection对象，
>   并将其放入 DataSource 实例的某个与 DataSourceTransactionManager 相关的某处容器中。
>   在接下来的整个事务中，客户代码都应该使用该 connection 连接数据库，
>   执行所有数据库命令。
>   [不使用该 connection 连接数据库执行的数据库命令，在本事务回滚的时候得不到回滚]
>  （物理连接 connection 逻辑上新建一个会话session；
>   DataSource 与 TransactionManager 配置相同的数据源）
>
>2) 事务结束时，回滚在第1步骤中得到的代理 connection 对象上执行的数据库命令，
>   然后关闭该代理 connection 对象。
>  （事务结束后，回滚操作不会对已执行完毕的SQL操作命令起作用）



**创建UserController测试**

```java
package com.raiuny.springboot_mybatis.controller;

import com.raiuny.springboot_mybatis.entity.User;
import com.raiuny.springboot_mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("findAll")
    public List<User> findAll(){
        System.out.println("UserController");
        return userService.findAll();
    }
    @RequestMapping("save")
    public void save(User user) {
        userService.save(user);
    }
}
```

#### 4.2.3 sql相关操作

**1. 建表**

```sql
CREATE TABLE `t_clazz` (
	`id` varchar(40) NOT NULL,
    `name` varchar(80) DEFAULT NULL,
    `no` varchar(90) DEFAULT NULL,
    PRIMARY KEY(`id`)
) ENGIN=InnoDB DEFAULT CHARSET=UTF8
```



## 5. 本地测试

### 5.1 Spring 本地测试

1. 启动工厂 ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml")
2. 从工厂中获取指定对象 UserDao userDao = context.getBean("userDao");
3. 调用方法   userDao.xxx(args);



### 5.2 SpringBoot 本地测试

springboot = spring +  springmvc

1. 引入结合Junit和spring-boot-starter-test依赖

2. 启动springboot应用，才能spring工厂启动，需要注入测试对象

   @SpringBootTest

   ​		修饰范围：作用在类上

   ​		作用：启动本地spring环境

## 6. 热部署工具

### 6.1 配置devtools依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <optional>true</optional>
</dependency>
```

### 6.2 IDEA中设置自动

![image-20210730145012576](C:\Users\Zy\AppData\Roaming\Typora\typora-user-images\image-20210730145012576.png)、

### 6.3 开启Registry中开启此项

<img src="C:\Users\Zy\AppData\Roaming\Typora\typora-user-images\image-20210730145317014.png" alt="image-20210730145317014" style="zoom:100%;"  align = left />

之后热部署就完成了

