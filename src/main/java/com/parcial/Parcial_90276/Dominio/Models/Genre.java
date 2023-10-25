package com.parcial.Parcial_90276.Dominio.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Entity
@Table(name = "genres")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Genre {
    @Id
    @Column(name = "genreId")
    Integer id;
    String name;
    @OneToMany(mappedBy = "genre")
    @JsonIgnore
    List<Track> tracks;
}
