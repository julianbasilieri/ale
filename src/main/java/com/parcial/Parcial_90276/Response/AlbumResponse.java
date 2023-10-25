package com.parcial.Parcial_90276.Response;

import com.parcial.Parcial_90276.Dominio.Models.Album;
import com.parcial.Parcial_90276.Dominio.Models.Track;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.stream.Stream;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AlbumResponse {
    Integer id;
    String title;
    String artist;
    //List<Track> tracks;
    Stream<String> tracks;

    public static AlbumResponse from (Album album){
        return AlbumResponse.builder()
                .id(album.getId())
                .title(album.getTitle())
                .artist(album.getArtist().getName())
                //.tracks(album.getTracks())
                .tracks(album.getTracks().stream().map((Track::getName)))
                .build();

    }

}
