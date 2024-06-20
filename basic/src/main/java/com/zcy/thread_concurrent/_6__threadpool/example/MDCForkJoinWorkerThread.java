package com.zcy.thread_concurrent._6__threadpool.example;//package com.infore.financial.repayment.utils;
//
//import org.slf4j.MDC;
//
//import java.util.Map;
//import java.util.concurrent.ForkJoinPool;
//import java.util.concurrent.ForkJoinWorkerThread;
//
//public class MDCForkJoinWorkerThread extends ForkJoinWorkerThread {
//
//    private final Map<String, String> mdcContext;
//
//    /**
//     * Creates a ForkJoinWorkerThread operating in the given pool.
//     *
//     * @param pool the pool this thread works in
//     * @throws NullPointerException if pool is null
//     */
//    protected MDCForkJoinWorkerThread(ForkJoinPool pool) {
//        super(pool);
//        this.mdcContext = MDC.getCopyOfContextMap();
//    }
//
//    @Override
//    protected void onStart() {
////        if (mdcContext != null) {
////            MDC.setContextMap(mdcContext);
////        } else {
////            MDC.getCopyOfContextMap();
////        }
//        super.onStart();
//    }
//
//    @Override
//    protected void onTermination(Throwable exception) {
//        super.onTermination(exception);
//        MDC.clear();
//    }
//
//
//
////    public void setInitialMdcContext(Map<String, String> initialMdcContext) {
////        this.initialMdcContext = initialMdcContext;
////    }
////
////    public void beforeExecute() {
////        if (initialMdcContext != null) {
////            MDC.setContextMap(initialMdcContext);
////        } else {
////            MDC.getCopyOfContextMap();
////        }
////    }
////
////    public void afterExecute() {
////        MDC.clear();
////    }
//}
