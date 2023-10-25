package com.parcial.Parcial_90276.Response;

import com.parcial.Parcial_90276.Dominio.Models.Playlist;
import com.parcial.Parcial_90276.Dominio.Models.Track;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.stream.Stream;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlaylistResponse {
    Integer id;
    String name;
    Stream<String> tracks;

//    public static PlaylistResponse from (Playlist playlist){
//        return PlaylistResponse.builder()
//                .id(playlist.getId())
//                .name(playlist.getName())
//                .tracks(playlist.getTracks().stream().map(Track::getName))
//                .build();
//    }

    public static PlaylistResponse from(Playlist playlist) {
        PlaylistResponseBuilder builder = PlaylistResponse.builder()
                .id(playlist.getId())
                .name(playlist.getName());

        if (playlist.getTracks() != null) {
            builder.tracks(playlist.getTracks().stream().map(Track::getName));
        }
        else {
            //Si track es nulo le doy empty
            builder.tracks(Stream.empty());
        }

        return builder.build();
    }

}
