package com.parcial.Parcial_90276.Dominio.Models;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "invoices")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Invoice {
    @Id
    @Column(name = "invoiceId")
    Integer id;
    LocalDate invoiceDate;
    String billingAddress;
    String billingCity;
    String billingState;
    String billingCountry;
    String billingPostalCode;
    Float total;
    @OneToOne
    @JoinColumn(name = "custumerId")
    Customer customer;

    @OneToMany(mappedBy = "invoice")
    List<Invoice_Items> invoiceItems;

}
