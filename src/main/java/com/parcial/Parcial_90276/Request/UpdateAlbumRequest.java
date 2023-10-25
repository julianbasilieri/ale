package com.parcial.Parcial_90276.Request;

import com.parcial.Parcial_90276.Dominio.Models.Track;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateAlbumRequest {
    @NotBlank(message = "Id necesario")
    Integer id;
    @NotBlank(message = "Titulo necesario")
    String title;
    @NotBlank(message = "Artista necesario")
    Integer artistId;
    @NotBlank(message = "Tracks necesarios")
    List<Track> tracks;

}
