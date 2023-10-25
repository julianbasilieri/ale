package com.parcial.Parcial_90276.Dominio.Service;

import com.parcial.Parcial_90276.Dominio.Models.Playlist;

import java.util.List;
import java.util.Optional;

public interface PlaylistService {
    Optional<Playlist> getById(Integer id);

    List<Playlist> getAll();

    Playlist addPlaylist(String name);

    void deletePlaylist(Integer id);

    void updatePlaylist(Integer id, String name);

    void addTrack(Integer playlistId, Integer trackId);

    Playlist createPlaylist(String name, Integer artistId, Integer genreId, Integer minutos);
}
