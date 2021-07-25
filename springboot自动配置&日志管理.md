[toc]
## springboot 自动配置原理
**自动配置原理：**
1. SpringBoot启动时候加载主配置类，开启了自动配置功能@EnableAutoConfiguration
2. @EnableAutoConfiguration的作用：
  - 利用选择器给容器导入了一些组件
  - 利用插件方法来获取候选的配置loadFactoryNames()
  - 扫描内容包装成properties对象
  - 从properties中获取到EnableAutoConfiguration.class类对应的值，把他们添加在容器中
3. 将类路径下 META-INF/spring.factories里面配置的所有xxxEnableAutoConfiguration的值加入到容器中
4. 用这些类来做自动配置

## 日志
日志接口： SLF4J
日志实现： Logback

SpringBoot：底层是Spring框架， Spring框架默认的是用JCL，
==SpringBoot选用的是SLF4J和Logback==
### SLF4J的使用
以后开发的时候，日志记录方法的调用，不应该直接调用日志的实现类，而是调用日志抽象层里面的方法；给系统里面导入slf4j和logback的实现jar

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class HelloWorld {
    public static void main(string []args) {
        Logger logger = LoggerFactory.getLogger(HelloWorld.class);
        logger.info("Hello World");
    }
}
```
统一使用slf4j+logback进行输出：
如果要引入其他框架，一定要把这个框架的默认日志依赖移除掉；
==SpringBoot能自动适配所有的日志，而且底层使用slf4j+logback的方式记录日志，引入其他框架的时候，只需要把这个框架依赖的日志框架排除掉，否则会引起冲突==

### 日志使用
參考博客
```java

```

