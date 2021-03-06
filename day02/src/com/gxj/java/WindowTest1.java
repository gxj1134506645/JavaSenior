package com.gxj.java;

/**
 * @author 葛孝杰
 * @date 2020/5/27 - 10:21
 * 例子：创建三个窗口卖票，总票数为100张.使用实现Runnable接口的方式
 * 存在线程的安全问题，待解决。
 */
public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w = new Window1();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t2.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window1 implements Runnable {
    private int ticket = 100;
    Object lock = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (ticket > 0) {
                    System.err.println(Thread.currentThread().getName() + "：卖票, 票号为：" + ticket);
                    ticket--;
                }else {
                    break;
                }
            }
        }
    }
}
