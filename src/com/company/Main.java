package com.company;

public class Main extends Thread {
    static final Object lock = new Object();
    void mobileCall()  {
        System.out.println(this);
        synchronized (lock) {
            System.out.println("Mobile call starts");
            try {
                Thread.sleep(3000);
            }
            catch (Exception e) {

            }
            System.out.println("Mobile call ends");
        }

    }
    void skypeCall() {
        System.out.println(this);
        synchronized (lock) {
            System.out.println("Skype call starts");
            try {
                Thread.sleep(3000);
            }
            catch (Exception e) {

            }
            System.out.println("Skype call ends");
        }
    }

    void whatsappCall() {
        System.out.println(this);
        System.out.println("Whatsapp call starts");
        synchronized (lock) {
            try {
                Thread.sleep(3000);
            }
            catch (Exception e) {

            }
            System.out.println("Whatsapp call ends");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new RunnableImplMobileImpl());
        Thread thread2 = new Thread(new RunnableImplWhatsapp());
        Thread thread3 = new Thread(new RunnableImplSkype());
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
class RunnableImplMobileImpl implements Runnable {
    public void run() {
        new Main().mobileCall();
    }
}
class RunnableImplSkype implements Runnable {
    public void run() {
        new Main().skypeCall();
    }
}
class RunnableImplWhatsapp implements Runnable {
    public void run() {
        new Main().whatsappCall();
    }
}
