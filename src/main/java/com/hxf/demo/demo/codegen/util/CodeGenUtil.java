package com.hxf.demo.demo.codegen.util;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;

import java.text.MessageFormat;
import java.util.Scanner;

/**
 * <p>
 * 代码生成工具类，基于Mybatis-plus的AutoGenerator
 * <p>
 *
 */
@Slf4j
public final class CodeGenUtil {

  /**
   * 代码生成main
   */
  public static void main(String[] args) {
    CodeGenUtil.codeGen();
  }

  /**
   * 数据源配置
   */
  private static final String DATA_SOURCE_URL =
      "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";
  private static final String DATA_SOURCE_USERNAME = "root";
  private static final String DATA_SOURCE_PASSWORD = "root";
  private static final String DATA_SOURCE_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

  /**
   * 父类字段
   */
  private static final String SUPER_ENTITY_ID = "id";
  private static final String SUPER_ENTITY_CREATE_TIME = "create_time";
  private static final String SUPER_ENTITY_EDIT_TIME = "update_time";
  private static final String SUPER_ENTITY_DELETED = "deleted";
  private static final String[] SUPER_ENTITY_COLUMNS =
      {SUPER_ENTITY_ID, SUPER_ENTITY_CREATE_TIME, SUPER_ENTITY_EDIT_TIME, SUPER_ENTITY_DELETED};
  /**
   * 父类配置
   */
  private static final String PACKAGE_PARENT = "com.hxf.demo";

  private static final String SUPER_ENTITY = PACKAGE_PARENT + ".demo.codegen.base.BaseEntity";
  private static final String SUPER_CONTROLLER = PACKAGE_PARENT + ".demo.codegen.base.BaseController";
  private static final String SUPER_SERVICE = PACKAGE_PARENT + ".demo.codegen.base.BaseService";
  private static final String SUPER_SERVICE_IMPL = PACKAGE_PARENT + ".demo.codegen.base.BaseServiceImpl";

  /**
   * 包名配置
   */
  private static final String PACKAGE_PARENT_CONTROLLER = PACKAGE_PARENT + ".{0}.web.controller";
  private static final String PACKAGE_PARENT_SERVICE = PACKAGE_PARENT + ".{0}.service";
  private static final String PACKAGE_PARENT_SERVICE_IMPL = PACKAGE_PARENT + ".{0}.service.impl";
  private static final String PACKAGE_PARENT_MAPPER = PACKAGE_PARENT + ".{0}.dao.mapper";
  private static final String PACKAGE_PARENT_MAPPER_XML = PACKAGE_PARENT + ".{0}.dao.mapper.xml";
  private static final String PACKAGE_PARENT_ENTITY = PACKAGE_PARENT + ".{0}.dao.entity";

  /**
   * 私有化构造
   */
  private CodeGenUtil() {
    super();
  }

  /**
   * 全局配置
   */
  private static final String GLOBAL_OUTPUT_DIR = "D:\\codeGen";
  private static final String GLOBAL_AUTHOR = "hxf@qq.com";

  /**
   * <p>
   * 读取控制台内容
   * </p>
   */
  private static String scanner(String tip) {
    Scanner scanner = new Scanner(System.in);
    StringBuilder help = new StringBuilder();
    help.append("请输入" + tip + "：");
    System.out.println(help.toString());
    if (scanner.hasNext()) {
      String ipt = scanner.next();
      if (StringUtils.isNotEmpty(ipt)) {
        return ipt;
      }
    }
    throw new MybatisPlusException("请输入正确的" + tip + "！");
  }

  public static void codeGen() {

    // 代码生成器
    AutoGenerator mpg = new AutoGenerator();

    // 全局配置
    GlobalConfig globalConfig = CodeGenUtil.getCodeGenGlobalConfig();
    mpg.setGlobalConfig(globalConfig);

    // 数据源配置
    DataSourceConfig dataSource = CodeGenUtil.getCodeGenDataSourceConfig();
    mpg.setDataSource(dataSource);

    // 包配置
    PackageConfig packageInfo = CodeGenUtil.getCodeGenPackageConfig();
    mpg.setPackageInfo(packageInfo);

    // 数据库表策略配置
    StrategyConfig strategy = CodeGenUtil.getCodeGenStrategyConfig();
    mpg.setStrategy(strategy);

    // 模板配置
    TemplateConfig template = CodeGenUtil.getCodeGenTemplateConfig();
    mpg.setTemplate(template);

    // 模板引擎配置
    AbstractTemplateEngine templateEngine = CodeGenUtil.getCodeGenTemplateEngine();
    mpg.setTemplateEngine(templateEngine);

    // 自定义注入篇配置
    InjectionConfig cfg = CodeGenUtil.getCodeGenInjectionConfig();
    mpg.setCfg(cfg);

    mpg.execute();

  }

  /**
   * 模板配置
   *
   * @return TemplateConfig
   */
  private static TemplateConfig getCodeGenTemplateConfig() {
    return new TemplateConfig();
  }

  /**
   * 自定义注入篇配置
   *
   * @return InjectionConfig
   */
  private static InjectionConfig getCodeGenInjectionConfig() {
    return new InjectionConfig() {

      @Override
      public void initMap() {
        log.info("InjectionConfig initMap");
      }
    };
  }

  /**
   * 模板引擎配置
   *
   * @return AbstractTemplateEngine
   */
  private static AbstractTemplateEngine getCodeGenTemplateEngine() {
    return new VelocityTemplateEngine();
  }

  /**
   * 策略配置
   *
   * @return StrategyConfig
   */
  private static StrategyConfig getCodeGenStrategyConfig() {
    StrategyConfig strategy = new StrategyConfig();
    strategy.setTablePrefix("jy_");
    // 数据库表映射到实体的命名策略
    strategy.setNaming(NamingStrategy.underline_to_camel);
    // 数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
    strategy.setColumnNaming(NamingStrategy.underline_to_camel);
    // 自定义继承的Entity类全称，带包名
    strategy.setSuperEntityClass(SUPER_ENTITY);
    // 自定义继承的Controller类全称，带包名
    strategy.setSuperControllerClass(SUPER_CONTROLLER);
    // 自定义继承的Service类全称，带包名
    strategy.setSuperServiceClass(SUPER_SERVICE);
    // 自定义继承的ServiceImpl类全称，带包名
    strategy.setSuperServiceImplClass(SUPER_SERVICE_IMPL);
    // 自定义基础的Entity类，公共字段
    strategy.setSuperEntityColumns(SUPER_ENTITY_COLUMNS);
    // 自定义继承的Mapper类全称，带包名
    strategy.setEntityLombokModel(true);
    // 生成 @RestController 控制器
    strategy.setRestControllerStyle(true);
    // 驼峰转连字符
    strategy.setControllerMappingHyphenStyle(true);
    // 逻辑删除属性名称
    strategy.setLogicDeleteFieldName(SUPER_ENTITY_DELETED);
    // 需要包含的表名，允许正则表达式（与exclude二选一配置）
    strategy.setInclude(scanner("表名，多个英文逗号分割").split(StringPool.COMMA));

    return strategy;
  }

  /**
   * 获取全局配置
   *
   * @return GlobalConfig
   */
  private static GlobalConfig getCodeGenGlobalConfig() {
    GlobalConfig gc = new GlobalConfig();
    // 生成文件的输出目录,默认值：D 盘根目录
    gc.setOutputDir(GLOBAL_OUTPUT_DIR);
    // 是否覆盖已有文件,默认值：false
    gc.setFileOverride(Boolean.TRUE);
    // 是否打开输出目录,默认值：true
    gc.setOpen(Boolean.TRUE);
    // 是否在xml中添加二级缓存配置,默认值：`false
    gc.setEnableCache(Boolean.FALSE);
    // 开发人员,默认值：NULL
    gc.setAuthor(GLOBAL_AUTHOR);
    // 开启 Kotlin 模式,默认值：false
    gc.setKotlin(Boolean.FALSE);
    // 开启 swagger2 模式,默认值：false
    gc.setSwagger2(Boolean.FALSE);
    // 开启 ActiveRecord 模式,默认值：false
    gc.setActiveRecord(Boolean.FALSE);
    // 开启 BaseResultMap,默认值：false
    gc.setBaseResultMap(Boolean.FALSE);
    // 开启 baseColumnList,默认值：false
    gc.setBaseColumnList(Boolean.FALSE);
    // 时间类型对应策略,默认值：TIME_PACK
    gc.setDateType(DateType.TIME_PACK);
    // 实体命名方式,默认值：null 例如：%sEntity 生成 UserEntity
    gc.setEntityName(null);
    // mapper 命名方式,默认值：null 例如：%sDao 生成 UserDao
    gc.setMapperName(null);
    // Mapper xml 命名方式,默认值：null 例如：%sDao 生成 UserDao.xml
    gc.setXmlName(null);
    // service 命名方式,默认值：null 例如：%sBusiness 生成 UserBusiness
    gc.setServiceName("%sService");
    // service 命名方式,默认值：null 例如：%sBusinessImpl 生成 UserBusinessImpl
    gc.setServiceImplName("%sServiceImpl");
    // controller 命名方式,默认值：null 例如：%sAction 生成 UserAction
    gc.setControllerName(null);
    // 指定生成的主键的ID类型,默认值：null
    gc.setIdType(IdType.ID_WORKER);
    return gc;
  }

  /**
   * 获取包配置
   *
   * @return PackageConfig
   */
  private static PackageConfig getCodeGenPackageConfig() {
    PackageConfig pc = new PackageConfig();
    String modelName = scanner("模块名");
    pc.setParent("");
    String packageController = MessageFormat.format(PACKAGE_PARENT_CONTROLLER, modelName);
    String packageService = MessageFormat.format(PACKAGE_PARENT_SERVICE, modelName);
    String packageServiceImpl = MessageFormat.format(PACKAGE_PARENT_SERVICE_IMPL, modelName);
    String packageMapper = MessageFormat.format(PACKAGE_PARENT_MAPPER, modelName);
    String packageMapperXml = MessageFormat.format(PACKAGE_PARENT_MAPPER_XML, modelName);
    String packageEntity = MessageFormat.format(PACKAGE_PARENT_ENTITY, modelName);
    pc.setController(packageController);
    pc.setService(packageService);
    pc.setServiceImpl(packageServiceImpl);
    pc.setMapper(packageMapper);
    pc.setXml(packageMapperXml);
    pc.setEntity(packageEntity);
    // 父包模块名
    pc.setModuleName(null);
    return pc;
  }

  /**
   * 获取数据源配置
   *
   * @return DataSourceConfig
   */
  private static DataSourceConfig getCodeGenDataSourceConfig() {
    DataSourceConfig dsc = new DataSourceConfig();
    dsc.setUrl(DATA_SOURCE_URL);
    dsc.setDriverName(DATA_SOURCE_DRIVER_NAME);
    dsc.setUsername(DATA_SOURCE_USERNAME);
    dsc.setPassword(DATA_SOURCE_PASSWORD);
    return dsc;
  }

}
