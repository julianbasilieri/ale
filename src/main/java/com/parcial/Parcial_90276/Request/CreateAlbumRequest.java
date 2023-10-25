package com.parcial.Parcial_90276.Request;

import com.parcial.Parcial_90276.Dominio.Models.Track;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class CreateAlbumRequest {
    @NotBlank(message = "Id necesario")
    Integer id;
    @NotBlank(message = "Titulo necesario")
    String title;
    @NotBlank(message = "Artista necesario")
    Integer artistId;
    @NotBlank(message = "Tracks necesarios")
    List<Track> tracks;

}
