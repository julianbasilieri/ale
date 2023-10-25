package com.parcial.Parcial_90276.Dominio.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Entity
@Table(name = "media_types")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Media_type {
    @Id
    @Column(name = "mediaTypeId")
    Integer id;
    String name;
    @OneToMany(mappedBy = "mediaType")
    @JsonIgnore
    List<Track> tracks;
}
