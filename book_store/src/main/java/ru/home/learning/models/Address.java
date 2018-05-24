package ru.home.learning.models;

import javax.validation.constraints.NotNull;

/**
 * POJO-объект "Адрес"
 * Created by YANesterov on 24.05.2018.
 */
public class Address {
    @NotNull
    private String street1;
    private String street2;
    @NotNull
    private String city;
    private String state;
    @NotNull
    @ZipCode
    private String zipcode;
    private String country;

    public Address() {
    }

    public Address(String street1) {
        this();
        this.street1 = street1;
    }

    public Address(String street1, String street2) {
        this(street1);
        this.street2 = street2;
    }

    public Address(String street1, String street2, String city) {
        this(street1, street2);
        this.city = city;
    }

    public Address(String street1, String street2, String city, String state) {
        this(street1, street2, city);
        this.state = state;
    }

    public Address(String street1, String street2, String city, String state, String zipcode) {
        this(street1, street2, city, state);
        this.zipcode = zipcode;
    }

    public Address(String street1, String street2, String city, String state, String zipcode, String country) {
        this(street1, street2, city, state, zipcode);
        this.country = country;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Address{");
        sb.append("street1='").append(street1).append('\'');
        sb.append(", street2='").append(street2).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", state='").append(state).append('\'');
        sb.append(", zipcode='").append(zipcode).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
