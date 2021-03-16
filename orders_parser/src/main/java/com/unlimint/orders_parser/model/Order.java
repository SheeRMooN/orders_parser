package com.unlimint.orders_parser.model;

import org.springframework.stereotype.Component;

@Component
public class Order {
    // id индификатор ордера
    private String id;
    // amount - сумма ордера
    private String amount;
    // currency - валюта суммы ордера
    private String currency;
    // comment - комментарий по ордеру
    private String comment;
    // filename имя исходного файла
    private String filename;
    // line - номер строки исходного файла
    private int line;
    // result - результат парсинга записи исходного файла.
    // OK - если запись конвертирована корректно,
    // или описание ошибки если запись не удалось конвертировать.
    private String result;

    public Order(String id, String amount, String currency, String comment, String filename, int line, String result) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.comment = comment;
        this.filename = filename;
        this.line = line;
        this.result = result;
    }


    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "{" +
                  "\"" + "id" + "\":" + id  +
                ", \"" + "amount" + "\":" + amount +
//                ", \"" + "currency" + "\":" + currency + "\"" +
                ", \"" + "comment" + "\":\"" + comment + "\"" +
                ", \"" + "filename" + "\":\"" + filename + "\"" +
                ", \"" + "line" + "\":" + line +
                ", \"" + "result" + "\":\"" + result + "\"}";
    }
}
