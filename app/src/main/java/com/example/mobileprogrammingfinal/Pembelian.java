package com.example.mobileprogrammingfinal;

public class Pembelian {

    public String invoice;
    public String price;
    public String code;
    public String item;
    public String method;

    public Pembelian(){

    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getMethod() { return method; }

    public void setMethod(String method) { this.method = method; }

    public Pembelian(String invoice, String item, String price, String code, String method){
        this.invoice = invoice;
        this.item = item;
        this.price = price;
        this.code = code;
        this.method = method;
    }
}
