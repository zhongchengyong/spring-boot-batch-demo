package com.kode.quickstart;

import org.springframework.boot.SpringApplication;

/**
 * Main程序
 * Created by kodezhong on 2017/4/10.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("begin");
        System.exit(SpringApplication.exit(SpringApplication.run(BatchConfiguration.class, args)));
    }
}
