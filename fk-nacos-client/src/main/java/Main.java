import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.client.config.listener.impl.PropertiesListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private static final String dataId = "camel.yaml";
    private static final String group = "task-center";
    private static final String content = "server:\n" +
            "  port: 8088";


    public static void main(String[] args) throws NacosException {
        // nacos连接配置
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, "localhost:8848");
        properties.put(PropertyKeyConst.NAMESPACE, "dev");
        // 创建nacos配置中心服务
        ConfigService configService = NacosFactory.createConfigService(properties);

        // 发布配置
        boolean publishConfig = configService.publishConfig(dataId, group, content);
        LOGGER.info("publishConfig: {}", publishConfig);

        // 获取nacos配置中心配置
        String config = configService.getConfig(dataId, group, 1000);
        LOGGER.info("getConfig: {}", config);

        // 监听配置
        configService.addListener(dataId, group, new PropertiesListener() {
            @Override
            public void innerReceive(Properties properties) {
                LOGGER.info("innerReceive: {}", properties);
            }
        });

        // 更新配置
        boolean updateConfig = configService.publishConfig(dataId, group, "connectTimeoutInMills=3000");
        LOGGER.info("updateConfig: {}", updateConfig);
        wait2Sync();

        // 删除配置
//        boolean removeConfig = configService.removeConfig(dataId, group);
//        LOGGER.info("removeConfig: {}", removeConfig);
//        wait2Sync();

        config = configService.getConfig(dataId, group, 5000);
        LOGGER.info("getConfig: {}", config);
    }

    private static void wait2Sync() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // ignore
        }
    }
}
