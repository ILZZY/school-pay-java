package com.baomidou.mybatisplus.generator;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.toolkit.StringUtils;

/**
 * mybatis-plus代码生成器(用于生成entity)<br>
 * 
 * <pre> 
 * 类名称：MyBatisPlusGenerator
 * 类描述： 
 * </pre>
 * 
 * @version 
 *
 */
public class MyBatisPlusGenerator {
    //项目工程路径
    public static final String PROJECT_PATH = "H:\\zl\\MYJAVA\\MyProjectes\\school-pay-java";

    public static final String OUT_PATH = PROJECT_PATH + "\\src\\main\\java";
    
    public static final String AUTHOR = "zhangliang";
    
    public static final String DB_HOST = "127.0.0.1";
    public static final String DB_NAME = "school_pay";
    public static final String DB_USER = "root";
    public static final String DB_PWD = "cyberaudit";
    public static final String DB_PORT = "3306";
    
    //代码输出目录
    public static final String OUTPUT_PATH = OUT_PATH;    
    //业务表名
    public static final String TABLE_NAME = "sp_resource";
    //模块包名（组成包名）
    public static final String MODULE_PACKAGE_NAME = "sp";
    //逻辑删除字段名称
    public static final String LOGIC_DELETE_FIELD_NAME = "";
    //生成的URI资源路径
    public static final String URI_PATH= "/resource"; 
    //是否继承实体bean父类
    public static boolean IS_BASE_ENTITY = false;
    //是否生成service
    public static boolean IS_SERVICE = false;
    //是否生成controller
    public static boolean IS_CONTROLLER = false;
    //是否生成业务对象模型
    public static boolean IS_MODLE = false;
    //业务对象模型名称,默认为 实体名+BO,例如:AdminBO
    public static String MODLE_NAME = "";
    //是否覆盖已存在文件
    public static boolean IS_FILE_OVERRIDE = true;
        
    public static void main(String[] args) {
       
    	AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(OUTPUT_PATH);
        gc.setFileOverride(IS_FILE_OVERRIDE);//是否覆盖
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setOpenService(IS_SERVICE);//是否生成service代码
        gc.setOpenController(IS_CONTROLLER);//是否生成service代码
        gc.setOpenModel(IS_MODLE);//是否生成
        gc.setModelName(MODLE_NAME);//配置业务对象名称
        
        gc.setAuthor(AUTHOR);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert() {
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                return super.processTypeConvert(fieldType);
            }
        });
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername(DB_USER);
        dsc.setPassword(DB_PWD);
        
        dsc.setUrl("jdbc:mysql://"+DB_HOST+":"+DB_PORT+"/"+DB_NAME+"?characterEncoding=utf8");
        
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix(new String[]{"sp_"});// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        
        String[] superEntityColumns = new String[]{"id","generate_by","generate_time","update_by","update_time"};
        if(IS_BASE_ENTITY) {
          strategy.setSuperEntityClass("com.venustech.ca.framework.common.model.BaseEntity");
          strategy.setSuperEntityColumns(superEntityColumns);
        }
        if(StringUtils.isNotEmpty(LOGIC_DELETE_FIELD_NAME)) {
          strategy.setLogicDeleteFieldName(LOGIC_DELETE_FIELD_NAME);
        }
        strategy.setInclude(new String[]{TABLE_NAME});
        
        //设置服务层基类
        //strategy.setSuperServiceImplClass("com.venustech.ca.framework.core.service.ConfBaseSevice");        
        //所有的Controller使用@RestController
        strategy.setRestControllerStyle(true);
        strategy.setSuperControllerClass("com.zl.sp.common.BaseController");        
        //设置uri模块名称        
        strategy.setUriPath(URI_PATH);
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(null);
        //实体bean目录
        pc.setEntity("com.zl."+MODULE_PACKAGE_NAME+".persistence.entity");
        //mapper目录
        pc.setMapper("com.zl."+MODULE_PACKAGE_NAME+".persistence.mapper");
        //mapper xml文件目录
        pc.setXml("com.zl."+MODULE_PACKAGE_NAME+".persistence.mapper.mapping");
        //service层接口目录
        pc.setService("com.zl."+MODULE_PACKAGE_NAME+".service");
        //service实现类目录
        pc.setServiceImpl("com.zl."+MODULE_PACKAGE_NAME+".service.impl");
        //控制层目录
        pc.setController("com.zl."+MODULE_PACKAGE_NAME+".web.controller");
        //设置业务模型对象目录
        pc.setModel("com.zl."+MODULE_PACKAGE_NAME+".model");
        mpg.setPackageInfo(pc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        /*InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                String temp = URI_PATH.substring(URI_PATH.indexOf("/")+1);
                //模块名称国际化key
                map.put("moduleI18n",temp.replace("/", "."));
                //功能名称国际化key
                map.put("functionI18n", temp.replace("/", "."));
                
                this.setMap(map);
            }
        };
        mpg.setCfg(cfg);*/

        // 执行生成
        mpg.execute();
    }
}