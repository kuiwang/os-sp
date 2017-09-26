package com.scott.dev.domain.jd;

import com.scott.dev.domain.BaseDomain;

public class JDProduct extends BaseDomain {

    private static final long serialVersionUID = 1L;

    private String id;

    private String title;

    private String brand;

    private String vendor;

    private String promotion;

    private String adword;

    private String status;

    private Categories categories;

    private Prices prices;

    private Pages pages;

    private Images images;

    private Histories histories;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public String getAdword() {
        return adword;
    }

    public void setAdword(String adword) {
        this.adword = adword;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Prices getPrices() {
        return prices;
    }

    public void setPrices(Prices prices) {
        this.prices = prices;
    }

    public Pages getPages() {
        return pages;
    }

    public void setPages(Pages pages) {
        this.pages = pages;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public Histories getHistories() {
        return histories;
    }

    public void setHistories(Histories histories) {
        this.histories = histories;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
