package com.example.application0724.VO;

public class Book {
    private String title;       // 제목
    private String genre;       // 장르
    private int thumbnailRes;   // 썸네일
    private int iconRes;        // 아이콘

    public Book() {
        this(null, null, 0, 0);
    }

    public Book(String title, String genre, int thumbnailRes, int iconRes) {
        this.title = title;
        this.genre = genre;
        this.thumbnailRes = thumbnailRes;
        this.iconRes = iconRes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getThumbnailRes() {
        return thumbnailRes;
    }

    public void setThumbnailRes(int thumbnailRes) {
        this.thumbnailRes = thumbnailRes;
    }

    public int getIconRes() {
        return iconRes;
    }

    public void setIconRes(int iconRes) {
        this.iconRes = iconRes;
    }
}

