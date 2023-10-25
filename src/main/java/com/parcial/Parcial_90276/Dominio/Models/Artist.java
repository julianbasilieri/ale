package com.parcial.Parcial_90276.Dominio.Models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@Table(name = "artists")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Artist {
    @Id
    @Column(name = "artistId")
    Integer id;
    String name;
    @OneToMany(mappedBy = "artist")
    List<Album> albums;

    public Artist() {
    }

    public Artist(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.albums = new LinkedList<>();
    }

    public void update(String name){
        this.name = name;
    }
}
