package com.zcy.collection.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 优先队列
 * <p>
 * Queue会严格按 FIFO的原则取出队首元素。
 * {@link PriorityQueue} 和 {@link Queue}的区别在于，
 * 它的出队顺序与元素的优先级有关，对{@link PriorityQueue}调用remove()或poll()方法，返回的总是优先级最高的元素。
 * 要使用PriorityQueue，我们就必须给每个元素定义“优先级”
 */
public class PriorityQueueTest {
    public static void main(String[] args) {

        Queue<String> queue = new PriorityQueue<>();
        queue.offer("apple");
        queue.offer("pear");
        queue.offer("banana");
        System.out.println(queue.poll()); // apple
        System.out.println(queue.poll()); // banana
        System.out.println(queue.poll()); // pear
        System.out.println(queue.poll()); // null,因为队列为空

        //我们放入的顺序是"apple"、"pear"、"banana"，但是取出的顺序却是"apple"、"banana"、"pear"，这是因为从字符串的排序看，"apple"排在最前面，"pear"排在最后面。
        //
        //因此，放入PriorityQueue的元素，必须实现Comparable接口，PriorityQueue会根据元素的排序顺序决定出队的优先级。
        //
        //如果我们要放入的元素并没有实现Comparable接口怎么办？PriorityQueue允许我们提供一个Comparator对象来判断两个元素的顺序。我们以银行排队业务为例，实现一个PriorityQueue：

        Queue<User> q = new PriorityQueue<>(new UserComparator());
        // 添加3个元素到队列:
        q.offer(new User("Bob", 21));
        q.offer(new User("Alice", 56));
        q.offer(new User("Boss", 18));
        System.out.println(q.poll()); // Boss/18
        System.out.println(q.poll()); // Bob/21
        System.out.println(q.poll()); // Alice/56
        System.out.println(q.poll()); // null,因为队列为空

    }


    static class UserComparator implements Comparator<User> {
        public int compare(User u1, User u2) {
            if (u1.getAge().equals(u2.getAge())) {
                return 0;
            } else if (u1.getAge() < u2.getAge()) {
                return -1; //不交换位置
            } else {
                return 1; //交换位置
            }
        }
    }

    static class User {
        private String name;
        private Integer age;

        public User() {
        }

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


}
