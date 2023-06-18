package com.pyszniutkie.backend.order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private int id;
    @NotBlank(message = "Wymagane imie!")
    private String fullName;
    @NotBlank(message = "Wymagane podanie miasta!")
    private String city;
    @NotBlank(message = "Wymagany kod pocztowy w formacie XX-XXX!")
    private String postCode;
    @NotBlank(message = "Wymagana ulica!")
    private String street;

    public Address() {
    }

    public Address(String fullName, String city, String postCode, String street) {
        this.fullName = fullName;
        this.city = city;
        this.postCode = postCode;
        this.street = street;
    }

    //GETTER + SETTER for object operations witch thymeleaf

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCity() {
        return city;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getStreet() {
        return street;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", city='" + city + '\'' +
                ", postCode='" + postCode + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
