package com.zcy.thread_concurrent._6__threadpool.example;//package com.infore.financial.repayment.utils;
//
//import java.util.concurrent.ForkJoinPool;
//import java.util.concurrent.ForkJoinTask;
//
//public class MDCForkJoinPool extends ForkJoinPool {
//
//    public MDCForkJoinPool() {
//        super(Runtime.getRuntime().availableProcessors(), new MDCForkJoinWorkerThreadFactory(), null, false);
//    }
//
//    @Override
//    public void execute(ForkJoinTask<?> task) {
//        MDCForkJoinWorkerThread workerThread = (MDCForkJoinWorkerThread) Thread.currentThread();
//        workerThread.beforeExecute();
//        try {
//            super.execute(task);
//        } finally {
//            workerThread.afterExecute();
//        }
//    }
//}
