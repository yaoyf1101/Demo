package com.yaoyifei.demo;

public class MyListViewData {
    private String item_text;
    private int item_image;

    public MyListViewData(String item_text, int item_image){
        this.item_text = item_text;
        this.item_image = item_image;
    }

    public String getItemText() {
        return item_text;
    }

    public void setItemText(String item_text) {
        this.item_text = item_text;
    }

    public int getItemImage() {
        return item_image;
    }

    public void setItemImage(int item_image) {
        this.item_image = item_image;
    }

}