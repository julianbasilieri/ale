package com.parcial.Parcial_90276.Dominio.Service;

import com.parcial.Parcial_90276.Dominio.Models.Artist;
import com.parcial.Parcial_90276.Dominio.Repository.ArtistRepository;
import com.parcial.Parcial_90276.Dominio.Repository.Id.IdRepository;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ArtistServiceImpl implements ArtistService{

    ArtistRepository artistRepository;
    IdRepository idRepository;
    @Override
    public Optional<Artist> getById(Integer id) {
        return artistRepository.findById(id);
    }

    @Override
    public List<Artist> getAll() {
        return artistRepository.findAll();
    }

    @Override
    public Artist addArtist(String name) {
        val id = idRepository.siguienteId("artists");
        val artist = new Artist(id,name);
        return artistRepository.save(artist);
    }

    @Override
    public void deleteArtist(Integer id) {
        artistRepository.deleteById(id);
    }
    @Override
    public void updateArtist(Integer id, String name) {
        val artistActual = artistRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe artista con ese nombre"));
        artistActual.update(name);
        artistRepository.save(artistActual);
    }
}
