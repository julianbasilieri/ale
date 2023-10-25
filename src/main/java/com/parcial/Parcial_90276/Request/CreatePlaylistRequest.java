package com.parcial.Parcial_90276.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreatePlaylistRequest {
    @NotBlank(message = "ID es necesario")
    Integer id;
    @NotBlank(message = "Nombre es necesario")
    String name;


}
