package com.gxj.java1;

/**
 * @author 葛孝杰
 * @date 2020/5/27 - 18:17
 * 演示线程的死锁问题
 */
public class ThreadTest {
    public static void main(String[] args) {

        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();


        new Thread(){
            @Override
            public void run() {
                synchronized (s1) {
                    s1.append("a");
                    s2.append("1");

//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                    synchronized (s2) {
                        s1.append("b");
                        s2.append("2");

                        System.err.println(s1);
                        System.err.println(s2);
                    }
                }
            }
        }.start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                synchronized (s2) {
                    s1.append("c");
                    s2.append("3");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    synchronized (s1) {
                        s1.append("d");
                        s2.append("4");

                        System.err.println(s1);
                        System.err.println(s2);
                    }
                }
            }
        }).start();
    }
}
