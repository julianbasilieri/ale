package com.parcial.Parcial_90276.Dominio.Service;

import com.parcial.Parcial_90276.Dominio.Models.Album;
import com.parcial.Parcial_90276.Dominio.Models.Artist;
import com.parcial.Parcial_90276.Dominio.Models.Track;

import java.util.List;
import java.util.Optional;

public interface AlbumService {
    Optional<Album> getById(Integer id);

    List<Album> getAll();

    Album addAlbum(String title, Integer artistId);

    void deleteAlbum(Integer id);

    void updateAlbum(Integer id, String title, Integer artistId);

    List<Album> getByArtistId(Integer artistID);
}
