package com.aaa.zyf.generator;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Collections;

public class MyGenerator {
    public static void main(String[] args) {
        AutoGenerator mpg =new AutoGenerator();

        GlobalConfig globalConfig=new GlobalConfig();
        globalConfig.setOutputDir("D://生成代码//");
        globalConfig.setFileOverride(true);
        globalConfig.setActiveRecord(true);
        globalConfig.setEnableCache(false);
        globalConfig.setBaseColumnList(true);
        globalConfig.setBaseColumnList(true);
        globalConfig.setAuthor("zyf");
        globalConfig.setMapperName("%sDao");
        globalConfig.setXmlName("%sDao");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        globalConfig.setControllerName("%sController");
        mpg.setGlobalConfig(globalConfig);

        DataSourceConfig sourceConfig =new DataSourceConfig();
        sourceConfig.setDbType(DbType.MYSQL);
        sourceConfig.setTypeConvert(new MySqlTypeConvert() {

           @Override
            public DbColumnType processTypeConvert(String fieldType){
                System.out.println("转换类型："+fieldType);
                return super.processTypeConvert(fieldType);
            }
        });

        sourceConfig.setDriverName("com.mysql.jdbc.Driver");
        sourceConfig.setUsername("root");
        sourceConfig.setPassword("123456");
        sourceConfig.setUrl("jdbc:mysql://127.0.0.1:3306/teacher?characterEncoding=utf8");
        mpg.setDataSource(sourceConfig);
        StrategyConfig strategyConfig =new StrategyConfig();
        strategyConfig.setTablePrefix(new String[]{"tbl_"});// 此处可以修改为您的表前缀
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        mpg.setStrategy(strategyConfig);
        PackageConfig packageConfig = new PackageConfig();

        packageConfig.setParent("com.aaa.zyf");
        packageConfig.setController("controller");
        packageConfig.setMapper("dao");
        packageConfig.setEntity("entity");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        mpg.setPackageInfo(packageConfig);
        // 注入配置
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };
        injectionConfig.setFileOutConfigList(Collections.<FileOutConfig>singletonList(new FileOutConfig("/templates/mapper.xml.vm") {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return globalConfig.getOutputDir() + tableInfo.getEntityName() + "Dao.xml";
            }
        }));
        mpg.setCfg(injectionConfig);
        // 执行生成*/
        mpg.execute();
    }

}


