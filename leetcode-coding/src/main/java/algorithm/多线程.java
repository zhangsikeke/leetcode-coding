package algorithm;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class 多线程 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        多线程 t = new 多线程();
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            t.start(num);
        }

    }

    public void start(int num) {
        AtomicInteger index = new AtomicInteger(0);
        AtomicInteger option = new AtomicInteger(1);
        Thread tD = new Thread(() -> {
            synchronized (this) {
                while (true) {
                    if (option.get() == 4) {
                        printD();
                        option.set(1);
                        index.getAndIncrement();
                        if (index.get() == num * 4) {
                            option.set(-1);
                            System.out.println();
                        }
                    }
                    this.notifyAll();
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            }
        });
        Thread tC = new Thread(() -> {
            synchronized (this) {
                while (true) {
                    if (option.get() == 3) {
                        printC();
                        index.getAndIncrement();
                        option.set(4);
                    }

                    this.notifyAll();
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            }

        });
        Thread tB = new Thread(() -> {
            synchronized (this) {
                while (true) {
                    if (option.get() == 2) {
                        printB();
                        index.getAndIncrement();
                        option.set(3);
                    }
                    this.notifyAll();
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            }

        });

        Thread tA = new Thread(() -> {
            synchronized (this) {
                while (true) {
                    if (option.get() == 1) {
                        printA();
                        index.getAndIncrement();
                        option.set(2);
                    }

                    this.notifyAll();
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            }

        });

        tA.start();
        tB.start();
        tC.start();
        tD.start();
    }

    public void printA() {
        System.out.print("A");

    }

    public void printB() {
        System.out.print("B");

    }

    void printC() {
        System.out.print("C");
    }

    void printD() {
        System.out.print("D");
    }

}
