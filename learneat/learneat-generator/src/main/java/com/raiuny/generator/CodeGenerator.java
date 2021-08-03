package com.raiuny.generator;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 代码生成器
 *
 * @author xiegege
 */
public class CodeGenerator {

    // 数据库连接地址
    private static final String URL = "jdbc:mysql://nj-cynosdbmysql-grp-2evx0i57.sql.tencentcdb.com:29672/database_learn?useUnicode=true&characterEncoding=utf8&useSSL=true";
    // 数据库连接驱动
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    // 数据库连接用户名
    private static final String USERNAME = "root";
    // 数据库连接密码
    private static final String PASSWORD = "zr&zy19950310";
    // 模块名（可选）
    private static final String MODULE_NAME = "";
    // 项目路径
    private static final String PROJECT_PATH = System.getProperty("user.dir");
    // xxx.java文件放置路径
    private static String JAVA_PATH = "/src/main/java";
    // xxxMapper.xml文件放置路径
    private static String XML_PATH = "/src/main/resources/mapper/";

    private static final String SCANNER_TEXT = "请输入";

    /**
     * 自动生成代码
     */
    public static void main(String[] args) {
        scannerModuleName("maven模块名（如：common）");
        String parentPackageName = scanner("父包名（如：com.xxx.xxx）");
        String author = scanner("开发人员（作者）");
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // TODO 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 生成文件的输出目录
        gc.setOutputDir(PROJECT_PATH + JAVA_PATH);
        // 作者
        gc.setAuthor(author);
        // 是否打开输出目录
        gc.setOpen(false);
        // controller 命名方式，注意 %s 会自动填充表实体属性
        gc.setControllerName("%sController");
        // service 命名方式
        gc.setServiceName("%sService");
        // serviceImpl 命名方式
        gc.setServiceImplName("%sServiceImpl");
        // mapper 命名方式
        gc.setMapperName("%sMapper");
        // xml 命名方式
        gc.setXmlName("%sMapper");
        // 开启 swagger2 模式
        gc.setSwagger2(true);
        // 是否覆盖已有文件
        gc.setFileOverride(true);
        // 是否开启 ActiveRecord 模式
        gc.setActiveRecord(true);
        // 是否在xml中添加二级缓存配置
        gc.setEnableCache(false);
        // 是否开启 BaseResultMap
        gc.setBaseResultMap(false);
        // XML columList
        gc.setBaseColumnList(false);
        // 全局 相关配置
        mpg.setGlobalConfig(gc);

        // TODO 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(URL);
        dsc.setDriverName(DRIVER_NAME);
        dsc.setUsername(USERNAME);
        dsc.setPassword(PASSWORD);
        mpg.setDataSource(dsc);

        // TODO 包配置
        PackageConfig pc = new PackageConfig();
        // 父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
        pc.setParent(parentPackageName);
        // 模块名，可以不指定
        pc.setModuleName(MODULE_NAME);
        // Controller包名
        pc.setController("controller");
        // Service包名
        pc.setService("service");
        // ServiceImpl包名
        pc.setServiceImpl("service.impl");
        // Mapper 包名
        pc.setMapper("mapper");
        // Entity包名
        pc.setEntity("pojo");
        mpg.setPackageInfo(pc);
        // TODO 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 输出文件配置
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // Mapper.xml 文件存放地址及文件名
                return PROJECT_PATH + XML_PATH + MODULE_NAME + "/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        // 自定义输出文件
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));
        // TODO 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 数据库表映射到实体的命名策略，驼峰原则
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 字数据库表字段映射到实体的命名策略，驼峰原则
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 实体是否生成 serialVersionUID
        strategy.setEntitySerialVersionUID(false);
        // 是否生成实体时，生成字段注解
        strategy.setEntityTableFieldAnnotationEnable(true);
        // 使用lombok
        strategy.setEntityLombokModel(true);
        // 设置逻辑删除键
        strategy.setLogicDeleteFieldName("del_flag");
        // TODO 指定生成的bean的数据库表名
        strategy.setInclude(scanner("表名，多个表使用英文逗号分割").split(","));
        // 驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    /**
     * 模块名键盘输入
     *
     * @param text 提示文字
     */
    public static void scannerModuleName(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(SCANNER_TEXT + text);
        if (scanner.hasNext()) {
            String moduleName = scanner.next();
            if (StringUtils.isNotBlank(moduleName)) {
                JAVA_PATH = "/" + moduleName + JAVA_PATH;
                XML_PATH = "/" + moduleName + XML_PATH;
                return;
            }
        }
        throw new MybatisPlusException(SCANNER_TEXT + "正确的" + text + "！");
    }

    /**
     * 通用键盘输入
     *
     * @param text 提示文字
     */
    public static String scanner(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(SCANNER_TEXT + text + "：");
        if (scanner.hasNext()) {
            String str = scanner.next();
            if (StringUtils.isNotBlank(str)) {
                return str;
            }
        }
        throw new MybatisPlusException(SCANNER_TEXT + "正确的" + text + "！");
    }
}
