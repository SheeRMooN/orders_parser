package com.unlimint.orders_parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Parser {
    private String file1;
    private String file2;
    @Autowired
    private Orders orders;

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Parser() {
    }
    public void runParseFiles(String file1, String file2){
        orders.rundMain(file1, file2);
    }
}
