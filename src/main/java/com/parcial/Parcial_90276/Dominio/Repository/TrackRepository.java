package com.parcial.Parcial_90276.Dominio.Repository;

import com.parcial.Parcial_90276.Dominio.Models.Artist;
import com.parcial.Parcial_90276.Dominio.Models.Genre;
import com.parcial.Parcial_90276.Dominio.Models.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track,Integer> {
    List<Track> findByAlbum_ArtistAndGenre(Artist artist, Genre genre);


}
