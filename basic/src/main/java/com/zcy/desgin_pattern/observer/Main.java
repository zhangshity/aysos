package com.zcy.desgin_pattern.observer;


import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 *     观察者模式
 *          1.观察者类
 *          2.被观察者
 *          3.被观察者维护一套观察者集合,需要时通知所有观察者
 *
 *          JDK中也有相关实现 {@link java.util.Observable} {@link java.util.Observer}
 * </pre>
 */
public class Main {
    public static void main(String[] args) {
        // 被观察者 (美女)
        美女_Observable observable = new 美女_Observable();

        // 通知观察者 (你们被发现了)
        observable.notifyObservers();

    }
}








// ==================== 被观察者 ====================

/**
 * 被观察者 (美女)
 * <p>
 * 只需维护一套观察者（Observer）的集合，这些Observer实现相同的接口，Subject只需要知道，通知Observer时，需要调用哪个统一方法就好了
 */
class 美女_Observable {
    private List<Observer> observers = Arrays.asList(
            new 海王_Observer(),
            new 胆小鬼_Observer(),
            new 猥琐男_Observer());

    // 通知全部观察者
    public void notifyObservers() {
        for (Observer observer : observers) {
            String result = observer.find();
            System.out.println(observer + ":" + result);
        }
    }
}







// ==================== 观察者 ====================

/**
 * 观察者
 */
abstract class Observer {
    // 发现
    protected abstract String find();
}

/**
 * 观察者 (海王)
 */
class 海王_Observer extends Observer {
    @Override
    protected String find() {
        return "微笑，放光，上前，要微信";
    }
}

/**
 * 观察者 (胆小鬼)
 */
class 胆小鬼_Observer extends Observer {
    @Override
    protected String find() {
        return "脸红，害羞，尿裤，流鼻涕";
    }
}

/**
 * 观察者 (猥琐男)
 */
class 猥琐男_Observer extends Observer {
    @Override
    protected String find() {
        return "口哨，口水，狂奔，撩裙子";
    }
}
