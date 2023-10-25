package com.parcial.Parcial_90276.Dominio.Service;

import com.parcial.Parcial_90276.Dominio.Models.Track;
import com.parcial.Parcial_90276.Dominio.Repository.*;
import com.parcial.Parcial_90276.Dominio.Repository.Id.IdRepository;
import com.parcial.Parcial_90276.ResponseHandler;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TrackServiceImpl implements TrackService{

    TrackRepository trackRepository;
    MediaTypeRepository mediaTypeRepository;
    GenreRepository genreRepository;
    AlbumRepository albumRepository;
    ArtistRepository artistRepository;
    IdRepository idRepository;

    @Override
    public Optional<Track> getById(Integer id) {
        return trackRepository.findById(id);
    }

    @Override
    public List<Track> getAll() {
        return trackRepository.findAll();
    }

    @Override
    public Track addTrack(String name, Integer mediaTypeId, Integer genreId, String composer, Integer milliseconds, Integer bytes, Float unitPrice) {
        val id = idRepository.siguienteId("tracks");
        val mediaType = mediaTypeRepository.findById(mediaTypeId).orElseThrow(() -> new IllegalArgumentException("No existe mediaType con esa ID"));
        val genre = genreRepository.findById(genreId).orElseThrow(() -> new IllegalArgumentException("No existe genero con esa ID"));
        val track = new Track(id,name,mediaType,genre,composer,milliseconds,bytes,unitPrice);
        return trackRepository.save(track);
    }


    @Override
    public void deleteTrack(Integer id) {
        trackRepository.deleteById(id);
    }

    @Override
    public void updateTrack(Integer id, String name, Integer mediaTypeId, Integer genreId, String composer, Integer milliseconds, Integer bytes, Float unitPrice) {
        val trackActual = trackRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe track con esa ID"));
        val mediaType = mediaTypeRepository.findById(mediaTypeId).orElseThrow(() -> new IllegalArgumentException("No existe mediaType con esa ID"));
        val genre = genreRepository.findById(genreId).orElseThrow(() -> new IllegalArgumentException("No existe genero con esa ID"));
        trackActual.update(name,mediaType,genre,composer,milliseconds,bytes,unitPrice);
        trackRepository.save(trackActual);
    }

    @Override
    public List<Track> getAllByArtistAndGenre(Integer artistId, Integer genreId) {
        val artist = artistRepository.findById(artistId).orElseThrow(() -> new IllegalArgumentException("No existe artista con esa ID"));
        val genre = genreRepository.findById(genreId).orElseThrow(() -> new IllegalArgumentException("No existe genero con esa ID"));
        return trackRepository.findByAlbum_ArtistAndGenre(artist, genre);
    }

}
