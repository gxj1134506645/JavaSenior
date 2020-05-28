package com.gxj.java;

/**
 * @author 葛孝杰
 * @date 2020/5/27 - 17:19
 */
public class WindowTest4 {
    public static void main(String[] args) {
        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window4 extends Thread {
    private static int ticket = 100;

    //    private static Object lock = new Object();
    @Override
    public void run() {
        while (true) {
            boolean flag = show();
            if (!flag) {
                break;
            }
        }
    }

    public static synchronized boolean show() {
        if (ticket > 0) {
            System.err.println(Thread.currentThread().getName() + "：卖票, 票号为：" + ticket);
            ticket--;
            return true;
        }
        return false;
    }
}
