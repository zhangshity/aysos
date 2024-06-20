package com.zcy.thread_concurrent._6__threadpool.example;

import org.slf4j.MDC;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

/**
 * MDC增强线程池 (装饰者模式)
 */
public class MDCAwareThreadPoolExecutor implements ExecutorService {

    private final ExecutorService delegate;

    public MDCAwareThreadPoolExecutor(ExecutorService delegate) {
        this.delegate = delegate;
    }


    // -----------------------------------------------------------------------
    // Implements.

    @Override
    public void execute(Runnable command) {
        delegate.execute(wrapWithMDC(command, MDC.getCopyOfContextMap()));
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return delegate.submit(wrapWithMDC(task, MDC.getCopyOfContextMap()));
    }


    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return delegate.submit(wrapWithMDC(task, MDC.getCopyOfContextMap()), result);
    }


    @Override
    public Future<?> submit(Runnable task) {
        return delegate.submit(wrapWithMDC(task, MDC.getCopyOfContextMap()));
    }


    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return delegate.invokeAll(wrapWithMDC(tasks));
    }


    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return delegate.invokeAll(wrapWithMDC(tasks), timeout, unit);
    }


    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return delegate.invokeAny(wrapWithMDC(tasks));
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return delegate.invokeAny(wrapWithMDC(tasks), timeout, unit);
    }


    // -----------------------------------------------------------------------
    // Other methods delegate to the original executorService.

    @Override
    public void shutdown() {
        delegate.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        return delegate.shutdownNow();
    }

    @Override
    public boolean isShutdown() {
        return delegate.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return delegate.isTerminated();
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return delegate.awaitTermination(timeout, unit);
    }


    // -----------------------------------------------------------------------
    //

    private Runnable wrapWithMDC(Runnable task, Map<String, String> context) {
        return () -> {
            if (context != null) {
                MDC.setContextMap(context);
            }
            try {
                task.run();
            } finally {
                MDC.clear();
            }
        };
    }

    private <T> Callable<T> wrapWithMDC(Callable<T> task, Map<String, String> context) {
        return () -> {
            if (context != null) {
                MDC.setContextMap(context);
            }
            try {
                return task.call();
            } finally {
                MDC.clear();
            }
        };
    }

    private <T> Collection<? extends Callable<T>> wrapWithMDC(Collection<? extends Callable<T>> tasks) {
        Map<String, String> context = MDC.getCopyOfContextMap();
        return tasks.stream().map(task -> wrapWithMDC(task, context)).collect(Collectors.toList());
    }

}
