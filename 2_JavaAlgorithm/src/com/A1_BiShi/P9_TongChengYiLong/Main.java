package com.A1_BiShi.P9_TongChengYiLong;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        Thread thread1 = new Thread(new Run1());
        Thread thread2 = new Thread(new Run2(thread1));
        Thread thread3 = new Thread(new Run3(thread2));

        System.out.print(s);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Run1 implements Runnable {

    @Override
    public void run() {
        System.out.print("_A");
    }
}

class Run2 implements Runnable {

    Thread thread;

    public Run2(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("_B");
    }
}

class Run3 implements Runnable {

    Thread thread;

    public Run3(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("_C");
    }
}