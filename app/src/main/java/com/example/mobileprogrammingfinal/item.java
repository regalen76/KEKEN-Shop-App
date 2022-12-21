package com.example.mobileprogrammingfinal;

public class item {
    int drawable;
    String judul;
    String currency;

    public item(int drawable, String judul, String currency) {
        this.drawable = drawable;
        this.judul = judul;
        this.currency = currency;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
