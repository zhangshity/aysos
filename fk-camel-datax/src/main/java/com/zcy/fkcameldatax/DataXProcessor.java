package com.zcy.fkcameldatax;

import com.alibaba.datax.common.util.Configuration;
import com.alibaba.datax.core.Engine;
import com.alibaba.datax.core.util.ConfigParser;
import com.alibaba.datax.core.util.SecretUtil;
import com.alibaba.datax.core.util.container.CoreConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFile;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Slf4j
@Component
public class DataXProcessor implements Processor {
    private static final Logger LOG = LoggerFactory.getLogger(Engine.class);
    private ConfigurableEnvironment environment;
    public static final String DATAX_HOME = "\\fk-camel-datax\\datax";
    public static final String JOB_PATH = "\\fk-camel-datax\\datax\\job\\txt2mysql.json";

    private String PREFIX_HOME = System.getProperty("user.dir");

    public DataXProcessor(@Autowired ConfigurableEnvironment environment) {
        this.environment = environment;
    }



    @Override
    public void process(Exchange exchange) throws Exception {
//        String dataxHome = "E:\\my_src\\javaMaster\\spring-datax\\datax";
//        System.setProperty("datax.home", dataxHome);
//        String[] datxArgs = {"-job", dataxHome + "/job/txt2mysql.json", "-mode", "standalone", "-jobid", "-1"};
//        try {
//            Engine.entry(datxArgs);
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }


        //读取配置
        init();
        GenericFile file = exchange.getIn().getBody(GenericFile.class);
        String filePath = file.getAbsoluteFilePath();
        filePath = filePath.replace("\\", "/");
        Map<String, String> sysConfig = getSysConfig();

        sysConfig.put("CURRENT_FILE_PATH", "D:/data/camel/demo.txt");
        sysConfig.put("JDBC_URL", "jdbc:mysql://db.airloan.com.cn:3301/loan_facilitation?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false");
        sysConfig.put("spring.datasource.dynamic.datasource.master.username", "console");
        sysConfig.put("spring.datasource.dynamic.datasource.master.password", "infore#Tec@Test");

//        sysConfig.put("CURRENT_FILE_PATH", filePath);
//        sysConfig.put("JDBC_URL", "jdbc:mysql://127.0.0.1:3306/data_x?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false");
//        sysConfig.put("spring.datasource.dynamic.datasource.master.username", "root");
//        sysConfig.put("spring.datasource.dynamic.datasource.master.password", "123456");

        //解析配置
        String jobConfig = FileUtils.readFileToString(new File(PREFIX_HOME + JOB_PATH));
        jobConfig = parseJobConfig(jobConfig, sysConfig);
        Configuration configuration = parse(jobConfig);

        LOG.info("\n{}",configuration.beautify());

        //启动路由
        Engine engine = new Engine();
        engine.start(configuration);
    }

    private void init() {
        System.setProperty("datax.home", PREFIX_HOME + DATAX_HOME);
    }

    public static Configuration parse(String jobConfig) {
        Configuration configuration = parseJobConfig(jobConfig);
        configuration.merge(Configuration.from(new File(CoreConstant.DATAX_CONF_PATH)), false);
        String readerPluginName = configuration.getString("job.content[0].reader.name");
        String writerPluginName = configuration.getString("job.content[0].writer.name");
        String preHandlerName = configuration.getString("job.preHandler.pluginName");
        String postHandlerName = configuration.getString("job.postHandler.pluginName");
        Set<String> pluginList = new HashSet();
        pluginList.add(readerPluginName);
        pluginList.add(writerPluginName);
        if (org.apache.commons.lang.StringUtils.isNotEmpty(preHandlerName)) {
            pluginList.add(preHandlerName);
        }

        if (org.apache.commons.lang.StringUtils.isNotEmpty(postHandlerName)) {
            pluginList.add(postHandlerName);
        }

        try {
            configuration.merge(ConfigParser.parsePluginConfig(new ArrayList(pluginList)), false);
        } catch (Exception var10) {
            LOG.warn(String.format("插件[%s,%s]加载失败，1s后重试... Exception:%s ", readerPluginName, writerPluginName, var10.getMessage()));

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException var9) {
            }

            configuration.merge(ConfigParser.parsePluginConfig(new ArrayList(pluginList)), false);
        }

        return configuration;
    }

    public static Configuration parseJobConfig(String jobContent) {
        Configuration config = Configuration.from(jobContent);
        return SecretUtil.decryptSecretKey(config);
    }

    /**
     * 解析替换配置
     *
     * @param jobConfig
     * @return
     */
    public String parseJobConfig(String jobConfig, Map<String, String> sysConfig) {
        for (Map.Entry<String, String> config
                : sysConfig.entrySet()) {
            String key = config.getKey();
            String value = config.getValue();
            jobConfig = jobConfig.replace("${" + key + "}", value);

        }
        return jobConfig;
    }

    /**
     * 获取系统当前配置信息
     *
     * @return 配置信息
     */
    private Map<String, String> getSysConfig() {
        Map<String, String> configMap = new HashMap<>();
        Iterator<PropertySource<?>> iterator = environment.getPropertySources().iterator();
        while (iterator.hasNext()) {
            PropertySource<?> source = iterator.next();
            String name = source.getName();
            Object o = source.getSource();
            if (name.startsWith("applicationConfig:")
                    && o instanceof Map) {
                for (Map.Entry<String, Object> entry : ((Map<String, Object>) o).entrySet()) {
                    String key = entry.getKey();
                    configMap.put(key, environment.getProperty(key));
                }
            }
        }
        return configMap;

    }
}
