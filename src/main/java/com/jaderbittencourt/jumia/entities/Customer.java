package com.jaderbittencourt.jumia.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String phone;
    private String country;
    private String state;
    private String countryCode;
    private String number;

    protected Customer() {}

    public Customer(String name, String phone, String country, String state, String countryCode, String number) {
        this.name = name;
        this.phone = phone;
        this.country = country;
        this.state = state;
        this.countryCode = countryCode;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
