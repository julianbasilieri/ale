package com.parcial.Parcial_90276.Dominio.Models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "employeeId")
    Integer id;
    String lastName;
    String firstName;
    String title;
    LocalDate birthDate;
    LocalDate hireDate;
    String address;
    String city;
    String state;
    String country;
    String postalCode;
    String phone;
    String fax;
    String email;
    //REPORTS TO
    @OneToOne
    @JoinColumn(name = "employeeId")
    Employee reportsTo;




}
