import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;

public class Main {
    private static final String dataId = "camel.yaml";
    private static final String group = "task-center";

    public static void main(String[] args) throws NacosException {
        // nacos连接配置
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, "localhost:8848");
        properties.put(PropertyKeyConst.NAMESPACE, "dev");
        // 创建nacos配置中心服务
        ConfigService configService = NacosFactory.createConfigService(properties);

        // 获取nacos配置中心配置
        String config = configService.getConfig(dataId, group, 1000);

        System.out.println(config);

    }
}
