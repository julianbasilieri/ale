package com.parcial.Parcial_90276.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateTrackRequest {
    @NotBlank(message = "ID necesario")
    Integer id;
    @NotBlank(message = "Nombre necesario")
    String name;
    @NotBlank(message = "ID de MediaType necesario")
    Integer mediaTypeId;
    @NotBlank(message = "ID de genero necesario")
    Integer genreId;
    @NotBlank(message = "Compositor necesario")
    String composer;
    @NotBlank(message = "Milisegundos necesarios")
    Integer milliseconds;
    @NotBlank(message = "Bytes necesarios")
    Integer bytes;
    @NotBlank(message = "Precio necesario")
    Float unitPrice;
}
