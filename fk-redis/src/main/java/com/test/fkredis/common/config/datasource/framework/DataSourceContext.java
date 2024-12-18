//package com.test.fkredis.common.config.datasource.framework;
//
//import com.test.fkredis.common.config.datasource.DynamicDataSourceConfiguration;
//
///**
// * 数据源上下文
// * <p>Title: DataSourceContext </p>
// * <p>Description: 数据源命名规则 (连接池种类_数据源类型) </p>
// * @author Allen.C.Y.Zhang
// * @version V1.0
// * @date 2021-03-04 18:20:37
// */
//public final class DataSourceContext {
//
//    /**
//     * ThreadLocal holder for DataSource associated with this thread.
//     * <p>【数据源Bean名称容器】
//     * @see DynamicDataSource#determineCurrentLookupKey()
//     * @see DynamicDataSourceConfiguration#dynamicDataSource()
//     */
//    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();
//
//
//    /** master 数据源名称 */
//    public static final String MASTER = "masterDataSource";
//
//    /** slave 数据源名称 */
//    public static final String SLAVE = "slaveDataSource";
//
//
//    private DataSourceContext() {
//    }
//
//
//    public static void setDataSource(String dataSourceName) {
//        CONTEXT_HOLDER.set(dataSourceName);
//    }
//
//    public static String getDataSource() {
//        return CONTEXT_HOLDER.get();
//    }
//
//    public static void clearDataSource() {
//        CONTEXT_HOLDER.remove();
//    }
//
//}
