package com.parcial.Parcial_90276.Dominio.Models;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Entity
@Table(name = "tracks")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Track {
    @Id
    @Column(name = "trackId")
    Integer id;
    String name;
    @ManyToOne
    @JoinColumn(name = "albumId")
    Album album;
    @ManyToOne
    @JoinColumn(name = "mediaTypeId")
    Media_type mediaType;
    @ManyToOne
    @JoinColumn(name = "genreId")
    Genre genre;
    String composer;
    Integer milliseconds;
    Integer bytes;
    Float unitPrice;
    @ManyToMany
    @JoinTable(
            name = "playlist_track",
            joinColumns = @JoinColumn(name = "trackId"),
            inverseJoinColumns = @JoinColumn(name = "playlistId"))
    List<Playlist> playlists;

    @OneToMany(mappedBy = "track")
    List<Invoice_Items> invoiceItems;

    public Track() {
    }

    public Track(Integer id, String name, Media_type mediaType, Genre genre, String composer, Integer milliseconds, Integer bytes, Float unitPrice) {
        this.id = id;
        this.name = name;
        this.mediaType = mediaType;
        this.genre = genre;
        this.composer = composer;
        this.milliseconds = milliseconds;
        this.bytes = bytes;
        this.unitPrice = unitPrice;
    }

    public void update(String name, Media_type mediaType, Genre genre, String composer, Integer milliseconds, Integer bytes, Float unitPrice){
        this.name = name;
        this.mediaType = mediaType;
        this.genre = genre;
        this.composer = composer;
        this.milliseconds = milliseconds;
        this.bytes = bytes;
        this.unitPrice = unitPrice;
    }
}
