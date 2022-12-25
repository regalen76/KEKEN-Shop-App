package com.example.mobileprogrammingfinal;

public class Pembelian {

    public Integer invoce;
    public String gameName;
    public String currencyName;
    public Integer amountCurrrency;

    public Pembelian(){

    }

    public Integer getInvoce() {
        return invoce;
    }

    public void setInvoce(Integer invoce) {
        this.invoce = invoce;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public Integer getAmountCurrrency() {
        return amountCurrrency;
    }

    public void setAmountCurrrency(Integer amountCurrrency) {
        this.amountCurrrency = amountCurrrency;
    }

    public Pembelian(Integer invoce, Integer amountCurrrency, String gameName, String currencyName){
        this.invoce = invoce;
        this.amountCurrrency = amountCurrrency;
        this.gameName = gameName;
        this.currencyName = currencyName;
    }
}
