package com.parcial.Parcial_90276.Dominio.Repository;

import com.parcial.Parcial_90276.Dominio.Models.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistTrackRepository extends JpaRepository<Playlist, Integer> {
}
