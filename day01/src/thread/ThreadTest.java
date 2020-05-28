package thread;

/**
 * @author 葛孝杰
 * @date 2020/5/26 - 8:29
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        System.err.println("hello");
    }
}


class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100 ; i++) {
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}
