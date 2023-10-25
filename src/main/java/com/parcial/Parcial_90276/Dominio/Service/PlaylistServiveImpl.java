package com.parcial.Parcial_90276.Dominio.Service;

import com.parcial.Parcial_90276.Dominio.Models.Playlist;
import com.parcial.Parcial_90276.Dominio.Models.Track;
import com.parcial.Parcial_90276.Dominio.Repository.ArtistRepository;
import com.parcial.Parcial_90276.Dominio.Repository.GenreRepository;
import com.parcial.Parcial_90276.Dominio.Repository.Id.IdRepository;
import com.parcial.Parcial_90276.Dominio.Repository.PlaylistRepository;
import com.parcial.Parcial_90276.Dominio.Repository.TrackRepository;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlaylistServiveImpl implements PlaylistService{


    PlaylistRepository playlistRepository;
    TrackRepository trackRepository;
    ArtistRepository artistRepository;
    GenreRepository genreRepository;
    IdRepository idRepository;

    @Override
    public Optional<Playlist> getById(Integer id) {
        return playlistRepository.findById(id);
    }

    @Override
    public List<Playlist> getAll() {
        return playlistRepository.findAll();
    }

    @Override
    public Playlist addPlaylist(String name) {
        val id = idRepository.siguienteId("playlists");
        val playlist = new Playlist(id, name);
        return playlistRepository.save(playlist);
    }

    @Override
    public void deletePlaylist(Integer id) {
        playlistRepository.deleteById(id);
    }

    @Override
    public void updatePlaylist(Integer id, String name) {
        val playlistActual = playlistRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe playlist con esa ID"));
        playlistActual.update(name);
        playlistRepository.save(playlistActual);
    }

    @Override
    public void addTrack(Integer playlistId, Integer trackId) {
        val playlist = playlistRepository.findById(playlistId).orElseThrow(() -> new IllegalArgumentException("No existe playlist con esa ID"));
        val track = trackRepository.findById(trackId).orElseThrow(() -> new IllegalArgumentException("No existe track con esa ID"));
        playlist.getTracks().add(track);
        playlistRepository.save(playlist);
    }

    @Override
    public Playlist createPlaylist(String name, Integer artistId, Integer genreId, Integer minutos) {
        int totalMilisegundos = 0;
        val id = idRepository.siguienteId("playlists");
        val artist = artistRepository.findById(artistId).orElseThrow(() -> new IllegalArgumentException("No existe artista con esa ID"));
        val genre = genreRepository.findById(genreId).orElseThrow(() -> new IllegalArgumentException("No existe genero con esa ID"));
        List<Track> tracks = trackRepository.findByAlbum_ArtistAndGenre(artist, genre);
        val playlist = new Playlist(id,name);
        for (int i = 0; i < tracks.size(); i++) {
            totalMilisegundos += tracks.get(i).getMilliseconds();
            if (minutos*60000 > totalMilisegundos){
                playlist.getTracks().add(tracks.get(i));

            }
        }


        return playlistRepository.save(playlist);
    }


}
