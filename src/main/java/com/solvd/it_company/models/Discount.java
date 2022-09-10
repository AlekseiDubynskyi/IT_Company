package com.solvd.it_company.models;

public class Discount {
    private int id;
    private String discount_name;
    private boolean discount_success;

    public Discount() {
    }

    public Discount(int id, String discount_name, boolean discount_success) {
        this.id = id;
        this.discount_name = discount_name;
        this.discount_success = discount_success;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiscount_name() {
        return discount_name;
    }

    public void setDiscount_name(String discount_name) {
        this.discount_name = discount_name;
    }

    public boolean isDiscount_success() {
        return discount_success;
    }

    public void setDiscount_success(boolean discount_success) {
        this.discount_success = discount_success;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "id=" + id +
                ", discount_name='" + discount_name + '\'' +
                ", discount_success=" + discount_success +
                '}';
    }
}
