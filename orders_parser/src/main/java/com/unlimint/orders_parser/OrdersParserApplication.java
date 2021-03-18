package com.unlimint.orders_parser;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class OrdersParserApplication  {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.unlimint.orders_parser");

		if (args.length == 2) {
			Parser parser = context.getBean("parser", Parser.class);
			parser.runParseFiles(args[0], args[1]);
//		}else if (args.length == 0){
//			Parser parser = context.getBean("parser", Parser.class);
//			parser.runParseFiles(
//					"C:\\Users\\SheeRMooN\\Desktop\\parse1.csv",
//					"C:\\Users\\SheeRMooN\\Desktop\\parse2.json");
		}else
			System.out.println("Enter two file name");

	}
}
