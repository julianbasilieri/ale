package com.parcial.Parcial_90276.Dominio.Models;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@Table(name = "playlists")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Playlist {
    @Id
    @Column(name = "playlistId")
    Integer id;
    String name;
    @ManyToMany
    @JoinTable(
            name = "playlist_track",
            joinColumns = @JoinColumn(name = "playlistId"),
            inverseJoinColumns = @JoinColumn(name = "trackId"))
    List<Track> tracks;

    public Playlist() {
        this.tracks = new LinkedList<>();
    }

    public Playlist(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.tracks = new LinkedList<>();
    }

    public void update(String name){
        this.name = name;
    }
}
