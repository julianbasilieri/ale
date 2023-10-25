package com.parcial.Parcial_90276.Dominio.Models;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Table(name = "invoice_items")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Invoice_Items {
    @Id
    @Column(name = "invoiceLineId")
    Integer id;
    @ManyToOne
    @JoinColumn(name = "trackId")
    Track track;
    @ManyToOne
    @JoinColumn(name = "invoiceId")
    Invoice invoice;
    Float unitPrice;
    Integer quantity;

}
