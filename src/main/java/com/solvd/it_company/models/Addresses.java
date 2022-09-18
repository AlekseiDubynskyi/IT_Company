package com.solvd.it_company.models;

import java.util.Objects;

public class Addresses {
    private int id;
    private String address;
    private String district;
    private String postalCode;
    private int cityId;

    public Addresses() {
    }

    public Addresses(String address, String district, String postalCode, int cityId) {
        this.address = address;
        this.district = district;
        this.postalCode = postalCode;
        this.cityId = cityId;
    }

    public Addresses(int id, String address, String district, String postalCode, int cityId) {
        this.id = id;
        this.address = address;
        this.district = district;
        this.postalCode = postalCode;
        this.cityId = cityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Addresses addresses = (Addresses) o;
        return id == addresses.id && cityId == addresses.cityId && address.equals(addresses.address) && district.equals(addresses.district) && postalCode.equals(addresses.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, district, postalCode, cityId);
    }

    @Override
    public String toString() {
        return "Addresses{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", district='" + district + '\'' +
                ", postal code='" + postalCode + '\'' +
                ", city id=" + cityId +
                '}';
    }
}
