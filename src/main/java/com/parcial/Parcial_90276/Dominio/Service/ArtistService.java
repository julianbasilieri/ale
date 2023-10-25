package com.parcial.Parcial_90276.Dominio.Service;

import com.parcial.Parcial_90276.Dominio.Models.Artist;

import java.util.List;
import java.util.Optional;

public interface ArtistService {
    Optional<Artist> getById(Integer id);

    List<Artist> getAll();

    Artist addArtist(String name);

    void deleteArtist(Integer id);

    void updateArtist(Integer id, String name);
}
