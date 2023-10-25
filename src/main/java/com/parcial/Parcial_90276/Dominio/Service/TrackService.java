package com.parcial.Parcial_90276.Dominio.Service;

import com.parcial.Parcial_90276.Dominio.Models.Track;

import java.util.List;
import java.util.Optional;

public interface TrackService {

    Optional<Track> getById(Integer id);

    List<Track> getAll();

    Track addTrack(String name, Integer mediaTypeId, Integer genreId, String composer, Integer milliseconds, Integer bytes, Float unitPrice);

    void deleteTrack(Integer id);

    void updateTrack(Integer id, String name, Integer mediaTypeId, Integer genreId, String composer, Integer milliseconds, Integer bytes, Float unitPrice);

    List<Track> getAllByArtistAndGenre(Integer artistId, Integer genreId);
}
