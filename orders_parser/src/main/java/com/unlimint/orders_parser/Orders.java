package com.unlimint.orders_parser;


import com.unlimint.orders_parser.model.Order;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Orders  {
    public  void rundMain(String filePath1, String filePath2)  {


        String fileName1 = new File(filePath1).getName();
        String fileName2 = new File(filePath2).getName();



        List<String> stringList1 = new LinkedList<>();
        List<String> stringList2 = new LinkedList<>();

        String regex1 = getRegex(filePath1);
        String regex2 = getRegex(filePath2);
        if (regex1 == null | regex2 == null){
            System.out.println("Incorrect file format");
            return;
        }

        readFile(stringList1, filePath1);
        readFile(stringList2, filePath2);

        List<Order> orderList1 = addOrders(stringList1, fileName1, regex1);
        List<Order> orderList2 = addOrders(stringList2, fileName2, regex2);

        orderList1.addAll(orderList2);
        validatorOrders(orderList1);

        stdout(orderList1);
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

    private  void stdout(List<Order> allOrders) {


        Iterator iterator = allOrders.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }



    public  List<Order> addOrders(List<String> list, String fileName, String regex){
        List<Order> orderList = new LinkedList<>();

        int count = 1;
        String result = "OK";
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            String str = (String) iterator.next();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                orderList.add(
                        new Order(
                                String.valueOf(matcher.group(1)),
                                String.valueOf(matcher.group(2)),
                                String.valueOf(matcher.group(3)),
                                String.valueOf(matcher.group(4)),
                                fileName,
                                count,
                                result
                        )
                );
            }
            count++;
        }
        return orderList;
    }

    public  List<String> readFile(List<String> list,String fileName){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            while (reader.ready()){
                list.add(reader.readLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    private  String getRegex(String fileName){
        String type = fileName.substring(fileName.indexOf('.'), fileName.length());
        String regex = null;
        switch (type){
            case ".csv":
                regex = "(\\d+)\\,(\\d+(?:[\\.,]\\d+)?)\\,(\\w+)\\,(\\W+)";
                break;
            case ".json":
                regex = "\\{\"orderId\":(\\d)\\,\\\"amount\":(\\d+(?:[\\.,]\\d+)?)\\,\\\"currency\":\"(\\w+)\\\",\"comment\":\"(\\W+)\\\"}";
                break;
            case ".xlsx":
                regex = "";
                break;
        }

        return regex;
    }
}
