package com.parcial.Parcial_90276.Dominio.Service;

import com.parcial.Parcial_90276.Dominio.Models.Album;
import com.parcial.Parcial_90276.Dominio.Models.Artist;
import com.parcial.Parcial_90276.Dominio.Models.Track;
import com.parcial.Parcial_90276.Dominio.Repository.AlbumRepository;
import com.parcial.Parcial_90276.Dominio.Repository.ArtistRepository;
import com.parcial.Parcial_90276.Dominio.Repository.Id.IdRepository;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AlbumServiceImpl implements AlbumService{

    AlbumRepository albumRepository;
    ArtistRepository artistRepository;
    IdRepository idRepository;

    @Override
    public Optional<Album> getById(Integer id) {
        return albumRepository.findById(id);
    }

    @Override
    public List<Album> getAll() {
        return albumRepository.findAll();
    }


    @Override
    public Album addAlbum(String title, Integer artistId) {
        val artist = artistRepository.findById(artistId).orElseThrow(() -> new IllegalArgumentException("No existe artista con esa ID"));
        val id = idRepository.siguienteId("albums");
        val album = new Album(id,title,artist);
        return  albumRepository.save(album);
    }

    @Override
    public void deleteAlbum(Integer id) {
        albumRepository.deleteById(id);
    }

    @Override
    public void updateAlbum(Integer id, String title, Integer artistId) {
        val albumActual = albumRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("No existe album con esa ID"));
        val artist = artistRepository.findById(artistId).orElseThrow(() -> new IllegalArgumentException("No existe artista con esa ID"));
        albumActual.update(title,artist);
        albumRepository.save(albumActual);

    }

    @Override
    public List<Album> getByArtistId(Integer artistID) {
        return albumRepository.findByArtist_Id(artistID);
    }


}
