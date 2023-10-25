package com.parcial.Parcial_90276.Dominio.Repository;

import com.parcial.Parcial_90276.Dominio.Models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AlbumRepository extends JpaRepository<Album, Integer> {

    List<Album> findByArtist_Id(Integer artistId);
}
