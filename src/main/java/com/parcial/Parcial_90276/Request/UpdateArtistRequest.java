package com.parcial.Parcial_90276.Request;

import com.parcial.Parcial_90276.Dominio.Models.Album;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateArtistRequest {
    @NotBlank(message = "Id necesario")
    Integer id;
    @NotBlank(message = "Nombre necesario")
    String name;
    @NotBlank(message = "Albums necesarios")
    List<Album> albums;

}
