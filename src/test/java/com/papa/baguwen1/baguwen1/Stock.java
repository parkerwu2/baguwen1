package com.papa.baguwen1.baguwen1;

public class Stock {
    private Integer stock;
    public Stock(int stock){
        this.stock = stock;
    }
    public boolean isOk(){
        return stock >= 1;
    }
    public void minus(){
        stock--;
    }
    public int getStock(){
        return stock;
    }
}
