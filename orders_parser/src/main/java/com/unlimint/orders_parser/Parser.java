package com.unlimint.orders_parser;

import org.springframework.stereotype.Component;


@Component
public class Parser {
    private String file1;
    private String file2;

    public Parser() {
    }
    public void runParseFiles(String file1, String file2){
        Orders orders = new Orders();
        orders.rundMain(file1, file2);

    }
}
