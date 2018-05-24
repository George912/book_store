package ru.home.learning.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * POJO-объект "Клиент"
 * Created by YANesterov on 24.05.2018.
 */
public class Customer {
    @NotNull
    @Size(min = 2)
    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String phoneNumber;
    private Date dateOfBirth;
    private Address deliveryAddress;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(String firstName, String lastName, String email) {
        this(firstName, lastName);
        this.email = email;
    }

    public Customer(String firstName, String lastName, String email, String phoneNumber) {
        this(firstName, lastName, email);
        this.phoneNumber = phoneNumber;
    }

    public Customer(String firstName, String lastName, String email, String phoneNumber, Date dateOfBirth) {
        this(firstName, lastName, email, phoneNumber);
        this.dateOfBirth = dateOfBirth;
    }

    public Customer(String firstName, String lastName, String email, String phoneNumber, Date dateOfBirth, Address deliveryAddress) {
        this(firstName, lastName, email, phoneNumber, dateOfBirth);
        this.deliveryAddress = deliveryAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Customer{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", deliveryAddress=").append(deliveryAddress);
        sb.append('}');
        return sb.toString();
    }
}
