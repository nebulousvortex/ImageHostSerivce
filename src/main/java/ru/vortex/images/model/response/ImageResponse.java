package ru.vortex.images.model.response;

public class ImageResponse {
    private String url;
    private String author;

    public ImageResponse(String url, String author) {
        this.url = url;
        this.author = author;
    }

    public ImageResponse() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
