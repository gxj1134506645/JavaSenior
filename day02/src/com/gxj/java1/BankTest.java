package com.gxj.java1;

/**
 * @author 葛孝杰
 * @date 2020/5/27 - 17:47
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 */
public class BankTest {

}

class Bank {
    private Bank() {}

    private static Bank bank = null;

    public static Bank getInstance() {
        if (bank == null) {
            synchronized (Bank.class) {
                if (bank == null) {
                    bank = new Bank();
                }
            }
        }
        return bank;
    }
}
