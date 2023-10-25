package com.parcial.Parcial_90276.Dominio.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Table(name = "customers")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {
    @Id
    @Column(name = "custumerId")
    Integer id;
    String lastName;
    String firstName;
    String company;
    String address;
    String city;
    String state;
    String country;
    String postalCode;
    String phone;
    String fax;
    String email;

}
