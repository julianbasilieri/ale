package com.parcial.Parcial_90276.Response;

import com.parcial.Parcial_90276.Dominio.Models.Album;
import com.parcial.Parcial_90276.Dominio.Models.Artist;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.stream.Stream;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArtistReponse {
    Integer id;
    String name;
    Stream<String> albums;

    public static ArtistReponse from (Artist artist){
        return ArtistReponse.builder()
                .id(artist.getId())
                .name(artist.getName())
                .albums(artist.getAlbums().stream().map(Album::getTitle))
                .build();

    }

}
