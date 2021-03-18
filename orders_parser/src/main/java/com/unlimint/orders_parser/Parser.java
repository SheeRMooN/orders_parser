package com.unlimint.orders_parser;

import com.unlimint.orders_parser.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


@Component
public class Parser {
    @Autowired
    private Orders orders ;

    public Parser() {
    }
    public void runParseFiles(String filePath1, String filePath2){
        Orders orders1 = getOrders();
        Orders orders2 = getOrders();
        orders1.fileName = new File(filePath1).getName();
        orders2.fileName = new File(filePath2).getName();
        List<String> stringList1 = new LinkedList<>();
        List<String> stringList2 = new LinkedList<>();
        orders1.regex = orders1.getRegexs(filePath1);
        orders2.regex = orders2.getRegexs(filePath2);
        orders1.readFile(stringList1, filePath1);
        orders2.readFile(stringList2, filePath2);
        List<Order> orderList1 = orders1.addOrders(stringList1, orders1.fileName, orders1.regex);
        List<Order> orderList2 = orders2.addOrders(stringList2, orders2.fileName, orders2.regex);


//        System.out.println(orders1.regex);
//        System.out.println(orders1.fileName);
//        System.out.println(orders1.stringList.size());
//        stdoutString(stringList1);
//        stdoutString(stringList2);
//        stdout(orderList1);
//        stdout(orderList2);

        orderList1.addAll(orderList2);

        validatorOrders(orderList1);
        stdout(orderList1);




    }
    private void stdoutString(List<String> strings){
        Iterator iterator = strings.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }

    private  void stdout(List<Order> allOrders) {
        Iterator iterator = allOrders.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }

    private  void validatorOrders(List<Order> allOrder) {
        String report = "OK";

        Iterator<Order> iterator = allOrder.iterator();
        while (iterator.hasNext()){
            Order order = iterator.next();
            try {
                int id = Integer.valueOf(order.getId());


            }catch (NumberFormatException e){
                report = "Error format id";
            }
            try {
                double amount = Double.valueOf(order.getAmount());

            }catch (NumberFormatException e){
                report = "Error format amount";
            }
            if (!order.getCurrency().equals("USD") & !order.getCurrency().equals("EUR")){
                System.out.println(order.getCurrency());
                report = "Error format currency";
            }
            order.setResult(report);
        }
    }
    @Lookup
    public Orders getOrders(){
        return null;
    }
}
