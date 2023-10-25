package com.parcial.Parcial_90276.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreatePlaylistFullRequest {
    @NotBlank(message = "Nombre requerido")
    String nombre;
    @NotBlank(message = "ID de artista requerida")
    Integer artistId;
    @NotBlank(message = "ID de genero requerida")
    Integer genreId;
    @NotBlank(message = "Minutos requeridos")
    Integer minutos;


}
