package com.yufa.xz.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
        System.out.println("*************************************************");
        System.out.println("EasyRpcClient start successfully!");
        System.out.println("You can trigger RPC calls through the following interfaces:");
        System.out.println("http://127.0.0.1:15011//users/listALL");
        System.out.println("http://127.0.0.1:15011//users/1");
        System.out.println("http://127.0.0.1:15011/addUser");
    }

}
