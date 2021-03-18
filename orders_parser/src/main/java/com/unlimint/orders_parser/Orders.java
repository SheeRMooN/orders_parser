package com.unlimint.orders_parser;


import com.unlimint.orders_parser.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Scope("prototype")
public class Orders  {
    String fileName;
    List<String> stringList = new LinkedList<>();
    String regex;
    @Autowired
    Order order;

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
                Order order = getOrder();
                //    public Order(String id, String amount, String currency, String comment, String filename, int line, String result) {
                order.setId(String.valueOf(matcher.group(1)));
                order.setAmount(String.valueOf(matcher.group(2)));
                order.setCurrency(String.valueOf(matcher.group(3)));
                order.setComment(String.valueOf(matcher.group(4)));
                order.setFilename(fileName);
                order.setLine(count);
                order.setResult(result);
                orderList.add(order);
//                orderList.add(
//                        order.(
//                                String.valueOf(matcher.group(1)),
//                                String.valueOf(matcher.group(2)),
//                                String.valueOf(matcher.group(3)),
//                                String.valueOf(matcher.group(4)),
//                                fileName,
//                                count,
//                                result
//                        )
//                );
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


    public   String getRegexs(String fileName){
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
    @Lookup
    public Order getOrder(){
        return null;
    }
}
