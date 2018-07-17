package com.example.abdo.challenge.Model;

public class ImageContainer {

    private static String url;

    public ImageContainer() { }

    public ImageContainer(String url) {
        this.url = url;
    }

    public static String getUrl() {
        return url;
    }
}
