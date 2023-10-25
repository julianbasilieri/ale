package com.parcial.Parcial_90276.Dominio.Models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@Table(name = "albums")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Album {
    @Id
    @Column(name = "albumId")
    Integer id;
    String title;

    @ManyToOne
    @JoinColumn(name = "artistId")
    Artist artist;

    @OneToMany(mappedBy = "album")
    List<Track> tracks;

    public Album() {
    }

    public Album(Integer id, String title, Artist artist) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.tracks = new LinkedList<>();
    }

    public void update(String title, Artist artist){
        this.title = title;
        this.artist = artist;
    }
}
