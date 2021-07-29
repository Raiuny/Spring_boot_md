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
    - 指定Dao接口所在的包
  - 创建事务管理器 开启注解式事务生效     省略
- 测试（同Spring）
  - 建表
  - 开发实体类
  - 开发Dao接口
  - 开发Mapper配置文件
  - 开发Service接口
  - 开发ServiceImpl实现类
  - 测试ServiceImpl





```xml
```





