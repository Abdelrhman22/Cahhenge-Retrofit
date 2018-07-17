package com.example.abdo.challenge.Model;

public class DataEncap  {

    private String productDescription;
    private String url;
    private String height;
    private String price;

    public DataEncap() { }

    public DataEncap(String productDescription, String url, String height, String price)
    {
        this.productDescription = productDescription;
        this.url = url;
        this.height = height;
        this.price = price;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getUrl() {
        return url;
    }

    public String getHeight() {
        return height;
    }

    public String getPrice() {
        return price;
    }
}