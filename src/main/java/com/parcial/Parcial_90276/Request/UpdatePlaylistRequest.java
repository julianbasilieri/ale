package com.parcial.Parcial_90276.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdatePlaylistRequest {
    @NotBlank(message = "ID es necesario")
    Integer id;
    @NotBlank(message = "Nombre es necesario")
    String name;

}
