package com.zcy.thread._7__intetrrupt;

public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {

        //线程逻辑
        Runnable interruptTask = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                try {
                    //在正常运行任务时，经常检查本线程的中断标志位，如果被设置了中断标志位就停止
                    while (!Thread.currentThread().isInterrupted()) {
                        Thread.sleep(100);
                        i++;
                        System.out.println(Thread.currentThread().getName() + " (" + Thread.currentThread().getState() + ") loop check " + i);
                    }
                } catch (InterruptedException e) {
                    //在调用阻塞方法时正确处理InterruptedException异常.(例如:catch异常后结束线程)
                    System.out.println(Thread.currentThread().getName() + " (" + Thread.currentThread().getState() + ") catch InterruptedException");
                }
            }
        };


        Thread t1 = new Thread(interruptTask, "t1");
        System.out.println(t1.getName() + " " + t1.getState() + " |just be loaded into memory");

        t1.start(); //启动t1线程
        System.out.println(t1.getName() + " " + t1.getState() + " |is started");

        //主线程休眠300ms,然后主线程给t1线程发送"中断"指令
        Thread.sleep(300);
        t1.interrupt();
        System.out.println(t1.getName() + " " + t1.getState() + " |is interrupted");

        //主线程休眠300ms,然后查看t1状态
        Thread.sleep(300);
        System.out.println(t1.getName() + " " + t1.getState() + " |is interrupted now");
    }
}
