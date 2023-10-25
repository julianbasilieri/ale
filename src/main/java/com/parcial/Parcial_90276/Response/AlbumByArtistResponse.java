package com.parcial.Parcial_90276.Response;

import com.parcial.Parcial_90276.Dominio.Models.Album;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AlbumByArtistResponse {
    Integer artistId;
    String title;

    public static AlbumByArtistResponse from (Album album){
        return AlbumByArtistResponse.builder().artistId(album.getId()).title(album.getTitle()).build();
    }



}
