package org.cy.xj.enhance;

import org.slf4j.MDC;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * MDC工具
 */
public class MDCUtils {

    /**
     * TraceId标识
     */
    public static final String TRACE_ID = "TRACE_ID";


    /**
     * 设置日志追踪标识
     */
    public static void init() {
        String traceID = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))
                + UUID.randomUUID().toString().replace("-", "");

        MDC.put(TRACE_ID, traceID);
    }

    /**
     * 清空日志追踪标识
     */
    public static void clear() {
        MDC.clear();
    }
}
